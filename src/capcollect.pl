#!/usr/bin/perl

###############################################################
#                                                             #
# EDIT CONFIGURATION HERE                                     #
#                                                             #
$INGRESS_TOKEN = "" ;             # eg. "JF281lsnEUGARvYv96x7vg" - gotten from the CLR CAP team
$TAGS = "";                       # ';' seperated list of tags: eg. "TAG1;TAG2";
$LOOP_WAIT_SECONDS = 28800;       # 8 hours
$TRACE_COLLECTION_DURATION = 900; # 15 minutes
$NUMBER_OF_COLLECTIONS = -1;      # <=0 forever, >0 that number of collections
$EVENTS = "-gccollectonly";       # -gconly, gccollectonly, etc. - perfcollect has a complete list
#                                                             #
###############################################################

###############################################################
# Loop forever... gathering traces at the interval asked for  #

# ensure we are running with sudo elevation
print "This script must be run with sudo priveleges... if it hangs, it does not\n";
`timeout 2 sudo id`;
if ($? != 0)
{
	print "./capcollect.pl must run with sudo priveleges\n";
	exit(1);
}

if (!-f "perfcollect")
{
	print "./perfcollect must be present next to this file\n";
	exit(1);
}

# start collecting
while(true)
{
	# cleanup previous zips
	print "rm *.zip\n";
	`rm *.zip`;

	# get machine name
	$machinename = `hostname`;
	chomp($machinename);

	# get date
	$date = `date`;
	chomp($date);
	$date =~ s/ /_/gi;
	$date =~ s/\:/_/gi; 

	# build trace name
	$tracename = $machinename . "_" . $date;

	# collect trace
	print "./perfcollect collect $tracename -collectsec $TRACE_COLLECTION_DURATION\n";
	`./perfcollect collect $tracename -collectsec $TRACE_COLLECTION_DURATION`;

	# gather current process list (to coorelate for long running processes)
	$ps = `ps -eo pid,command | grep -i "dotnet "`;
	$ps =~ s/\,/ /gi;
	$ps =~ s/\n/,/gi;
	$ps =~ s/\"/\'/gi;

	# create the tag list
	$tags = "__CAP_MACHINENAME:$machinename;__CAP_PS:$ps";
	if ($TAGS ne "") { $tags .= ";$TAGS"; }

	# send the trace
	$tracename = $tracename . ".trace.zip";
	print "dotnet CAPUploaderCore.dll '$INGRESS_TOKEN' $tracename '$tags'\n";
	`dotnet CAPUploaderCore.dll "$INGRESS_TOKEN" $tracename "$tags"`;

	if ($NUMBER_OF_COLLECTIONS > 0 && --$NUMBER_OF_COLLECTIONS <= 0)
	{
		print "Completed one collection, exiting\n";
		exit(0);
	}

	# wait LOOP_WAIT_SECONDS
	print "Waiting for $LOOP_WAIT_SECONDS seconds ... \n";
	`ping 127.0.0.1 -c 2 -i $LOOP_WAIT_SECONDS`;
}


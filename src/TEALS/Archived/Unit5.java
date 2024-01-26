public class Unit5{
    public static void main(String[] args) {
        Teacher classRoomTeacher = new Teacher("Braun", "Michael");
        Teacher volunteerTeacher1 = new Teacher("Gunarso", "Osmond");

        classRoomTeacher.SetAddress("1 Lindbergh Way, Renton");
        volunteerTeacher1.SetAddress("1 Microsoft Way, Redmond");

        System.out.println(classRoomTeacher.GetAddress());
        System.out.println(volunteerTeacher1.GetAddress());
    }
}

public class Teacher{
    private String name;
    private String address;
    public Teacher(String lastName, String firstName){
        name=firstName + " " + lastName;
    }

    public void SetAddress(String location){
        address=location;
    }

    public String GetAddress(){
        return address;
    }
}
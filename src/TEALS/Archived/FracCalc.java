public class FracCalc  {
    public static void main(String[] args) {
        //System.out.println(produceAnswer("5_3/4 + 6_5/8"));
        //System.out.println(AddTwoNumbers(3, 1, 2, 2, 3, 4));
        System.out.println(produceAnswer2("5_3/4 + 6_5/8"));
    }

    // This function takes two fractions (with integer parts) and adds them and returns the result in a string form
    //
    // input is a fraction string that needs to be evaluated.  
    //      e.g. input ==> "3_1/2 + 2_3/4", the parameters to this method will be
    //              3, 1, 2, 2, 3, 4
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "6_1/4"
    public static String AddTwoNumbers(int whole1, int num1, int den1, int whole2, int num2, int den2){
        //code to add 2 numbers and return a string
        num1 += den1*whole1;
        num2 += den2*whole2;
        int num = num1*den2 + num2*den1;
        int den=den1*den2;
        int gcd = GetGcd(num, den);
        num /= gcd;
        den /= gcd;
        int whole = num/den;
        num %=den;

        return whole + "_" + num + "/" + den;
    }

    public static String produceAnswer2(String input){ 
// TODO: Implement this function to produce the solution to the input
int firstSpace = input.indexOf(' ');
String firstWord = input.substring(0 , firstSpace);
String leftoverEquation = input.substring(firstSpace + 1);
firstSpace = leftoverEquation.indexOf(' ');
String manipulator = leftoverEquation.substring(0 , firstSpace);
String finalSecondWord = leftoverEquation.substring(firstSpace + 1);
int underscoreSearch = finalSecondWord.indexOf("_");
String wholeNumberFinal = "";
String numerator = "";
String denominator = "";
int slashSearch = finalSecondWord.indexOf("/");
if(underscoreSearch == -1 && slashSearch == -1)
{
wholeNumberFinal = finalSecondWord;
}
else if(underscoreSearch != -1 && slashSearch != -1)
{
wholeNumberFinal = finalSecondWord.substring(0 , underscoreSearch);
}
else if(underscoreSearch == -1 && slashSearch != -1)
{
wholeNumberFinal = "0";
}

if(slashSearch == -1)
{
numerator = "0";
denominator = "1";
}
else if(slashSearch != -1)
{
numerator = finalSecondWord.substring(underscoreSearch + 1, slashSearch );
}
if(slashSearch != -1)
{
denominator = finalSecondWord.substring(slashSearch + 1);
}
String answer = "whole:" + wholeNumberFinal + " numerator:" + numerator + " denominator:" + denominator;
return answer;

    }

// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    //
    // Solution
    //  - We parse the string to 3 parts: operand1 operator operand2
    //  - Then we get the whole number, numerator and denominator for operand1 and operand2
    //  - Then we call a routine that does the operation for the 2 operand and converts the result to the expected string
    //  - does not handle more than 2 operands - NO EXTRA CREDIT
    //
    public static String produceAnswer(String input){         

        int index = input.indexOf(' ');
        String operaand1 = input.substring(0, index);

        String rest = input.substring(index + 1);


        index = rest.indexOf(' ');
        char operator = rest.substring(0, index).charAt(0);

        rest = rest.substring(index + 1);
        
        String operaand2 = rest;

        index = rest.indexOf(' ');
        assert index == -1: "multi operands are not currently supported";

        int whole_1 = GetWhole(operaand1);
        int numerator_1 = GetNumerator(operaand1);
        int denominator_1 = GetDenominator(operaand1);

        int whole_2 = GetWhole(operaand2);
        int numerator_2 = GetNumerator(operaand2);
        int denominator_2 = GetDenominator(operaand2);



        String result = DoBasicOperation(whole_1, numerator_1, denominator_1, whole_2, numerator_2, denominator_2, operator);

        return result;
    }

    // We first convert each operand to a fraction (even improper)
    // We then do the operation on the 2 operands
    // We then convert the fraction to the expected value
    //
    // We assumes that the denominators are not negative
    // we assume only the whole number or in its absence, the numerator carry the sign
    //
    // the parameters are automatically widened to long since all calculations are in long
    //
    private static String DoBasicOperation(long whole_1, long numerator_1, long denominator_1, long whole_2, long numerator_2,
            long denominator_2, char operator) {
        
        assert denominator_1 > 0 : "denominator_1 is notpositive";
        assert denominator_2 > 0 : "denominator_2 is notpositive";
        
        assert !(whole_1 < 0 && numerator_1 < 0) : "Both whole and numerator negative in 1st number";
        assert !(whole_2 < 0 && numerator_2 < 0) : "Both whole and numerator negative in 2nd number";

        // we convert the mixxed number inputs to improper fractions to make the fraction calculation easier
        // the math to do this gets challenging with signs (we need to subract when the mixed number is negative)
        // so we remember the sign and do the operation in positive and then apply the sign
        boolean firstNegative = false;
        if(whole_1 < 0 || numerator_1 < 0){
            firstNegative = true;
        }

        boolean secondaNegative = false;
        if(whole_2 < 0 || numerator_2 < 0){
            secondaNegative = true;
        }

        long fullNumerator_1 = Math.abs(whole_1) * denominator_1 + Math.abs(numerator_1);
        long fullNumerator_2 = Math.abs(whole_2) * denominator_2 + Math.abs(numerator_2);

        if(firstNegative){
            fullNumerator_1 *= -1;
        }

        if(secondaNegative){
            fullNumerator_2 *= -1;
        }

        //we do the operation now based on the operand
        //note that for all operands except '/', denominator calculation is the same
        //so for '/' operator, we flip the  nuemrator-denointaor for 2nd number 
        long denominator = 0;
        long numerator = 0;

        if(operator == '/'){
            //we flip numerator and denominator for the 2nd number
            //we will preserve the denominator being positive
            long temp = denominator_2;
            if(fullNumerator_2 < 0){
                denominator_2 = -1 * fullNumerator_2;
                fullNumerator_2 = -1 * temp;
            }else{
                denominator_2 = fullNumerator_2;
                fullNumerator_2 = temp;
            }
        }

        denominator = denominator_1 * denominator_2;

        switch(operator){
            case '+':
                numerator = denominator_2 * fullNumerator_1 + denominator_1 * fullNumerator_2;
                break;
            case '-':
                numerator = denominator_2 * fullNumerator_1 - denominator_1 * fullNumerator_2;
                break;                
            case '*':
            case '/':
                numerator = fullNumerator_1 * fullNumerator_2;
                break;                
        }


        long whole = numerator / denominator;
        
        //only whole or numerator can carry the sign
        //we make the numnerator positive if both are negative
        if(whole < 0 && numerator < 0){
            numerator *= -1;
        }

        numerator = numerator % denominator;

        //simplify the proper fraction by finding the GCD
        //gcd expects both parameters to be positive (or zero). denominator is guarantted to be positive
        long gcd = CalculateGCD(denominator,  Math.abs(numerator));

        if(gcd > 1){
            numerator /= gcd;
            denominator /= gcd;
        }
        
        String result = "";
        //we only write whole if its non-zero or when numerator is zero (and whole is zero)
        if(whole != 0 || numerator == 0){
            result =  String.valueOf(whole);
        }

        if(numerator != 0){
            if(whole != 0){
                result += "_";
            }
            result += numerator + "/" + denominator;
        }

        return result;
    }


    ///Euclid
    private static long CalculateGCD(long a, long b) {
        while(b > 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    // https://en.wikipedia.org/wiki/Euclidean_algorithm
    private static int GetGcd(int a, int b) {
        while(b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    /// input: 5_3/4
    /// output: 4 (1 if no numerator)
    private static int GetDenominator(String input) {
        int denominator = 1;
        int index = 0;

        index = input.indexOf('/');
        if(index>=0){
            input = input.substring(index + 1);
            denominator = Integer.parseInt(input);
        }

        return denominator;
    }

    /// input: 5_3/4
    /// output: 3 (0 if no denominator)
    private static int GetNumerator(String input) {
        int numerator = 0;
        int index = 0;

        index = input.indexOf('_');
        if(index>=0){
            input = input.substring(index+1);
        }
        index = input.indexOf('/');
        if(index>=0){
            input = input.substring(0, index);
            numerator = Integer.parseInt(input);
        }
        return numerator;
    }

    /// input: 5_3/4
    /// output: 5 (the whole string parsed if no numerator and denominator)
    private static int GetWhole(String input) {
        int whole = 0;
        int index = input.indexOf('_');
        if(index>=0){
             input = input.substring(0, index);
             whole = Integer.parseInt(input);
        }else{
            index = input.indexOf('/');
            if(index == -1){
                whole = Integer.parseInt(input);
            }
        }

        return whole;
    }
}
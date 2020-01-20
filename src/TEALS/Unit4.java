import java.util.ArrayList;
import java.util.Random;
public class Unit4{
    public static void main(String[] args){

        //Q5();


        //Q10();

        //Q11();


        //Q20();

        Unit_4_7();

    }

    static void Unit_4_7(){
        ArrayList<String> spongebob = new ArrayList<String>();
        
        spongebob.add("Patrick Star");
        spongebob.add("Squidward Tentacles");
        spongebob.add("Mr. Krabs");
        spongebob.add("Pikachu");
        spongebob.add("Sandy Cheeks");

        //System.out.println("Some of the character on Spongebob​ are " + spongebob);
        System.out.println("Value are " + spongebob);
    }

    static void Q11(){
        String[] what = chop("Hello, world.");
        System.out.println(what[2]);
    }


    static void Q18(){

        int x = 0;
             int[] a = new int[8];
             x = x + 2;
             mystery(x, a);

   x = x + 2;
             mystery(x, a);
             PrintArray(a);

    }

    static void Q15(){
        int[] arr = new int [6];
        int i=5;
        if((i <= arr.length) && (i >= arr.length)){
            System.out.println("xx" + arr.length);
        }

    }

    static void Q10(){
        int[] numbers = new int [6];
        PrintArray(numbers);
        numbers[1] = 4;
        numbers[3] = 104;
        numbers[5] = 2;
        
        int x = numbers[1];
        numbers[x] = 44;
        numbers[numbers[5]] = 11;
                
        PrintArray(numbers);
    }

    static void Q5(){
        Random random = new Random();

        int[] arr = new int[5];
        for(int i=0; i<arr.length; i++)
            arr[i] = random.nextInt(100);

        PrintArray(arr);
    }

    static void Q20(){
        int result = 3;
        int[] x = { 3, 3, 3, 3, 3 };
        for (int i=0; i<2; i++) {
            result = calculateA(result, x);
        }
        System.out.println(result);
        PrintArray(x);


    }

    public static int calculateA(int a, int[] b) {
        b[a] = b[a/2] / 2;
        return b[a/2] + b[a];
    }


    static void PrintArray(int[] arr){
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mystery(int x, int[] a) {
        x = x + 1;
        a[x] = a[x] + 1;
    }


    public static String[] chop(String input) {
        String[] output = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
                 output[i] = input.substring(i);
             }
 	        return output;
    }

}
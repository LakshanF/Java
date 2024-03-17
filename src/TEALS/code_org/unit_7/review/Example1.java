package TEALS.code_org.unit_7.review;

public class Example1 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println("Before method call: num = " + num);
        modifyInt(num);
        System.out.println("After method call: num = " + num);
    }

    public static void modifyInt(int value) {
        value += 5;
        System.out.println("Inside method: value = " + value);
    }
}

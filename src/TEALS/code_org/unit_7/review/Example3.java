package TEALS.code_org.unit_7.review;

public class Example3 {
    public static void main(String[] args) {
        String name = "Alice";
        System.out.println("Before method call: name = " + name);
        modifyString(name);
        System.out.println("After method call: name = " + name);
    }

    public static void modifyString(String str) {
        str += " Smith";
        System.out.println("Inside method: str = " + str);
    }
}

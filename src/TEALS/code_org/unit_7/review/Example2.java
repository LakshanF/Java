package TEALS.code_org.unit_7.review;

public class Example2 {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};
        System.out.print("Before method call: nums = ");
        PrintArray(nums);

        modifyArray(nums);

        System.out.print("After method call: num = ");
        PrintArray(nums);
    }

    private static void modifyArray(int[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] += 100;
        }
        System.out.print("Inside modifyArray: values = ");
        PrintArray(values);
    }

    private static void PrintArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
        System.out.println();
    }
}

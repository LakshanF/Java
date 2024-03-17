package TEALS.code_org.unit_6.Lesson_9;

import java.util.ArrayList;
import java.util.Arrays;

public class HW {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(3, 6, 9, 1, 8, 5, 2));
        RemoveItems(numbers);
        System.out.println("Hello, World!");
    }

    private static void RemoveItems(ArrayList<Integer> nums) {
        ArrayList<Integer> evenNums = new ArrayList<Integer>();
        for (int i = 0; i < nums.size(); i++) {
        if (nums.get(i) % 2 == 0) {
            evenNums.add(nums.get(i));
        } else {
            nums.remove(i);
            i--;
        }
        }
        System.out.println(evenNums);
    }
}

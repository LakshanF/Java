package TEALS.code_org.unit_9;

public class SortDriver {

    static int counter=0;
    public static void main(String[] args) {
        // int[] numbers = {12, 11, 13, 5, 6, 7};
        int[] numbers = {12, 11, 8, 7, 6, 5};
        mergeSort(numbers, 0, numbers.length - 1);
        System.out.println("numbers after merge sort -> ");
        PrintArray(numbers);
    }

    private static void PrintArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
        System.out.println();
    }

    public static void mergeSort(int[] numList, int left, int right) {
        if (left < right) {
          System.out.println("mergeSort_1 called " + counter++ + " times, left = " + left + ", right = " + right);
          int middle = (left + right) / 2;
    
          mergeSort(numList, left, middle);
          
          System.out.println("mergeSort_2 called " + counter++ + " times, middle + 1 = " + (middle + 1) + ", right = " + right);
          mergeSort(numList, middle + 1, right);
    
          System.out.println("mergeSort_3 called " + counter++ + " times, left = " + left + ", middle = " + middle + ", right = " + right);
          merge(numList, left, middle, right);
        }
      }
      
      public static void merge(int[] numList, int left, int middle, int right) {
        // create temporary arrays
        System.out.println("merge called " + counter++ + " times, left = " + left + ", middle = " + middle + ", right = " + right);
        int[] leftList = new int[middle - left + 1];
        int[] rightList = new int[right - middle];
    
        // copy numList into the temporary arrays
        for (int index = 0; index < leftList.length; index++) {
          leftList[index] = numList[left + index];
        }
    
        for (int index = 0; index < rightList.length; index++) {
          rightList[index] = numList[middle + index + 1];
        }
    
        // current indexes of temporary arrays
        int leftIndex = 0;
        int rightIndex = 0;
        
        // copy from leftList and rightList back into numList
        for (int index = left; index <= right; index++) {
          // if there are still uncopied values in leftList and rightList, copy the smallest value of the two
          if (leftIndex < leftList.length && rightIndex < rightList.length) {
            if (leftList[leftIndex] < rightList[rightIndex]) {
              numList[index] = leftList[leftIndex];
              leftIndex++;
            }
            else {
              numList[index] = rightList[rightIndex];
              rightIndex++;
            }
          }
          else if (leftIndex < leftList.length) {
            // if all values have been copied from rightList, copy the rest of leftList
            numList[index] = leftList[leftIndex];
            leftIndex++;
          }
          else if (rightIndex < rightList.length) {
            // if all values have been copied from leftList, copy the rest of rightList
            numList[index] = rightList[rightIndex];
            rightIndex++;
          }
        }
        System.out.print("Merge ->");
        PrintArray(numList);
      }      
}

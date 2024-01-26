public class Question_4 {
    public static void main(String[] args) {
  
      System.out.println("HW");
    
      int[][] intArr = {
        {10, 11, 12},
        {20, 21, 22},
        {30, 31, 32},
        {40, 41, 42},
      };
  
      System.out.println("Rows: " + intArr.length);
      System.out.println("Columns: " + intArr[0].length);
      
      System.out.println();
      System.out.println("Print by Rows");
      printArrByRow(intArr);
  
      System.out.println();
      System.out.println("Print by Columns");
      printArrByCol(intArr);

      System.out.println();
      System.out.println("Print Column");
      printArrCol(intArr, 1);

      // BoxOfCandy box = new BoxOfCandy();
      // System.out.println(box.moveCandyToFirstRow(0));
      
    }
  
    static void printArrByRow(int[][] array) {
      for(int row = 0; row < array.length; row++) {
        for(int col = 0; col < array[row].length; col++) {
          System.out.print( array[row][col] + " ");
        }
        System.out.println();
      }
    }
  
    static void printArrByCol(int[][] array) {
      for(int col = 0; col < array[0].length; col++) {
        for(int row = 0; row < array.length; row++) {
          System.out.print( array[row][col] + " ");
        }
        System.out.println();
      }
    }
    
    static void printArrCol(int[][] array, int col) {
      for(int row = 0; row < array.length; row++) {
        System.out.print( array[row][col] + " ");
      }
      System.out.println();
    }
  }
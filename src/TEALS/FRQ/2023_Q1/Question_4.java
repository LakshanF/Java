public class Question_4 {
    public static void main(String[] args) {
      check2DArrayAccess();

      // partA();
      // partB();
      
    }

    private static void partB() {
      Candy[][] candy = {
        {new Candy("lime"), new Candy("lime"), null, new Candy("lemon"), null},
        {new Candy("orange"), null, null, new Candy("lime"), new Candy("lime")},
        {new Candy("cherry"), null, new Candy("lemon"), null, new Candy("orange")},
      };
      BoxOfCandy box = new BoxOfCandy(candy);
      showCandyBox(candy);
      System.out.println();

      Candy choc;

      choc = box.removeNextByFlavor("cherry");
      showCell(choc);
      showCandyBox(candy);
      System.out.println();

      choc = box.removeNextByFlavor("lime");
      showCell(choc);
      showCandyBox(candy);
      System.out.println();

      choc = box.removeNextByFlavor("grape");
      showCell(choc);
      showCandyBox(candy);
      System.out.println();

    }

    private static void showCell(Candy choc) {
      if(choc==null)
        System.out.println("null");
      else
        System.out.println(choc.getFlavor());
    }

    static void partA() {

      Candy[][] candy = {
        {null, new Candy("lime"), null},
        {null, new Candy("orange"), null},
        {null, null, new Candy("cherry")},
        {null, new Candy("lemon"), new Candy("grape")}
      };
      BoxOfCandy box = new BoxOfCandy(candy);
      showCandyBox(candy);

      System.out.println(box.moveCandyToFirstRow(0));
      showCandyBox(candy);

      System.out.println(box.moveCandyToFirstRow(1));
      showCandyBox(candy);

      System.out.println(box.moveCandyToFirstRow(2));
      showCandyBox(candy);
    }

    private static void showCandyBox(Candy[][] candy) {
      for(int row = 0; row < candy.length; row++) {
        for(int col = 0; col < candy[row].length; col++) {
          if(candy[row][col]==null)
            System.out.print("null ");
          else
            System.out.print(candy[row][col].getFlavor() + " ");
        }
        System.out.println();
      }
    }

    static void check2DArrayAccess() {
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
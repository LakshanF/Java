public class BoxOfCandy {
    private Candy[][] box;

    public BoxOfCandy(Candy[][] chocs) {
      box = chocs;
    }

    public boolean moveCandyToFirstRow(int col) {
      // 1) Check the first row, col => If a candy is found return true
      // 2) Walk down the column to see if there is a candy in a row:
      // 3) IF we find it, move it to the first row, make sure the old candy is no longer there, return true
      // 4) return false

      if(box[0][col] != null) {
        return true;
      }

      for(int row = 1; row < box.length; row++) {
        if(box[row][col] != null) {
          box[0][col] = box[row][col];
          box[row][col] = null;
          return true;
        }
      }

      // Traversing from the end
      // for(int row = box.length - 1; row > 0; row--) {
      //   if(box[row][col] != null) {
      //     box[0][col] = box[row][col];
      //     box[row][col] = null;
      //     return true;
      //   }
      // }

      return false;

    }

    public Candy removeNextByFlavor(String flavor) {
      for(int row = box.length -1 ; row >= 0; row--) {
        for(int col = 0; col < box[row].length; col++) {
          if(box[row][col]!=null && box[row][col].getFlavor().equals(flavor)) {
            Candy c = box[row][col];
            box[row][col] = null;
            return c;
          }
        }
      }

      return null;

    }

}

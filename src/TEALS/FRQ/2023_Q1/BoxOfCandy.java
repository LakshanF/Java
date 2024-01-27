public class BoxOfCandy {
    private Candy[][] box;

    public BoxOfCandy(Candy[][] chocs) {
      box = chocs;
    }

    public boolean moveCandyToFirstRow(int col) {
      if(box[0][col] != null)
        return true;

      for(int row = 1; row < box.length; row++) {
        if(box[row][col] != null) {
          box[0][col] = box[row][col];
          box[row][col] = null;
          return true;
        }
      }
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

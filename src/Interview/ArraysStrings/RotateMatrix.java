/** Given an image represented by an NxN matrix, where each pixel in the image is 4 butes, write a method to rotate the image by 90 degrees.
 *  Can you do this in place?
 * 
*/

public class RotateMatrix{
    public static void main(String[] args) {
        int[][] A = GetMatrix(5);
        PrintMatrix(A);
        int[][] B = RotateOld(A);
        System.out.println();
        PrintMatrix(B);
    }

    static int[][] GetMatrix(int n){
        int[][] A = new int[n][n];
        int value = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                A[i][j] = value++;
            }
        }
        return A;
    }

    /** This method rotates the matrix in place
     *  There are 4 points that are impacted by a rotate: 0=>90=>180=>270=>0
     *  We will therefore use a temporary buffer  to store the 4 points impacted by a rotation
     *  We also will consider concentric squares of the matrix starting from the outermost
     *  There will be floor[n/2] iterations of concentric squares
     * 
     * @param A - Matrix to be transponsed
     */
    static void Rotate(int[][] A){
        int n = A.length;
        int[] tempVAlues = new int[4];
        for(int i = 0, z = (n - i); i< Math.floor(n); i++, z--){
            //looking at each square matrix in concentric circles
            for(int j = (i + 0), y = (n - i); j < (n - i); j++, y--){
                //save the points that are to be rotated in a temp buffer
                //for(int k = 0; k <4; k++){
                tempVAlues[0] = A[i][j];
                tempVAlues[1] = A[i][k];
                tempVAlues[2] = A[i][j];
                tempVAlues[3] = A[i][j];
                //}
            }
        }
    }

    static int[][] RotateOld(int[][] A){
        int n=A.length;
        int[][] B = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0, k=n-1; j < n; j++, k--){
                B[i][j] = A[k][i];
            }
        }
        return B;
    }


    static void PrintMatrix(int[][] A){
        int n = A.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf("%3d ", A[i][j]);
            }
            System.out.println();
        }
    }
}
/** Given an image represented by an NxN matrix, where each pixel in the image is 4 butes, write a method to rotate the image by 90 degrees.
 *  Can you do this in place?
 * 
*/

public class RotateMatrix{
    public static void main(String[] args) {
        int[][] A = GetSampleMatrix(3);
        PrintMatrix(A);
        System.out.println();

        //int[][] B = RotateOld(A);
        RotateInPlace(A);

        PrintMatrix(A);
    }

    /**
     * Gets a sample matrix for testing purposes initialized with sequential values
     * @param n
     * @return
     */
    static int[][] GetSampleMatrix(int n){
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
    static void RotateInPlace(int[][] A){
        int n = A.length;
        int[] tempValues = new int[4];
        for(int i = 0, z = (n - i - 1); i< Math.floor(n/2); i++, z--){
            //looking at each square matrix in concentric circles
            for(int j = (i + 0), y = (n - j - 1); j < (n - i - 1); j++, y--){
                //save the points that are to be rotated in a temp buffer
                tempValues[0] = A[i][j];
                tempValues[1] = A[j][z];
                tempValues[2] = A[z][y];
                tempValues[3] = A[y][i];

                A[i][j] = tempValues[3];
                A[j][z] = tempValues[0];
                A[z][y] = tempValues[1];
                A[y][i] = tempValues[2];

            }
        }
    }

    /**
     * Rotates to a new matric
     * @param A
     * @return
     */
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
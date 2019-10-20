/** Given an image represented by an NxN matrix, where each pixel in the image is 4 butes, write a method to rotate the image by 90 degrees.
 *  Can you do this in place?
 * 
*/

public class RotateMatrix{
    public static void main(String[] args) {
        int[][] A = GetMatrix(5);
        PrintMatrix(A);
        int[][] B = Rotate(A);
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

    static int[][] Rotate(int[][] A){
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
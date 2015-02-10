// 2D Array Practice for Recitation 3
public class Rec3 {

	public static void main(String[] args) {

		int[][] matrix = {
				{2, 4, 6, 5},
				{4, 7, 2, 0},
				{1, 3, 9, 1},
				{6, 0, 3, 1}
		};  
		printMatrix(matrix);

		int[][] zeroedMatrix = zeroMatrix(matrix);

		System.out.println("\nThe zeroed matrix:");
		printMatrix(zeroedMatrix);

	}

	/** Accepts a square 2D array and returns a 'zeroed' 2D array
	 *  To 'zero' an array:
	 *   If an element in the original array == 0, then set all of the
	 *   elements in the entire row and column of the new array to 0
	 */
	public static int[][] zeroMatrix(int[][] matrix) {
		int[][] DupicateMatrix = new int[4][4];

		/* make duplicate of the original matrix*/
		for (int row =0; row< matrix.length;row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				DupicateMatrix [row][col]=matrix[row][col];   
			}
		}

		/** Note that arrays are objects
		 * Assigning an object to another object is NOT equal to copying
		 * Therefore,
		 * DupicateMatrix =matrix;
		 * will not give us what we want. */



		// implement this function!
		for (int row =0; row< matrix.length;row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (DupicateMatrix[row][col]==0) {
					for (int i=0;i<matrix.length;i++){
						matrix[i][col]=0;
					}
					for (int j=0;j<matrix[0].length;j++){
						matrix[row][j]=0;
					}

				}
			}
		}

		System.out.print('\n');   
		System.out.print("Duplicate");   
		System.out.print('\n');   

		for (int row =0; row< matrix.length;row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				System.out.print(DupicateMatrix[row][col] + " ");   
			}
			System.out.print('\n');
		}

		return matrix;
	}

	/** Accepts a 2D integer array and prints it to the console */
	public static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.print('\n');
		}
	}

}



package SCF_Session5_Recursion;
/**
 * main class of N Queen Problem
 */
public class N_Queen {
	static N_Queen nqueen = new N_Queen();
	
	/**
	 * function to display the final matrix
	 * @param n: size of matrix
	 */
	 public void display(int chessBoard[][],int n)
	 {
	            for (int row = 0; row < n; row++) {
	                for (int column = 0; column < n; column++)
	                {
	                    System.out.print("    " + chessBoard[row][column] + "    ");
	                }
	                System.out.println("");
	            }	
	            System.out.println("");
	 }
	 
	 /**
	  * function to calculate the positon of n queens 
	  * @param chessBoard: array storing the position of Queen
	  * @param row
	  * @param n:size of matrix
	  * @return true if placing is possible else false
	  */
    boolean funcOperation(int chessBoard[][], int row, int n) {
        
        if (row >= n) {
        	display(chessBoard,n);
            return true;
        }
        for (int column = 0; column < n; column++) {
            if (isCorrectPosition(chessBoard, row, column)) {
                chessBoard[row][column] = 1;

                if (funcOperation(chessBoard, row + 1,n)) {
                    return true;
                }
                chessBoard[row][column] = 0;

            }
        }

        return false;
    }

    /**
     * function to check if the position where the queen to be place is free
     * @param chessBoard
     * @param row
     * @param column
     * @return true if the position is empty else false
     */
    boolean isCorrectPosition(int chessBoard[][], int row, int column) {
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][column] == 1) {
                return false;
            }
        }
        for (int row1 = row, column1 = column; row1 >= 0 && column1 >= 0; row1--, column1--) {
            if (chessBoard[row1][column1] == 1) {
                return false;
            }
        }
        for (int row1 = row, column1 = column; row1 >= 0
                && column1 < chessBoard.length; row1--, column1++) {
            if (chessBoard[row1][column1] == 1) {
                return false;
            }
        }

        return true;
    }

}

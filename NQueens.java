//THIS WORKS. But it doesn't flow through the test bc my placeNQueens method has paramaters
public class NQueens{
    public int n;
    public int board[][];
    public int row;
    public int col;

    NQueens(int n){
        this.n = n;
        this.board = new int[n][n];
        this.row = n-1;
        this.col = n-1;
    }

    /* prints solution */
    void printSolution(int board[][]) {

        {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(" " + board[i][j]
                            + " ");
                System.out.println();
            }
        }
    }

    /* checks if a queen can be placed on board[row][col] */

    Boolean placeNQueens(int board[][], int row,int col) throws ArrayIndexOutOfBoundsException{
        int i;
        int j;

        if(n<1){
            throw new ArrayIndexOutOfBoundsException("Size is less than one");
        }

        /* Checks the left side row */
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        /* Checks the left side diagonal */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        /* Checks left side lower diagonal */
        for (i = row, j = col; j >= 0 && i < n; i++, j--) {

            if (board[i][j] == 1) {
                return false;
            }
        }


        return true;
    }


    Boolean NQueensBacktrack(int board[][], int col){

        if (col >= n){
            return true;
        }

        for(int i =0; i < n; i++){
            if (placeNQueens(board, i, col)){
                board[i][col]= 1;
                if (NQueensBacktrack(board, col+1) == true){
                    return true;
                }else{
                    board[i][col] = 0;
                }
            }
        }return false;
    }

    Boolean solveNQ(){
        int board[][] = { { 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0},
        };
        if (NQueensBacktrack(board, 0)==false){
            System.out.print("No answer");
            return false;
        }
        printSolution(board);
        return true;

    }

    public static void main(String args[]){
        NQueens Queen = new NQueens(8);

        Queen.solveNQ();
    }


}

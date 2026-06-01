package TictactoeProject.service;


import TictactoeProject.entity.Board;


import TictactoeProject.entity.Mark;
import TictactoeProject.exception.CellAlreadyOccupiedException;




public class BoardService {

    private Board board;

    public BoardService(Board board) {
        this.board = board;

    }



    public void placeMark(int row, int col, Mark mark)  {



        if (board.getBoard()[row][col] != null) {
            throw new CellAlreadyOccupiedException("Cell already occupied");
        }

        board.getBoard()[row][col] = mark;
    }


    public void displayBoard() {

            int position = 1;

            System.out.println("-----------------");

            for (int i = 0; i < 3; i++) {

                System.out.print("| ");

                for (int j = 0; j < 3; j++) {

                    if (board.getBoard()[i][j] == null) {
                        System.out.print(position + " | ");
                    } else {
                        System.out.print(board.getBoard()[i][j] + " | ");
                    }

                    position++;
                }

                System.out.println();
                System.out.println("-----------------");
            }
        }

    public boolean checkRowWin() {

        Mark[][] b = board.getBoard();

        for (int i = 0; i < 3; i++) {

            if ( b[i][0] != null &&b[i][0] == b[i][1] && b[i][1] == b[i][2]) {
                return true;
            }
        }

        return false;
    }

    public boolean checkColumnWin() {

        Mark[][] b = board.getBoard();

        for (int i = 0; i < 3; i++) {
            if (b[0][i] != null &&
                    b[0][i] == b[1][i] &&
                    b[1][i] == b[2][i]) {

                return true;
            }
        }

        return false;
    }

    public boolean checkDiagonalWin() {

        Mark[][] b = board.getBoard();

        return (b[0][0] != null &&

                b[0][0] == b[1][1] &&
                b[1][1] == b[2][2]) ||

                (b[0][2] != null && b[0][2] == b[1][1] &&
                        b[1][1] == b[2][0]) ;
    }

    public boolean isBoardFull() {

        Mark[][] b = board.getBoard();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == null) {
                    return false;
                }
            }
        }

        return true;
    }
}

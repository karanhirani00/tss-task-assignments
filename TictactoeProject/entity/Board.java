package TictactoeProject.entity;

public class Board {

    private Mark[][] board;

    public Board() {
        board = new Mark[3][3];
    }

    public Mark[][] getBoard() {
        return board;
    }
}
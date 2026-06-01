package TictactoeProject.service;


import TictactoeProject.entity.Player;
import TictactoeProject.exception.CellAlreadyOccupiedException;
import TictactoeProject.exception.InvalidInputException;


public class GameService {

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    private BoardService boardService;
    private InputService inputService;

    public GameService(Player player1, Player player2, BoardService boardService, InputService inputService) {

        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;

        this.boardService = boardService;
        this.inputService = inputService;

    }

    public void startGame() {
        boardService.displayBoard();
        while (true) {

            try {


                System.out.println(currentPlayer.getName() + "'s Turn");
                int position = inputService.getInput("enter a possition 1 to 9");
                if(!(position >=1 && position<=9)){
                    throw  new InvalidInputException("plese enter a valid possition between 1 to 9");
                }
                int row = (position - 1) / 3;
                int col = (position - 1) % 3;

                boardService.placeMark(row, col, currentPlayer.getMark());
                boardService.displayBoard();

                if (boardService.checkRowWin() || boardService.checkColumnWin() ||
                        boardService.checkDiagonalWin()) {

                    System.out.println(currentPlayer.getName() + " Won The Game");

                    break;
                }

                if (boardService.isBoardFull()) {
                    System.out.println("Game Draw");
                    break;
                }

                switchPlayer();

            }

            catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }catch (CellAlreadyOccupiedException e){
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println("somting want wrong!");
            }
        }
    }

    private void switchPlayer() {

        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}
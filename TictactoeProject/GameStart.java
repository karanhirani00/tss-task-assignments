package TictactoeProject;

import TictactoeProject.entity.Board;
import TictactoeProject.entity.Mark;
import TictactoeProject.entity.Player;
import TictactoeProject.exception.InvalidInputException;
import TictactoeProject.service.BoardService;
import TictactoeProject.service.GameService;
import TictactoeProject.service.InputService;

import java.util.Scanner;

public class GameStart {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

    try {
        System.out.println("=================================");
        System.out.println("     WELCOME TO TIC TAC TOE      ");
        System.out.println("=================================");

        System.out.print("Enter Player 1 Name (X): ");
       String player1Name = sc.nextLine();
        if (!player1Name.matches("[a-zA-Z ]+")) {
            throw new InvalidInputException("Invalid Name");
        }

        System.out.print("Enter Player 2 Name (O): ");
        String  player2Name = sc.nextLine();
        if (!player2Name.matches("[a-zA-Z ]+")) {
            throw new InvalidInputException("Invalid Name");
        }


        Board board = new Board();

        Player player1 = new Player(player1Name, Mark.X);

        Player player2 = new Player(player2Name, Mark.O);

        BoardService boardService = new BoardService(board);

        InputService inputService = new InputService();

        GameService gameService = new GameService(player1, player2, boardService, inputService);

        gameService.startGame();

    }catch (InvalidInputException e){
        System.out.println(e.getMessage());
    } catch (Exception e) {
        System.out.println(e);
    }
    }
}

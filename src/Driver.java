import models.Player;
import services.TicTacToeService;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicTacToeService ticTacToeService = new TicTacToeService();
        // only 2 players can play
        for(int i=0; i<2; i++){
            ticTacToeService.addPlayer(new Player(sc.next().charAt(0),sc.next()));
        }
        ticTacToeService.printBoard();
        System.out.println("Start your moves by giving position where you want to insert");
        while (true){
            String firstInput = sc.next();
            if(!firstInput.equalsIgnoreCase("exit")){
                ticTacToeService.move(Integer.parseInt(firstInput), sc.nextInt());
            }else{
                System.out.println("Game has been finished");
                break;
            }
        }

    }
}

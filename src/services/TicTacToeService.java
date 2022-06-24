package services;

import models.Player;
import models.TicTacToeArena;

import java.util.LinkedList;
import java.util.Queue;

public class TicTacToeService {
    Queue<Player> players;
    TicTacToeArena ticTacToeArena;

    public TicTacToeService() {
        players = new LinkedList<>();
        ticTacToeArena = new TicTacToeArena();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void move(int x, int y){
        Player currentPlayer = players.peek();
        if(isValidMove(x,y)){
            players.poll();
            ticTacToeArena.getBoard()[x-1][y-1] = currentPlayer.getMovePiece();
            printBoard();
            if(hasWon(currentPlayer, x, y)){
                System.out.println("Player "+currentPlayer.getName()+" won the game");
            }
            players.add(currentPlayer);
        }else{
            System.out.println("Invalid Move");
        }
    }

    public void printBoard() {
        char[][] board = ticTacToeArena.getBoard();
        int boardSize = board.length;
        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private boolean hasWon(Player player, int x, int y) {
        char movePiece = player.getMovePiece(); // X or O
        char[][] board = ticTacToeArena.getBoard();
        // keeping y fixed, check for all in that column
        // checking vertical
        boolean colLine = true;
        int boardSize = ticTacToeArena.getBoardSize();
        for(int i=0; i<boardSize; i++){
            colLine = colLine && board[i][y-1] == movePiece;
        }

        // keeping x fixed, check for all in that row
        // checking vertical
        boolean rowLine = true;
        for(int j=0; j<boardSize; j++){
            rowLine = rowLine && board[x-1][j] == movePiece;
        }

        // check diagonal
        if(x==y || (x+y == boardSize-1)){
            boolean diagonalLine1 = true;
            for(int i=0; i<boardSize; i++){
                diagonalLine1 = diagonalLine1 && board[i][i] == movePiece;
            }

            boolean diagonalLine2 = true;
            for(int i=0; i<boardSize; i++){
                diagonalLine2 = diagonalLine2 && board[i][boardSize-i-1] == movePiece;
            }

            return rowLine || colLine || diagonalLine1 || diagonalLine2;
        }else{
            return rowLine || colLine;
        }
    }

    private boolean isValidMove(int x, int y) {
        int boardSize = ticTacToeArena.getBoardSize();
        return (x > 0 && x <= boardSize) && (y > 0 && y <= boardSize) && ticTacToeArena.getBoard()[x-1][y-1] == '-';
    }


}

package models;

import java.util.HashMap;
import java.util.Map;

public class TicTacToeArena {
    private Integer boardSize;
    private static Integer DEFAULT_BOARD_SIZE = 3;
    char[][] board;
    public TicTacToeArena(Integer boardSize) {
        this.boardSize = boardSize;
        board = new char[boardSize][boardSize];
        initializeBoard();
    }

    private void initializeBoard() {
        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                board[i][j] = '-';
            }
        }
    }

    public TicTacToeArena() {
        this(TicTacToeArena.DEFAULT_BOARD_SIZE);
    }

    public Integer getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(Integer boardSize) {
        this.boardSize = boardSize;
    }

    public static Integer getDefaultBoardSize() {
        return DEFAULT_BOARD_SIZE;
    }

    public static void setDefaultBoardSize(Integer defaultBoardSize) {
        DEFAULT_BOARD_SIZE = defaultBoardSize;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }
}

package models;

public class Player {

    private char movePiece;
    private String name;

    public Player(char movePiece, String name) {
        this.movePiece = movePiece;
        this.name = name;
    }

    public char getMovePiece() {
        return movePiece;
    }

    public void setMovePiece(char movePiece) {
        this.movePiece = movePiece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

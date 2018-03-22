package sample;

import javafx.scene.Node;

public class Coordinates {
    private Node node;
    private int higth;
    private int wigth;

    public Coordinates (Node node, int higth, int wigth) {
        this.node = node;
        this.higth = higth;
        this.wigth = wigth;
    }

    public Node getNode() { return node; }

    public int getHigth() { return higth; }

    public void setHigth(int higth) {
        this.higth = higth;
    }

    public int getWigth() { return wigth; }

    public void setWigth(int wigth) {
        this.wigth = wigth;
    }

    @Override
    public String toString() {
        return "hight " + higth + " wigth " + wigth;
    }
}

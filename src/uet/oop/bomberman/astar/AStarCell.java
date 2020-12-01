package uet.oop.bomberman.astar;

public class AStarCell<T> {
    int col;
    int row;
    boolean isTraversable;

    double g;
    double f;
    double h;

    AStarCell<T> cameFrom;

    public AStarCell(int col, int row, boolean isPath) {
        this.col=col;
        this.row=row;
        this.isTraversable = isPath;
    }

    public double getF() {
        return f;
    }

    public double getG() {
        return g;
    }

    public double getH() {
        return h;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}

package uet.oop.bomberman.astar;

public class AStarCell<T> {
    int col;
    int row;
    boolean isTraversable;

    /**
     * A pointer to an object of your choice. Unused in the A* algorithm.
     * Usually you convert your grid to the (virtual) A* grid, then find the path.
     * Afterwards you'd want to find out which of your cells are on the path.
     */
    T obj;

    double g;
    double f;
    double h;

    AStarCell<T> cameFrom;

    public AStarCell(int col, int row, boolean isPath, T obj) {
        this.col=col;
        this.row=row;
        this.isTraversable = isPath;
        this.obj = obj;
    }

    public T getObject() {
        return obj;
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
}

package uet.oop.bomberman.astar;

public class AStarGrid<T> {

    AStarCell<T>[][] gridCells;
    int cols;
    int rows;

    public AStarGrid( int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        gridCells = new AStarCell[rows][cols];
    }

    public void setCell(int col, int row, boolean path) {
        gridCells[row][col] =  new AStarCell<T>(col,row, path);
    }

    public AStarCell<T> getCell( int col, int row) {
        return gridCells[row][col];
    }

    public AStarCell<T>[] getNeighbors(AStarCell<T> cell) {

        AStarCell<T>[] neighbors = new AStarCell[4];

        int currentColumn = cell.col;
        int currentRow = cell.row;

        int neighborColumn;
        int neighborRow;

        // top
        neighborColumn = currentColumn;
        neighborRow = currentRow - 1;

        if (neighborRow >= 0) {
            if( gridCells[neighborRow][neighborColumn].isTraversable) {
                neighbors[0] = gridCells[neighborRow][neighborColumn];
            }
        }

        // bottom
        neighborColumn = currentColumn;
        neighborRow = currentRow + 1;

        if (neighborRow < rows) {
            if( gridCells[neighborRow][neighborColumn].isTraversable) {
                neighbors[1] = gridCells[neighborRow][neighborColumn];
            }
        }

        // left
        neighborColumn = currentColumn - 1;
        neighborRow = currentRow;

        if ( neighborColumn >= 0) {
            if( gridCells[neighborRow][neighborColumn].isTraversable) {
                neighbors[2] = gridCells[neighborRow][neighborColumn];
            }
        }

        // right
        neighborColumn = currentColumn + 1;
        neighborRow = currentRow;

        if ( neighborColumn < cols) {
            if( gridCells[neighborRow][neighborColumn].isTraversable) {
                neighbors[3] = gridCells[neighborRow][neighborColumn];
            }
        }
        return neighbors;
    }

}

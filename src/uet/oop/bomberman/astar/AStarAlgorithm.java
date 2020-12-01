package uet.oop.bomberman.astar;

import java.util.*;

public class AStarAlgorithm {
    /**
     * Get the cell with the minimum f value.
     */
    public class CellComparator implements Comparator<AStarCell>
    {
        @Override
        public int compare(AStarCell a, AStarCell b)
        {
            return Double.compare(a.f, b.f);
        }
    }

    /**
     * Find a path from start to goal using the A* algorithm
     */
    @SuppressWarnings("unchecked")
    public List<AStarCell> getPath( AStarGrid grid, AStarCell start, AStarCell goal) {

        AStarCell current = null;
        boolean containsNeighbor;

        int cellCount = grid.rows * grid.cols;

        // closedset := the empty set    // The set of nodes already evaluated.
        Set<AStarCell> closedSet = new HashSet<>( cellCount);

        // openset := {start}    // The set of tentative nodes to be evaluated, initially containing the start node
        PriorityQueue<AStarCell> openSet = new PriorityQueue<AStarCell>( cellCount, new CellComparator());
        openSet.add( start);

        // g_score[start] := 0    // Cost from start along best known path.
        start.g = 0d;

        // Estimated total cost from start to goal through y.
        // f_score[start] := g_score[start] + heuristic_cost_estimate(start, goal)
        start.f = start.g + heuristicCostEstimate(start, goal);


        // while openset is not empty
        while( !openSet.isEmpty()) {

            // current := the node in openset having the lowest f_score[] value
            // note: we have a priorityqueue => for performance reasons we also remove the item instead of removing it later (as suggested in the algorithm)
            // remove current from openset
            current = openSet.poll();

            // if current = goal
            //        return reconstruct_path(came_from, goal)
            if( current == goal) {
                return reconstructPath( goal);
            }

            // remove current from openset
            // already done in openSet.poll(), see above

            // add current to closedset
            closedSet.add( current);

            // for each neighbor in neighbor_nodes(current)
            for( AStarCell neighbor: grid.getNeighbors( current)) {

                if( neighbor == null) {
                    continue;
                }

                // if neighbor in closedset
                //   continue
                if( closedSet.contains( neighbor)) {
                    continue;
                }

                // tentative_g_score := g_score[current] + dist_between(current,neighbor)
                double tentativeScoreG = current.g + distBetween( current, neighbor);

                // if neighbor not in openset or tentative_g_score < g_score[neighbor]
                if( !(containsNeighbor=openSet.contains( neighbor)) || Double.compare(tentativeScoreG, neighbor.g) < 0) {

                    // came_from[neighbor] := current
                    neighbor.cameFrom = current;

                    // g_score[neighbor] := tentative_g_score
                    neighbor.g = tentativeScoreG;

                    // f_score[neighbor] := g_score[neighbor] + heuristic_cost_estimate(neighbor, goal)
                    neighbor.h = heuristicCostEstimate(neighbor, goal);
                    neighbor.f = neighbor.g + neighbor.h;

                    // if neighbor not in openset
                    //   add neighbor to openset
                    if( !containsNeighbor) {
                        openSet.add( neighbor);
                    }
                }
            }
        }

        // nothing found
        return new ArrayList<>();
    }

    /**
     * Create final path of the A* algorithm.
     * The path is from goal to start.
     */
    // function reconstruct_path(came_from,current)
    private List<AStarCell> reconstructPath( AStarCell current) {

        List<AStarCell> totalPath = new ArrayList<>(200); // arbitrary value, we'll most likely have more than 10 which is default for java

        // total_path := [current]
        totalPath.add( current);

        // while current in came_from:
        // current := came_from[current]
        while( (current = current.cameFrom) != null) {

            // total_path.append(current)
            totalPath.add( current);

        }

        // return total_path
        return totalPath;
    }

    /**
     * Distance between a given cell and its neighbor.
     * Used in the algorithm as distance calculation between the current cell and a neighbor.
     * In our case we use the same distance which we use from the current cell to the goal.
     */
    private double distBetween(AStarCell current, AStarCell neighbor) {
        return heuristicCostEstimate( current, neighbor);
    }

    /**
     * Distance between two cells. We use the euclidian distance here.
     * Used in the algorithm as distance calculation between a cell and the goal.
     */
    private double heuristicCostEstimate(AStarCell from, AStarCell to) {

        return Math.sqrt((from.col-to.col)*(from.col-to.col) + (from.row - to.row)*(from.row-to.row));

    }

}

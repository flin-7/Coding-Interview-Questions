package com.felix;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchAMaze {

    /*
    Black cells are wall. We cannot walk on them.
    White cells are traversable. We can walk on white cells.
     */
    public static enum Color { WHITE, BLACK }

    /*
    A standard coordinate to represent a cell in the maze with an row and col position
     */
    public static class Coordinate {
        public int row, col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row &&
                    col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate start, Coordinate end) {

        // This will hold the path.
        List<Coordinate> path = new ArrayList<>();

        maze.get(start.row).set(start.col, Color.BLACK);
        path.add(start);

        if (!hasPathToEnd(maze, start, end, path)) {
            path.remove(path.size() - 1);
        }

        return path;
    }

    private static boolean hasPathToEnd(List<List<Color>> maze, Coordinate node, Coordinate end, List<Coordinate> path) {
        if (node.equals(end)) {
            return true;
        }

        final int[][] SHIFTS = {
                {0, 1}, // going right
                {1, 0}, // going down
                {0, -1}, // going left
                {-1, 0} // going up
        };

        for (int[] shift: SHIFTS) {
            // The next item to possibly add to our path and search
            Coordinate next = new Coordinate(node.row + shift[0], node.col + shift[1]);

            if (canTraverse(next, maze)) {
                maze.get(next.row).set(next.col, Color.BLACK);
                path.add(next);
            }

            if (hasPathToEnd(maze, next, end, path)) {
                return true;
            }

            path.remove(path.size() - 1);
        }

        return false;
    }

    private static boolean canTraverse(Coordinate node, List<List<Color>> maze) {
        return node.row >= 0 && node.row < maze.size() &&
                node.col >= 0 && node.col < maze.get(node.row).size() &&
                maze.get(node.row).get(node.col) == Color.WHITE;
    }
}

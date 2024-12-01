import java.util.List;
import java.util.ArrayList;

public class Field {
    private Object[][] field;

    public Field(int depth, int width) {
        field = new Object[depth][width];
    }

    public void clear(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }

    public void place(Object object, Location location) {
        field[location.getRow()][location.getCol()] = object;
    }

    public Object getObjectAt(Location location) {
        return field[location.getRow()][location.getCol()];
    }

    public Location freeAdjacentLocation(Location location) {
        List<Location> free = new ArrayList<>();
        List<Location> adjacent = adjacentLocations(location);
        for (Location loc : adjacent) {
            if (getObjectAt(loc) == null) {
                free.add(loc);
            }
        }
        return free.isEmpty() ? null : free.get(0);
    }

    public List<Location> adjacentLocations(Location location) {
        List<Location> locations = new ArrayList<>();
        int[] rowOffsets = {-1, 1, 0, 0, -1, -1, 1, 1}; // Up, Down, Left, Right, and diagonals
        int[] colOffsets = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int i = 0; i < rowOffsets.length; i++) {
            int newRow = location.getRow() + rowOffsets[i];
            int newCol = location.getCol() + colOffsets[i];
            if (newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[0].length) {
                locations.add(new Location(newRow, newCol));
            }
        }
        return locations;
    }

    public int getDepth() {
        return field.length;
    }

    public int getWidth() {
        return field[0].length;
    }
}

import java.util.HashMap;
import java.util.Set;

public class Room {
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getDescription() {
        return description;
    }

    public String getExitString() {
        Set<String> directions = exits.keySet();
        return directions.isEmpty() ? "No exits available." : "Exits: " + String.join(", ", directions);
    }

    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }
}

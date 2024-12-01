import java.util.List; 

public abstract class Animal {
    private int age;
    private boolean alive;
    private Field field;
    private Location location;
    private String name;

    public Animal(Field field, Location location, String name) {
        this.age = 0;
        this.alive = true;
        this.field = field;
        this.name = name;
        setLocation(location);
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setDead() {
        alive = false;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location newLocation) {
        location = newLocation;
    }

    public Field getField() {
        return field;
    }

    public void incrementAge() {
        age++;
    }

    public abstract void act(List<Animal> newAnimals);

    @Override
    public String toString() {
        return name + " at " + location + " Alive: " + alive;
    }
}

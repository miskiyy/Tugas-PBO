import java.util.List;

public class Rabbit extends Animal {
    public Rabbit(Field field, Location location, String name) {
        super(field, location, name);
    }

    @Override
    public void act(List<Animal> newAnimals) {
        if (isAlive()) {
            System.out.println(getName() + " is alive at location: " + getLocation());
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if (newLocation != null) {
                setLocation(newLocation);
                System.out.println(getName() + " moved to: " + newLocation);
            } else {
                System.out.println(getName() + " has no space to move, is dead.");
                setDead();
            }
            incrementAge();  
        }
    }
}

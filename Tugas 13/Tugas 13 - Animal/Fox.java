import java.util.List;

public class Fox extends Animal {
    public Fox(Field field, Location location, String name) {
        super(field, location, name);
    }

    @Override
    public void act(List<Animal> newAnimals) {
        if (isAlive()) {
            Location foodLocation = findFood();
            if (foodLocation == null) {
                foodLocation = getField().freeAdjacentLocation(getLocation());
            }
            if (foodLocation != null) {
                setLocation(foodLocation);
            } else {
                setDead();
            }
            incrementAge();  
        }
    }

    private Location findFood() {
        List<Location> adjacent = getField().adjacentLocations(getLocation());
        for (Location loc : adjacent) {
            Object animal = getField().getObjectAt(loc);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                rabbit.setDead(); 
                return loc;
            }
        }
        return null; 
    }
}

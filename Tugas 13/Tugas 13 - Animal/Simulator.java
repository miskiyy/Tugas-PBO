import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private Field field;
    private List<Animal> animals;

    public Simulator(int depth, int width) {
        field = new Field(depth, width);
        animals = new ArrayList<>();
        populate();
    }

    public void simulate(int steps) {
        for (int step = 0; step < steps; step++) {
            System.out.println("Step " + step); 
            List<Animal> newAnimals = new ArrayList<>();
            for (Animal animal : animals) {
                animal.act(newAnimals);
            }
            animals.addAll(newAnimals);
           
            for (Animal animal : animals) {
                System.out.println(animal);
            }

            System.out.println("Alive animals: " + animals.stream().filter(Animal::isAlive).count());
        }
    }

    private void populate() {
        int numberOfFoxes = 5;
        int numberOfRabbits = 10;

        for (int i = 0; i < numberOfFoxes; i++) {
            Location location = getRandomLocation();
            Fox fox = new Fox(field, location, "Fox" + (i + 1));
            animals.add(fox);
            field.place(fox, location);
        }

        for (int i = 0; i < numberOfRabbits; i++) {
            Location location = getRandomLocation();
            Rabbit rabbit = new Rabbit(field, location, "Rabbit" + (i + 1));
            animals.add(rabbit);
            field.place(rabbit, location);
        }

        System.out.println("Number of foxes: " + numberOfFoxes);
        System.out.println("Number of rabbits: " + numberOfRabbits);
    }

    private Location getRandomLocation() {
        int row = (int) (Math.random() * field.getDepth());
        int col = (int) (Math.random() * field.getWidth());
        Location location = new Location(row, col);

        while (field.getObjectAt(location) != null) {
            row = (int) (Math.random() * field.getDepth());
            col = (int) (Math.random() * field.getWidth());
            location = new Location(row, col);
        }

        return location;
    }
}

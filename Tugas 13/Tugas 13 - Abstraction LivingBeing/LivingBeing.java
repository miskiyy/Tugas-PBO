public abstract class LivingBeing {
    private String name;

    // Constructor
    public LivingBeing(String name) {
        this.name = name;
    }

    // Getter untuk nama
    public String getName() {
        return name;
    }

    // Metode umum untuk bernafas
    public void breathe() {
        System.out.println(name + " is breathing.");
    }

    // Metode abstrak untuk tumbuh
    public abstract void grow();
}

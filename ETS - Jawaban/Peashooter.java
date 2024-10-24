class Peashooter extends Tanaman {

    // Konstruktor untuk Peashooter
    public Peashooter() {
        super("Peashooter", 100);  // Memanggil konstruktor kelas induk
    }

    // Metode khusus untuk Peashooter
    public void menembak() {
        System.out.println(nama + " menembakkan kacang polong!");
    }
}

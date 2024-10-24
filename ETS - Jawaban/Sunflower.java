class Sunflower extends Tanaman {

    // Konstruktor untuk Sunflower
    public Sunflower() {
        super("Sunflower", 80);  // Memanggil konstruktor kelas induk
    }

    // Metode khusus untuk Sunflower
    public void menghasilkanMatahari() {
        System.out.println(nama + " menghasilkan matahari!");
    }
}

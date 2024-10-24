class Tanaman {
    String nama;
    int health;

    // Konstruktor kelas induk
    public Tanaman(String nama, int health) {
        this.nama = nama;
        this.health = health;
    }

    // Metode umum untuk semua tanaman
    public void tumbuh() {
        System.out.println(nama + " sedang tumbuh.");
    }

    public void info() {
        System.out.println(nama + " memiliki " + health + " HP.");
    }
}

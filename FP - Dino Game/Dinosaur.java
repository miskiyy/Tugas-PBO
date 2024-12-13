import java.awt.Image;

public class Dinosaur extends Block {
    // Properti utama
    protected boolean isDucking = false;
    private boolean isAdjustingHeight = false;
    protected int velocityY = 0;
    protected int gravity = 1; // Gaya gravitasi konstan
    protected int originalY;  // Posisi Y awal
    private final Image runImage; // Gambar untuk posisi berlari
    private final Image duckImage; // Gambar untuk posisi menunduk

    // Konstruktor
    public Dinosaur(int x, int y, int width, int height, Image runImage, Image duckImage) {
        super(x, y, width, height, runImage); // Default menggunakan runImage
        this.originalY = y; // Simpan posisi awal
        this.runImage = runImage;
        this.duckImage = duckImage;
    }

    // Fungsi untuk melompat
    public void jump() {
        if (y == originalY && !isDucking) { // Hanya lompat jika di tanah dan tidak menunduk
            velocityY = -17; // Kecepatan lompat ke atas
        }
    }

    // Fungsi untuk menunduk
    public void duck() {
        if (!isDucking) {
            isDucking = true;
            // height = 50; // Tinggi saat menunduk
            if (!isAdjustingHeight) {
                y += 44; // Turun sedikit untuk menyesuaikan posisi
                isAdjustingHeight = true;
            }
            img = duckImage; // Ganti ke gambar menunduk
        }
    }

    // Fungsi untuk kembali berdiri
    public void standUp() {
        if (isDucking) {
            isDucking = false;
            // height = 94; // Kembali ke tinggi normal
            if (isAdjustingHeight) {
                y -= 44; // Kembali ke posisi awal
                isAdjustingHeight = false;
            }
            img = runImage; // Kembali ke gambar berlari
        }
    }

    // Fungsi untuk pergerakan vertikal
    public void move() {
        velocityY += gravity; // Tambahkan gravitasi ke kecepatan vertikal
        y += velocityY; // Perbarui posisi Y

        // Cegah dino jatuh di bawah tanah
        if (y > originalY) {
            y = originalY;
            velocityY = 0;
        }
    }

    public void reset() {
        y = originalY;
        height = 94;
        velocityY = 0;
        isDucking = false;
        img = runImage; // Pastikan kembali ke gambar berlari
    }
}

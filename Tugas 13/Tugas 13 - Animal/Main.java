public class Main {
    public static void main(String[] args) {
        // Membuat simulator dengan ukuran field 10x10
        Simulator simulator = new Simulator(10, 10);

        // Menjalankan simulasi selama 10 langkah
        simulator.simulate(10);
    }
}

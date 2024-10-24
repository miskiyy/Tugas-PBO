public class Main {
    public static void main(String[] args) {
        // Membuat objek dari Peashooter
        Peashooter peashooter = new Peashooter();
        peashooter.info();        
        peashooter.tumbuh();      
        peashooter.menembak();    

        System.out.println();

        // Membuat objek dari Sunflower
        Sunflower sunflower = new Sunflower();
        sunflower.info();               
        sunflower.tumbuh();             
        sunflower.menghasilkanMatahari(); 
    }
}

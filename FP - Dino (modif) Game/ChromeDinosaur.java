import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class ChromeDinosaur extends JPanel implements ActionListener, KeyListener {
    private static int highScore = 0;
    int boardWidth = 750;
    int boardHeight = 250;
    int trackX = 0; 
    int trackWidth = 0; 
 
    Image dinosaurImg1;
    Image dinosaurImg2;
    Image dinosaurImg3;
    Image cactus1Img;
    Image cactus2Img;
    Image cactus3Img;
    Image cactus4Img;
    Image cactus5Img;
    Image cactus6Img;
    Image gameOverImg;
    Image trackImage;
    Image resetImg;

    class Block {
        int x;
        int y;
        int width;
        int height;
        Image img;

        Block(int x, int y, int width, int height, Image img) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.img = img;
        }
    }

    // dinosaur
    int dinosaurWidth = 88;
    int dinosaurHeight = 94;
    int duckedDinosaurHeight = 47;
    boolean isDucking = false;
    int dinosaurX = 50;
    int dinosaurY = boardHeight - dinosaurHeight - 20; // adjust the Y position for a better view
    Block dinosaur;

    // cactus
    int cactus1Width = 34;
    int cactus2Width = 69;
    int cactus3Width = 102;
    int cactus4Width = 50;
    int cactus5Width = 103;
    int cactus6Width = 150;
    int cactusHeight = 70;
    int cactusBigHeight = 100;
    int cactusX = 700;
    int cactusY = boardHeight - cactusHeight - 20; // adjust the Y position for a better view
    ArrayList<Block> cactusArray;

    // physics
    int velocityX = -12; // cactus moving left speed
    int velocityY = 0; // dinosaur jump speed
    int gravity = 1;

    boolean gameOver = false;
    int score = 0;

    Timer gameLoop;
    Timer placeCactusTimer;

    public ChromeDinosaur(int playerChoice) {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.lightGray);
        setFocusable(true);
        addKeyListener(this);

        // Load images
        trackImage = new ImageIcon(getClass().getResource("./img/track.png")).getImage(); // Ganti dengan jalur gambar track
        dinosaurImg1 = new ImageIcon(getClass().getResource("./img/dino1-run.png")).getImage();
        dinosaurImg2 = new ImageIcon(getClass().getResource("./img/dino2-run.png")).getImage();
        dinosaurImg3 = new ImageIcon(getClass().getResource("./img/dino3-run.png")).getImage();
        cactus1Img = new ImageIcon(getClass().getResource("./img/cactus1.png")).getImage();
        cactus2Img = new ImageIcon(getClass().getResource("./img/cactus2.png")).getImage();
        cactus3Img = new ImageIcon(getClass().getResource("./img/cactus3.png")).getImage();
        cactus4Img = new ImageIcon(getClass().getResource("./img/big-cactus1.png")).getImage();
        cactus5Img = new ImageIcon(getClass().getResource("./img/big-cactus2.png")).getImage();
        cactus6Img = new ImageIcon(getClass().getResource("./img/big-cactus3.png")).getImage();
        gameOverImg = new ImageIcon(getClass().getResource("./img/game-over.png")).getImage();
        resetImg = new ImageIcon(getClass().getResource("./img/reset.png")).getImage();

        // Dinosaur selection
        switch (playerChoice) {
            case 0:
                dinosaur = new Block(dinosaurX, dinosaurY, dinosaurWidth, dinosaurHeight, dinosaurImg1);
                break;
            case 1:
                dinosaur = new Block(dinosaurX, dinosaurY, dinosaurWidth, dinosaurHeight, dinosaurImg2);
                break;
            case 2:
                dinosaur = new Block(dinosaurX, dinosaurY, dinosaurWidth, dinosaurHeight, dinosaurImg3);
                break;
            default:
                dinosaur = new Block(dinosaurX, dinosaurY, dinosaurWidth, dinosaurHeight, dinosaurImg1);
        }

        // Initialize cactus array
        cactusArray = new ArrayList<Block>();

        // Game timer
        gameLoop = new Timer(1000/60, this); // 60 frames per second
        gameLoop.start();
        trackWidth = boardWidth; // Lebar track sesuai dengan lebar papan permainan

        // Place cactus timer
        placeCactusTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeCactus();
            }
        });
        placeCactusTimer.start();
    }

    void placeCactus() {
    if (gameOver) {
        return;
    }

    double placeCactusChance = Math.random(); // 0 - 0.999999

    if (placeCactusChance > 0.95) { // 5% chance for cactus6
        Block cactus = new Block(cactusX, cactusY, cactus6Width, cactusBigHeight, cactus6Img);
        cactusArray.add(cactus);
    } else if (placeCactusChance > 0.80) { // 15% chance for cactus5
        Block cactus = new Block(cactusX, cactusY, cactus5Width, cactusBigHeight, cactus5Img);
        cactusArray.add(cactus);
    } else if (placeCactusChance > 0.65) { // 15% chance for cactus4
        Block cactus = new Block(cactusX, cactusY, cactus4Width, cactusBigHeight, cactus4Img);
        cactusArray.add(cactus);
    } else if (placeCactusChance > 0.45) { // 20% chance for cactus3
        Block cactus = new Block(cactusX, cactusY, cactus3Width, cactusHeight, cactus3Img);
        cactusArray.add(cactus);
    } else if (placeCactusChance > 0.25) { // 20% chance for cactus2
        Block cactus = new Block(cactusX, cactusY, cactus2Width, cactusHeight, cactus2Img);
        cactusArray.add(cactus);
    } else { // 25% chance for cactus1
        Block cactus = new Block(cactusX, cactusY, cactus1Width, cactusHeight, cactus1Img);
        cactusArray.add(cactus);
    }

    // Batasi jumlah kaktus di layar agar tidak terlalu banyak
    if (cactusArray.size() > 10) { // Batas maksimal 10 kaktus di layar
        cactusArray.remove(0);
    }
}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw track as the background at the bottom
        if (trackImage != null) {
            int trackHeight = 40; 
            g.drawImage(trackImage, trackX, boardHeight - trackHeight, trackWidth, trackHeight, this); 
            g.drawImage(trackImage, trackX + trackWidth, boardHeight - trackHeight, trackWidth, trackHeight, this); 

            if (trackX + trackWidth <= 0) {
                trackX = 0; // Reset posisi untuk mencegah gap
            }
        }

        // Draw dinosaur
        g.drawImage(dinosaur.img, dinosaur.x, dinosaur.y, dinosaur.width, dinosaur.height, null);

        // Draw cacti
        for (int i = 0; i < cactusArray.size(); i++) {
            Block cactus = cactusArray.get(i);
            g.drawImage(cactus.img, cactus.x, cactus.y, cactus.width, cactus.height, null);
        }

        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.PLAIN, 25));
        if (gameOver) {
            g.drawImage(gameOverImg, boardWidth / 2 - gameOverImg.getWidth(null) / 2, boardHeight / 2 - gameOverImg.getHeight(null) / 2, this);
            g.drawString("Game Over: " + String.valueOf(score), 10, 35);
        } else {
            g.drawString("Score: " + String.valueOf(score), 10, 35);
        }

        g.drawString("High Score: " + String.valueOf(highScore), boardWidth - 300, 35);
    }

    public void move() {
        // Dinosaur physics
        velocityY += gravity;
        dinosaur.y += velocityY;

        if (dinosaur.y > dinosaurY) { // Stop the dinosaur from falling past the ground
            dinosaur.y = dinosaurY;
            velocityY = 0;
        }

        trackX += velocityX;
        if (trackX <= -trackWidth) {
            trackX = 0; // Reset posisi ke awal saat gambar track sudah keluar dari layar
        }

        // Cactus movement and collision check
        for (int i = 0; i < cactusArray.size(); i++) {
            Block cactus = cactusArray.get(i);
            cactus.x += velocityX;

            if (collision(dinosaur, cactus)) {
                gameOver = true;
            }
        }

        if (score > highScore) {
            highScore = score;
        }

        // Increment score
        score++;
    }

    boolean collision(Block a, Block b) {
        return a.x < b.x + b.width &&
               a.x + a.width > b.x &&
               a.y < b.y + b.height &&
               a.y + a.height > b.y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            placeCactusTimer.stop();
            gameLoop.stop();
        }
    }

     @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_SPACE) { // Jump action for both UP and SPACE keys
        if (!gameOver && dinosaur.y == dinosaurY) {
            velocityY = -17; // Set jump speed
            // Optionally change the image to a jumping image if you have one
        }
        // Restart the game if it's over and space is pressed
        if (gameOver) {
            // Reset the game state
            dinosaur.y = dinosaurY; // Reset dinosaur position
            dinosaur.height = dinosaurHeight; // Reset dinosaur height
            velocityY = 0; // Reset vertical speed
            isDucking = false; // Stop ducking

            // Reset the high score tracking if needed (if game-over logic includes high score)
            if (score > highScore) {
                highScore = score; // Update high score if new score is higher
            }

            // Clear existing cacti
            cactusArray.clear();

            // Reset the score and game state
            score = 0;
            gameOver = false;
            gameLoop.start(); // Restart the game loop
            placeCactusTimer.start(); // Restart the cactus placement timer
        }
    } else if (keyCode == KeyEvent.VK_DOWN) { // Duck action
        if (!gameOver) {
            isDucking = true;
            dinosaur.height = duckedDinosaurHeight; // Resize the dinosaur height for ducking
            // Optionally change the image to a ducking image if you have one
        }
    }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_DOWN) { // Stop ducking
            if (!gameOver) {
                isDucking = false;
                dinosaur.height = dinosaurHeight;
            }
        }
    }
}

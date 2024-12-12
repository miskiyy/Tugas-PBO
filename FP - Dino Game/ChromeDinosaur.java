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
    private int playerChoice;
    private Image backgroundImage;

    Image trackImage;
    Image gameOverImg;
    Image resetImg;

    Dinosaur dinosaur;
    ArrayList<Cactus> cactusArray;
    Timer placeCactusTimer;
    ArrayList<Bird> birdArray;
    Timer placeBirdTimer;

    int score = 0;
    boolean gameOver = false;

    Timer gameLoop;

    public ChromeDinosaur(int playerChoice) {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.lightGray);
        setFocusable(true);
        addKeyListener(this);
        this.playerChoice = playerChoice;

        // Load images
        trackImage = new ImageIcon(getClass().getResource("./img/track.png")).getImage();
        gameOverImg = new ImageIcon(getClass().getResource("./img/game-over.png")).getImage();
        resetImg = new ImageIcon(getClass().getResource("./img/reset.png")).getImage();

        switch (playerChoice) {
            case 0:
                dinosaur = new Dinosaur(50, boardHeight - 94 - 20, 88, 94, 
                    new ImageIcon(getClass().getResource("./img/dino1-run.png")).getImage(),
                    new ImageIcon(getClass().getResource("./img/dino-duck.gif")).getImage());
                break;
            case 1:
                dinosaur = new Dinosaur(50, boardHeight - 94 - 20, 88, 94, 
                    new ImageIcon(getClass().getResource("./img/dino2-run.png")).getImage(),
                    new ImageIcon(getClass().getResource("./img/dino-duck.gif")).getImage());
                break;
            case 2:
                dinosaur = new Dinosaur(50, boardHeight - 94 - 20, 88, 94, 
                    new ImageIcon(getClass().getResource("./img/dino3-run.png")).getImage(),
                    new ImageIcon(getClass().getResource("./img/dino-duck.gif")).getImage());
                break;
            default:
                dinosaur = new Dinosaur(50, boardHeight - 94 - 20, 88, 94, 
                    new ImageIcon(getClass().getResource("./img/dino1-run.png")).getImage(),
                    new ImageIcon(getClass().getResource("./img/dino-duck.gif")).getImage());
        }

        
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
        trackWidth = boardWidth;
        
        // Place cactus timer
        cactusArray = new ArrayList<Cactus>();
        placeCactusTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeCactus();
            }
        });
        placeCactusTimer.start();
        
        // Timer for placing birds
        birdArray = new ArrayList<Bird>();
        placeBirdTimer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeBird();
            }
        });
        placeBirdTimer.start();
    }

    void placeCactus() {
        if (gameOver) {
            return;
        }

        double placeCactusChance = Math.random();

        if (placeCactusChance > 0.95) {
            cactusArray.add(new Cactus(700, boardHeight - 70 - 20, 150, 100, new ImageIcon(getClass().getResource("./img/big-cactus3.png")).getImage()));
        } else if (placeCactusChance > 0.80) {
            cactusArray.add(new Cactus(700, boardHeight - 70 - 20, 103, 100, new ImageIcon(getClass().getResource("./img/big-cactus2.png")).getImage()));
        } else if (placeCactusChance > 0.65) {
            cactusArray.add(new Cactus(700, boardHeight - 70 - 20, 50, 100, new ImageIcon(getClass().getResource("./img/big-cactus1.png")).getImage()));
        } else if (placeCactusChance > 0.45) {
            cactusArray.add(new Cactus(700, boardHeight - 70 - 20, 102, 70, new ImageIcon(getClass().getResource("./img/cactus3.png")).getImage()));
        } else if (placeCactusChance > 0.25) {
            cactusArray.add(new Cactus(700, boardHeight - 70 - 20, 69, 70, new ImageIcon(getClass().getResource("./img/cactus2.png")).getImage()));
        } else {
            cactusArray.add(new Cactus(700, boardHeight - 70 - 20, 34, 70, new ImageIcon(getClass().getResource("./img/cactus1.png")).getImage()));
        }

        // Batasi jumlah kaktus di layar agar tidak terlalu banyak
        if (cactusArray.size() > 40) {
            cactusArray.remove(0);
        }
    }

    void placeBird() {
            if (gameOver) {
                return;
            }

            double placeBirdChance = Math.random(); 

            // Tentukan aturan kemunculan burung
            if (placeBirdChance > 0.3) { // Aturan kemunculan burung, kamu bisa mengubah angka ini
                int birdHeight = 120; // Randomkan posisi vertikal burung
                birdArray.add(new Bird(700, birdHeight, 64, 64, 
                    new ImageIcon(getClass().getResource("./img/bird.gif")).getImage()));
            }

            // Batasi jumlah burung di layar agar tidak terlalu banyak
            if (birdArray.size() > 10) {
                birdArray.remove(0);
            }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            // Menggambar latar belakang sesuai ukuran panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        // Draw track
        g.drawImage(trackImage, trackX, boardHeight - 40, trackWidth, 40, this);
        g.drawImage(trackImage, trackX + trackWidth, boardHeight - 40, trackWidth, 40, this);

        if (trackX + trackWidth <= 0) {
            trackX = 0;
        }

        // Draw dinosaur
        // g.drawImage(dinosaur.img, dinosaur.x, dinosaur.y, dinosaur.width, dinosaur.height, null);

        if (dinosaur.isDucking) {
            g.drawImage(dinosaur.img, dinosaur.x, 180, dinosaur.width, dinosaur.height, null);
        } else {
            g.drawImage(dinosaur.img, dinosaur.x, dinosaur.y, dinosaur.width, dinosaur.height, null);
        }

        // Draw cacti
        for (Cactus cactus : cactusArray) {
            g.drawImage(cactus.img, cactus.x, cactus.y, cactus.width, cactus.height, null);
        }

        // Draw birds
        for (Bird bird : birdArray) {
            g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
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
        dinosaur.move();
        trackX += -12; // Track moving

        // Move and check collision for each cactus
        for (Cactus cactus : cactusArray) {
            cactus.x -= 12; // Cactus moving left
            if (collision(dinosaur, cactus)) {
                gameOver = true;
            }
        }

        // Move and check collision for each bird
        for (Bird bird : birdArray) {
            bird.x -= 8; // Gerakan burung ke kiri
            bird.y += Math.sin(bird.x / 50.0) * 2; // Gerakan vertikal sederhana

            if (collision(dinosaur, bird)) {
                gameOver = true;
            }
        }


        if (score > highScore) {
            highScore = score;
        }

        score++; // Increment score
    }

    boolean collision(Block a, Block b) {
        int tolerance = -20;  // Tentukan toleransi pergerakan (misalnya 5 piksel)

        // Periksa tabrakan dengan toleransi
        return a.x < b.x + b.width + tolerance && a.x + a.width > b.x - tolerance &&
            a.y < b.y + b.height + tolerance && a.y + a.height > b.y - tolerance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            placeCactusTimer.stop();
            placeBirdTimer.stop();
            gameLoop.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if ((keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_SPACE) && !dinosaur.isDucking) {
            dinosaur.jump();
        }

        if (keyCode == KeyEvent.VK_DOWN && !dinosaur.isDucking) {
            dinosaur.duck();
            // dinosaur.y=180;
        }

        if (gameOver && keyCode == KeyEvent.VK_SPACE) {
            resetGame();
        }
    }

    private void resetGame() {
        dinosaur.reset();

        if (score > highScore) {
            highScore = score;
        }

        cactusArray.clear();
        birdArray.clear();
        score = 0;
        gameOver = false;
        gameLoop.start();
        placeCactusTimer.start();
        placeBirdTimer.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // Jika tombol bawah dilepaskan dan dinosaur sedang ducking, kembali ke mode run
        if (keyCode == KeyEvent.VK_DOWN && dinosaur.isDucking) {
            dinosaur.standUp();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    // Menentukan ukuran panel tetap 750x250
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(750, 250);
    }
}

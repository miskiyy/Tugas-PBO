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

    Image trackImage;
    Image gameOverImg;
    Image resetImg;

    Dinosaur dinosaur;
    ArrayList<Cactus> cactusArray;

    int score = 0;
    boolean gameOver = false;

    Timer gameLoop;
    Timer placeCactusTimer;

    public ChromeDinosaur(int playerChoice) {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.lightGray);
        setFocusable(true);
        addKeyListener(this);

        // Load images
        trackImage = new ImageIcon(getClass().getResource("./img/track.png")).getImage();
        gameOverImg = new ImageIcon(getClass().getResource("./img/game-over.png")).getImage();
        resetImg = new ImageIcon(getClass().getResource("./img/reset.png")).getImage();

        // Dinosaur selection
        switch (playerChoice) {
            case 0:
                dinosaur = new Dinosaur(50, boardHeight - 94 - 20, 88, 94, new ImageIcon(getClass().getResource("./img/dino1-run.png")).getImage());
                break;
            case 1:
                dinosaur = new Dinosaur(50, boardHeight - 94 - 20, 88, 94, new ImageIcon(getClass().getResource("./img/dino2-run.png")).getImage());
                break;
            case 2:
                dinosaur = new Dinosaur(50, boardHeight - 94 - 20, 88, 94, new ImageIcon(getClass().getResource("./img/dino3-run.png")).getImage());
                break;
            default:
                dinosaur = new Dinosaur(50, boardHeight - 94 - 20, 88, 94, new ImageIcon(getClass().getResource("./img/dino1-run.png")).getImage());
        }

        // Initialize cactus array
        cactusArray = new ArrayList<Cactus>();

        // Game timer
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
        trackWidth = boardWidth;

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

        double placeCactusChance = Math.random();

        if (placeCactusChance > 0.95) {
            cactusArray.add(new Cactus(700, boardHeight - 100 - 20, 150, 100, new ImageIcon(getClass().getResource("./img/big-cactus3.png")).getImage()));
        } else if (placeCactusChance > 0.80) {
            cactusArray.add(new Cactus(700, boardHeight - 100 - 20, 103, 100, new ImageIcon(getClass().getResource("./img/big-cactus2.png")).getImage()));
        } else if (placeCactusChance > 0.65) {
            cactusArray.add(new Cactus(700, boardHeight - 100 - 20, 50, 100, new ImageIcon(getClass().getResource("./img/big-cactus1.png")).getImage()));
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw track
        g.drawImage(trackImage, trackX, boardHeight - 40, trackWidth, 40, this);
        g.drawImage(trackImage, trackX + trackWidth, boardHeight - 40, trackWidth, 40, this);

        if (trackX + trackWidth <= 0) {
            trackX = 0;
        }

        // Draw dinosaur
        g.drawImage(dinosaur.img, dinosaur.x, dinosaur.y, dinosaur.width, dinosaur.height, null);

        // Draw cacti
        for (Cactus cactus : cactusArray) {
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
        dinosaur.move();
        trackX += -12; // Track moving

        // Move and check collision for each cactus
        for (Cactus cactus : cactusArray) {
            cactus.x -= 12; // Cactus moving left
            if (collision(dinosaur, cactus)) {
                gameOver = true;
            }
        }

        if (score > highScore) {
            highScore = score;
        }

        score++; // Increment score
    }

    boolean collision(Block a, Block b) {
        return a.x < b.x + b.width && a.x + a.width > b.x && a.y < b.y + b.height && a.y + a.height > b.y;
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

        if ((keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_SPACE) && !dinosaur.isDucking) {
            dinosaur.jump();
        }

        if (keyCode == KeyEvent.VK_DOWN && !dinosaur.isDucking && dinosaur.y == dinosaur.originalY) {
            dinosaur.duck();
        }

        if (gameOver && keyCode == KeyEvent.VK_SPACE) {
            resetGame();
        }
    }

    private void resetGame() {
        dinosaur.y = dinosaur.originalY;
        dinosaur.height = 94;
        dinosaur.velocityY = 0;
        dinosaur.isDucking = false;

        if (score > highScore) {
            highScore = score;
        }

        cactusArray.clear();
        score = 0;
        gameOver = false;
        gameLoop.start();
        placeCactusTimer.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}

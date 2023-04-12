// Add customized dinosaurs, sound effect, objects, background, game features (jumping, ducking, obstacle speed), scoreboard counter, game restart

package edu.nyu.cs;
import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Iterator;
import edu.nyu.cs.Game.*;

public class App extends PApplet {
    int playerX = 100; // intial x position of Player
    int playerY = 520; // intial y position of Player
    int playerWidth = 50; // width of player
    int playerHeight = 100; // height of player
    int screenWidth = 1000; // screen width
    int screenHeight = 800; // screen height
    int v1 = 203; // background v1
    int v2 = 195; // background v2
    int v3 = 227; // background v3

    Player player = new Player(playerX, playerY, playerWidth, playerHeight);
    Background background = new Background(0, playerY + playerHeight, screenWidth, playerY + playerHeight);
    ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

    public void settings() {
        this.setSize(screenWidth, screenHeight);
}

    public void setup() {
        this.background(v1, v2, v3);
        player.draw(this);
        // for (int i = 0; i<200; i++) {
        //     obstacle_2 o = new obstacle_2();
        //     obstacles.add(o);
        // } 
    }

    public void draw() {
        this.background(v1, v2, v3);
        player.draw(this);
        player.move();
        background.draw(this);
        // instantiates random new obstacles
        if(random(1) < 0.8 && frameCount % 60 == 0) {
            obstacles.add(new Obstacle(screenWidth, playerY, playerHeight, player));
        }

        // for(int i=obstacles.size()-1; i>=0; i--) {
        //     Obstacle p = obstacles.get(i);
        //     if (p.getOnScreen()) {
        //         p.update();
        //         p.draw(this);
        //     }
        // }

        // Trying to remove objects from the class that are no longer on the screen, currently not working
        Iterator<Obstacle> iterator = obstacles.iterator();
        while (iterator.hasNext()) {
            Obstacle obstacle = iterator.next();
            if (obstacle.getOnScreen()) {
                obstacle.update();
                obstacle.draw(this);
            } else {
                iterator.remove();
                // System.out.println("removed");
            }
        }
        // System.out.println(obstacles.size());
        }

    public void keyPressed() {
        //System.out.println(String.format("Key pressed: %s, key code: %d.", this.key, this.keyCode));
        switch (this.key) {
            case ' ':
            if (player.getJumping() == false) {
                player.jump();
                player.move();
            }
            break;     
        }
    }
    
    public static void main(String[] args) {
        // Processing requires us to pass our full package + class name to its main method.
        PApplet.main("edu.nyu.cs.App");
    }
}

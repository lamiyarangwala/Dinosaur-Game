// Add customized dinosaurs, sound effect, objects, background, game features (jumping, ducking, obstacle speed), game restart

package edu.nyu.cs;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.apache.commons.lang3.SystemUtils;
import java.util.Iterator;
import edu.nyu.cs.Game.*;

import processing.core.*; // import the base Processing library
import processing.sound.*; // import the processing sound library

public class App extends PApplet {
    // Properties
    int playerX = 100; // intial x position of Player
    int playerY = 520; // intial y position of Player
    int playerWidth = 50; // width of player
    int playerHeight = 100; // height of player
    int screenWidth = 1000; // screen width
    int screenHeight = 800; // screen height
    int v1 = 203; // background v1
    int v2 = 195; // background v2
    int v3 = 227; // background v3
    float velocityIncrement = 0.001f; // increment of obstacle velocity as the game goes on

    Player player = new Player(playerX, playerY, playerWidth, playerHeight);
    Background background = new Background(0, playerY + playerHeight, screenWidth, playerY + playerHeight);
    ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    String cwd = Paths.get("").toAbsolutePath().toString(); // the current working directory as an absolute path

    public void settings() {
        this.setSize(screenWidth, screenHeight);
}

    public void setup() {
        this.background(v1, v2, v3);
        player.draw(this);
        
        // load up a sound file and play it once when program starts up
		// String cwd = Paths.get("").toAbsolutePath().toString(); // the current working directory as an absolute path
        // String path = Paths.get(cwd, "images", "me.png").toString(); // e.g "images/me.png" on Mac/Unix vs. "images\me.png" on Windows
        // this.imgMe = loadImage(path);
        }

    public void draw() {
        // image(this.imgMe, this.width / 2, this.height/2); // draw image to center of window
        // for (int i=0; i<this.stars.size(); i++) {
        //     Star star = this.stars.get(i); // get the current Star object from the ArrayList
        //     star.moveRandomly(); // move the star by a random amount
        //     star.draw(); // draw the star to the screen
        //   }

        this.background(v1, v2, v3);
        background.draw(this);
        player.move();
        player.draw(this);

        // instantiates random new obstacles
        if(random(1) < 0.8 && frameCount % 60 == 0) {
            String path = Paths.get(cwd, "images", "star.png").toString(); 
            if(random(1) < 0.5){ 
            obstacles.add(new Obstacle(this, screenWidth, playerY, playerHeight, path));
            }
            else{
            obstacles.add(new Obstacle(screenWidth, playerY, playerHeight));
            }
        }
        
        // Trying to remove objects from the class that are no longer on the screen, currently not working
        Iterator<Obstacle> iterator = obstacles.iterator();
        while (iterator.hasNext()) {
            Obstacle obstacle = iterator.next();
            if (obstacle.getOnScreen()) {

                obstacle.update();
                if (obstacle.getPath()==null){
                    obstacle.draw(this); // works with old draw
                }
                else{
                obstacle.draw();
                }
                if (!obstacle.getEndGame()) {
                    obstacle.setObsSpeed(obstacle.getObsSpeed() + velocityIncrement);
                    if (frameCount % 6 == 0) {
                        player.setScore(player.getScore() + 1);
                    }
                    System.out.println(obstacle.getObsSpeed());
                    if (obstacle.checkCollision(player)) {
                        System.out.println("collided");
                        obstacle.setEndGame(true);
                        player.setEndGame(true);
                    }
                    else {
                        System.out.println("not collided");
                    }
                } else {
                    textSize(100);
                    textAlign(CENTER);
                    text("GAME OVER!", screenWidth / 2, screenHeight /2);
                }
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
                break;
            }
            // case 'r':
            //     player = new Player(playerX, playerY, playerWidth, playerHeight);
            //     background = new Background(0, playerY + playerHeight, screenWidth, playerY + playerHeight);
            //     obstacles = new ArrayList<Obstacle>();
            //     // player.setEndGame(false);
            //     // for ()
            //     // obstacle.setEndGame(true);
            //     break;     
        }
    }

    public static void main(String[] args) {
        // Processing requires us to pass our full package + class name to its main method.
        PApplet.main("edu.nyu.cs.App");
    }
}

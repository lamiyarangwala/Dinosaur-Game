
package edu.nyu.cs;
import processing.core.*; // import the base Processing library
// import processing.core.PApplet;
import processing.core.PVector;
import edu.nyu.cs.Game.Player;


public class App extends PApplet {
    int x_initial = 100;
    int y_initial = 520;
    int radius = 50;
    int width = 1000;
    int height = 800;
    int v1 = 203;
    int v2 = 195;
    int v3 = 227;

    Player u = new Player(x_initial, y_initial, radius);
    // PVector gravity = new PVector(0, (float) 0.1);
    public void settings() {
        this.setSize(width, height);
}

    public void setup() {
        this.background(v1, v2, v3);
        u.draw(this);
    }

    public void draw() {
        this.background(v1, v2, v3);
        u.draw(this);
        u.move();
    }

    public void keyPressed() {
        System.out.println(String.format("Key pressed: %s, key code: %d.", this.key, this.keyCode));
        switch (this.key) {
            case ' ':
            if (u.getJumping() == false) {
                u.jump();
                u.move();
            }
            break;     
        }
    }
    
    public static void main(String[] args) {
        
        // Processing requires us to pass our full package + class name to its main method.
        PApplet.main("edu.nyu.cs.App");
    }
}

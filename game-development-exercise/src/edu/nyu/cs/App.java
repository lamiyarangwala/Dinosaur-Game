
package edu.nyu.cs;
import processing.core.PApplet;
import processing.core.PVector;
import edu.nyu.cs.Game.Player;



public class App extends PApplet {
    Player u = new Player(100,520,50);
    PVector gravity = new PVector(0, (float) 0.1);
    public void settings() {
        this.setSize(1000, 800);
}

    public void setup() {
        background(203, 195, 227);
        
        u.draw(this);
      
    
    }

    public void keyPressed() {
        switch (key) {
            case ' ':
            // test to see if keyboard input registered
            // System.out.println("hi");
            u.jump();
            u.move();
            break;
            

        }
    }

    
    
    

    
    public static void main(String[] args) {
        
        // Processing requires us to pass our full package + class name to its main method.
        PApplet.main("edu.nyu.cs.App");
      
    }
}


package edu.nyu.cs;
import processing.core.PApplet;
import processing.core.PVector;
import edu.nyu.cs.Game.Player;
import game.*;


public class App extends PApplet {
    PVector gravity = new PVector(0, (float) 0.1);
    public void settings() {
        this.setSize(1000, 800);
}

    public void setup() {
        background(203, 195, 227);
        Player u = new Player(100,520,50);
        u.draw(this);
      
    
    }

    
    

    
    public static void main(String[] args) {
        
        // Processing requires us to pass our full package + class name to its main method.
        PApplet.main("edu.nyu.cs.App");
      
    }
}

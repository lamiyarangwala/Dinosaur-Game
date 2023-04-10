
package edu.nyu.cs;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

import edu.nyu.cs.Game.Player;
import edu.nyu.cs.Game.obstacle;



public class App extends PApplet {
    Player u;
    int groundHeight = 50;
    //PVector gravity = new PVector(0, (float) 0.1);
    ArrayList<obstacle> obstacles = new ArrayList<obstacle>();
    
    public void settings() {
        this.setSize(800, 400);
    }

    public void setup() {       
        u =  new Player(100,0,50);

    }

    public void draw(PApplet app) {
        System.out.println("hi");
        background(203, 195, 227);
        u.draw(this);
        u.jumping();
        line(0, height-groundHeight-30, width, height-groundHeight-30);
        
        if(Math.random()<0.5&&app.frameCount % 60 == 0) {

          this.draw();

    }
}

    public void keyPressed() {
        switch (key) {
            case ' ':
            // test to see if keyboard input registered
            // System.out.println("hi");
            u.jump();
            break;
            

        }
    }

    
    
    

    
    public static void main(String[] args) {
        
        // Processing requires us to pass our full package + class name to its main method.
        PApplet.main("edu.nyu.cs.App");
      
    }
}

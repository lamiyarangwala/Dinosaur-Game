// Add customized dinosaurs, sound effect, objects, background, game features (jumping, ducking, obstacle speed), scoreboard counter, game restart

package edu.nyu.cs;
import processing.core.*; // import the base Processing library
// import processing.core.PApplet;
import edu.nyu.cs.Game.Player;
import java.util.ArrayList;
import edu.nyu.cs.Game.*;

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
    Background background = new Background(0, y_initial + radius / 2, width, y_initial + radius / 2);
    ArrayList<obstacle_2> obstacles = new ArrayList<obstacle_2>();

    public void settings() {
        this.setSize(width, height);
}

    public void setup() {
        this.background(v1, v2, v3);
        u.draw(this);
        for (int i = 0; i<200; i++) {
            obstacle_2 o = new obstacle_2();
            obstacles.add(o);
        } 
           
    }

    public void draw() {
        this.background(v1, v2, v3);
        u.draw(this);
        u.move();
        background.draw(this);
        
        //for (int i = 0; i<obstacles.size(); i++){
        if(random(1)<0.8&&frameCount % 60 == 0){
            obstacles.add(new obstacle_2());
        }
        

            for(int i=obstacles.size()-1; i>=0; i--){
            obstacle_2 p = obstacles.get(i);
            p.update();
            p.draw(this);
            // System.out.println(obstacles.get(i));
            // obstacle_2 obs = obstacles.get(i);
            // System.out.Format("x: %f, tall: %f, width: %f", obs.getX(), obs.getTall(), obs.getWidth()));
            // System.out.print("x: "+ obs.getX());
            // System.out.print("tall: "+ obs.getTall());
            // System.out.print("width: "+ obs.getWidth());
            
            
            
            }
            // obs.update();
            // obs.draw(this);
            // break;
        }
            // if (!obs.getOnScreen()){
            
        
        
    

    public void keyPressed() {
        //System.out.println(String.format("Key pressed: %s, key code: %d.", this.key, this.keyCode));
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

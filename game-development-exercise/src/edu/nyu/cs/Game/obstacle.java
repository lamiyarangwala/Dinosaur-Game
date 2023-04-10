package edu.nyu.cs.Game;
import java.util.ArrayList;

import processing.core.PApplet;


public class obstacle {
    float tall;
    float width;
    float x;
    float obsSpeed = 3;
    ArrayList<obstacle> obstacles = new ArrayList<obstacle>();

    public static int getRandomNumber(int min, int max) {
        int num = (int) ((Math.random() * (max - min)) + min);
        return num;
    }
    public obstacle () {
        this.tall = getRandomNumber(150,180);
    }

    public void update() {
        this.x -= this.obsSpeed;
    }

    public void show(PApplet app) {
        app.stroke(0,0,0);
        app.strokeWeight(2);
        app.rect(this.x, app.height-this.tall, this.width, this.tall-110);

    }

    public void draw(PApplet app) {
        
        
        obstacles.add(new obstacle()); 
        System.out.println("hi");
        
          
          for (int i = obstacles.size()-1; i>=0; i--) {
              obstacle o = obstacles.get(i);
              o.update();
              o.show(app);
          }
    }
}

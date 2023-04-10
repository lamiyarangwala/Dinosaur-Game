package edu.nyu.cs.Game;
import java.util.ArrayList;

import processing.core.PApplet;


public class obstacle_2 {
    float tall;
    float width=20;
    float x;
    float obsSpeed = 3;
    boolean onScreen;
    ArrayList<obstacle_2> obstacles = new ArrayList<obstacle_2>();

    public static int getRandomNumber(int min, int max) {
        int num = (int) ((Math.random() * (max - min)) + min);
        return num;
    }
    public obstacle_2 () {
        this.x = 1000+ this.width;
        this.tall = getRandomNumber(150,180);
        this.onScreen = true;

    }

    public void update() {
        this.x -= this.obsSpeed;
        if (this.x + this.width == 0) {
            // setOnScreen(false);
            this.onScreen = false;
        }
    }

    public void draw(PApplet app) {
        app.stroke(0,0,0);
        app.strokeWeight(2);
        // app.rectMode(CENTER);
        app.rect(this.x, app.height-520-(this.tall), this.width, this.tall);
        // app.rect(this.x, this.tall + 520, this.width, this.tall);
        // app.rect(this.x, app.height-this.tall, this.width, this.tall-110);

    }

    public float getX() {return this.x;}
    public float getTall() {return this.tall;}
    public float getWidth() {return this.width;}
    public boolean getOnScreen() {return this.onScreen;}

    // public void draw(PApplet app) {
        
        
    //     obstacles.add(new obstacle_2()); 
    //     System.out.println("hi");
        
          
    //       for (int i = obstacles.size()-1; i>=0; i--) {
    //           obstacle_2 o = obstacles.get(i);
    //           o.update();
    //           o.show(app);
    //       }
    // }
}

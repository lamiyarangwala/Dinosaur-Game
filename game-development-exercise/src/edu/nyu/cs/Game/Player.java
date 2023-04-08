package edu.nyu.cs.Game;
import processing.core.PApplet;
import processing.core.PVector;

public class Player {
    private float x = 100;
    private float y;
    private float velY;
    double gravity = 9.8;
    private int radius;
    // private PVector pos;
    // private PVector acc;
    // private PVector vel;
    // PVector gravity = new PVector(0, (float) 0.1);


    public Player(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        

        
    } 

    public void jump() {
        this.velY = 16;

    }
    
    public void move() {
        this.y += this.velY;
        if (this.y > 520) {
            this.velY -= gravity;

        }
        else{
            this.y = 520;
            this.velY = 0;
        }
    }
   
    public void draw(PApplet app) {
        app.circle(this.x, this.y, this.radius);


    }

}

    
    


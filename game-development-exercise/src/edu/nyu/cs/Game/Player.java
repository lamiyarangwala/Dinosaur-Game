package edu.nyu.cs.Game;
import processing.core.PApplet;
import processing.core.PVector;

public class Player {
    private float x = 100;
    private float y=50;
    private float velY=0;
    double gravity = 1.2;
    private int radius;
    public boolean isJumping;



    public Player(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        isJumping = false;
        
    } 

    public void jump() {
        if (this.y == 50){
            this.gravity = 1.2;
            this.velY = 16;
        }
        

    }
    
    public void jumping() {
        
            this.y += this.velY;
            if (this.y > 50) {
                this.velY -= this.gravity;

            }
            else{
                this.y = 50;
                this.velY = 0;
            }
        }
    
   
    public void draw(PApplet app) {
        app.circle(this.x, this.y, this.radius);


    }

}

    
    


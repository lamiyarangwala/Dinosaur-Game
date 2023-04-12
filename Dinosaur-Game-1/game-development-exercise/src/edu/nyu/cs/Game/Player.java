package edu.nyu.cs.Game;
import processing.core.PApplet;

public class Player {
    private float x; // Top left x position
    private float y; // Top right y position
    private float velY;
    private float gravity;
    private int width;
    private int height;
    private boolean jumping;
    // private float fps;
    private float yInitial;

    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.jumping = false;
        // this.fps  = 1/20;
        this.yInitial = y;
    } 

    public void jump() {
        setVelY(160);
        setGravity(50);
        setJumping(true);
    }
    
    public void move() {
        if (getJumping() == true) {
            setY(getY() - getVelY() * 1/20); // Change y position
            setVelY(getVelY() - getGravity() * 1/20); // Change velocity
            setGravity(getGravity() + 5); // Change gravity
            //System.out.println(String.format("y: %f, velY: %f, g: %f", getY(), getVelY(), getGravity()));

            // If next jump will be below the ground, return to player to original position
            if (getY() - getVelY() * 1/20 > getYInitial()) {
                setY(getYInitial());
                setJumping(false);
            }
        }
    }
    
    public void draw(PApplet app) {
        app.rect(getX(), getY(), getWidth(), getHeight());
    }

    // Getters
    public float getX() {return this.x;}
    public float getY() {return this.y;}
    public int getWidth() {return this.width;}
    public int getHeight() {return this.height;}
    public float getVelY() {return this.velY;}
    public float getGravity() {return this.gravity;}
    public boolean getJumping() {return this.jumping;}
    public float getYInitial() {return this.yInitial;}
    // Setters
    public void setY(float y) {if (y>0 && y<1000) this.y = y;}
    public void setVelY(float velY) {if (true) this.velY = velY;}
    public void setGravity(float gravity) {if (gravity > 0) this.gravity = gravity;}
    public void setJumping(boolean jumping) {if (jumping == true || jumping == false) this.jumping = jumping;}
}
    
    


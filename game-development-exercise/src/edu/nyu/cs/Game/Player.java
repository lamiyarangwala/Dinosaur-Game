package edu.nyu.cs.Game;
import processing.core.PApplet;
import processing.core.PVector;

public class Player {
    // int x_initial = 100;
    // int y_initial = 520;
    // float fps = 1/60;

    private float x = 100;
    private float y;
    private float velY;
    private float gravity;
    private int radius;
    private boolean jumping;

    public Player(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.jumping = false;
    } 

    public void jump() {
        setVelY(150);
        setGravity(50);
        setJumping(true);
    }
    
    public void move() {
        if (getJumping() == true) {
            setY(getY() - getVelY() * 1/20);
            setVelY(getVelY() - getGravity() * 1/20);
            setGravity(getGravity() + 5);
            //System.out.println(String.format("y: %f, velY: %f, g: %f", getY(), getVelY(), getGravity()));
            if (getY() - getVelY() * 1/20 > 520) {
                setY(520);
                setJumping(false);
            }
        }
    }
    
    public void draw(PApplet app) {
        app.circle(getX(), getY(), getRadius());
        app.line(getX() + getRadius() / 2, getY() + getRadius() / 2, getX() + getRadius() / 2, getY() - getRadius() / 2);
    }

    // Getters
    public float getX() {return this.x;}
    public int getRadius() {return this.radius;}
    public float getY() {return this.y;}
    public float getVelY() {return this.velY;}
    public float getGravity() {return this.gravity;}
    public boolean getJumping() {return this.jumping;}
    // Setters
    public void setY(float y) {if (y>0 && y<1000) this.y = y;}
    public void setVelY(float velY) {if (true) this.velY = velY;}
    public void setGravity(float gravity) {if (gravity > 0) this.gravity = gravity;}
    public void setJumping(boolean jumping) {if (jumping == true || jumping == false) this.jumping = jumping;}
}
    
    


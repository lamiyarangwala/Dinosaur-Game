package edu.nyu.cs.Game;
import processing.core.PApplet;
import processing.core.PVector;

public class Player {
    private int x;
    private int y;
    private int radius;
    private PVector pos;
    private PVector acc;
    private PVector vel;
    PVector gravity = new PVector(0, (float) 0.1);
    
    public Player(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.pos = new PVector(100,520);
        this.vel = new PVector(0,20);
        this.acc = new PVector();
        

        
    } 

    public void applyForce(PVector force){
        getAcc().add(force);

    }
    public PVector getPos() {
        return this.pos;
    }
    public PVector getAcc() {
        return this.acc;
    }
    public PVector getVel() {
        return this.vel;
    }

    public void draw(PApplet app) {
        app.circle(this.x, this.y, this.radius);

    }

    public void update() {
        
        applyForce(gravity);
        this.vel.add(this.acc);
        this.pos.add(this.vel);
        vel.limit(4);


        
    }

    
    
}

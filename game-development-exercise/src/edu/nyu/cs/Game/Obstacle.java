package edu.nyu.cs.Game;
// import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Obstacle {
    //private App app; // will hold a reference to the main Game object
    private PApplet app;
    private PImage img; // will hold a reference to an image of a star
    private float height; // obstacle height
    private float width; // obstacle width
    private float x; // obstacle x position
    private int playerY; // initial Player y position
    private int playerHeight; // player height
    private static float obsSpeed = 5;
    private boolean onScreen;
    private int screenWidth;
    private static boolean endGame = false;
    private float finalSpeed = 15; 
    private String path;

    public Obstacle (int screenWidth, int playerY, int playerHeight) {
        this.screenWidth = screenWidth;
        this.x = this.screenWidth + this.width;
        this.playerY = playerY;
        this.playerHeight = playerHeight;
        this.height = getRandomNumber(55,85);
        this.width = getRandomNumber(20, 60);
        this.onScreen = true;
        this.path=null;
    }

    public Obstacle (PApplet app, int screenWidth, int playerY, int playerHeight, String imgFilePath) { // Overloaded
        this.app=app;
        this.img = app.loadImage(imgFilePath);
        // this.img.resize(0, playerHeight);
        this.screenWidth = screenWidth;
        this.x = this.screenWidth + this.width;
        this.playerY = playerY;
        this.playerHeight = playerHeight;
        this.height = playerHeight;
        //this.width = getRandomNumber(20, 60);
        this.onScreen = true;
        this.path = imgFilePath;
    }

    public static int getRandomNumber(int min, int max) {
        int num = (int) ((Math.random() * (max - min)) + min);
        return num;
    }

    public void update() {
        if (!endGame) {
            setX(getX() - getObsSpeed());
            if (getX() + getWidth() == 0) {
                setOnScreen(false);
            }
        }
    }
    public void draw(){
        // this.app.imageMode(PApplet.CENTER); // setting so the image is drawn centered on the specified x and y coordinates
        this.app.image(this.img, this.x, this.playerY+18);
    }

    public void draw(PApplet app) {
            app.stroke(0,0,0);
            app.strokeWeight(2);
            app.rect(getX(), getPlayerY() + getPlayerHeight() - getHeight(), getWidth(), getHeight());
    }

    public boolean checkCollision(Player player) {  
        float y = getPlayerY() + getPlayerHeight() - getHeight();
        if((player.getY()+player.getHeight()>y)
        &&
        (player.getX()+player.getWidth() > this.getX() 
        &&
        player.getX() < this.getX()+this.getWidth())) {
            return true;
        }
        return false;
    }
    
    // Getters
    public float getHeight() {return this.height;}
    public float getWidth() {return this.width;}
    public float getX() {return this.x;}
    public int getPlayerY() {return this.playerY;}
    public int getPlayerHeight() {return this.playerHeight;}
    public float getObsSpeed() {return obsSpeed;}
    public boolean getOnScreen() {return this.onScreen;}
    public int getScreenWidth() {return this.screenWidth;}
    public boolean getEndGame() {return endGame;}
    public String getPath() {return this.path;}
    // Setters
    public void setHeight(float height) {if(height >= 0) this.height = height;}
    public void setWidth(float width) {if(width >= 0) this.width = width;}
    public void setX(float x) {if(getX() + getWidth() >= 0) this.x = x;}
    public void setObsSpeed(float v) {if(v > 0 && v < finalSpeed) obsSpeed = v;}
    public void setOnScreen(boolean onScreen) {this.onScreen=onScreen;}
    public void setEndGame(boolean b) {endGame = b;}
}

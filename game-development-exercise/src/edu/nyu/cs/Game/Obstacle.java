package edu.nyu.cs.Game;
// import java.util.ArrayList;
import processing.core.PApplet;

public class Obstacle {
    private float height; // obstacle height
    private float width; // obstacle width
    private float x; // obstacle x position
    private int playerY; // initial Player y position
    private int playerHeight; // player height
    private float obsSpeed = 5;
    private boolean onScreen;
    private int screenWidth;
    private static boolean collision = false;
    private static Player player;

    // private String[] obstacleType;

    public Obstacle (int screenWidth, int playerY, int playerHeight, Player player) {
        this.screenWidth = screenWidth;
        this.x = this.screenWidth + this.width;
        this.playerY = playerY;
        this.playerHeight = playerHeight;
        this.height = getRandomNumber(55,85);
        this.width = getRandomNumber(20, 60);
        this.onScreen = true;
        this.player = player;
    }

    public static int getRandomNumber(int min, int max) {
        int num = (int) ((Math.random() * (max - min)) + min);
        return num;
    }

    public void update() {
        setX(getX() - getObsSpeed());
        if (getX() + getWidth() == 0) {
            setOnScreen(false);
        }
    }

    public void draw(PApplet app) {
        app.stroke(0,0,0);
        app.strokeWeight(2);
        app.rect(getX(), getPlayerY() + getPlayerHeight() - getHeight(), getWidth(), getHeight());
    }

    public void checkCollision() {
        getPlayer();
    }

    //     /**
    //  * Determines whehter a given x, y coordinate overlaps with this Star.
    //  * @param x The x coordinate of interest.
    //  * @param y The y coordinate of interest.
    //  * @param fudgeFactor An amount by which to expand the area we consider overlap
    //  * @return Boolean true if the x,y coordinate overlaps with this star, false otherwise.
    //  */
    // public boolean overlaps(int x, int y, int fudgeFactor) {
    //     // get the coordinates of all edges of this Star's image
    //     int l = this.x - this.img.width/2 - fudgeFactor; // the left edge's x coord
    //     int r = this.x + this.img.width/2 + fudgeFactor; // the right edge's x coord
    //     int t = this.y - this.img.height/2 - fudgeFactor; // the top edge's y coord
    //     int b = this.y + this.img.height/2 + fudgeFactor; // the bottom edge's y coord
    //     // return whether the x,y coords are within the bounds of this Star's image
    //     return (x > l && x < r && y > t && y < b);
    // }

    // Getters
    public float getHeight() {return this.height;}
    public float getWidth() {return this.width;}
    public float getX() {return this.x;}
    public int getPlayerY() {return this.playerY;}
    public int getPlayerHeight() {return this.playerHeight;}
    public float getObsSpeed() {return this.obsSpeed;}
    public boolean getOnScreen() {return this.onScreen;}
    public int getScreenWidth() {return this.screenWidth;}
    public Player getPlayer() {return this.player;}
    // Setters
    public void setHeight(float height) {if(height >= 0) this.height = height;}
    public void setWidth(float width) {if(width >= 0) this.width = width;}
    public void setX(float x) {if(getX() + getWidth() >= 0) this.x = x;}
    public void setObsSpeed(float obsSpeed) {if(obsSpeed > 0) this.obsSpeed = obsSpeed;}
    public void setOnScreen(boolean onScreen) {if(onScreen == true || onScreen == false) this.onScreen=onScreen;}

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

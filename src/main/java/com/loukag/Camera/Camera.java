package com.loukag.Camera;

import com.loukag.Scene.GameScene;
import com.loukag.Scene.Scene;

import java.awt.*;

public class Camera {
    private int posX, posY;

    /**
     * Constructor for Camera
     * @param posX x position (in pixels)
     * @param posY y position (in pixels)
     */
    public Camera(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * Move the camera
     * @param x x offset (in pixels)
     * @param y y offset (in pixels)
     */
    public void move(int x, int y){
        posX += x;
        posY += y;
    }

    /**
     * Set the position of the camera
     * @param x x position (in pixels)
     * @param y y position (in pixels)
     */
    public void setPos(int x, int y){
        posX = x;
        posY = y;
    }

    /**
     * Set the position of the camera smoothly
     * @param x x position (in pixels)
     * @param y y position (in pixels)
     * @param smoothness smoothness of the movement
     */
    public void setPosSmooth(int x, int y, int smoothness){
        this.posX = (posX * (smoothness - 1) + x) / smoothness;
        this.posY = (posY * (smoothness - 1) + y) / smoothness;
    }

    public boolean isOnCamera(Rectangle rec){
        Rectangle camera = new Rectangle(posX, posY, Scene.getScreenW(), Scene.getScreenH());
        return camera.intersects(rec);
    }

    public boolean isOnCamera(int x, int y){
        Rectangle camera = new Rectangle(posX, posY, Scene.getScreenW(), Scene.getScreenH());
        return camera.contains(x,y);
    }

    /**
     * Get the x position of the camera
     * @return x position (in pixels)
     */
    public int getPosX(){
        return posX;
    }

    /**
     * Get the y position of the camera
     * @return y position (in pixels)
     */
    public int getPosY(){
        return posY;
    }
}

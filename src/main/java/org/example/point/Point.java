package org.example.point;

public class Point implements Movable {
    private int x;
    private int y;

    public Point(){};

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public void moveUp(){
        x = getX();
        y = getY();
        System.out.println("Move up the point with the coordinates" + "(" + x + "," + y + ")");

    }
    public void moveDown(){
        x = getX();
        y = getY();
        System.out.println("Move down the point with the coordinates" + "(" + x + "," + y + ")");
    }
    public void moveLeft(){
        x = getX();
        y = getY();
        System.out.println("Move left the point with the coordinates" + "(" + x + "," + y + ")");
    }
    public  void moveRight(){
        x = getX();
        y = getY();
        System.out.println("Move right the point with the coordinates" + "(" + x + "," + y + ")");
    }





}

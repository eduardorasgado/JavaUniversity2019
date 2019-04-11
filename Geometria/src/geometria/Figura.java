/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometria;

/**
 *
 * @author cheetos
 */
public abstract class Figura {
    private int x;
    private int y;
    
    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public abstract double area();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}

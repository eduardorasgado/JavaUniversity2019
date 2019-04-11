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
public class Rectangulo extends Figura{
    private int largo;
    private int ancho;

    public Rectangulo(int x, int y, int largo, int ancho) {
        super(x, y);
        this.largo = largo;
        this.ancho = ancho;
    }
    
    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    @Override
    public double area() {
        return largo * ancho;
        
    }
    
    
}

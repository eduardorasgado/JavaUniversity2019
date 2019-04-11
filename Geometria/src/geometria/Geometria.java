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
public class Geometria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Figura r = new Rectangulo(1, 2, 5, 6);
        //r.setLargo(5);
        //r.setAncho(6);
        System.err.println("area: "+r.area());
        System.err.println("x: "+r.getX());
        System.err.println("y: "+r.getY());
    }
    
}

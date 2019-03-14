/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardocode.app.model;

import java.util.Date;

/**
 *
 * @author cheetos
 */
public class Alumno extends Persona {
    private int control;
    private Date fechaIngreso;

    public Alumno(String nombre, int edad) {
            super(nombre, edad);
            System.out.println("Se ha creado un alumno");
            // creando una fecha
            this.fechaIngreso = new Date();
    }

    public int getControl() {
            return control;
    }

    public void setControl(int control) {
            this.control = control;
    }

    public Date getFechaIngreso() {
            return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
            return "Alumno [ Nombre="
                            + this.getNombre()
                            +" Numero de control=" 
                            + control + ", fecha de ingreso=" 
                            + fechaIngreso + "]";
    }
}

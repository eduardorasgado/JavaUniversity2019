/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardocode.app.service;

import com.eduardocode.app.model.Alumno;
import java.util.Date;

/**
 *
 * @author cheetos
 */
public class AlumnoServiceImp implements IAlumnoService {

    @Override
    public Alumno saveAlumno(String nombre, int edad, int control, Date fechaIngreso) {
        Alumno alumno = new Alumno(nombre, edad);
        alumno.setControl(control);
        alumno.setFechaIngreso(fechaIngreso);
        return alumno;
    }
    
}

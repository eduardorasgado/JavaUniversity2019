/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardocode.app.service;

import com.eduardocode.app.model.Alumno;

/**
 *
 * @author cheetos
 */
public interface IAlumnoService {
    Alumno saveAlumno(String nombre, int edad, int control);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariopersonal;

import com.eduardocode.app.UI.FormularioPrincipal;
import com.eduardocode.app.service.AlumnoServiceImp;

/**
 *
 * @author cheetos
 */
public class FormularioPersonal {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // agregando el servicio
        AlumnoServiceImp alumnoService = new AlumnoServiceImp();
    
        FormularioPrincipal form = new FormularioPrincipal();
        
        form.setVisible(true);
        form.setLocationRelativeTo(null);
        
        // if(numControl != 0 && edadPersona != 0) {
            // guardar como una entidad
        //    Alumno alumnoSaved = alumnoService.saveAlumno(nombrePersona, edadPersona, numControl, fechaIngreso);
        //    this.showAlumnoCreated(alumnoSaved);
        //}
    }
    
}

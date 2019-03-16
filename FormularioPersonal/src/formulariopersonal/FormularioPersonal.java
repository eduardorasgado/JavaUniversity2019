/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariopersonal;

import com.eduardocode.app.UI.FormularioPrincipal;
import com.eduardocode.app.model.Alumno;
import com.eduardocode.app.service.AlumnoServiceImp;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JTextField;

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
        FormularioPrincipal alumnoForm = new FormularioPrincipal();
        
        alumnoForm.setVisible(true);
        alumnoForm.setLocationRelativeTo(null);
        
        // if(numControl != 0 && edadPersona != 0) {
            // guardar como una entidad
        //    Alumno alumnoSaved = alumnoService.saveAlumno(nombrePersona, edadPersona, numControl, fechaIngreso);
        //    this.showAlumnoCreated(alumnoSaved);
        //}
        
        alumnoForm.getBtnSalir().addActionListener( (ActionListener) -> {
            System.err.println("SALIR");
            System.exit(0);
        });
        
        alumnoForm.getBtnGuardar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // recaudando los datos de los campos
                String nombre = alumnoForm.getNombreText();
                int edad = 0;
                int numControl = 0;

                JTextField edadContainer = alumnoForm.getEdadText();
                JTextField numControlContainer = alumnoForm.getNumControlText();
                JCalendar fechaIngresoContainer = alumnoForm.getFechaIngresoText();
                
                // validacion y obtencion de campos, conversion a enteros
                if ("".equals(nombre)) {
                    alumnoForm.showInputError(alumnoForm, "Inserte un nombre");
                }

                try {
                    edad = Integer.parseInt(edadContainer.getText());
                } catch(NumberFormatException error) {
                    alumnoForm.showInputError(alumnoForm, "inserte una edad valida");
                }

                try {
                    numControl = Integer.parseInt(numControlContainer.getText());
                } catch(NumberFormatException error) {
                    alumnoForm.showInputError(alumnoForm, "inserte un numero de control valido");
                }

                Date fechaIngreso = fechaIngresoContainer.getCalendar().getTime();

                // si se cumple la validacion
                if(edad != 0 && numControl != 0 && !"".equals(nombre)) {
                    Alumno newAlumno = alumnoService.saveAlumno(nombre, edad, numControl, fechaIngreso);
                    alumnoForm.showAlumnoCreated(newAlumno);
                }
            }
        });
    }    
}

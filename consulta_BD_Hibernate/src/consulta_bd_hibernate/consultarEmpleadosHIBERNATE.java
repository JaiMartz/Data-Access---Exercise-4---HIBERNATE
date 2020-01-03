/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consulta_bd_hibernate;

import java.util.List;
import modelo.Empleados;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jairo
 */
public class consultarEmpleadosHIBERNATE {
    
     public static void main(String[] args) {
       //Create a session and work with it
       //Creamos una sesion y trabajamos con ella
       SessionFactory sesionGeneral = SessionFactoryUtil.getSessionFactory();
       Session sesionActual = sesionGeneral.openSession();
       
       //Set the query
       //Establecemos la sentencia
       Query q = sesionActual.createQuery("from Empleados");
       //Set the result into an Array (List)
       //Asignamos los resultados a un Array
       List<Empleados> listaEmpleados = q.list();
       
        System.out.println("");
        System.out.println("");
        System.out.println("INFORMACIÓN DE LOS EMPLEADOS");
        System.out.println("====================================");
       //Print the information inside the array
       //Recorremos el ArrayList de forma clásica
       for(Empleados empleadoActual : listaEmpleados){
           System.out.println("codEmpleado: "+empleadoActual.getCodEmpleado()
                        + "\tNombre: "+empleadoActual.getNombre()+" "
                        + "\tApellido: "+empleadoActual.getApellidos()+" "
                        + "\tPuesto: "+empleadoActual.getPuesto()+" "
                        + "\t\tSalario: "+empleadoActual.getSalario());
       }
        System.out.println("====================================");
        sesionActual.close();
     }
    
}

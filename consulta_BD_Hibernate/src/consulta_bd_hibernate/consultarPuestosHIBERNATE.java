/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consulta_bd_hibernate;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import modelo.Empleados;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jairo
 */
public class consultarPuestosHIBERNATE {
     public static void main(String[] args) {
         
        //Creamos una sesión y trabajamos con ella
        SessionFactory sesionGeneral = SessionFactoryUtil.getSessionFactory();
        Session sesionActual = sesionGeneral.openSession();
         
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        Query q;
        List<Empleados> listaEmpleados;
        
        do{
            System.out.println("¿Desea consultar los diferentes puestos de trabajo?");
            System.out.println("1 - Sí");
            System.out.println("2 - Salir\n");
            System.out.println("Introduzca el número de la respuesta: ");
            final int sc = scanner.nextInt();
        
        try{
            if(sc == 1){
                q = sesionActual.createQuery("from Empleados");
                listaEmpleados = q.list();
                
                System.out.println("==================================");
                for(Empleados emp: listaEmpleados){
                    System.out.println("- "+emp.getPuesto());
                }
            System.out.println("\nConsultar empleados cuyo puesto de trabajo es\n"+"1- Administrativo"
                    +"\n2- Programador Senior"+"\n3- Programador Junior"+"\n4- Jefe de equipo"+"\n5- Salir");
            System.out.println("Introduzca su respuesta:");
            //Create a new variable that save the scanner's information
            //Creamos una nueva variable que recoja la información del scanner
            final int scSwitch = scanner.nextInt();
            System.out.println("");
            
            
            switch(scSwitch){
                
                case 1:
                    System.out.println("Has seleccionado: Administrativo");
                    System.out.println("---------------------------------------------------\n");
                    q = sesionActual.createQuery("from Empleados emp where emp.puesto='Administrativo'");
                    listaEmpleados = q.list();
                    consultaPuestos(listaEmpleados);
                    break;
                case 2:
                    System.out.println("Has seleccionado Programador Senior");
                    System.out.println("---------------------------------------------------\n");
                    q = sesionActual.createQuery("from Empleados emp where emp.puesto='Programador Senior'");
                    listaEmpleados = q.list();
                    consultaPuestos(listaEmpleados);
                    break;
                case 3:
                    System.out.println("Has seleccionado Programador Junior");
                    System.out.println("---------------------------------------------------\n");
                    q = sesionActual.createQuery("from Empleados emp where emp.puesto='Programador Junior'");
                    listaEmpleados = q.list();
                    consultaPuestos(listaEmpleados);
                    break;
                case 4:
                    System.out.println("Has seleccionado Jefe de equipo");
                    System.out.println("---------------------------------------------------\n");
                    q = sesionActual.createQuery("from Empleados emp where emp.puesto='Jefe de equipo'");
                    listaEmpleados = q.list();
                    consultaPuestos(listaEmpleados);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("***FIN DE LA APLICACIÓN***");
                    salir=true;
                    sesionActual.close();
                    break;
            }
            
            }else if(sc==2){
                salir = true;
                sesionActual.close();
                System.out.println("***FIN DE LA APLICACIÓN***");
            }
        }catch(InputMismatchException e){
                System.out.println("Debes introducir correctamente las opciones");
                scanner.next();
            }
        }while(!salir);

     }
     public static void consultaPuestos(List<Empleados> list){
         for(Empleados emp: list){
              System.out.println("codEmpleado: "+emp.getCodEmpleado()+"\tNombre: "+emp.getNombre()+"\tApellido: "+emp.getApellidos()
                                    +"\tPuesto: "+emp.getPuesto()+"\tSalario: "+emp.getSalario());
        }
    }
}

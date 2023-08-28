/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umariana.proyecto;

import Mundo.Alumno;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author AnaMera
 */
public class Proyecto {

    public static void main(String[] args) throws FileNotFoundException {
        
        //Función que permite leer la opción del usuario
        Scanner lector = new Scanner(System.in);
        
        //Se crea el ArrayList para almacenar los datos de los alumnos
        ArrayList<Alumno> misAlumnos = new ArrayList<>();
        
        //Con la siguiente función se cargaran los datos al iniciar el programa
        
        //Asignamos una ruta donde se almacenaran los datos
        String rutaArchivo="data/alumnos.txt";
        //Se cargaran los datos desde el archivo hacia el ArrayList
        
        cargarDatosDesdeArchivo(rutaArchivo, misAlumnos);
        
        boolean activo=true;
        while(activo){
            mostrarMenu();
            int opcion=lector.nextInt();
            
            switch(opcion){
                case 1:
                    insertarAlumno(lector, misAlumnos);
                    break;
                case 2:
                    eliminarAlumno(lector, misAlumnos);
                    break;
                case 3:
                    modificarAlumno(lector, misAlumnos);
                    break;
                case 4:
                    consultarAlumnos(lector, misAlumnos);
                    break;
                case 5:
                    generarReporte(lector, misAlumnos);
                    break;
                case 6:
                    guardarDatosEnArchivo(rutaArchivo, misAlumnos);
                    activo = false;
                    break;
                default:
                    System.out.println("Opción no válida, elija una opción existente");
            }
        }
    }
    
    private static void cargarDatosDesdeArchivo(String rutaArchivo, ArrayList<Alumno> misAlumnos){
        try {
            File archivo=new File(rutaArchivo);
            Scanner scanner=new Scanner(archivo);
            while(scanner.hasNextLine()){
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");
                int cedula = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String apellido = datos[2];
                int semestre = Integer.parseInt(datos[3]);
                String correo = datos[4];
                String celular = datos[5];
                misAlumnos.add(new Alumno(cedula, nombre, apellido, semestre, correo, celular));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe, al finalizar el programa se creará uno");
        }
    }
         private static void mostrarMenu() {
        System.out.println("------------------- Menu de opciones -------------------");
        System.out.println("1. Insertar alumno");
        System.out.println("2. Eliminar alumno");
        System.out.println("3. Modificar alumno");
        System.out.println("4. Consultar alumnos registrados");
        System.out.println("5. Generar Reporte");
        System.out.println("6. Terminar Programa");
        System.out.println("--------------------------------------------------------");
    }
         
         private static void insertarAlumno(Scanner lector, ArrayList<Alumno> misAlumnos) {
             System.out.println("Bienvenid@ a registro de nuevo alumno");
             System.out.println("_____________________________________");
             System.out.println("Introduce cedula del almunno");
             int cedula = lector.nextInt();
             System.out.println("Introduce nombre del almunno");
             String nombre = lector.next(); 
             System.out.println("Introduce apellido del almunno");
             String apellido = lector.next();
             System.out.println("Introduce semestre del almunno");
             int semestre = lector.nextInt();
             System.out.println("Introduce correo del almunno");
             String correo = lector.next();
             System.out.println("Introduce celular del almunno");
             String celular = lector.next();
            // Agregamos los datos del alumno al ArrayList
            misAlumnos.add(new Alumno(cedula, nombre, apellido,semestre, correo, celular));
             System.out.println("Alumno agregado correctamente");
    }
         private static void eliminarAlumno(Scanner lector, ArrayList<Alumno> misAlumnos) {
             //Por seguridad del programa se pedirá la cédula del alumno que se haya registrado
             System.out.println("Ingrese la cédula del estudiante que desea eliminar");
             int cedulaEliminar=lector.nextInt();
             Alumno alumnoEliminar = null;
             
             for (Alumno alumno : misAlumnos){
                        if (alumno.getCedula()==cedulaEliminar){
                            alumnoEliminar = alumno;
                            break;
                        }
             }
             if (alumnoEliminar !=null){
                 misAlumnos.remove(alumnoEliminar);
                 System.out.println("Alumno eliminado");
             }else{
                 System.out.println("Alumno no encontrado");
             }
    }
         
         private static void modificarAlumno(Scanner lector, ArrayList<Alumno> misAlumnos) {
             System.out.println("Ingrese la cédula del alumno que desea modificar");
             int cedulaModificar=lector.nextInt();
             Alumno alumnoModificar=null;
             
             for (Alumno alumno : misAlumnos){
                        if (alumno.getCedula()==cedulaModificar){
                            alumnoModificar = alumno;    
                            break;
                        }
             }
             if(alumnoModificar != null){
         
                    System.out.println("Introduce nueva cedula");
                    int nuevocedula = lector.nextInt();
                    
                    System.out.println("Introduce nuevo nombre");
                    String nuevonombre = lector.next();
                    
                    System.out.println("Introduce nuevo apellido");
                    String nuevoapellido = lector.next();
                    
                    System.out.println("Introduce nuevo semestre");
                    int nuevosemestre = lector.nextInt();
                    
                    System.out.println("Introduce nuevo correo");
                    String nuevocorreo = lector.next();
                    
                    System.out.println("Introduce nuevo celular");
                    String nuevocelular = lector.next();
                    
                    alumnoModificar.setCedula(nuevocedula);
                    alumnoModificar.setNombre(nuevonombre);
                    alumnoModificar.setApellido(nuevoapellido);
                    alumnoModificar.setSemestre(nuevosemestre);
                    alumnoModificar.setCorreo(nuevocorreo);
                    alumnoModificar.setCelular(nuevocelular);
                    
                    System.out.println("Se ha modificado correctamente al alumno");  
                } else {
                        System.out.println("Alumno no encontrado");
             }
         }

         private static void consultarAlumnos(Scanner lector, ArrayList<Alumno> misAlumnos) {
             System.out.println("Digite la cédula del alumno que desea consultar");
             int cedulaConsultar=lector.nextInt();
             boolean alumnoEncontrado=false;
             
             for(Alumno alumno:misAlumnos){
                 if(alumno.getCedula()==cedulaConsultar){
                     System.out.println(alumno.toString());
                     alumnoEncontrado=true;
                     break;
                 }
             }
             if(!alumnoEncontrado){
                 System.out.println("No se ha encontrado ningún resultado");
             }
    }
         
         private static void generarReporte(Scanner lector, ArrayList<Alumno> misAlumnos) throws FileNotFoundException {
             System.out.println("Generar reporte");
             System.out.println("Ingrese el semestre");
             int semestreBusqueda=lector.nextInt();
             
             File archivo=new File("./data/reportesemestre.txt");
             
             try (PrintWriter pluma=new PrintWriter(archivo)){
                 pluma.println("Reporte de semestre"+semestreBusqueda);
                 pluma.println("__________________________________");
                 
                 for (Alumno alumno:misAlumnos){
                     if(semestreBusqueda==alumno.getSemestre()){
                         pluma.println(alumno.toString());
                     }   
                 }
             }
             System.out.println("Reporte generado y guardado");
    }
         
         private static void guardarDatosEnArchivo(String rutaArchivo, ArrayList<Alumno> misAlumnos) {
        try {
            PrintWriter pluma = new PrintWriter(rutaArchivo);
            for (Alumno alumno : misAlumnos) {
                pluma.println(alumno.getCedula() + "," + alumno.getNombre() + "," + alumno.getApellido() + ","
                        + alumno.getSemestre() + "," + alumno.getCorreo() + "," + alumno.getCelular());
            }
            pluma.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al guardar los datos");
        }
         }
}
       

    
    





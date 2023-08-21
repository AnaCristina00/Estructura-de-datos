/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umariana.proyecto;

import Mundo.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author AnaMera
 */
public class Proyecto {

    public static void main(String[] args) {
        
        //Función que permite leer la opción del usuario
        Scanner lector = new Scanner(System.in);
        
        //Se crea el ArrayList para almacenar los datos de los alumnos
        ArrayList<Alumno> misAlumnos = new ArrayList<>();
        
        //Bandera que permite terminar el programa
        boolean activo = true;
        
        //Ciclo que permite mostrar el menú de opciones hasta que se finalice el programa
        while (activo) {            
           System.out.println("------------------- Menu de opciones -------------------");
           System.out.println("1. Insertar alumno");
           System.out.println("2. Eliminar alumno");
           System.out.println("3. Modificar alumno");
           System.out.println("4. Consultar alumno");
           System.out.println("5. Terminar Programa");
           System.out.println("--------------------------------------------------------");
 
           int opcion = lector.nextInt();
           
            switch (opcion) {
                case 1 ->{
                    System.out.println("Bienvenid@ a registro de nuevo alumno");
                    
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
                    
                    // Agregar alumno al ArrayList
                     misAlumnos.add(new Alumno(cedula, nombre, apellido, semestre, correo, celular));
                    System.out.println("Alumno agregado correctamente");
                }
            
        
                case 2 -> { 
                    System.out.println("Ingrese la cédula del estudiante que desea eliminar");
                    int cedulaEliminar = lector.nextInt(); 
                    Alumno alumnoEliminar = null;
                    
                    //Ciclo que permite buscar al alumno en el ArrayList
                    for (Alumno alumno : misAlumnos){
                        if (alumno.getCedula()==cedulaEliminar){
                            alumnoEliminar = alumno;
                            
                            break;
                        }
                    }
                    if (alumnoEliminar != null){
                        //Opción que elimina al alumno del ArrayList
                        misAlumnos.remove(alumnoEliminar);
                        System.out.println("Alumno eliminado correctamente");
                    }
                    else{
                        System.out.println("Alumno no encontrado");  
                    }
                
                }
                case 3 -> { 
                    System.out.println("Ingrese la cédula del alumno que desee modificar");
                    int cedulaModificar = lector.nextInt();
                    Alumno alumnoModificar = null;
                    
                    //Ciclo que busca al alumno que vamos a modificar
                    for (Alumno alumno : misAlumnos){
                        if (alumno.getCedula()==cedulaModificar){
                            alumnoModificar = alumno;    
                            break;
                        }          
                    }
                    //Ingresamos los nuevos datos
            
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
                    
                    //Modificamos datos del alumno
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
                   break;
                }
            
                case 4 -> {
                    System.out.println("Introduce la cedula del alumno a consultar:");
                    int cedulaConsultar = lector.nextInt();
                    
                    boolean alumnoEncontrado = false;
                    
                    //Buscamos en el ArrayList al alumno
                
                for (Alumno alumno : misAlumnos) {
                        if (alumno.getCedula() == cedulaConsultar) {
                            System.out.println("Cedula: " + alumno.getCedula());
                            System.out.println("Nombre: " + alumno.getNombre());
                            System.out.println("Apellido: " + alumno.getApellido());
                            System.out.println("Semestre: " + alumno.getSemestre());
                            System.out.println("Correo: " + alumno.getCorreo());
                            System.out.println("Celular: " + alumno.getCelular());
                            
                            alumnoEncontrado = true;
                            break;
                        }
                }
            if(!alumnoEncontrado){
                System.out.println("Alumno no encontrado");
            }
                }
    
                case 5 -> {
                    //Opción para finalizar programa
                    System.out.println("Terminar Programa");
                    activo = false;
                }
                    
                default -> System.out.println("Opción no válida, elija una opción existente");
                }
            }
            }
        }
    
    





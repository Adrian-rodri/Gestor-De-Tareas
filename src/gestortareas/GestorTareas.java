package gestortareas;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author adria
 */
public class GestorTareas {

    public static void main(String[] args){
        try{
            System.setOut(new java.io.PrintStream(System.out,true,"UTF-8"));
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        
        Scanner entrada= new Scanner(System.in);
        int opcion= 0;
        TaskManager taskMng= new TaskManager("tareas.txt");
        do{
            System.out.println("+---------------------+");
            System.out.println("| 1. Agregar Tarea    |");
            System.out.println("| 2. Mostrar Tareas   |");
            System.out.println("| 3. Completar Tarea  |");
            System.out.println("| 4. Salir            |");
            System.out.println("+---------------------+");
            System.out.print("Seleccione una opcion: ");
            try{
                 opcion= entrada.nextInt();
                 entrada.nextLine();
                 switch(opcion){
                     case 1:
                         System.out.print("Ingrese la nueva tarea: ");
                         String newtask =entrada.nextLine();
                         taskMng.agregarTarea(newtask);
                         break;
                     case 2:
                         System.out.println("- Lista de Tareas -");
                         for(String task:taskMng.leerTareas()){
                             System.out.println(task);
                         }
                         break;
                     case 3:
                         System.out.println("- Lista de Tareas -");
                         int opcionTarea=1;
                         for(String task:taskMng.leerTareas()){
                             System.out.println(opcionTarea+". "+task);
                             opcionTarea++;
                         }
                         System.out.print("Numero de tarea a completar: ");
                         int ent=entrada.nextInt();
                         taskMng.completarTarea(ent);
                         entrada.nextLine();
                         break;
                     case 4:
                         System.out.println("Byee");
                         break;
                 }
            }catch(IOException e){
                System.err.println("Error: "+e.getMessage());
            }catch(InputMismatchException e){
                System.err.println("Ingrese una opcion valida");
                entrada.nextLine();
            }
            
        }while(opcion != 4);
}
    
}

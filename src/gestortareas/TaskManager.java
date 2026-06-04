package gestortareas;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class TaskManager {
    private File archivo;
    
    public TaskManager(String ruta){
       archivo= new File(ruta);
    }
    public void agregarTarea(String tarea) throws IOException{
        try(FileWriter writer= new FileWriter(archivo,true)){
            String formato= String.format("[ ] %s\n",tarea);
            writer.write(formato);
        }
    }
    
    public ArrayList<String> leerTareas() throws IOException{
   
        if(!archivo.exists())
            return new ArrayList<>();
        else{
            ArrayList<String> arrayTareas= new ArrayList<>();
            String linea="";
            try(FileReader reader= new FileReader(archivo)){
                int charact=reader.read();
                while(charact!=-1){
                    if((char)charact=='\n'){
                        arrayTareas.add(linea);
                        linea="";
                    }
                    else
                        linea+=(char)charact;
                    charact=reader.read();
                }
            }
             return arrayTareas;
        }
    }
    public void completarTarea(int numTarea) throws IOException{
        ArrayList<String> arrayTareas= leerTareas();
        if(numTarea>arrayTareas.size())
            return;
        String linea= arrayTareas.get(numTarea-1);
        String lineaMod=linea.replace("[ ]", "[\u2713]");
        arrayTareas.set(numTarea-1, lineaMod);
        
        try(FileWriter writer= new FileWriter(archivo, false)){
            for(String t:arrayTareas){
                writer.write(t+"\n"); 
            }
        }
    }
}

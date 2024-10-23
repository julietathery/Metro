/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author julietathery
 */
public class Functions {
    
    //Variables declaradas como atributos de la clase para facilitar el manejo de los metodos creados 
    
    File archivo; 
    FileInputStream entrada; 
    FileOutputStream salida; 

    /**
     * Funcion que abre el archivo y obtiene su contendio 
     * @param archivo seleccionado por el usuario
     * @return Contenido del archivo seleccionado 
     */
    
    
    public String AbrirArchivo(File archivo){
        String documento="";
        try{
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read())!=-1){
                char caracter = (char) ascci; 
                documento += caracter; 
            }
        }catch(Exception e){      
        }
        return documento; 
    }
    
    public String[] getParadas (String content){
        ListaParadas lista = new ListaParadas();
        String[] separar = content.split("Linea");
        for (int i = 1; i < separar.length-1; i++) {
            String newString = separar[i].replaceAll("/n","");
            newString = newString.replaceAll(" ", "").replaceAll(String.valueOf('"'), "").replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\[","").replaceAll("\\]","");
            String[] paradas = newString.split(",");
            for (int j = 0; j < paradas.length; j++) {
                lista.insertLast(new NodoParadas(new Sucursal(paradas[j])));
            }
        }
        lista.printList();
        String paradas = separar [0];
        String[] stops = paradas.split("\n");
        
        return stops;
    }
    
    public String[] getRelaciones (String content){
        String[] separar = content.split("Relaciones");
        String relaciones = separar[1];
        String[] relations = relaciones.split("\n");
        return relations;
    }
    
}

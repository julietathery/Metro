/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

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
    
    
    /**
     * Metodo que crea una lista con los nombres de las paradas 
     * @param content
     * @return 
     */
    
    public ListaParadas getParadas (String content){
        
        ListaParadas lista = new ListaParadas();
        String[] separar = content.split("Linea");
        
        
        
        for (int i = 1; i < separar.length; i++) {
            String newString = separar[i].replaceAll("/n","");
            newString = newString.replaceAll(" ", "").replaceAll(String.valueOf('"'), "").replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\[","").replaceAll("\\]","");
            String[] paradas = newString.split(",");

            
            lista.insertLast(new NodoParadas(new Sucursal("OtraLinea")));
            for (int j = 0; j < paradas.length; j++) {
                 if (paradas[j].contains(":")) {
                    try{
                     String[] probando = paradas[j].split(":");
                     int prueba = Integer.parseInt(paradas[j].split(":")[0]);
                     if (probando.length > 2){
                         paradas[j] = paradas[j].split(":")[1].trim();
                     } else{
                         paradas[j] = paradas[j].split(":")[1].trim();
                     }
                     
                    } catch (NumberFormatException e) {
                      paradas[j] = paradas[j].split(":")[0].trim();
                      }
                    
                      
                    }
                    
                if (!checkParadasList (lista, paradas[j])){
                lista.insertLast(new NodoParadas(new Sucursal(paradas[j])));
            }}}
        
       
        return lista;
    }
    
    public boolean checkParadasList (ListaParadas lista, String elemento){
        for (int i = 0; i < lista.getSize(); i++) {
            if (lista.getDato(i).getStop().getNameparada().equals(elemento)){
                return true; 
            }
        } return false;
    }
    
    
    
    
    
//    public ListaParadas getParadas (String content){
//        
//        ListaParadas lista = new ListaParadas();
//        String[] separar = content.split("Linea");
//        
//        
//        
//        for (int i = 1; i < separar.length-1; i++) {
//            String newString = separar[i].replaceAll("/n","");
//            newString = newString.replaceAll(" ", "").replaceAll(String.valueOf('"'), "").replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\[","").replaceAll("\\]","");
//            String[] paradas = newString.split(",");
//
//            lista.insertLast(new NodoParadas(new Sucursal("OtraLinea")));
//            for (int j = 0; j < paradas.length; j++) {
//                 if (paradas[j].contains(":")) {
//                    paradas[j] = paradas[j].split(":")[1].trim();
//                 }
//                lista.insertLast(new NodoParadas(new Sucursal(paradas[j])));
//            }
//        }
//       
//        return lista;
//    }
//    
    
    
    public ListaParadas getOnlyParadasCcs (String content){
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
       
        String paradas = separar [0];
        
        String[] stops = paradas.split("\n");
     
        return lista;
    }
    
  
}

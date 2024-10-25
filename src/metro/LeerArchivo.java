/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 * Clase para leer el archivo 
 * @author julietathery
 */
public class LeerArchivo {
    
    /**
     * Funcion para leer el json
     * @param CaracasJSON
     * @return 
     */
    

    
    
    public String leerCaracasJson(String CaracasJSON){
       String jsonText = " ";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(CaracasJSON));
            String line;
            while ((line = bf.readLine()) != null ){
                jsonText += line + "/n";
                
                
            }
            bf.close();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return jsonText; 
        
    }

     
    
    /**
     * Funcion para leer el json
     * @param BogotaJSON
     * @return 
     */
    
    public String leerBogotaJson(String BogotaJSON){
        String jsonText = " ";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(BogotaJSON));
            String line;
            while ((line = bf.readLine()) != null ){
                jsonText += line + "/n";
                
            }
            bf.close();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return jsonText;
    }

    
}
    
    
    

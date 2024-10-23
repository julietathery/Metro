/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metro;




/**
 *
 * @author julietathery
 */
public class Metro {
    public static Grafo grafoCcs;
    public static Grafo grafoBog;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        Startpage window = new Startpage();
        window.setVisible(true);
        
        LeerArchivo readFile = new LeerArchivo();
        Functions editFile = new Functions();
        FunctionsGrafo grafoFunciones = new FunctionsGrafo();
        
        String infoGrafo1 = readFile.leerCaracasJson("./src/metro/CaracasJSON.json");
        String infoGrafo2 = readFile.leerBogotaJson("./src/metro/BogotaJSON.json");
        String [] stopsCcs = editFile.getParadas(infoGrafo1);
        String [] stopsBog = editFile.getParadas(infoGrafo2);
        grafoCcs = grafoFunciones.crearGrafo(stopsCcs);
        grafoBog = grafoFunciones.crearGrafo(stopsBog);
        
        
        
    }
}       
       
  
     

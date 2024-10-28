/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metro;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;


/**
 *
 * @author julietathery
 */
public class FunctionsGrafo {
    
    //Variables declaradas como atributos de la clase para facilitar el manejo de los metodos creados 
    
    Grafo grafoAux = new Grafo();
    LeerArchivo f = new LeerArchivo();
    Functions use = new Functions();
    String infoGrafo1 = f.leerCaracasJson("./src/metro/CaracasJSON.json");
    String infoGrafo2 = f.leerBogotaJson("./src/metro/BogotaJSON.json");
    ListaParadas stopsCcs = use.getParadas(infoGrafo1);
    ListaParadas stopsBog = use.getParadas(infoGrafo2);
    ListaParadas allStopsCcs = use.getOnlyParadasCcs(infoGrafo1);
    //hacer bogota 
    
    
    /**
     * Metodo que crea un nuevo grafo a partir de la informacion del archivo
     * @param stops
     * @return 
     */
    
    
    
    
    
    
   
    
//    public Grafo crearGrafoCcs(ListaParadas stopsCcs){
//        
//       for (int i = 1; i < stopsCcs.getSize(); i++) {
//           for (int j = 0; j < this.allStopsCcs.getSize(); j++) {
//               if(stopsCcs.getDato(i).getStop().getNameparada() != this.allStopsCcs.getDato(j).getStop().getNameparada()){
//                   
//               }
//           }
//            
//            Sucursal stop1 = new Sucursal(stopsCcs.getDato(i).getStop().getNameparada());
//            Sucursal stop2 = new Sucursal(stopsCcs.getDato(i).getStop().getNameparada());
//            
//            grafoAux.addVertice(stop1);
//            
//            Nodo finLista = new Nodo(stopsCcs);
//       } 
//            
//       
//       return grafoAux;
//    }
    
    
   
    
    public Grafo crearGrafoBog(ListaParadas stopsBog){
        
       for (int i = 1; i < stopsBog.getSize(); i++) {
            
            Sucursal stop1 = new Sucursal(stopsBog.getDato(i).getStop().getNameparada());
            Sucursal stop2 = new Sucursal(stopsBog.getDato(i).getStop().getNameparada());
            
            grafoAux.addVertice(stop1);
            
           
       } 
            
       
       return grafoAux;
    }
    
    
    /**
     * Metodo para crear el grafo 
     * @param stopsCcs
     * @return 
     */
    
    public Grafo crearGrafoCcs(ListaParadas stopsCcs) {
    Sucursal stopPrevia = null;  // Para manejar la parada anterior y crear las conexiones
    boolean nuevaLinea = true;  // Indicador de que comienza una nueva línea
    
        
    for (int i = 0; i < stopsCcs.getSize(); i++) {
   
        String nombreParadaActual = stopsCcs.getDato(i).getStop().getNameparada();  
       
        
        // Verificar si es un marcador de cambio de línea
        if (nombreParadaActual.equalsIgnoreCase("OtraLinea")) {
             
            nuevaLinea = true;// Indicamos que estamos comenzando una nueva línea
            continue;  // Saltar esta iteración y seguir con la próxima parada
        }
        
        // Si no es "otraLínea", validamos si la parada actual ya está en el grafo
        boolean verticeExiste = false;
        Sucursal nodoExistente = null;
        if (nuevaLinea) {
            for (int k = 0; k < grafoAux.getSucursalList().getSize(); k++) {
            
                String nombreParadaGrafo = grafoAux.getSucursalList().getDato(k).getElement().getNameparada();
                        
                if (nombreParadaActual.equals(nombreParadaGrafo)) {
                verticeExiste = true;
                nodoExistente = grafoAux.getSucursalList().getDato(k).getElement(); // Guardar la referencia del nodo existente
                
                }
            }
        }
        
                
        // Si no existe, agregamos la parada como nuevo vértice
        if (!verticeExiste) {
            
            Sucursal stopActual = new Sucursal(nombreParadaActual);
            grafoAux.addVertice(stopActual);
            nodoExistente = stopActual; 
            
        }
        
        if (nuevaLinea) {
            if (nodoExistente != null && stopPrevia != null) {
                  
            // Conectar el último nodo de la línea anterior (stopPrevia) con el nodo actual
                grafoAux.deleteEdge(stopPrevia, nodoExistente);
            }
        // Ya no es una nueva línea después de procesar la primera estación
        nuevaLinea = false;
        } else {
        // Crear el arco normal si no es el comienzo de una nueva línea
            if (stopPrevia != null) {
                grafoAux.deleteEdge(stopPrevia, nodoExistente);  // Crear arco entre la parada anterior y la actual
            }
        }
    
    // Actualizamos la parada previa para la próxima iteración
    stopPrevia = nodoExistente;
        
    }
    
    return grafoAux;
}
              

    
    /**
     * Metodo para visualizar grafo
     * @param graph 
     */
    public void viewGraph(Graph graph) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout()){
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(640, 480);
            }
        };
        frame.setSize(panel.getWidth(), panel.getHeight());
        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        ViewPanel viewPanel = (ViewPanel) viewer.addDefaultView(false);
        panel.add(viewPanel);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);  
        
    }
     
    public Graph drawGraph (Grafo grafo){
        Graph graph = new MultiGraph("Paradas"); 
        System.setProperty("org.graphstream.ui", "swing");
        //graph.setAttribute("ui.stylesheet", "nodo {\n size:40px,30px;\n fill-color:#9EBCEF; \n text-mode: normal; \n}");
        
        for (int i=0;i<grafo.getSucursalList().getSize();i++){
            
            String stop = grafo.getSucursalList().getDato(i).getElement().getNameparada();
            graph.addNode(stop);
           
        }
        // Se recorre la lista de adyacencia de nuestro grafo para añadir los arcos y pesos al grafo de GraphStream
        for (int i=0; i < grafo.getSucursalList().getSize(); i++){
            String stop1 = grafo.getSucursalList().getDato(i).getElement().getNameparada();
            
            NodoVertice<Sucursal> node1 = grafo.getSucursalList().getDato(i).getNext();
            
              String stop2 = node1.getElement().getNameparada();
              org.graphstream.graph.Edge newEdge = graph.addEdge(stop1+ "-" + stop2, stop1, stop2);
              
   
            }
     return graph;
    }
     
    
    public void resaltarParada(String nombreParada) {
        // Buscar la parada en la lista de paradas
        Graph graph = new SingleGraph("Sucursales"); 
        Sucursal paradaEncontrada;
        System.out.println(grafoAux);
        for (int i = 0; i < stopsCcs.getSize(); i++) {
            Sucursal parada = grafoAux.getSucursalList().getDato(i).getElement(); //ERROR
            
            if (parada.getNameparada().equalsIgnoreCase(nombreParada)) {
                System.out.println("ahi voy");
                paradaEncontrada = parada;
                //graph.addNode(nombreParada);
                break;
            }else{
                JOptionPane.showMessageDialog(null, "Parada no encontrada en el grafo.");
                return;
            }
        }

        // Cambiar el color del nodo correspondiente en GraphStream
        Node nodo = graph.getNode(nombreParada);
        if (nodo != null) {
            nodo.setAttribute("ui.style", "fill-color: red;"); // Cambia el color a rojo (o cualquier color deseado)
            JOptionPane.showMessageDialog(null, "Parada " + nombreParada + " resaltada en el grafo.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al intentar resaltar el nodo en el grafo.");
        } 
    }
    
}

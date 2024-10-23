/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metro;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

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
    String[] stopsCcs = use.getParadas(infoGrafo1);
    String [] stopsBog = use.getParadas(infoGrafo2);
    
    
    
    
    /**
     * Metodo que crea un nuevo grafo a partir de la informacion del archivo
     * @param stops
     * @return 
     */
    
    public Grafo crearGrafo(String[] stopsCcs){
        
       for (int i = 1; i < stopsCcs.length; i++) {
            String[] info = stopsCcs[i].trim().split(",");
            String nameparada = info[1].trim();
            Sucursal stop1 = new Sucursal(nameparada);
            System.out.println(stop1);
            grafoAux.addVertice(stop1);} 
            
       
       return grafoAux;
    }
    
    
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
        /*graph.setAttribute("ui.stylesheet", "nodo {\n size:40px,30px;\n fill-color:#9EBCEF; \n text-mode: normal; \n}");*/
        System.out.println(grafo.getSucursalList().getSize());
        for (int i=0;i<grafo.getSucursalList().getSize();i++){
            
            String stop = grafo.getSucursalList().getDato(i).getElement().getNameparada();
            graph.addNode(stop);
            System.out.println("stop" + stop);
        }
        // Se recorre la lista de adyacencia de nuestro grafo para añadir los arcos y pesos al grafo de GraphStream
        for (int i=0; i < grafo.getSucursalList().getSize(); i++){
            String stop1 = grafo.getSucursalList().getDato(i).getElement().getNameparada();
            NodoVertice node1 = grafo.getSucursalList().getDato(i);
            for (int j=0; j<node1.getStoplist().getSize(); j++){
                String stop2 = node1.getStoplist().getDato(j).getStop().getNameparada();
                graph.addEdge(" ", stop1, stop2, false);
            }
    } return graph;
    }
     
     
     
    
}

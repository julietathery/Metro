/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metro;

import javax.swing.JOptionPane;

/**
 *
 * @author julietathery
 */
public class Grafo {
    private Vertice<NodoVertice> sucursalList;
    private Vertice<NodoParadas> edges;
    private int Vmax; // numero maximo de vertices
    private int V; // numero de vertices
    private int A; // numero de aristas

    
    
    /**
     * Constructor 
     *
     */
    
    
    public Grafo() {
        this.sucursalList =  new Vertice<NodoVertice>();
        this.edges = new Vertice<NodoParadas>();
        this.Vmax = 100;
        this.V = 0;
        this.A = 0;
    }

    
   
   
    /**
     * Metodo que agrega una sucursal como vertice del grafo 
     * @param currentSucursal 
     */
    
    public void addVertice(Sucursal currentSucursal) {
        sucursalList.insertFinal(currentSucursal);
        V++;
    }
    
    
    /**
     * Agrega la conexion entre los vertices
     * @param parada1
     * @param parada2 
     */
    
     public void addEdge(Sucursal parada1, Sucursal parada2) {
         if (!"".equals(parada1.getNameparada()) && "".equals(parada2.getNameparada())){
             if(parada1.getNameparada().equals(parada2.getNameparada())){
                 JOptionPane.showMessageDialog(null,( "No se puede conectar la estacion con ella misma"));
                 
             } else{
                 Vertice vertice1 = this.getSucursalList();
                 Vertice vertice2 = this.getSucursalList();
                 
                 if(vertice1 == null || vertice2 == null){
                     JOptionPane.showMessageDialog(null,"Alguna de las estaciones no existe");
                 }
//               else{
//                  grafoAux.addEdge(parada1.getNameparada()+ "-"+ parada2.getNameparada(), parada1.getNameparada(),parada2.getNameparada() );
//                            
//                 }
                        
             }            
         }
     }

  
    /**
     * Metodo que elimina un vertice del grafo 
     * @param sucursal 
     */ 
     
     
      public void deleteVertice(Sucursal sucursal) {
        if (sucursalList.checkParada(sucursal)) {

            for (int i = 0; i < sucursalList.getSize(); i++) {

                for (int j = 0; j < sucursalList.getDato(i).getStoplist().getSize(); j++) {

                    // elimina el usuario de las diferentes listas
                    if (sucursalList.getDato(i).getStoplist().getDato(j).getStop() == sucursal) {
                        sucursalList.getDato(i).getStoplist().deleteInIndex(j);
                        A--;

                    }

                    // elimina el usuario de la lista de usuarios vertex
                    if (sucursalList.getDato(i).getElement() == sucursal) {
                        sucursalList.deleteInIndex(i);
                    }
                }
            } 
            V--;
            sucursalList.setSize(V);

        } else {
            JOptionPane.showMessageDialog(null, "Error. El usuario que desea eliminar no existe.");
        }
    }
    
    
      /**
       * Metodo que elimina una arista entre dos vertices 
       * @param parada1
       * @param parada2 
       */
      
      
        public void deleteEdge(Sucursal parada1, Sucursal parada2) {
        if (sucursalList.checkParada(parada1) && sucursalList.checkParada(parada2)) {

            for (int i = 0; i < sucursalList.getSize(); i++) {

                if (sucursalList.getDato(i).getElement().equals(parada1)) {
                    NodoParadas pointer = sucursalList.getDato(i).getStoplist().getHead();

                    for (int j = 0; j < sucursalList.getDato(i).getStoplist().getSize(); j++) {

                        if (pointer.getStop() == parada2) {
                            sucursalList.getDato(i).getStoplist().deleteInIndex(j);

                            break;

                        } else {
                            pointer = pointer.getNext();
                        }
                    }

                } else if (sucursalList.getDato(i).getElement().equals(parada2)) {
                    NodoParadas pointer = sucursalList.getDato(i).getStoplist().getHead();

                    for (int j = 0; j < sucursalList.getDato(i).getStoplist().getSize(); j++) {

                        if (pointer.getStop() == parada1) {
                            sucursalList.getDato(i).getStoplist().deleteInIndex(j);
                            break;

                        } else {
                            pointer = pointer.getNext();
                        }

                    }
                }
            }
            A--;
        } else {
            JOptionPane.showMessageDialog(null, "Error. Alguno de los usuarios ingresados no existe.");
        }
    }
        
       
    /**
     * Metodo la verificar si hay una arista entre dos vertices 
     * @param parada1
     * @param parada2
     * @return 
     */   
        
        
     public boolean checkAdj(Sucursal parada1, Sucursal parada2) {
        boolean adj = false;
        for (int i = 0; i < sucursalList.getSize(); i++) {
            Sucursal currentUser = sucursalList.getDato(i).getElement();
            if (currentUser == parada1) {
                for (int j = 0; j < sucursalList.getDato(i).getStoplist().getSize(); j++) {

                    if (sucursalList.getDato(i).getStoplist().getDato(j).getStop() == parada2) {
                        adj = true;
                    }
                }

            }
        }
        return adj;
    }   
     
     
    /**
     * Metodo que imprime los vertices del grafo 
     */
     
      public void printVerts() {

        String sVerts = "";
        sVerts += V + " vertices, " + A + " aristas " + "\n";
        for (int i = 0; i < V; i++) {
            NodoVertice pointer = sucursalList.getHead();
            sVerts += (sucursalList.getDato(i).getElement().getNameparada() + " -> ");
            for (int j = 0; j < sucursalList.getDato(i).getStoplist().getSize(); j++) {
                sVerts += "(" + sucursalList.getDato(i).getStoplist().getDato(j).getStop().getNameparada() + ")";

            }
            sVerts += " \n";
        }
        System.out.println(sVerts);
    }
      
    /**
     * Metodo para imprimir las sucursales 
     */ 
      
     public void printSucursales() {

        sucursalList.printList();
    }
      
    
    
    /**
     *  Metodo para imprimir las aristas de cada verfice del grafo 
     */
     
     
     public void printStop() {

        for (int i = 0; i < sucursalList.getSize(); i++) {
            System.out.println(sucursalList.getDato(i).getElement().getNameparada() + "-->");
            for (int j = 0; j < sucursalList.getDato(i).getStoplist().getSize(); j++) {
                System.out.println(j + ". " + sucursalList.getDato(i).getStoplist().getDato(j).getStop().getNameparada());
            }
        }

    }
     
     
     
    
     /**
      * Metodo que indica la posicion de la sucursal en la lista de paradas 
      * @param sucursal
      * @return 
      */
     
     public int getIndex(Sucursal sucursal) {
        if (!(sucursalList.isEmpty())) {
            int index = 0;
            NodoVertice aux = sucursalList.getHead();
            while (aux != null) {
                if (aux.getElement() == (sucursal)) {
                    break;
                }
                aux = aux.getNext();
                index++;
            }
            return index;
        }
        return -1;
    }

     
     
    /**
     * Metodo para el recorrido de anchura del grafo 
     * @return
     * @throws Exception 
     */ 
     
     
      public int BFS() throws Exception {

        Queue<Sucursal> cola = new Queue<>();
        Vertice<Sucursal> paradasVisitadas = new Vertice<>();
        boolean visitados[] = new boolean[V];
        Sucursal currentSucursal;
        int contIslas = 0;

        for (int i = 0; i < V; i++) {
            visitados[i] = false;
        }

        for (int i = 0; i < V; i++) {

            if (!visitados[i]) {
                cola.enqueue(sucursalList.getDato(i).getElement());
                visitados[i] = true;

                while (!cola.isEmpty()) {
                    currentSucursal = cola.dequeue();
                    paradasVisitadas.insertFinal(currentSucursal);
                    int numAux = getIndex(currentSucursal);

                    for (int j = 0; j < V; j++) {
                        if ((numAux != j) && (checkAdj(currentSucursal, sucursalList.getDato(j).getElement())) && (!visitados[j])) {
                            cola.enqueue(sucursalList.getDato(j).getElement());
                            visitados[j] = true;
                        }
                    }
                }
                contIslas += 1;

            }
        }
        return contIslas;

    }
      
    
     
     /**
      * Metodo para obtener la lista de sucursales del grafo 
      * @return 
      */ 
      
     public Vertice<NodoVertice> getSucursalList() {
        return sucursalList;
    }
     
      
    /**
     * Metodo recursivo que permite recorrer la lista para realizar el recorrido por profundidad del grafo 
     * @param numVertice
     * @param visitados
     * @param paradasVisitadas
     * @return 
     */ 
     
    private Vertice deepTraveling(int numVertice, boolean[] visitados, Vertice paradasVisitadas) {
        visitados[numVertice] = true;
        paradasVisitadas.insertFinal(sucursalList.getDato(numVertice).getElement());

        for (int i = 0; i < V; i++) {
            if ((numVertice != i) && (!visitados[i]) && (checkAdj(sucursalList.getDato(numVertice).getElement(), sucursalList.getDato(i).getElement()))) {
                paradasVisitadas = deepTraveling(i, visitados, paradasVisitadas);
            }
        }
        return paradasVisitadas;
    }
    
    
    /**
     * Metodo para realizar el recorrido de profundidad del grafo 
     * @return
     * @throws Exception 
     */
    
     public int DFS() throws Exception {

        int contIslas = 0;

        boolean[] visitados = new boolean[V];
        Vertice<Sucursal> paradasVisitadas = new Vertice<>();
        
       
        for (int i = 0; i < V; i++) {
            visitados[i] = false;
        }
        for (int i = 0; i < V; i++) {
            if (!visitados[i]) {
                paradasVisitadas = deepTraveling(i, visitados, paradasVisitadas);
                contIslas ++;
            } 
        }
        return contIslas;

    }
     
     
     public boolean checkPuente(Sucursal parada1, Sucursal parada2) throws Exception {

        boolean isPuente = false;
        

        // obtiene el peso de la arista para volverla agregar al grafo al finalizar la funcion
        if (sucursalList.checkParada(parada1) && sucursalList.checkParada(parada2)) {
            
            for (int i = 0; i < sucursalList.getSize(); i++) {
                Sucursal currentSucursal = sucursalList.getDato(i).getElement();
                if (currentSucursal == parada1) {
                    for (int j = 0; j < sucursalList.getDato(i).getStoplist().getSize(); j++) {
                        NodoParadas pointer = sucursalList.getDato(i).getStoplist().getDato(j);
                        if (pointer.getStop() == parada2) {
//                            years = sucursalList.getDato(i).getStoplist().getDato(j).getWeight();
                            break;
                        }
                    } break;
                }
            }

            int cantPuentes = BFS();
            deleteEdge(parada1, parada2);
            int cantNuevaPuentes = BFS();
            
            addEdge(parada1, parada2);
            
                      
            if (cantPuentes != cantNuevaPuentes) {
                isPuente = true;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error. Alguno de los usuarios ingresados no existe.");
        }
        return isPuente;
    }



}
    
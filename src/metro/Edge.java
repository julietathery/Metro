/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metro;

/**
 *
 * @author julietathery
 */
public class Edge {
    private Vertice next;
    private Vertice prev;

    
    public Edge(Vertice next, Vertice prev) {
        this.next = next;
        this.prev = prev;
    }
    
    

    public Vertice getNext() {
        return next;
    }
    
    

    public void setNext(Vertice next) {
        this.next = next;
    }
    
    

    public Vertice getPrev() {
        return prev;
    }
    
    

    public void setPrev(Vertice prev) {
        this.prev = prev;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metro;

/**
 *
 * @author julietathery
 */
public class NodoVertice <Sucursal> {
    private Sucursal element;
    private NodoVertice next;
    private NodoVertice prev;
    private ListaParadas stoplist;
    
    
    // Constructor de la clase 

    public NodoVertice(Sucursal sucursal) {
        this.element = sucursal;
        this.next = null;
        this.prev = null;
        this.stoplist = new ListaParadas();
    }
    
    
    
    // Getters and setters de la clase 

    public Sucursal getElement() {
        return element;
    }

    
    public void setElement(Sucursal element) {
        this.element = element;
    }
    

    public NodoVertice getNext() {
        return next;
    }
    

    public void setNext(NodoVertice next) {
        this.next = next;
    }
    

    public NodoVertice getPrev() {
        return prev;
    }
    

    public void setPrev(NodoVertice prev) {
        this.prev = prev;
    }
    

    public ListaParadas getStoplist() {
        return stoplist;
    }
    

    public void setStoplist(ListaParadas stoplist) {
        this.stoplist = stoplist;
    }
    
}
    

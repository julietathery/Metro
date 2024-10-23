/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metro;

/**
 *
 * @author julietathery
 */
public class NodoParadas {
    private NodoParadas next;
    private NodoParadas prev;
    private Sucursal stop;
    
    
    // Constructor de la clase 

    public NodoParadas( Sucursal stop) {
        this.next = null;
        this.prev = null;
        this.stop = stop;
    }
    
    
    // Getters and setters de la clase 

    public NodoParadas getNext() {
        return next;
    }
    
    

    public void setNext(NodoParadas next) {
        this.next = next;
    }
    
    

    public NodoParadas getPrev() {
        return prev;
    }
    
    

    public void setPrev(NodoParadas prev) {
        this.prev = prev;
    }
    

    

    public Sucursal getStop() {
        return stop;
    }
    
    

    public void setStop(Sucursal stop) {
        this.stop = stop;
    }
    
       
}

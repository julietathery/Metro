/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metro;

/**
 *
 * @author julietathery
 */
public class Nodo <T> {
    private T tInfo;
    private Nodo <T> pNextNodo;
    private Nodo <T> pPrevious;
    
    
    //Constructor de la clase 

    public Nodo(T tInfo) {
        this.tInfo = tInfo;
        this.pNextNodo = null;
        this.pPrevious = null;
    }
    
    
    // Getters and setters de la clase 

    public T gettInfo() {
        return tInfo;
    }
    
    

    public void settInfo(T tInfo) {
        this.tInfo = tInfo;
    }
    
    

    public Nodo<T> getNext() {
        return pNextNodo;
    }
    
    

    public void setNext(Nodo<T> pNextNodo) {
        this.pNextNodo = pNextNodo;
    }

    public Nodo<T> getPrev() {
        return pPrevious;
    }

    public void setPrev(Nodo<T> pPrevious) {
        this.pPrevious = pPrevious;
    }
    
    
    
}

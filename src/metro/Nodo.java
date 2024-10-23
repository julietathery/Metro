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
    
    
    //Constructor de la clase 

    public Nodo(T tInfo) {
        this.tInfo = tInfo;
        this.pNextNodo = null;
    }
    
    
    // Getters and setters de la clase 

    public T gettInfo() {
        return tInfo;
    }
    
    

    public void settInfo(T tInfo) {
        this.tInfo = tInfo;
    }
    
    

    public Nodo<T> getpNextNodo() {
        return pNextNodo;
    }
    
    

    public void setpNextNodo(Nodo<T> pNextNodo) {
        this.pNextNodo = pNextNodo;
    }
    
    
}

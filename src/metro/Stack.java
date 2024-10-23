/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metro;

/**
 *
 * @author julietathery
 */
public class Stack <T>{
    private int length;
    private Nodo <T> top;
    private Nodo <T> bottom;

    
    
    // Constructor 
    
    
    public Stack() {
        this.length = 0;
        this.top = null;
        this.bottom = null;
    }

    
    
    // Getters and setters 
    
    
    public int getLength() {
        return length;
    }
    
    

    public void setLength(int length) {
        this.length = length;
    }
    
    

    public Nodo<T> getTop() {
        return top;
    }

    
    
    public void setTop(Nodo<T> top) {
        this.top = top;
    }
    
    

    public Nodo<T> getBottom() {
        return bottom;
    }
    
    

    public void setBottom(Nodo<T> bottom) {
        this.bottom = bottom;
    }
    
    
    
    // Metodo que revisa si la pila esta vacia 
    
    
    private boolean isEmpty(){
        return top == null;
    }
    
    
   // Metodo que retorna el siguiente nodo 
    
    
    public Nodo<T> next(Nodo<T> nodo) {
        return nodo.getpNextNodo();
    }
   
    
    
    // Metodo para agregar el primer elemento de la pila 
    
    
    public void push(T tInfo){
        Nodo <T> newNodo = new Nodo(tInfo);
        if (isEmpty()){
            bottom = newNodo; 
        } else {
            top.setpNextNodo(newNodo);
        }
        top = newNodo;
        length ++;
    }
    
    
    // Metodo para eliminar el primer elemento de la pila 
    
    
   public T pop() {
        T aux = null;
        if (!isEmpty()) {
            aux = top.gettInfo();
            this.top = next(top);
            length--;
        }
        return aux;
    }

}

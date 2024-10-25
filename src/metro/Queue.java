/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metro;

/**
 *
 * @author julietathery
 */
public class Queue <T> {
    
    private int length;
    private Nodo <T> front;
    private Nodo <T> back;

    
    
    // Constructor 
    public Queue() {
        this.length = 0;
        this.front = null;
        this.back = null;
    }

    
    
    // Getters and setters 
    
    
    public int getLength() {
        return length;
    }

    
    
    public void setLenght(int length) {
        this.length = length;
    }

    
    
    public Nodo<T> getFront() {
        return front;
    }
    
    

    public void setFront(Nodo<T> front) {
        this.front = front;
    }

    
    
    public Nodo<T> getBack() {
        return back;
    }
    
    

    public void setBack(Nodo<T> back) {
        this.back = back;
    }

    
    // Metodo que retorna el siguiente nodo 
    
    
    public Nodo<T> next(Nodo<T> nodo) {
       return nodo.getNext();
    }
   
    
    // Metodo que verifica si la cola esta vacia 
    
    
    boolean isEmpty(){
        return front == null;
        
    }
    
    
    
    // Metodo para insertar un nodo al final de la cola 
    
    
    public void enqueue(T tInfo) {
        Nodo<T> newNodo = new Nodo(tInfo);
        if (isEmpty()) {
            front = newNodo;
        } else {
            back.setNext(newNodo);
        }
        back = newNodo;
        length++;
    }
    
    
    // Metodo para eliminar el primer elemento de la cola
    
    public T dequeue() {
        T aux = null;
        if (!isEmpty()) {
            aux = front.gettInfo();
            this.front = next(front);
            length--;
        }
        return aux;
    }
}

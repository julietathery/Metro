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
public class Vertice <T>{
    
    
    //Atributos de la clase 
    private NodoVertice <Sucursal> head;
    private NodoVertice <Sucursal> tail;
    private int size;

    // Constructor de la clase 
    
    public Vertice() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // Revisa si la lista esta vacia 
    
    
    public boolean isEmpty(){
        return head == null;
    }
    
    
    //Metodo que inserta al comienzo de la lista de vertices 
    
    
     public void insertBegin(T element) {
        NodoVertice<Sucursal> nodo = new NodoVertice(element);

        if (isEmpty()) {
            nodo.setNext(nodo);
            nodo.setPrev(nodo);
            setHead(nodo);
            setTail(nodo);

        } else {
            nodo.setNext(head);
            head.setPrev(nodo);
            setHead(nodo);
        }
        size++;
    }
     
    // Metodo qye inserta al final de la lista de vertices 
     
     
     public void insertFinal(Sucursal element) {
        NodoVertice<Sucursal> node = new NodoVertice(element);

        if (isEmpty()) {
            node.setNext(node);
            node.setPrev(node);
            setHead(node);
            setTail(node);

        } else {
            getTail().setNext(node);
            node.setPrev(tail);
            setTail(node);
            node.setNext(getHead());
            

        }
        size++;
    }
     
    
     // Metodo que elimina al comienzo de la lista de vertices 
     
     public NodoVertice deleteBegin(){
        if (isEmpty()) {
            System.out.println("List is Empty");
        } else {
            NodoVertice pointer = getHead();
            NodoVertice pointer2 = getHead();
            setHead((NodoVertice) getHead().getNext());
            while (pointer.getNext() != pointer2) {
                pointer = (NodoVertice) pointer.getNext();
            }
            pointer.setNext(getHead());
            pointer2.setNext(null);
            size--;
            return pointer;
        }
        
        return null;
    }
     
     
    // Metodo que elimina al final de la lista de vertices
     
     
     
    public NodoVertice deleteFinal(){
        if (isEmpty()) {
            System.out.println("List is Empty");
        } else {
            NodoVertice pointer = getHead();
            NodoVertice pointer2;
            
            if (size > 1){
                while (((pointer.getNext())).getNext() != getHead()) {
                    pointer = pointer.getNext();
                }
                pointer2 = pointer.getNext();
                pointer2.setNext(null);
                pointer.setNext(getHead());
            } else {
                pointer2 = deleteBegin();
            }
            size--;
            return pointer2;
        }
        
        return null;
    }
    
    
    
    // Metodo que elimina en una posicion especifica de la lista de vertices 
    
    
     public NodoVertice deleteInIndex(int index){
        if (isEmpty()) {
            System.out.println("List is Empty");
        } else {
            if (index == 0){
                deleteBegin();
            } else {
                if (index < size) {
                    if(index == size - 1) {
                        deleteFinal();
                    } else {
                        NodoVertice pointer = getHead();
                        NodoVertice pointer2;
                        int cont = 0;
                        while ( cont< index-1 ) {
                            pointer = (NodoVertice) pointer.getNext();
                            cont++;
                        }
                        pointer2 = (NodoVertice) pointer.getNext();
                        pointer.setNext((NodoVertice) pointer2.getNext());
                        pointer2.setNext(null);
                        return pointer2;
                    }
                    
                } else {
                    System.out.println("Error in index");
                }
            }
        }
        size--;
        return null;
    }
    
     
     
    // Metodo para imprimir la lista 
     
     
    public void printList() {
        if (!isEmpty()) {

            String aux = "[";
            for (int i = 0; i < getSize(); i++) {
                String dato = getDato(i).getElement().getNameparada();
                if (i == getSize() - 1) {
                    aux += dato + "]";
                } else {
                    aux += dato + ",";
                }
            }
            System.out.println(aux);

        } else {
            JOptionPane.showMessageDialog(null, "The list is currently empty.");
        }
    }
    
    
    
   // Metodo que obtiene el nodo verice que se encuentra en una posicion especifica  
     
   public NodoVertice<Sucursal> getDato(int index) {
        if (isEmpty()) {
            return null;

        } else {
            NodoVertice<Sucursal> pointer = getHead();
            int counter = 0;
            while (counter < index && pointer.getNext() != null) {
                pointer = pointer.getNext();
                counter++;
            }
            return pointer;
        }
    }
   
   // Metodo que verifica si alguna sucursal se encuentra en la lista de vertices 
   
   
   public boolean checkParada(Sucursal currentSucursal) {
        boolean found = false;
        for (int i = 0; i < getSize(); i++) {
            if (getDato(i).getElement().equals(currentSucursal)) {
                found = true;
                break;
            }
        }
        return found;
    }
 
     
    // Getters and setters 

    public NodoVertice<Sucursal> getHead() {
        return head;
    }

    public void setHead(NodoVertice<Sucursal> head) {
        this.head = head;
    }

    public NodoVertice<Sucursal> getTail() {
        return tail;
    }

    public void setTail(NodoVertice<Sucursal> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    Object get(Vertice vertice1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     
     
}

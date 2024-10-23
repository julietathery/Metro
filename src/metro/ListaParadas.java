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
public class ListaParadas {
    private NodoParadas head;
    private NodoParadas tail;
    private int size;
    
    
    // Constructor de la clase 

    public ListaParadas() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    
    public boolean isEmpty(){
        return head == null;
    }
    
    // Metodo para insertar al comienzo 
    
    
    public void insertBegin(NodoParadas nodo){
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
    
    // Metodo para insertar al final 
    
    
    public void insertLast(NodoParadas nodo){
        if (isEmpty()) {
            nodo.setNext(nodo);
            nodo.setPrev(nodo);
            setHead(nodo);
            setTail(nodo);

        } else {
            getTail().setNext(nodo);
            nodo.setPrev(tail);
            setTail(nodo);
            nodo.setNext(getHead());

        }
        size++;
    }
    
    // Metodo para eliminar el primero 
    
    
     public void deleteFirst() {

        if (!isEmpty()) {
            NodoParadas pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            size--;

        } else {
            JOptionPane.showMessageDialog(null, "Error. Cannot delete node because the list is empty.");

        }
    }
     
     
    // Metodo para eliminar el ultimo 
     
     
      public NodoParadas deleteFinal() {
        if (!isEmpty()) {
            NodoParadas pointer = getHead();
            if (getSize() == 1) {
                NodoParadas nodeReturn = getHead();
                setHead(null);
                size--;
                return nodeReturn;
            } else {
                while (pointer.getNext() != getHead() && pointer.getNext().getNext() != getHead()) {
                    pointer = pointer.getNext();
                }
                pointer.getNext().setPrev(null);
                NodoParadas nodeReturn = pointer.getNext();
                pointer.setNext(null);
                setTail(pointer);
                getHead().setPrev(getTail());
                getTail().setNext(getHead());
                size--;
                return nodeReturn;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error. Cannot delete node because the list is empty.");
        }
        return null;
    }
      
      
      
    // Metodo para eliminar en una posicion especifica 
      
      
      
     public NodoParadas deleteInIndex(int index) {
        if (!isEmpty()) {
            NodoParadas pointer = getHead();
            if (index > getSize()) {
                System.out.println("The index is bigger than the size");
                return deleteFinal();
                
            } else if (index == 0){
                deleteFirst();
                
            } else {
                if (index > getSize() / 2) {
                    pointer = getTail();
                    int cont = 0;
                    while (cont <= (getSize() - index - 1) && pointer.getPrev() != getTail()) {
                        pointer = pointer.getPrev();
                        cont++;
                    }
                    NodoParadas temp = pointer.getNext();
                    pointer.setNext(temp.getNext());
                    temp.getNext().setPrev(pointer);
                    temp.setNext(null);
                    temp.setPrev(null);
                    size--;
                    return temp;

                } else {
                    pointer = getHead();
                    int cont = 0;
                    while (cont < (index - 1) && pointer.getNext() != getHead()) {
                        pointer = pointer.getNext();
                        cont++;
                    }
                    NodoParadas temp = pointer.getNext();
                    pointer.setNext(temp.getNext());
                    temp.getNext().setPrev(pointer);
                    temp.setNext(null);
                    temp.setPrev(null);
                    size--;
                    return temp;
                }
            }
        }
        return null;
    } 
    
     
     
    // Metodo para imprimir la lista 
     
     
    public void printList() {
        if (!isEmpty()) {

            String aux = "[";
            for (int i = 0; i < getSize(); i++) {
                String dato = getDato(i).getStop().getNameparada();
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

    
    // Metodo que obtiene el nodo en el que se encurnta una parada especifica 
    
    
    public NodoParadas getDato(int index) {
        if (isEmpty()) {
            return null;

        } else {
            NodoParadas pointer = getHead();
            int counter = 0;
            while (counter < index && pointer.getNext() != null) {
                pointer = pointer.getNext();
                counter++;
            }
            return pointer;
        }
    }
    
    // Metodo que checkea si en la parada hay una sucursal 
    
    
     public boolean checkParada(Sucursal currentSucursal) {
        boolean found = false;
        for (int i = 0; i < getSize(); i++) {
            if (getDato(i).getStop().equals(currentSucursal)) {
                found = true;
                break;
            }
        }
        return found;
    }
    
     
     
    // Getters and setters 

    public NodoParadas getHead() {
        return head;
    }

    public void setHead(NodoParadas head) {
        this.head = head;
    }

    public NodoParadas getTail() {
        return tail;
    }

    public void setTail(NodoParadas tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
       
}

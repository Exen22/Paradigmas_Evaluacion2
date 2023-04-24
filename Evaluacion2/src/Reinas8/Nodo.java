/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas8;

public class Nodo<T> {
    private T date;
    private Nodo<T> next;
    
    public Nodo(T date){
        this.date = date;
        this.next = null;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public T getDate() {
        return date;
    }
    
    
    
    
}

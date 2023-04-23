
package nqueensr;

public class Pila<T> {
    
    private Nodo<T> top;
    private int size;
    //String text = "";
    
    public Pila()
    {
        top = null;
        size = 0;
    }
    
    public void push(T info){
        
        Nodo<T> niuNodo = new Nodo<>(info);
        niuNodo.setNext(top);
        top = niuNodo;
        size++;
    }

    public int getsize() {
        return size;
    }
    
    public T pop()
    {
        T aux = top.getDate();
        top = top.getNext();
        size--;
        return aux;
    }
    
    public boolean isEmpty()
    {
        return top == null;
    }

    public T gettopDate() {
        return top.getDate();
    }

   
    @Override
    public String toString() {
        return "Pila{" + "top =" + top + ", size =" + size + '}';
    }
    
    public void emptyAll()
    {
        while(!isEmpty())
            pop();
    }
    
    public void showAll()
    {
        Nodo<T> aux = top;
        int i = 1;
        
        do{
           
            System.out.print(" "+i + ": " + aux.getDate() + "\n");
               
            i++;
            aux = aux.getNext();
            
        }while(aux != null);
    }
     
    public void modify(int size, T niuValue)
    {
        Nodo<T> aux;
        aux = top;
        
        for(int i = 1; i < size; i++)
            aux = aux.getNext();
       
        aux.setDate(niuValue);
    }
    
    public T get(int i)
    {
        Nodo<T> aux;
        aux = top;
        i = size-i;
        int cont = 1;//contador
        
        //iteramos hasta la posicion indicada
        while(cont != i ){aux = aux.getNext(); cont++;}
       
        return aux.getDate();
        
    }
    
}


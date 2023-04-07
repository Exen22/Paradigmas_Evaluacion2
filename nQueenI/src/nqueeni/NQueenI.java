
package nqueeni;


import java.util.Scanner;
import java.util.Stack;
//import java.util.ArrayList;
//import java.util.Arrays;

class Resolve{
    Stack<Integer> pila = new Stack<>();
    //private int[]queens;
    private final int nQueens;
    
    public Resolve(int nQueens)
    {
        this.nQueens = nQueens;
    }
    
    //mostrar resultado
    private void showS(Stack<Integer> stack)
    {
        System.out.println();
        
        for(int row = 0; row < nQueens; row++ )
        {
            for (int col = 0; col < nQueens;col++)
            {
                //puesto que al pila almacena la columna si cada fila (row) contendra
                //el indice la columna
                if (stack.get(row) == col)
                    System.out.print(" Q ");
                else System.out.print(" - ");
            }
            System.out.println();
        }
    }
    
    private boolean check(int row, int col)
    {
        //comparamo sel indice de la columna con la columna en la que estamos
        /*
         * Si la columna actual es igual al indice se marca el fallo
         * Si el indice - la posicion actual es igual a la diagonal principal se marca el fallo
         * Si el indice + la posicion actual es igual a la diagonal secundaria se marca el fallo
         */
        
        for (int i = 0; i < row; i++) {
            if (pila.get(i) == col || pila.get(i) - i == col - row || pila.get(i) + i == col + row) {
                return false;
            }
        }
        return true;
    }
    
    //proceso completo
    public void solution()
    {
        int col = 0;
        
        //bucle que se repite hasta que lo terminemos 
        while(true)
        {    
            //comparamos cada columna mientras que la columna no supere el numero de reinas
            while(col < nQueens)
            {
                if (check(pila.size(),col)){
                    pila.push(col);//guardamos el indice de la columna
                    col = 0;
                    break;
                }
                col++;
            }    
            
            
            if (col == nQueens)
                //si la pila esta vacia es porque ya exploramos todas las soluciones
                if (pila.empty())
                    break;
                else col = pila.pop() + 1;//caso contrario iteramos a la siguiente columna y eliminamos el error
            
            if (pila.size() == nQueens)
            {
                showS(pila);
                //col = pila.pop() + 1;
                //en caso de querer mostrar una sola solucion quite el siguiente comentario
                break;
            }
            
        }
    }
}


public class NQueenI {
   
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\n Ingrese el numero de reinas: ");
        int nQ = keyboard.nextInt();
        Resolve reSolution = new Resolve(nQ);
        
        if (nQ <= 3)
        {
            
            System.out.println("No hay soluciones posibles o el tablero es invalido");
            System.exit(0);
            
        } else reSolution.solution();
        
    }   
}


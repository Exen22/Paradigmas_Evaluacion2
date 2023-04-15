
package nqueeni;


import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import java.util.Arrays;

class Resolve{
    Stack<Integer> pila;
    ArrayList<Stack<Integer>> arStack;
    
    //private int[]queens;
    private int nQueens;
    
    public Resolve()
    {
        pila = new Stack<>();
        arStack = new ArrayList<>();
    }

    public int getnQueens() {
        return nQueens;
    }

    public void setnQueens(int nQueens) {
        this.nQueens = nQueens;
    }
    
    
    //mostrar resultado
    public void showS()
    {
        int option;
        String juan = new String();
        Scanner keyboard = new Scanner(System.in);
        JOptionPane.showMessageDialog(null," Soluciones disponibles: " + arStack.size());
        //System.out.print("\n Soluciones disponibles: " + arStack.size());
        
        do{
            option = Integer.parseInt(JOptionPane.showInputDialog(null, " Ingrese la solucion que desea ver: "));
            
            if(option < 1 || option > arStack.size())
                JOptionPane.showMessageDialog(null," No existe esa solucion. intente otra");
            
        }while(option < 1 || option > arStack.size());
        
        Stack<Integer> pilaS = arStack.get(option-1);
        
        System.out.println(pilaS.isEmpty());
        
        
      
        
        for(int row = 0; row < nQueens; row++ )
        {
            for (int col = 0; col < nQueens;col++)
            {
                //puesto que al pila almacena la columna si cada fila (row) contendra
                //el indice la columna
                if (pilaS.get(row) == col)
                    juan+=" Q ";
                    //System.out.print(" Q ");
                else juan+= " -- "; //System.out.print(" - ");
            }
            //System.out.println();
            juan+="\n";
        }
        
        JOptionPane.showMessageDialog(null,juan);
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
                //showS(pila);
                
                //instacio una nueva pila donde guardare los indice 
                Stack<Integer> solutionStack = new Stack<>();
                 
                //guardamos los indices en la pila
                pila.forEach((queenCol) -> {
                    solutionStack.push(queenCol);
                });
                
                //guardamos la pila en la lista
                arStack.add(solutionStack);
                
                //iteramos para seguir buscando soluciones
                col = pila.pop() + 1;

                //en caso de querer mostrar una sola solucion quite el siguiente comentario
                //break;
            }
            
        }
    }
}


public class NQueenI {
   
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //System.out.print("\n Ingrese el numero de reinas: ");
        
        
        Resolve reSolution = new Resolve();
        int nQ = Integer.parseInt(JOptionPane.showInputDialog(null, " Ingrese el numero de reinas: "));
        reSolution.setnQueens(nQ);

        
        if (nQ <= 3)
        {
            
            System.out.println("No hay soluciones posibles o el tablero es invalido");
            System.exit(0);
            
        } else {
            reSolution.solution();
            reSolution.showS();
        }
        
    }   
}


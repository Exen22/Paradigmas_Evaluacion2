
package nqueeni;


import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import java.util.Arrays;

class Resolve{
    Pila<Integer> pila;
    ArrayList<Pila<Integer>> arStack;
    
    //private int[]queens;
    private int nQueens;
    
    public Resolve()
    {
        pila = new Pila<>();
        arStack = new ArrayList<>();
    }

    public int getnQueens() {
        return nQueens;
    }

    public void setnQueens(int nQueens) {
        this.nQueens = nQueens;
    }
    
    
    //mostrar resultado
    public void showS(/*Pila<Integer> pilaS*/)
    {
        int option;
        String show,confirm;
        
        JOptionPane.showMessageDialog(null," Soluciones disponibles: " + arStack.size());
        //System.out.print("\n Soluciones disponibles: " + arStack.getsize());
        
        do{
            //variables re inicializadas 
            show = "";
            option = 0;
            do{
                confirm = JOptionPane.showInputDialog(null, " Ingrese la solucion que desea ver: ");
                
                //validacion
                if (null == confirm)//si cancela sale del programa
                    System.exit(0);
                else if (onlyNumbers(confirm))//onlyNumbers() compara que solo ingrese numeros
                    JOptionPane.showMessageDialog(null,"Solo puede ingresar numeros intente de nuevo");
                else 
                switch (confirm) {
                    //confirma que la cadena no este vacia
                    case "":
                        JOptionPane.showMessageDialog(null," No puede dejar el campo vacio. intente de nuevo");
                        break;
                    //termino por defecto. todo bien
                    default:
                        option = Integer.parseInt(confirm);
                        if(option < 1 || option > arStack.size())
                            JOptionPane.showMessageDialog(null," No existe esa solucion. intente otra");
                        break;
                }

            }while(option < 1 || option > arStack.size() && "".equals(confirm) && onlyNumbers(confirm));
            
        
            Pila<Integer> pilaS = arStack.get(option-1);
        
            //System.out.println(pilaS.isEmpty());

            for(int row = 0; row < nQueens; row++ )
            {
                for (int col = 0; col < nQueens;col++)
                {
                    //puesto que al pila almacena la columna si cada fila (row) contendra
                    //el indice la columna
                    if (pilaS.get(row) == col)
                        show+=" Q ";
                        //System.out.print(" Q ");
                    else show+= " -- ";  //System.out.print(" - ");
                }
                //System.out.println();
                show+="\n";
            }
        
            JOptionPane.showMessageDialog(null,show);
        }while(0 == JOptionPane.showConfirmDialog(null, "¿Quiere ver otra opcion?", "NQueens Problem", JOptionPane.YES_NO_OPTION));
        
    }
    
    private boolean check(int row, int col)
    {
        //comparamos el indice de la columna con la columna en la que estamos
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
                if (check(pila.getsize(),col)){
                    pila.push(col);//guardamos el indice de la columna
                    col = 0;
                    break;
                }
                col++;
            }    
            
            
            if (col == nQueens)
                //si la pila esta vacia es porque ya exploramos todas las soluciones
                if (pila.isEmpty())
                    break;
                else col = pila.pop() + 1;//caso contrario iteramos a la siguiente columna y eliminamos el error
            
            if (pila.getsize() == nQueens)
            {
                //showS(pila);
                
                //instancio una nueva pila donde guardare los indice 
                
                
                Pila<Integer> solutionStack = new Pila<>();
                 
                //guardamos los indices en la pila
                for(int i = 0; i < pila.getsize(); i++)
                    solutionStack.push(pila.get(i));
                
                
                //guardamos la pila en la lista
                arStack.add(solutionStack);
                
                //iteramos para seguir buscando soluciones
                col = pila.pop() + 1;

                //en caso de querer mostrar una sola solucion quite el siguiente comentario
                //break;
            }
            
            //System.out.println(pila.getsize());
            
        }
        
    }
    
    private boolean onlyNumbers(String str)
    {
        //bucle foreach para recorrer toda las posiciones de la cadena
        //el metodo ToCharArray() convierte la cadena en una cadena de caracteres
        for (char Char : str.toCharArray())
        {
            if (Char < '0' || Char > '9' && Char != ' ')
            return true;
        }
        return false;
    }
}


public class NQueenI {
   
    public static void main(String[] args) {
        //System.out.print("\n Ingrese el numero de reinas: ");
        String confirm;
        
        Resolve reSolution = new Resolve();
        confirm = JOptionPane.showInputDialog(null, " Ingrese el numero de reinas: ");
        
        if (confirm == null)
            System.exit(0);
        
        int nQ = Integer.parseInt(confirm);
        
        while (nQ <= 3)
        {
            JOptionPane.showMessageDialog(null, "No hay soluciones posibles o el tablero es invalido. Intente de nuevo");      
            nQ = Integer.parseInt(JOptionPane.showInputDialog(null, " Ingrese el numero de reinas: "));    
        } 
        
        reSolution.setnQueens(nQ);
        reSolution.solution();
        reSolution.showS();
        
    }   
}


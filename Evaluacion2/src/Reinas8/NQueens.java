
package Reinas8;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NQueens{
    
    private int nqueens;
    private final Pila<Integer> pila;
    ArrayList<Pila<Integer>> solutions;
    
    //constructor
    public NQueens(){
        pila = new Pila<>();//inicializamos la pila
        solutions = new ArrayList<>();
    }
    
    public int getNqueens() {
        return nqueens;
    }

    public void setNqueens(int nqueens) {
        this.nqueens = nqueens;
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
    
    public boolean process(int row)
    {
        //si el tamaño de la pila es igual al numero de reinas es porque se encontro una solucion
        if (pila.getsize() == nqueens)
        {
            Pila<Integer> solutionpila = new Pila<>();
                 
                //guardamos los indices en la pila
                for(int i = 0; i < pila.getsize(); i++)
                    solutionpila.push(pila.get(i));
                
                
                //guardamos la pila en la lista
                solutions.add(solutionpila);
        }
        
        //Si la fila es mayor o igual al numero de reinas es porque ya se encontro una solucion
        //En caso de que la pila no este vacia retornara false y seguira buscando mas soluciones
        //Cuando la pila este vacia es porque encontramos todas las soluciones
        if (row >= nqueens)
        {
            return pila.isEmpty(); 
        }
        
        //Bucle del proceso recursivo
        for (int i = 0; i < nqueens; i++)
        {
            if (check(pila.getsize(),i)){
                
                //almacenamos el inidice de la columna
                pila.push(i);
                
                //llamada recursiva
                if(process(pila.getsize()))
                    return true;
                
                //en caso de no encontrar solucion volvemos atras (quitamos el indice de la columna) e iteramos
                pila.pop();
              }
   
        }
    
        return false;
    }
    
     public void show()
    {
        int option;
        String show,confirm;
        
        JOptionPane.showMessageDialog(null," Soluciones disponibles: " + solutions.size());
        //System.out.print("\n Soluciones disponibles: " + solutions.getsize());
        
        do{
            //variables re inicializadas 
            show = "";
            option = 0;
            do{
                confirm = JOptionPane.showInputDialog(null, " Ingrese la solucion que desea ver: ");
                
                //validacion
                if (null == confirm){//si cancela sale del programa
                    
                    int opc =JOptionPane.showConfirmDialog(null,"Esta seguro que quiere volver al Menu?", "Confirmacion", JOptionPane.YES_NO_OPTION);

                    if (opc==JOptionPane.YES_OPTION){
                        throw new NullPointerException();
                    }
                    else{
                        continue;  
                    }
                    
                }
                    //System.exit(0);
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
                        if(option < 1 || option > solutions.size())
                            JOptionPane.showMessageDialog(null," No existe esa solucion. intente otra");
                        break;
                }

            }while(option < 1 || option > solutions.size() || "".equals(confirm) || onlyNumbers(confirm));
            
        
            Pila<Integer> pilaS = solutions.get(option-1);

            for(int row = 0; row < nqueens; row++ )
            {
                for (int col = 0; col < nqueens;col++)
                {
                    //puesto que al pila almacena la columna si cada fila (row) contendra
                    //el indice la columna
                    if (pilaS.get(row) == col){
                        show+="♛";
                    }
                    
                    else
  
                        if ((row + col) % 2 == 0) {
                            show += "\u25A0"; // Caracter Unicode para el cuadrado negro
                        } else {
                            show += "\u25A1"; // Caracter Unicode para el cuadrado blanco
                        //show+= " -- ";
                        }
                }
                //System.out.println();
                show += "\n";
            }
            
            // Ajusta el tamaño de la fuente 
            Font font = new Font("monospaced", Font.PLAIN, 30);

            //el area de texto es necesaria para aumentar de tamano la tipografia
            JTextArea textArea = new JTextArea(show);//Creamos un area de texto para mostrar las reinas
            textArea.setFont(font);//guardamos la fuenta ya modificada en el area de texto
            textArea.setEditable(false);//hacemos que no sea pueda editar
            //mostramos mensaje
            JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Solución encontrada", JOptionPane.INFORMATION_MESSAGE);
            
        }while(0 == JOptionPane.showConfirmDialog(null, "¿Quiere ver otra solucion?", "NQueens Problem", JOptionPane.YES_NO_OPTION));
        
    }

    public Pila<Integer> getpila() {
        return pila;
    }
    
    //Comprobar que una cadena solo contenga numeros
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


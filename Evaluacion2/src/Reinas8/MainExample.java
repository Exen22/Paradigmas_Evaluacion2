
package Reinas8;

//descomentar en caso de necesitarlo
//import javax.swing.JOptionPane;

public class MainExample {

    public static void main(String[] args) {
       
       
        NQueens resolve = new NQueens();//inicializamos el numero de reinas en el constructor
        
        
        //Descomentar el siguiente codigo en caso de querer que el usuario ingrese el numero de reinas
        
        /*
        String confirm;
        confirm = JOptionPane.showInputDialog(null, " Ingrese el numero de reinas: ");
        
        if (confirm == null)
            System.exit(0);
        
        int nQ = Integer.parseInt(confirm);
        
        while (nQ <= 3)
        {
            JOptionPane.showMessageDialog(null, "No hay soluciones posibles o el tablero es invalido. Intente de nuevo");      
            nQ = Integer.parseInt(JOptionPane.showInputDialog(null, " Ingrese el numero de reinas: "));    
        }
        */
         
        //Descomentar o comentar esto en caso de ser necesario
        
        //resolve.setNqueens(nQ); //Determinado por el usuario
        
       
        resolve.setNqueens(8);//Numero de reinas fijo
        
        resolve.process(0);//iniciamos en 0; esto significa que iniciamos en la fila 0
        
        //mostrar resultado
        resolve.show();
        
    }
    
}

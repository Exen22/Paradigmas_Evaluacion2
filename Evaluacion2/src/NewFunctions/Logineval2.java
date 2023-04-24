
package NewFunctions;
import javax.swing.JOptionPane;
import static NewFunctions.ayuda.esNumero;
import static NewFunctions.login.login;
public class Logineval2 {

   //el usuario es Gato con G mayuscula porque sino no funciona y la clave es felino
    public static void main(String[] args) {
        String user="Gato", clave="felino";
        login(user, clave);
        
        
        String opcion;
        boolean sigue = true;
        do {
            
           
            do{
            opcion = JOptionPane.showInputDialog(null,"\nMenu:  \n1. Sacar el factorial de un numero \n2. Determinar los numeros primos y compuestos de los numeros ingesados \n3. Cajero Automatico \n4. Determinar los valores reales e imaginarios de una ecuacion de segundo grado \n5. Sacar el MCM y el MCD de 3 numeros\n6. Programa de las 8 reinas \n7. Salir. \nIntroduzca la operacion que desea realizar");
             if(esNumero(opcion)){
            sigue=true;
             }
             else {
                 JOptionPane.showMessageDialog(null,"Ha ingresado un caracter");
                 sigue=false;
             }
            }while(sigue!=true);
             int numero=Integer.parseInt(opcion);
             switch(numero){
                 case 1:
                  
                   
                     break;
                     
                     
                  
                 case 2:
                   
                 break;
                 
                 case 3:
                     
                 break;
                 
                 case 4:
                   
                 break;
                 
                 case 5:
               
                    
                 break;
                 case 6:
                 
                     
                 break;
                 
                 case 7:
                 System.exit(0);
                 break;
                 
                 default:
                  JOptionPane.showMessageDialog(null,"Opcion Invalida");
                 
                 
             }
    
        }while(opcion !="8");
    }   



}
  
        
        
    
    


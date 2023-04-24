
package NewFunctions;

import javax.swing.JOptionPane;


public class login {
  
    public static void login(String user, String clave) {
     
        int intentos = 0;

        do  {
           
            String nombreUsuario =JOptionPane.showInputDialog(null,"Ingrese su nombre de usuario");
            
          
            String password = JOptionPane.showInputDialog(null,"Ingrese su clave");

            if (nombreUsuario.equals(user) && password.equals(clave)) {
               
                JOptionPane.showMessageDialog(null,"Bienvenido al sistema, " + user);
                break;
            } else {
                intentos++;
              
                JOptionPane.showMessageDialog(null,"Nombre de usuario o clave incorrectos, intentelo de nuevo.");
                
            }
            
            if (intentos == 3){
                
               JOptionPane.showMessageDialog(null,"Ha agotado sus numeros de intentos, el sistema se cerrara");
                System.exit(0);
            }
        }while (intentos < 3);
     
}  
    
}


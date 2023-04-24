
package NewFunctions;


import javax.swing.JOptionPane;


public class login {
  
    public static void login(String user, String clave) {
     
        int intentos = 0;
      
        do  {
            
            String nombreUsuario =null;
            String password=null;
             try{
              nombreUsuario =JOptionPane.showInputDialog(null,"Ingrese su nombre de usuario");
               if(nombreUsuario==null)throw new Exception();
          
              password = JOptionPane.showInputDialog(null,"Ingrese su clave");
             if(password==null)throw new Exception();
             }catch(Exception e){
                  int opc =JOptionPane.showConfirmDialog(null,"Esta seguro de salir del programa?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                  if (opc==JOptionPane.YES_OPTION){
                      System.exit(0);
                  }
                  else{
                      continue;
                  }
                      
                  }
            if ( nombreUsuario.equals(user) && password.equals(clave)) {
               
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


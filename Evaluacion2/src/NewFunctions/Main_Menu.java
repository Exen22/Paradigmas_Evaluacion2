package NewFunctions;
import javax.swing.JOptionPane;
import Reinas8.NQueens;//importar paquete donde se guarda el programas de las Reinas
import javax.swing.UIManager;

/*

INTEGRANTES DEL GRUPO:

Jose Flores C.I: 31.197.661
Willian Coral C.I: 31.296.612
Carlos Andrade C.I:
José Garcia C.I: 

*/


public class Main_Menu {
    

    //el usuario es Admin con A mayuscula porque sino no funciona y la clave es 1234
    
    //suprimir alarma innecesaria
    @SuppressWarnings("null")
    public static void main(String[] args) {
        
        //Constantes
        final String user = "Admin", userpassword = "1234";
        
        // Establecer los valores predeterminados de los botones
        UIManager.put("OptionPane.okButtonText", "Aceptar");
        UIManager.put("OptionPane.cancelButtonText", "Salir");
        
        login(user, userpassword);
    
        String option = null;
        boolean confirm  = true;
        
        do {
            
           try{
                do{
                    option = (String) JOptionPane.showInputDialog(null,"\n1. Factorial de un numero "
                        + "\n2. Determinar los numeros primos y compuestos de los numeros ingesados "
                        + "\n3. Cajero Automatico \n4. Determinar los valores reales e imaginarios de una ecuacion de segundo grado "
                        + "\n5. MCM y el MCD de 3 numeros\n6. Problema de las 8 reinas "
                        + "\n\n Introduzca la operacion que desea realizar"," MENU",JOptionPane.PLAIN_MESSAGE,null,null,null);
                                                               //PLAIN_MESSAGE es para que en vez de Entrada arriba diga MENU
                    if(option==null)throw new NullPointerException();
                
                    if(esNumero(option)){
                        confirm = true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Opcion Invalida");
                        confirm = false;
                    }
                }while(confirm != true);
            }
            catch(NullPointerException e){
                
                int opc =JOptionPane.showConfirmDialog(null,"Esta seguro de salir del programa?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                
                if (opc==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
                else{
                    continue;
                }
            }
            
            int numero=Integer.parseInt(option);
            
            //los try y catch con NullPointerException son por si el usuario pulsa cancelar dentro del respectivo programa
            switch(numero){
                 
                //FACTORIAL
                case 1:
                   
                    try{
                            
                        do{
                        
                            Factorial2 fac = new Factorial2();
                    
                            fac.setNum();
                            fac.showFact();  
                        }while(0 == JOptionPane.showConfirmDialog(null, "¿Desea calcular nuevamente el factorial?", "Factorial", JOptionPane.YES_NO_OPTION));
                            
                    }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, "No se ha calculado el factorial debido a que el objeto es nulo.");
                    }
                
                    break;
                     
                //NUMEROS PRIMOS    
                case 2:
                    
                    try{
                        
                        do{
                        
                            Primos2 pri = new Primos2();
                        
                            pri.setNum();
                            pri.showN();
                            
                        }while(0 == JOptionPane.showConfirmDialog(null, "¿Desea volver nuevamente a determinar numeros?", "Primos o Compuestos", JOptionPane.YES_NO_OPTION));
                        
                    }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, "No se ha determinado el numero debido a que el objeto es nulo.");
                    }

                    break;
                 
                //CAJERO
                case 3:
                       
                    try{
                        
                        do{
                            
                            Cajero2 caj = new Cajero2();    
                            caj.setMoney(); 
                            caj.showBill(); 
                            
                        }while(0 == JOptionPane.showConfirmDialog(null, "¿Desea volver a intentar con otra cantidad?", "Cajero", JOptionPane.YES_NO_OPTION));
                        
                    }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, " No se ha desglosado el numero debido a que el objeto es nulo.");
                    }
                        
                    break;
                 
                //ECUACION 2DO GRADO
                case 4:
                    
                    try{
                        
                        do{
                            
                            QuadraticEc2 ec = new QuadraticEc2();
                            ec.setVar();
                            ec.showResult(); 
                            
                        }while(0 == JOptionPane.showConfirmDialog(null, "¿Desea volver a calcular otra ecuacion?", "Ecuacion Segundo Grado", JOptionPane.YES_NO_OPTION));
                        
                    }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, "No se pudo calcular la ecuacion debido a que el objeto es nulo.");
                    }
                    
                    break;

                //MCM Y MCD
                case 5:
                    
                    try{
                        
                        do{
                            McmandMcd2 mc = new McmandMcd2();
                            mc.setNums(); 
                            mc.showMcd(); 
                            mc.showMcm();
                            
                        }while(0 == JOptionPane.showConfirmDialog(null, "¿Desea volver a calcular el MCM Y MCD de otros 3 numeros?", "MCM Y MCD", JOptionPane.YES_NO_OPTION));
                        
                    }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, "No se pudo calcular el MCM ni el MCD debido a que el objeto es nulo.");
                    }

                    break;
                 
                //8 REINAS
                case 6:
                    
                    NQueens resolve = new NQueens();//inicializamos el numero de reinas en el constructor
                    
                    try{
                        
                        resolve.setNqueens(8);//Numero de reinas fijo
        
                        resolve.process(0);//iniciamos en 0; esto significa que iniciamos en la fila 0
        
                        //mostrar resultado
                        resolve.show();
                        
                    }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, "No se ha resuelto el problema debido a que el objeto es nulo.");
                    }
                    
                     
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null,"Opcion Invalida");  
            }
        }while(option != null);
    }   

    //funcion para validar sesions
    //es mas rapido hacer aca que en una clase completa solo para esto
    public static void login(String user, String userpassword) {
     
        int attempts = 0;
      
        do  {
            
            String nameUser = null;
            String password = null;
            
            try{
               
                nameUser =JOptionPane.showInputDialog(null,"Ingrese su nombre de usuario");
                if(nameUser==null)throw new NullPointerException();
          
                password = JOptionPane.showInputDialog(null,"Ingrese su clave");
                if(password==null)throw new NullPointerException();
             
            }catch(NullPointerException e){
                
                int opc =JOptionPane.showConfirmDialog(null,"Esta seguro de salir del programa?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                
                if (opc==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
                
                else{
                    continue;
                }
                      
                }
            
            if(nameUser.equals(user) && password.equals(userpassword)) {
               
                JOptionPane.showMessageDialog(null,"Bienvenido al sistema, " + user);
                break;
                
            } else {
                
                attempts++;
                if(attempts < 3){
                    JOptionPane.showMessageDialog(null,"Nombre de usuario o clave incorrectos, intentelo de nuevo.");
                }
                
            }
            
            if (attempts == 3){
                
               JOptionPane.showMessageDialog(null,"Ha agotado sus numeros de intentos, el sistema se cerrara");
               System.exit(0);
            }
            
        }while (attempts < 3);
     
    }
    
    //validar que se ingrese un numero haciendo uso de las excepciones
    public static boolean esNumero(String str){
        
        boolean numeric = true;

        try{
            Double num =Double.parseDouble(str);
        }catch(NumberFormatException e){
            numeric = false;
        }       


        return numeric;

    }
    
}
  
        
        
    
    


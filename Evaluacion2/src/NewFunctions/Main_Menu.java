package NewFunctions;
import javax.swing.JOptionPane;
import Reinas8.NQueens;
//import static NewFunctions.ayuda.esNumero;

/*

INTEGRANTES DEL GRUPO:

Jose Flores C.I: 31.197.661
Willian Coral C.I: 31.296.612
Carlos Andrade C.I:
José Garcia C.I: 

*/


public class Main_Menu {
    

    //el usuario es Admin con A mayuscula porque sino no funciona y la clave es 1234
    public static void main(String[] args) {
        
        //Constantes
        final String user = "Admin", userpassword = "1234";

        login(user, userpassword);
    
        String option = null;
        boolean sigue = true;
        
        do {
            
           try{
                do{
                    option = (String) JOptionPane.showInputDialog(null,"\n1. Sacar el factorial de un numero "
                        + "\n2. Determinar los numeros primos y compuestos de los numeros ingesados "
                        + "\n3. Cajero Automatico \n4. Determinar los valores reales e imaginarios de una ecuacion de segundo grado "
                        + "\n5. Sacar el MCM y el MCD de 3 numeros\n6. Programa de las 8 reinas "
                        + "\n7. Salir." + "\n\n Introduzca la operacion que desea realizar"," MENU",JOptionPane.PLAIN_MESSAGE);
                                                               //PLAIN_MESSAGE es para que en vez de Entrada arriba diga MENU
                    if(option==null)throw new NullPointerException();
                
                    if(esNumero(option)){
                        sigue=true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Ha ingresado un caracter");
                        sigue=false;
                    }
                }while(sigue!=true);
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
                    Factorial2 fac = new Factorial2();
                    
                    try{
                        
                        fac.setNum();
                        fac.showFact();  
                        
                    }catch(NullPointerException e){
                        continue;
                    }
                                    
                break;
                     
                //NUMEROS PRIMOS    
                case 2:
                    Primos2 pri = new Primos2();
                    
                    try{
                        
                        pri.setNum();
                        pri.showN();
                        
                    }catch(NullPointerException e){
                        continue;
                    }
                break;
                 
                //CAJERO
                case 3:
                    Cajero2 caj = new Cajero2();
                    
                    try{
                        
                    caj.setMoney(); 
                    caj.showBill(); 
                    
                    }catch(NullPointerException e){
                        continue;
                    }
                break;
                 
                 //ECUACION 2DO GRADO
                case 4:
                    QuadraticEc2 ec = new QuadraticEc2();
                    
                    try{
                        
                        ec.setVar();
                        ec.showResult(); 
                        
                    }catch(NullPointerException e){
                        continue;
                    }
        
                    
                break;
                 
                 
                //MCM Y MCD
                case 5:
                    McmandMcd2 mc = new McmandMcd2();
                    
                    try{
                        
                    mc.setNums(); 
                    mc.showMcd(); 
                    mc.showMcm(); 
                    
                    }catch(NullPointerException e){
                        continue;
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
                        continue;
                    }
                    
                     
                    break;
                 
                //SALIR
                case 7: 
                    int opc =JOptionPane.showConfirmDialog(null,"Esta seguro de salir del programa?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                
                    if (opc==JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                    else{
                        option = "0";
                    }
                break;
                 
                default:
                    JOptionPane.showMessageDialog(null,"opcion Invalida");  
            }
        }while(!"7".equals(option));
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
  
        
        
    
    


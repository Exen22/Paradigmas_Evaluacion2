
package NewFunctions;
import javax.swing.JOptionPane;
import Reinas8.NQueens;
//import static NewFunctions.ayuda.esNumero;

public class Logineval2 {
    

    //el usuario es Gato con G mayuscula porque sino no funciona y la clave es felino
    public static void main(String[] args) {
        
        //Constantes
        final String user = "Admin", userpassword = "1234";

        login(user, userpassword);
       
    
        String option = "";
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
                    if(option==null)throw new Exception();
                
                    if(esNumero(option)){
                        sigue=true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Ha ingresado un caracter");
                        sigue=false;
                    }
                }while(sigue!=true);
            }
            catch(Exception e){
                
                int opc =JOptionPane.showConfirmDialog(null,"Esta seguro de salir del programa?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                
                    if (opc==JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                    else{
                        continue;
                    }
            }
            
            int numero=Integer.parseInt(option);
            
            switch(numero){
                 
                //FACTORIAL
                case 1:
                    Factorial2 fac = new Factorial2();
                    fac.setNum();
                    //fac.setNum(6);
                    fac.showFact();                  
                break;
                     
                //NUMEROS PRIMOS    
                case 2:
                    Primos2 pri = new Primos2();
                    pri.setNum();
                    //pri.setNum(1); //para ingresar directamente si se quiere hacer la interfaz desde el menú
                    //pri.getPrimos(); pri.getComp(); //Para obtener el numero de primos y compuestos ingresados si se quiere hacer la interfaz desde el menu
                    pri.showN();
                break;
                 
                //CAJERO
                case 3:
                    Cajero2 caj = new Cajero2();
        
                    caj.setMoney(); //ingresar cantidad de dinero y desglosar
                    caj.showBill(); // mostrar la cantidad de billetes y monedas de cada tipo
                break;
                 
                 //ECUACION 2DO GRADO
                case 4:
                    QuadraticEc2 ec = new QuadraticEc2();
        
                    ec.setVar();//pide los valores y los procesa
                    ec.showResult();//muestra los resultado
                break;
                 
                 
                //MCM Y MCD
                case 5:
                    McmandMcd2 mc = new McmandMcd2();
                    mc.setNums(); //establecer los 3 numeros a sacar su MCM Y MCD
                    mc.showMcd(); //mostrar desde JOptionPane el MCD de los numeros ingresados
                    mc.showMcm(); //mostrar desde JOptionPane el MCM de los numeros ingresados
                    /*JOptionPane.showMessageDialog(null, "mcm: "+mc.mcm()); /*Mostrar el mcm de los numeros ingresados directamente con 
                    la funcion mcm() y mcd para el MCD respectivamente*/
                break;
                 
                //8 REINAS
                case 6:
                    
                    NQueens resolve = new NQueens();//inicializamos el numero de reinas en el constructor
                    resolve.setNqueens(8);//Numero de reinas fijo
        
                    resolve.process(0);//iniciamos en 0; esto significa que iniciamos en la fila 0
        
                    //mostrar resultado
                    resolve.show();
                     
                    break;
                 
                //SALIR
                case 7: 
                    System.exit(0);
                break;
                 
                default:
                    JOptionPane.showMessageDialog(null,"opcion Invalida");  
            }
        }while(!"8".equals(option));
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
                if(nameUser==null)throw new Exception();
          
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
            
            if(nameUser.equals(user) && password.equals(userpassword)) {
               
                JOptionPane.showMessageDialog(null,"Bienvenido al sistema, " + user);
                break;
                
            } else {
                
                attempts++;
                JOptionPane.showMessageDialog(null,"Nombre de usuario o clave incorrectos, intentelo de nuevo.");
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
  
        
        
    
    


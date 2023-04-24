
package NewFunctions;
import javax.swing.JOptionPane;
import static NewFunctions.ayuda.esNumero;
import static NewFunctions.login.login;
public class Logineval2 {

   //el usuario es Gato con G mayuscula porque sino no funciona y la clave es felino
    public static void main(String[] args) {
        
        String user="Gato", clave="felino";
       
        
           
        
        login(user, clave);
       
    
        String opcion = "";
        boolean sigue = true;
        do {
            
           try{
                do{
                    opcion = JOptionPane.showInputDialog(null,"\nMenu:  \n1. Sacar el factorial de un numero "
                        + "\n2. Determinar los numeros primos y compuestos de los numeros ingesados "
                        + "\n3. Cajero Automatico \n4. Determinar los valores reales e imaginarios de una ecuacion de segundo grado "
                        + "\n5. Sacar el MCM y el MCD de 3 numeros\n6. Programa de las 8 reinas "
                        + "\n7. Salir. \nIntroduzca la operacion que desea realizar");
            
                    if(opcion==null)throw new Exception();
                
                    if(esNumero(opcion)){
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
            
            int numero=Integer.parseInt(opcion);
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
                 
                     
                break;
                 
                //SALIR
                case 7: 
                    System.exit(0);
                break;
                 
                default:
                    JOptionPane.showMessageDialog(null,"Opcion Invalida");  
            }
        }while(opcion !="8");
    }   



}
  
        
        
    
    


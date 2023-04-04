/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionsPkg;

import java.util.Scanner;


public class Menu1{
    
    public static boolean login(String user, String password)
    {   
        if (user.equals("Admin") && password.equals("1234"))
            return true;
        else{
            System.out.println("\n Usuario o Contraseña incorrecto \n");
            return false;
        }
    }
    public static void clear(int n){
        for (int i = 0; i < n; i++)
            System.out.println();
    }
    
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        ValidF _validF = new ValidF();//objeto de la clase para validar flotantes
        MenuPila menupila = new MenuPila();//objeto para entrar al menu de pila
        String user,password;
        int attempts = 0,option;
        boolean band;
       
        do{
           System.out.print("\n\n\t\t Inicio Sesion");
           System.out.print("\t\n Usuario: ");
           user = keyboard.nextLine();
           System.out.print("\t\n Contraseña: ");
           password = keyboard.nextLine();
           
           attempts++;
           //Tengo que decirle al usuario en que se equivoco
           if(attempts == 3 && !login(user,password))
           {
               clear(20);
               System.out.print("Ha superado el limite de intentos de inicio de sesion. Reinicie el programa para volver a intentar\n\n");
               System.exit(0);
           }

        }while(attempts != 3 && !login(user,password));
        
        do{
            clear(30);
            band = false;
            
            System.out.print("\n\t\t Menu \n\n");
            System.out.print("\n\t 1. Factorial de un numero");
            System.out.print("\n\t 2. MCM y MCD de 3 nuemros");
            System.out.print("\n\t 3. Primos y Compuestos");
            System.out.print("\n\t 4. Ecuacion de 2do grado");
            System.out.print("\n\t 5. Desglosar monto en billetes");
            System.out.print("\n\t 6. Menu Pilas");
            System.out.print("\n\t Otro. Salir del programa");
            System.out.print("\n\n Ingrese el numero correspondiente a la opcion: ");
            option = (int) _validF.validate();

            
            switch(option)
                {
                    case 1:
                    
                        long num;
                        clear(10);
                        System.out.print("\n\n\t Factorial de un numero \n\n");
                        do{
                        
                            System.out.print("\n\n Ingrese un numero: ");
                            num = (int) _validF.validate();
                        
                            if (num < 0)
                                System.out.println("\n Es imposible calcular el factorial de un numero negativo. Intente de nuevo");
                        
                        }while(num < 0);
                    
                    Factorial F = new Factorial(num);
                    F.process();
                    System.out.print("\n\n Factorial de "+ num + ": "+ F.show() +"\n\n");
                   
                    break;
               
                    case 2:
                        
                        clear(10);
                        int []numbers = new int[3];
               
               
                        System.out.print("\n\n\n\n\t MCM y MCD de 3 numueros\n\n");
                        System.out.print("\n\n Ingrese los numeros \n\n");
               
                        for (int i = 0; i < 3; i++)
                        {
                            System.out.print("\n Numero " + (i+1) + ": ");
                            numbers[i] = (int) _validF.validate();
                            //numbersAux[i] = numbers[i];
                        }
                    
                        McmandMcd mcmAndmcd = new McmandMcd(numbers);
                    
                        System.out.print("\n\n El M.C.M es: " + mcmAndmcd.mcm() );
                        System.out.print("\n El M.C.D es: " + mcmAndmcd.mcd());
                    
                        break;
                    
                    case 3:
                        
                        clear(10);
                        System.out.println("\n\n Numeros Primos y Compuestos \n\n");
                        Primos _primo = new Primos(2);//se le asigna 2 solo para inicializar 
                        _primo.process();
                        break;
                    
                    case 4:
                        
                        clear(10);
                        double a,b,c;
                        System.out.println("\n\n Ecuacion cuadratica \n");
                        
                        do
                        {
                             System.out.print("\n Ingrese el valor de a: ");
                            a = _validF.validate();
                            if (a == 0)
                                System.out.println("\n a no puede ser 0\n\n");
                        }while(a == 0);
                        
                        do
                        { 
                            System.out.print("\n Ingrese el valor de b: ");
                            b = _validF.validate();
                            if (b == 0)
                                System.out.println("\n b no puede ser 0\n\n");
                        }while(b == 0);
                        
                        
                        System.out.print("\n Ingrese el valor de c: ");
                        c = _validF.validate();
                        
                        QuadraticEc ecuation = new QuadraticEc(a,b,c);
                        ecuation.process();
                        break;
                        
                    case 5:
                        
                        clear(10);
                        System.out.println("\n\t Desglosar monto en billetes\n\n");
                        System.out.print("\n Ingrese el monto: ");
                        option = (int) _validF.validate();
                        Cajero convert = new Cajero(option);
                        convert.desgloseMonto();
                        convert.show();
                        break;
                    case 6:
                        clear(20);
                        menupila.mainPila();
                        break;
                    default:
                        band = true;
                        clear(5);
                        System.out.println("\t Seguro que quiere salir? ");
                        System.out.print("\n\t 0. Cancelar");
                        System.out.print("\n\t Otro. Confirmar: ");
                         System.out.print("\n\n\t Ingrese: ");
                        option = (int) _validF.validate();
                }
            
            
            if (!band)
            {
                System.out.println("\n\n Pulse una tecla para continuar: ");
                keyboard.nextLine();
                clear(4);
                System.out.println("\t Desea salir?");
                System.out.print("\n\t 0. Volver al Menu");
                System.out.print("\n\t Otro. Salir");
                System.out.print("\n\n\t Ingrese: ");
                option = (int) _validF.validate();
            }
            
        }while(option == 0);    
    }
    
}

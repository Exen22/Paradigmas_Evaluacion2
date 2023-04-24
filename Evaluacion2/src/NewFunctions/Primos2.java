package NewFunctions;

import javax.swing.JOptionPane;

/**
 *
 * @author Willian Coral
 */
public class Primos2 {
    private int number;
    private int n_primos;
    private int n_compuestos;
    
    public Primos2(){
        this.n_primos = 0;
        this.n_compuestos = 0;
        this.number = 0;
    }
    
    //para ingresar numeros desde el main
    public void setNum(int n){
        this.number = n;
        process();
    }
    
    //metodo para ingresar numeros 
    public void setNum(){
        
        try{
            int nAux = 1;
            int count = 1;
            while(nAux != 0){
                nAux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero "
                        + "o Ingrese '0' para mostrar la cantidad de numeros primos ingresados\n["+count+"]: "));
                count++;
                if(nAux!= 0){
                    this.number = nAux;
                    process();
                }
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ha ingresado un valor invalido");
        }
        catch(NullPointerException e){
            //JOptionPane.showMessageDialog(null, "");
        }
        
    }
    
    private void process(){
        int cont = 0;
        
        //validar si es primo o no (si cont es mayor a 2 entonces no es primo)
        for(int i=1; i<=number; i++){
            if(number%i==0){
                cont++;
            }
        }
        
        //si es primo aumenta n_primos
        if(cont==2 || cont == 1){
            n_primos++;
        }
        //si no es primo aumenta n_compuestos
        else if(cont > 2){
            n_compuestos++;
        }
    }
    
    public void showN(){
        JOptionPane.showMessageDialog(null, "La cantidad de numeros primos ingresados es: "+ getPrimos() 
                + "\nLa cantidad de numeros compuestos ingresados es: "+ getComp());
    }
    
    public int getPrimos(){
        return n_primos;
    }
    
    public int getComp(){
        return n_compuestos;
    }
    
    
}

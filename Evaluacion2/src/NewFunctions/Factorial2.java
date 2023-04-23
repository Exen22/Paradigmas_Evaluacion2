package NewFunctions;

import javax.swing.JOptionPane;

/**
 *
 * @author Willian Coral
 */
public class Factorial2 {
    private long num, aux, fact;
    
    public Factorial2(){
        this.aux = 1;
    }
    
    //ingresar el numero
    public void setNum(){
        try{
            long num1;
            do{
                num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero a sacar su factorial: "));
                if(num1 < 0){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor positivo");
                }
            }while(num1 < 0);
            
            num = num1;
            aux = 1;
            
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Valor invalido");
        }
        
    }
    
    //Ingreso manual
    public void setNum(long num){
        this.aux = 1;
        this.num = num;
        
    }
    
    //sacar factorial con recursividad
    private long process(long n){
        aux = n;
        if(n==0){
            return 1;
        }
        else{
            aux *= process(n-1);
        }
        return aux;
    }
    
    //mostrar el factorial
    public void showFact(){
        fact = process(this.num);
        JOptionPane.showMessageDialog(null, "El factorial de: "+num +" es: "+getFact());
    }
    
    //obtener el factorial
    public long getFact(){
        fact = process(this.num);
        return this.fact;
    }
}

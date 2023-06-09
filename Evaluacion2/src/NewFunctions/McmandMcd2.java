package NewFunctions;

import javax.swing.JOptionPane;

public class McmandMcd2 {
    
    private final int[]numbers;
    private final int[]numbersAux;
    private int mcdF, mcmF;
    
    public McmandMcd2()
    {
        this.numbers = new int[3];
        this.numbersAux = new int[3];
        this.mcdF = 0;
        this.mcmF = 0;
        
    }
    
    public void setNums(){
        String aux1 = null;
        
        do{
            try{
                int[] auxNumbers = new int[3];

                for(int i=0; i<3; i++){
                    /*auxNumbers[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "MCM y MCD de 3 numueros\nIngrese los numeros"
                           + "\n\n Numero " + (i+1) + ": "));*/
                    aux1 = JOptionPane.showInputDialog(null, "MCM y MCD de 3 numueros\nIngrese los numeros"
                           + "\n\n Numero " + (i+1) + ": ");
                    
                    if(aux1 == null){
                        throw new NullPointerException();
                    }
                    
                    auxNumbers[i] = Integer.parseInt(aux1);
                }


                for (int i = 0; i < auxNumbers.length; i++)
                {
                    numbers[i] = auxNumbers[i];
                    numbersAux[i] = auxNumbers[i];
                }
            }
            
            //CATCHS
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Valor Invalido");
                aux1 = null;
            }
            catch(NullPointerException e){
                int opc =JOptionPane.showConfirmDialog(null,"Esta seguro que quiere volver al Menu?", "Confirmacion", JOptionPane.YES_NO_OPTION);

                if (opc==JOptionPane.YES_OPTION){
                    throw new NullPointerException();
                }
                else{
                    continue;  
                }
            }
        }while(aux1 == null);
    }
    
    public int mcm(){
        int product,mcm = 0, residue;
        try{
        
        
        for (int i = 0; i < 3; i++)
        {
            //Determinamos el primer termino como el mcm de el mismo
            if (i == 0){
                mcm = numbers[i];
                //product = numbers[i];
            
            //para los siguientes calculamos el mcm del mcm anterior con el numero actual sucesivamente
            } else {
                product = mcm * numbers[i];
                
                do{
                    residue = mcm%numbers[i];
                    mcm = numbers[i];
                    numbers[i] = residue;
                }while(residue != 0);
                
                mcm = product / mcm;
            }
            
        }
        
        
        
        }
        catch(ArithmeticException e){
            
        }
        this.mcmF = mcm;
        return mcm;
    }
    
    public int mcd()
    {
        int mcd = 0;
        int residue;
        
        for (int i = 0; i < 3; i++)
        {
            //Determinamos el primer termino como el mcd de el mismo
            if (i == 0)
            {
                mcd = numbersAux[i];
            }
            else
            {
                do
                {
                    residue = mcd % numbersAux[i];
                    mcd = numbersAux[i];
                    numbersAux[i] = residue;
                } while (residue != 0);
            }
        }
        
        return mcd;
    }
    
    public void showMcd(){
        try{
        mcdF = mcd();
        JOptionPane.showMessageDialog(null, "El Maximo Comun divisor de los numeros ingresados es: "+mcdF);
        }
        catch(ArithmeticException e){
            JOptionPane.showMessageDialog(null, "Error: Los numeros ingresados no son validos para calcular el MCD.");
        }
    }
    
    public void showMcm(){
        try{
        mcm();
        JOptionPane.showMessageDialog(null, "El Minimo Comun multiplo de los numeros ingresados es: "+mcmF);
        }
        catch(ArithmeticException e){
            JOptionPane.showMessageDialog(null, "Error: Los numeros ingresados no son validos para calcular el MCM.");
        }
    }
    
}

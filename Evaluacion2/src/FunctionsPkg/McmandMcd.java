package FunctionsPkg;

public class McmandMcd {
    
    private final int[]numbers;
    private final int[]numbersAux;
    
    public McmandMcd(int[] _numbers)
    {
        this.numbers = new int[3];
        this.numbersAux = new int[3];
        
        for (int i = 0; i < _numbers.length; i++)
        {
            numbers[i] = _numbers[i];
            numbersAux[i] = _numbers[i];
        }
    }
    
    public int mcm()
    {
        int product,mcm = 0, residue;
        
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
}

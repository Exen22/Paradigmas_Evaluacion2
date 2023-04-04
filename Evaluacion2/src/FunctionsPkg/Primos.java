package FunctionsPkg;

public class Primos {
    
    private int number;
    private int n_primos = 0;
    private int n_compuestos = 0;
    ValidF _int = new ValidF();
    
    public Primos(int number)
    {
        this.number = number;
       
    }
    
    public void process()
    {
        
        int cont = 0;
        
        while(number != 0)
        {
            //validacion 
            System.out.print("\n Ingrese un numero o 0 para salir: ");
            number = (int) _int.validate();
            
            for(int i=1; i<=number; i++){
                if(number%i==0){
                    cont++;
                }
            }
            
            //contador
            if(cont==2 || cont == 1){
                n_primos++;
                System.out.println(" Es primo");
            }
            else if(cont > 2){
                n_compuestos++;
                System.out.println(" Es compuesto");
            }
            cont = 0;
            
        }
        
        System.out.print("\n Numeros de Primos ingresados: "+n_primos);
        System.out.println("\n Numeros de Compuestos ingresados: "+n_compuestos);
        
    }
}

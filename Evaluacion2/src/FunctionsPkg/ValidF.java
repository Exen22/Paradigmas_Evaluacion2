package FunctionsPkg;

import java.util.Scanner;

public class ValidF<T> {
    
    //compara que solo haya numeros
    private boolean hasAcharF(String number){
        
	int i = 0,cont = 0,contN = 0;
        
        if (number.isEmpty())
            return true;
        
	while(i < number.length()){
            
            //valida la primera posicion para saber si es negativo
            if (number.charAt(0) == '-' && contN < 1){
                i++; contN++;
            }
                        
                    
            //valida la separacion de la parte entera de la decimal
            //si hay mas de un punto ( . ) no saltara un espacio y retornara verdadero
            if (number.charAt(i) == '.' && cont != 1){
                i++; cont++;
            }
                    
            //comparamos que sean numeros haciendo uso del codigo ascii
            if((number.charAt(i) < '0' || number.charAt(i) > '9') )
                return true;
			
		i++;
	}

	return false;
}
        
        public double validate()
	{
		Scanner keyboard = new Scanner(System.in);
		String numberS;
		double num;

		numberS = keyboard.nextLine();

		do{
			if(hasAcharF(numberS))
			{
				System.out.print("\n\n Caracter ingresado invalido. Intente de nuevo ");
				System.out.print("\n\n Numero: ");
				numberS = keyboard.nextLine();
			}
		}while(hasAcharF(numberS));

		num = Double.parseDouble(numberS);// <--- convertir la cadena a double

		return num;
	}
}

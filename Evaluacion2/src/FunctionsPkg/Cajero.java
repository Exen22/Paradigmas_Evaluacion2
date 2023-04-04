package FunctionsPkg;

public class Cajero {

    private final int dinero;
    private int max, cont = 0, total = 0;
    private final int[] billetes= {100,50,20,10,5,2,1};
    private int b100 = 0, b50 = 0, b20 = 0, b10 = 0, b5 = 0, b2 = 0, b1 = 0;
    
    public Cajero(int _dinero){//Constructor
        this.dinero = _dinero;
    }
    
    public void desgloseMonto(){//setter
        
        int din = dinero;
        
        //Bucle de randomizado
        for(int i=0; i<billetes.length; i++){
            
            
            while(din >= billetes[i]){
                cont=0;
               
                //comprobar cuantos billetes faltan para llegar al de 1 dolar
                for(int j=i; billetes[j]!=1; j++){
                    cont++; //6
                }
                //max del numero random
                max = cont;
               
                int pos = (int)(Math.random()*(max+1));
                int rest = billetes[i+pos];
                
                
                //Contador de cada billete
                switch(rest){
                    case 100: din -= 100;
                    total+=100;
                    b100++;
                    break;
                    case 50: din-= 50;
                    total+=50;
                    b50++;
                    break;
                    case 20: din -= 20;
                    total+=20;
                    b20++;
                    break;
                    case 10: din -= 10;
                    total+=10;
                    b10++;
                    break;
                    case 5: din -= 5;
                    total+=5;
                    b5++;
                    break;
                    case 2: din -= 2;
                    total+=2;
                    b2++;
                    break;
                    case 1: din -= 1;
                    total+=1;
                    b1++;
                    break;
                }
                
            } 
        }
        
    }
    
    public void show(){//getter
        System.out.println("\n El desglose del monto '"+dinero+"' Es: \n");
        System.out.println("Billetes de 100: "+b100+"\nBilletes de 50: "+b50+"\nBilletes de 20: "+b20+
        "\nBilletes de 10: "+b10+"\nBilletes de 5: "+b5+"\nBilletes de 2: "+b2+"\nBilletes de 1: "+b1);
        System.out.println("\nTOTAL: "+total);
    }
    
}

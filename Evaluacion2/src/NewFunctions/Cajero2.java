package NewFunctions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;

public class Cajero2 {
    private double money, total;
    private int b100 = 0, b50 = 0, b20 = 0, b10 = 0, b5 = 0, b2 = 0, b1 = 0, m25 = 0, m5=0, m1 = 0, cent;
    
    public Cajero2 (){
        this.money = 0;
        this.total = 0;
    }
    
    public void setMoney(){
        String aux1 = null;
        
        do{
            try{
                String nMoney2 = JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero a desglosar: ");
                
                aux1 = nMoney2;
                //CANCELAR
                if(aux1 == null){
                    throw new NullPointerException();
                }
                
                //DEJARLO CON SOLO 2 DECEMALES Y PASARLO A DOUBLE
                int dotIndex = nMoney2.indexOf('.');
                if (dotIndex != -1 && dotIndex + 3 < nMoney2.length()) {
                nMoney2 = nMoney2.substring(0, dotIndex + 3);
                }
                double nMoney = Double.parseDouble(nMoney2);

                this.money = nMoney;


                //Sacar la parte decimal y guardarla en cent (lo pasé a float porque en double no me da el valor exacto de las 2 primeras decimales)
                int aux = (int) money;
                float cent2 =(float) ((money - aux));
                cent = (int) (cent2 * 100);
                //cent = (int)((money - Math.floor(money))*100);//parte decimal del dinero (los centavos) (FUNCION NO SACA EXACTOS LOS DECIMALES DE UN DOUBLE)
                /*int aux = (int) money;
                cent =(int) ((money - aux)*100);*/ //la misma parte decimal pero sin la funcion

                b100 = 0; b50 = 0; b20 = 0; b10 = 0; b5 = 0; b2 = 0; b1 = 0; m25 = 0; m5=0; m1 = 0; total = 0;
                decompose();

            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Valor invalido");
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
    
    public double getMoney(){
        return this.money;
    }
    
    private void decompose(){
        int[] bill = {100, 50, 20, 10, 2, 1};
        int[] cents = {25, 5, 1};
        
        
        
        double auxMoney = money;
        int cont = 0, max = 0;
        
        //billetes
        for(int i = 0; i < bill.length; i++){
            while((int)money >= bill[i]){
                cont = 0;
                
                //comprobar cuantos billetes faltan para llegar al de 1 dolar
               for(int j=i; bill[j]!=1; j++){
                   cont++; 
               }
               //max del numero random
               max = cont;
               
               int pos = (int)(Math.random()*(max+1));
               int rest =bill[i+pos];
               
               
               switch(rest){
                   case 100: money -= 100;
                   total+=100;
                   b100++;
                   break;
                   case 50: money-= 50;
                   total+=50;
                   b50++;
                   break;
                   case 20: money -= 20;
                   total+=20;
                   b20++;
                   break;
                   case 10: money -= 10;
                   total+=10;
                   b10++;
                   break;
                   case 5: money -= 5;
                   total+=5;
                   b5++;
                   break;
                   case 2: money -= 2;
                   total+=2;
                   b2++;
                   break;
                   case 1: money -= 1;
                   total+=1;
                   b1++;
                   break;
               }
            }
        }
        money = auxMoney;
        
        //monedas
        for(int i = 0; i < cents.length; i++){
            while(cent >= cents[i]){
                cont = 0;
                
                //comprobar cuantas monedas faltan para la de 1 centavo
               for(int j=i; cents[j]!=1; j++){
                   cont++; 
               }
               //max del numero random
               max = cont;
               
               int pos = (int)(Math.random()*(max+1));
               int rest =cents[i+pos];
               
               switch(rest){
                   
                   case 25:
                       cent -=25;
                       total += (25*0.01);
                       m25++;
                       break;
                   case 5:
                       cent -=5;
                       total += (5*0.01);
                       m5++;
                       break;
                   case 1:
                       cent -=1;
                       total += (1*0.01);
                       m1++;
                       break;
               }
            }
        }
        //redondea
        BigDecimal decimal = BigDecimal.valueOf(total);
        decimal = decimal.setScale(2, RoundingMode.HALF_UP);
        total = decimal.doubleValue();
    }
    
    public void showBill(){
        if(money > 0){
        JOptionPane.showMessageDialog(null, "Dinero a desglosar: "+ money +"\n\nCantidad de billetes:\n 100: "+b100+"\n 50: "+b50+"\n 20: "
                +b20+"\n 10: "+b10+"\n 5: "+b5+"\n 2: "+b2+"\n 1: "+b1+"\n\n Cantidad de monedas:\n M25: "
                +m25+"\n M5: "+m5+"\n M1: "+m1+"\n\nTotal: "+total);
        }
        else{
            JOptionPane.showMessageDialog(null, "No se ha ingresado ningun valor a desglosar");
        }
    }
}

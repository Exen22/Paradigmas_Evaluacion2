package NewFunctions;

import javax.swing.JOptionPane;

public class QuadraticEc2 {
            
    private double a, b, c, root;
    private double x1, x2;
    private boolean real, flag; //real para verificar si da valores reales  ///// flag para verificar si se han ingresado datos validos
    
    public QuadraticEc2(){
        this.a = 0;
        this.b = 0;
        this.c = 0;
        x1 = 0;
        x2 = 0;
        flag = false;
    }
    
    //set de variables y llamada a metodo proceso
    public void setVar(){
        String aux1 = "";
        
        do{
            try{
                a = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de 'a'."));
                b = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de 'b'."));
                c = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de 'c'."));
                
                String a2, b2, c2;
                a2 = Double.toString(a);
                b2 = Double.toString(b);
                c2 = Double.toString(c);
                
                if(a2 == null || b2 == null || c2 == null){
                    throw new NullPointerException();
                }
                

                //lo que está dentro de la raiz cuadrada de la ecuación
                root = b*b - 4*a*c;

                //llamo a la funcion process para sacar los resultados y guardarlos 
                process();
                flag = true;
                aux1 = "";
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Valor invalido");
                aux1 = null;
            }
            catch(NullPointerException e){
                int opc =JOptionPane.showConfirmDialog(null,"Esta seguro que quiere volver al Menu?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                flag = false;

                if (opc==JOptionPane.YES_OPTION){
                    throw new NullPointerException();
                }
                
            }
            
        }while(aux1 == null);
    }
    
    //Proceso
    private void process(){
        
        //si root es mayor a 0 entonces da un resultado real
        if(root>=0){
            //x1 resultado 1     ////    x2 = resultado 2
            x1 = (-b + Math.sqrt(root)) /(2*a);
            x2 = (-b - Math.sqrt(root)) /(2*a);
            real = true;
        }
        else{
            //x1 = parte real    ////    x2 = parte imaginaria
            x1 = -b / (2*a);
            x2 = Math.sqrt(-root) / ( 2 * a);
            real = false;
        }
        
    }
    
    //mostrar con JOptionPane los resultados
    public void showResult(){
        
        if(flag == false){
            JOptionPane.showMessageDialog(null, "NO SE HAN INGRESADO LOS DATOS DE LA ECUACIÓN.");
        }
        else if(real == true){
            JOptionPane.showMessageDialog(null, "No hay valores imaginarios en esta operacion y sus valores son:\n\n"
                    + "El valor de x1 es = " +x1+ "\nEl valor de x2 es = "+x2);
        }
        else if(real == false){
            JOptionPane.showMessageDialog(null, "Los numeros imaginarios de esta ecuacion son: " +x2+ "\nLos numeros reales "
                    + "de esta ecuacion son: "+x1);
        }
        
    }
    
    
    
}

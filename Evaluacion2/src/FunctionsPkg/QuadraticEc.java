package FunctionsPkg;




public class QuadraticEc {

    private double a,b,c;
    private double x1,x2;
    
    public QuadraticEc(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void process()
    {
        double discrimi = b*b-4*a*c;
    
        if(discrimi>=0){
            x1 = (-b+ Math.sqrt(discrimi))/(2*a);
            x2 = (-b-Math.sqrt(discrimi))/(2*a);
            System.out.print("\n No hay valores imaginarios en esta operacion y sus valores son: ");
            System.out.print("\n El valor de x1 es = " +x1 );
            System.out.print("\n El valor de x2 es = " +x2 );
        }
    
        else{
            double reales = -b / (2*a);
            double imagin= Math.sqrt(-discrimi) / ( 2 * a);
            System.out.print("\n Los numeros imaginarios de esta ecuacion son:"+imagin);
            System.out.print("\n Los numeros reales de esta ecuacion son:"+reales);
        }
    
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewFunctions;

/**
 *
 * @author JUAN
 */
public class ayuda {
    public static boolean esNumero(String str){
boolean numeric = true;

try{
Double num =Double.parseDouble(str);

}catch(NumberFormatException e){
numeric = false;
}


return numeric;



}
}

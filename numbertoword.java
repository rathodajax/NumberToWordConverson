/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Aj
 */
public class numbertoword {
    static String []unitPlace={"ONE ","TWO ","THREE ","FOUR ","FIVE ","SIX ","SEVEN ","EIGHT ","NINE ","TEN ","ELEVEN ","TWELVE ","THIRDTEEN ","FOURTEEN ","FIVETEEN ","SIXTEEN ","SEVENTEEN ","EIGHTTEEN ","NINETEEN "};
    static String []tenPlace={"TWENTY ","THIRTY ","FOURTY ","FIVETY ","SIXTY ","SEVENTY ","EIGHTY ","NINETY "};
    static String []morePlace={"HUNDRED ","THOUSAND ","LACK ","CRORE "};
   // static long number;
    static int digit,length;
    
    
    public static void main(String[] args) {
        System.out.println("Enter the number you want to convert into word [1 to 999999999].");
        long number=new Scanner(System.in).nextLong();
        numberSplit(number,0,0);
    }
    
     static void numberSplit(long number,int digit,int length){
        
        if (number > 0){
            if(length == 2)
                numberSplit(number/10,(int)number%10,length+1);
            else
                numberSplit(number/100,(int)number%100,length+2);      
        }
           
        wordPrint((int)digit, length);
    }
    static void wordPrint(int digit,int length){
        if(digit != 0){
            if(digit < 20)
                System.out.print(unitPlace[digit-1]);
            else{
                System.out.print(tenPlace[(digit/10)-2]);
                if(digit % 10 != 0)
                    System.out.print(unitPlace[(digit%10)-1]);
            }
            if(length > 2)
                System.out.print(morePlace[(length/2)-1]);
        }
    }
}

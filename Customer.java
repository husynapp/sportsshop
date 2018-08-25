
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
     private double customerMoney;
     
     public Customer(){
        
         customerMoney= 0;
         
        }
        
     public void setMoney (double moneyPaid){
        customerMoney = customerMoney- moneyPaid;
        }  
        
     public void refund (double moneyReceived){
        customerMoney += moneyReceived;
     }
         
     public double showMoney(){
        return this.customerMoney;
        }   
}





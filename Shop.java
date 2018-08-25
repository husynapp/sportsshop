
public class Shop
{
    private double balance;
    
    
    public Shop()
    {
        
       this.balance = 500.00;
            
    }
    

    public void addMoney(double custMoney){
        balance += custMoney;
    }
      public void refund(double custMoney){
        balance -= custMoney;
    }
  
    
    public double showShopBalance (){
        return balance;
    }
   
    public void resetBalance(){
        balance = 500.00;
    }
}

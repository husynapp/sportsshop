public class Basket
{
    private double cost;
    
    public Basket(){
    
            cost=0;
    
    }
    
    
    public void addToCost(double itemCost){
       cost += itemCost;
    
    }
    
    public void refund(double itemCost){
       cost -= itemCost;
    
    }
    
    
    public double totalCost(){
        return cost;
    }
}


public class Item
{
    private String itemID;
    private String itemName;
    private double itemPrice;
    private String itemDesc;  
    private int stock;
    public Item(){                        
    }
    public Item(String ID, String name, double price, String desc, int stock){
        this.itemID = ID;
        this.itemName = name;
        this.itemPrice = price;
        this.itemDesc = desc;  
        this.stock = stock;
    }
    
    public String getProductDetail(){
        // getName();
        // getPrice();
        // getDesc();
        // getStock();
        String x = "Item ID: " + getID() + "\nName: " + getName()+ "\nPrice: £"+ getPrice() + 
                    "\nDescrption: "+ getDesc()+ "\nRemaining stock: " + getStock();
        
        return x;
    }
    
    public String getID(){
        return this.itemID;
    }
    
    public String getName(){
        return this.itemName;
    }
    
    public double getPrice(){
        return this.itemPrice;
    }
    
    public String getDesc(){
        return this.itemDesc;
    }
    
    public int getStock(){
        return this.stock;
    }
    
    public void setName(String name){
        this.itemName = name;
    }
    
    public void setPrice(double price){
        this.itemPrice = price;
    }
    
    public void setDesc(String desc){
        this.itemDesc = desc;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
}

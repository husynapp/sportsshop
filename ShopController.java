import java.util.*;
public class ShopController

    {
        List<Item> searchResult;
        protected Item itemObject = new Item();
        //protected Item footballReset = new Item("FB100","World Cup Football", 149.99, "Original Telstar Football that was"+
                                   //" used in the 2018 FIFA World Cup", 5);
        protected Department departmentObject = new Department();
        protected Shop shopObject = new Shop();
        protected Basket basketObject = new Basket();
        protected Customer custObject = new Customer();
        protected int restockNumber;
    protected ShopController(){
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("================================================");
        System.out.println("================================================");
        System.out.println("==========Sportmaaaaaaaaaaaaaaaaart=============");
        System.out.println("================================================");
        System.out.println("====WELCOME TO SPORTMART, ONE STOP SPORT SHOP===");
        System.out.println("                 _...----.._                    ");
        System.out.println("             ,:':::::.      `>.                 ");
        System.out.println("            ,' |:::::;'      |:::.              ");
        System.out.println("           /    `'::'       :::::'\'            ");
        System.out.println("          /         _____     `::;'\'           ");
        System.out.println("         :         /:::::'\'      `  :          ");
        System.out.println("         | ,.     /::SMS::'\'        |          ");
        System.out.println("         |;:::.   `::::::;'          |          ");
        System.out.println("         ::::::     `::;'      ,.   ;           ");
        System.out.println("         '\':::'               ,:::/            ");
        System.out.println("          '\'                 '\':/             ");
        System.out.println("            `.     ,:.        :;'               ");
        System.out.println("              `-.::::::..  _.''                 ");
        System.out.println("                 ```----'''                     ");

        System.out.println("Please get started with requesting what items are available");
        System.out.println("for that you can say 'Open Shop', 'Show items' then select " +
                            "the item you required\n"+ 
                            "Available commands are: " + "\n exit, help, open store, show items, "+
                            "buy item, show basket total,restock, show customer balance, and restock football"+
                            "\n If you have ran out of money, you can top by writing 'top up £500'");
        System.out.println("\n\n\n\n Please state how much money you have: 500, 1000, or 1500?");
        
        Scanner local_in = new Scanner(System.in);
        Boolean local_isApplicationRunning = true;
        while(local_isApplicationRunning) {
            
            System.out.println("> ");
            String local_inputLine = local_in.nextLine();
                        
            if(local_inputLine.equalsIgnoreCase("exit")){
                System.out.println( this.exitText());
                local_isApplicationRunning = false;
            }else if(local_inputLine.equalsIgnoreCase("help")){
                System.out.println( this.helpText());
            }else if(local_inputLine.equalsIgnoreCase("Open store")){
                System.out.println( this.openStore());
            }else if(local_inputLine.equalsIgnoreCase("show items")){
                System.out.println( this.showItems());
            // }else if(local_inputLine.equalsIgnoreCase("buy something")){
                // System.out.println( this.sellItem());
            }else if(local_inputLine.equalsIgnoreCase(("buy item"))){
                System.out.println("Please select an Item ID from product list\n");
                //if(local_inputLine.equalsIgnoreCase("FB100")){
                   // String x = "FB100";
                    System.out.println(searchByID(local_in.nextLine()));
              
            //}else if (local_inputLine.equalsIgnoreCase("show stock")){
               // System.out.println( this.getResult());
            }else if(local_inputLine.equalsIgnoreCase("show basket total")){
                System.out.println( this.showBasketTotal());
            }else if (local_inputLine.equalsIgnoreCase("show customer balance")){
                System.out.println( this.showCustBalance());
            //}else if (local_inputLine.equalsIgnoreCase("restock football")){
               // System.out.println( this.reStock());
            }else if (local_inputLine.equalsIgnoreCase("shop balance")){
                System.out.println( this.shopBalance());
            }else if (local_inputLine.equalsIgnoreCase("refund")){
                System.out.println("Please select Item ID you want to return");
                    System.out.println(refund(local_in.nextLine()));
            }else if (local_inputLine.equalsIgnoreCase("restock")){
                System.out.println("Please select Item ID you want to re stock");
                    System.out.println(reStock(local_in.nextLine()));
              
            }else if(local_inputLine.equalsIgnoreCase("top up £500")){
                System.out.println( this.topUpCard());
            }else if(local_inputLine.equalsIgnoreCase("500")){
                System.out.println( this.topUp500());
            }
            else if(local_inputLine.equalsIgnoreCase("1000")){
                System.out.println( this.topUp1000());
            }else if(local_inputLine.equalsIgnoreCase("1500")){
                System.out.println( this.topUp1500());
            }
            
        
        }
        
    }
    protected String exitText(){
        return "Thanks for coming, see you again";
    }
    protected String helpText(){
        return "Available commands are: " + "\n exit, help, open store, show items, "+
                            "buy item, show basket total, restock, show customer balance, and restock football";
    }
    protected String openStore(){
        showItems();
        return "Store is now open, you may go ahead and look and purchase items";
        
    }
    protected String showItems(){
        for(int i = 0; i <departmentObject.entries.size(); i++){
            System.out.println(departmentObject.entries.get(i).getProductDetail());
        }
        return "End of list";
    }
    // protected String sellItem(){
        // Department items = new Department();
        // Item stock = new Item();
        // int x = stock.getStock()-1;
        // for(int i=0; i <items.entries.size(); i++){
            // items.entries.get(i).setStock(x);
        // }
        // return null;
    // }
    

    protected List<Item> searchByID(String itemID){
        List<Item> searchResult = new ArrayList<>();
        
        List<Item> listToSearchThrough = departmentObject.getEntries();
        
        int limit = listToSearchThrough.size();
        
        for (int i=0; i<limit; i++){
            Item products = (listToSearchThrough.get(i));
            String productID = (products.getID());
            if(products.getPrice()>custObject.showMoney()){
                System.out.println("You do no have enough money, Please get Money");
            }else{
            if(productID.equalsIgnoreCase(itemID)){
                searchResult.add(products);
                System.out.println(products);
                int x = products.getStock();
                if (products.getStock()<1){
                    System.out.println("There is no items left, Please restock"); 
                } else {
                    products.setStock(x-=1);
                    
                    System.out.println("You have succesfully added " +
                    products.getName() + "\nto the basket, here are the remaining stock for this "+
                    products.getProductDetail());
                    double y= products.getPrice();
                    basketObject.addToCost(y);
                    custObject.setMoney(y);
                    shopObject.addMoney(y);
                }              
            }
        }
        }
        // if (productID!=itemID){
               // System.out.println("Incorrect product ID entered, Please enter correct ID to add to bakset");
        // }
        return searchResult;
        
    
    }
    
    protected List<Item> refund(String itemID){
        List<Item> searchResult = new ArrayList<>();
        
        List<Item> listToSearchThrough = departmentObject.getEntries();
        
        int limit = listToSearchThrough.size();
        
        for (int i=0; i<limit; i++){
            Item products = (listToSearchThrough.get(i));
            String productID = (products.getID());
            
            if(productID.equalsIgnoreCase(itemID)){
                searchResult.add(products);
                System.out.println(products);
                int x = products.getStock();
                products.setStock(x+=1);
                System.out.println("You have succesfully returned " +
                products.getName() + "\n to the shop, here are the remaining stock for this "+
                products.getProductDetail());
                double y= products.getPrice();
                basketObject.refund(y);
                custObject.refund(y);
                shopObject.refund(y);
                               
            }   
        }
        // if (productID!=itemID){
               // System.out.println("Incorrect product ID entered, Please enter correct ID to add to bakset");
        // }
        return searchResult;
        
    
    }
    protected List<Item> reStock(String itemID){
        List<Item> searchResult = new ArrayList<>();
        
        List<Item> listToSearchThrough = departmentObject.getEntries();
        
        int limit = listToSearchThrough.size();
        
        for (int i=0; i<limit; i++){
            Item products = (listToSearchThrough.get(i));
            String productID = (products.getID());
            
            if(productID.equalsIgnoreCase(itemID)){
                searchResult.add(products);
                System.out.println(products);
                int x = products.getStock();
                products.setStock(x=10);
                System.out.println("You have succesfully restocked " + products.getName() + "selected item");
            }   
        }
        // if (productID!=itemID){
               // System.out.println("Incorrect product ID entered, Please enter correct ID to add to bakset");
        // }
        return searchResult;
        
    
    }
    //public List getResult(){
    //    return searchResult;
    //}
    protected String showBasketTotal (){
        double x = basketObject.totalCost();
        return  "Total value of the items addes is: £"+ x;
    }
    protected String showCustBalance(){
        double x = custObject.showMoney();
        return "Currently you have : £" + x;
    }
    // public String reStockWFootball(){
        // List x = departmentObject.getEntries();
        // x.set(0,footballReset);
        // return "World Cup Football were restocked";
    // }
    protected String shopBalance(){
        double x = shopObject.showShopBalance();
        return "The shop currently has £" + x + " left in the till";
    }
    protected String topUpCard(){
        double x = 500;
        custObject.refund(x);
        return "You have sucessfully topped up your card by £500";
    }
    protected String topUp500(){
        custObject.refund(500);
        return "You have sucessfully topped up your card by £500";
       }
    protected String topUp1000(){
        custObject.refund(1000);
        return "You have sucessfully topped up your card by £1000";
    }
    protected String topUp1500(){
        custObject.refund(1500);
        return "You have sucessfully topped up your card by £1500";
    }
    }


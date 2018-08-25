import java.util.*;
public class Department
{
    protected List<Item> entries;
    
    public Department(){
        entries = new ArrayList<>();
        
        Item football0 = new Item("FB100","World Cup Football", 149.99, "Original Telstar Football that was"+
                                   " used in the 2018 FIFA World Cup", 10);
        Item premfootball0 = new Item("FB101", "Premier League Football ", 99.99, " 2018/19 Premier League Football"+
                                    " used in the league", 10);
        Item gloves1 = new Item("FB102", "Football Gloves ", 49.99, " Football gloves used by best goalkeepers"+ 
                                    " in the world", 10);                         
        Item boots1 = new  Item("FB103", "Football Boots ",199.99, "Best boots around town", 10);  
                                    
        entries.add(football0);                                                         
        entries.add(premfootball0);
        entries.add(boots1);
        entries.add(gloves1);
    }
    
    public List<Item> getEntries(){
        
        return entries;
    }
    
 
}

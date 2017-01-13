import java.util.ArrayList;

public class Inventory {
	
	
	private ArrayList<Item> items;
	
	public Inventory(){
		items = new ArrayList<Item>();
	}
	
	public void add(Item item){
		items.add(item);
	}
	
	public Item getItem(){
		// Randomly select an item and return it
		return null;
	}
	
	public Item getItemByAttribute(int attributeIndex, double lower, double upper){
		//Randomly select an inventory to draw from, but  using a specific set of parameters
		return null;
	}
	
	
	
	
	
}

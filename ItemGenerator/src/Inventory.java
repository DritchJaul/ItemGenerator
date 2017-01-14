import java.util.ArrayList;

import javax.swing.JTextField;

public class Inventory {
	
	
	private ArrayList<Item> items;
	private String inventoryName;
	private TypeList type;
	
	
	
	public Inventory(String name){
		inventoryName = name;
		items = new ArrayList<Item>();
		type = null;
	}
	
	
	public void add(Item item){
		items.add(item);
	}
	
	
	public ArrayList<Item> getItems(int n){
		ArrayList<Item> generatedItems = new ArrayList<Item>();
		while (n > 0){
			generatedItems.add(new Item(items.get((int) (Math.random() * items.size())).getAttributes()));
			n--;
		}
		return generatedItems;
	}
	
	public Item getItem(){
		return getItems(1).get(0);
	}
	
	public Item getItemByAttribute(int attributeIndex, double lower, double upper){
		//Randomly select an inventory to draw from, but  using a specific set of parameters
		return null;
	}
	
	public String getName(){
		return inventoryName;
	}

	public Item getItem(JTextField jTextField) {
		return null;
	}
	
	public String getType(){
		return type.getName();
	}
	
}

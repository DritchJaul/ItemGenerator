import java.util.ArrayList;

public class Inventory {
	
	
	private ArrayList<Item> items;
	private String inventoryName;
	


	private int probability;
	private boolean enabled;
	
	
	
	public Inventory(String name){
		inventoryName = name;
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
	
	public String getName(){
		return inventoryName;
	}
	
	public int getProbability() {
		return probability;
	}

	public void setProbability(int probability) {
		this.probability = probability;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}


public class TypeInventory extends Inventory{

	
	private TypeList types;
	
	public TypeInventory(String name, TypeList list){
		super(name);
		types = list;
	}
	
	
	public Item getItem(){
		// Randomly select an item and type, then returns it 
		return null;
	}
	
	public Item getItemByAttribute(int attributeIndex, double lower, double upper){
		//Randomly select an inventory to draw from, but  using a specific set of parameters
		return null;
	}
	
	
	
	
}

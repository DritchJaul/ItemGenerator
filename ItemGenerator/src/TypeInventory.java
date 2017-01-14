import javax.swing.JTextField;

public class TypeInventory extends Inventory{



	private TypeList types;
	
	public TypeInventory(String name, TypeList list){
		super(name);
		types = list; 
	}
	
	
	public Item getItem(){
		return getItem(new JTextField());
	}
	
	public Item getItemByAttribute(int attributeIndex, double lower, double upper){
		//Randomly select an inventory to draw from, but  using a specific set of parameters
		return null;
	}
	
	public Item getItem(JTextField jTextField) {
		int n = -1;
		try{
			n = Integer.parseInt(jTextField.getText());
		}
		catch(java.lang.NumberFormatException e){
			
		}
		Item ret = getItems(1).get(0);
		
		Type type = types.getRandomType(n);
		
		ret.add(type.getType());
		ret.setAttribute(1, type.getValue());
		
		return ret;
		
		
	}
	
	public String getTypesType() {
		return types.getName();
	}


}

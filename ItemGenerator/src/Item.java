
public class Item {
	
	
	private String[] Attributes;
	
	public Item(String line){
		Attributes = line.split(" ");
	}
	
	public String get(int att){
		return Attributes[att];
	}
	
	public String getName(){
		return Attributes[0];
	}
	
	public int getNumberOfAttributes(){
		return Attributes.length;
	}
	
	
}


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
	
	public String getAttribute(int index){
		return Attributes[index];
	}
	
	public String toString(){
		String output = String.format("%-40s", Attributes[0]);
		for (int i = 1; i < Attributes.length; i++){
			output = String.format("%-10s %-10s", output, Attributes[i].replaceAll("[_]", " "));
		}
		return output + "\n";
	}
	
}

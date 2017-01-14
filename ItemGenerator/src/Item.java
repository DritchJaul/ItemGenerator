
public class Item {
	
	
	private String[] Attributes;
	
	public Item(String line){
		Attributes = line.split(" ");
		for (int i = 0; i < Attributes.length; i++){
			Attributes[i] = Attributes[i].replaceAll("[_]", " ");
		}
	}
	
	public Item(String[] atts){
		setAttributes(atts);
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
	
	public void setAttribute(int index, String att){
		Attributes[index] = att;
	}
	
	public String[] getAttributes(){
		return Attributes;
	}
	
	public void setAttributes(String[] atts){
		Attributes = atts;
	}
	
	
	public String toString(){
		String output = String.format("%-40s", Attributes[0]);
		for (int i = 1; i < Attributes.length; i++){
			output = String.format("%-10s %-10s", output, Attributes[i].replaceAll("[_]", " "));
		}
		return output + "\n";
	}
	
	public void add(String att){
		String[] newAttributes = new String[Attributes.length + 1];
		for (int i = 0; i < Attributes.length; i++){
			newAttributes[i] = Attributes[i];
		}
		newAttributes[Attributes.length] = att;
		Attributes = newAttributes;
	}
	
	
}

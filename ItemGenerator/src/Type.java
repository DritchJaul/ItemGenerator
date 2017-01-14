
public class Type{
	


	private String type;
	private String value;
	private int level;
	
	public Type(String line){
		String[] attributes = line.split(" ");
		type = attributes[0];
		value = attributes[1];
		level = Integer.parseInt(attributes[2]);
	}
	
	
	
	
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getLevel(){
		return level;
	}
	public void setLevel(int n){
		level = n;
	}
	
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String n){
		value = n;
	}
	
	
	public String toString(){
		return type;
	}



	
}

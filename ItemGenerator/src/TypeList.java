import java.util.ArrayList;

public class TypeList {
	
	private ArrayList<Type>  types;
	
	
	public TypeList(){
		types = new ArrayList<Type>();
	}
	
	
	public void addType(String type){
		types.add(new Type(type));
	}
	
	
	
	
	
}

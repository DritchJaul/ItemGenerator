import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TypeList {
	
	private ArrayList<Type>  types;
	private String name;
	
	public TypeList(String typeFile){
		types = new ArrayList<Type>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(typeFile));
			String line = br.readLine();
			name = line;
			while ((line = br.readLine()) != null){
				types.add(new Type(line));
			}
			br.close();
			
			
		}catch(Exception e){
			System.out.println("Error Reading file " + typeFile);
			e.printStackTrace();
		}
	}
	
	
	public void addType(Type type){
		types.add(type);
	}
	
	public Type getRandomType(){
		return types.get((int)( Math.random() * types.size()));
	}
	
	public Type getRandomType(int n){
		if (n == -1){
			return getRandomType();
		}
		
		
		ArrayList<Type> subTypes = new ArrayList<Type>();
		
		for (Type c : types){
			if (c.getLevel() == n){
				subTypes.add(c);
			}
		}
		if (subTypes.isEmpty()){
			return (getRandomType());
		}
		
		
		return subTypes.get((int)( Math.random() * subTypes.size()));
	}
	
	public String getName(){
		return name;
	}
}

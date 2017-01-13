import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MacroInventory {
	
	private ArrayList<Inventory> inventories;
	
	public MacroInventory(String itemFile){
		inventories = new ArrayList<Inventory>();
		generateInventories(itemFile);
	}
	
	private void generateInventories(String file){
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;               
			ArrayList<String> lines = new ArrayList<String>();
			while ((line = br.readLine()) != null){
				
				lines.add(line); // Process lines here, make items and add them to inventories
				inventories.add(new Inventory());
				
			}
			br.close();

		}catch(Exception e){
			System.out.println("Error Reading file " + file);
			e.printStackTrace();
		}
		
	}
	
	public Item getItem(){
		// Randomly select an inventory to draw an item from
		return null;
	}
	
	public Item getItemByAttribute(int attributeIndex, double lower, double upper){
		//Randomly select an inventory to draw from, but  using a specific set of parameters
		return null;
	}
	
	
	
}

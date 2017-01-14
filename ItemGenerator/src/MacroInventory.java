import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

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
			Inventory currentInventory = null;
			while ((line = br.readLine()) != null){
				
				/*
				 * Item List should look similar to this:
				 * 
				 * CLOTHING                      - Inventory Type, 1 or 2 entries
				 * Apron 0.01gp 1				 - Generic Item, 3 entries always [name][value][weight]
				 * Bell,_Plain 0.3gp 1
				 * Bell,_Fancy 1gp 2
				 * Sword_and_Dagger 1.5gp 5
				 * Boots,_High_(hard) 2gp 3
				 * Boots,_High_(soft) 1gp 3
				 * 
				 */
				
				// If the entry is not an item it should be an inventory heading.
				if(line.split(" ").length < 3){
					
					if(line.split(" ").length < 2){
						currentInventory = new Inventory(line);
					}else{
						currentInventory = new TypeInventory(line, new TypeList());
					}
					inventories.add(currentInventory);
				}else{
					currentInventory.add(new Item(line));
				}

				
			}
			br.close();

		}catch(Exception e){
			System.out.println("Error Reading file " + file);
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public Item getItem(ArrayList<JRadioButton> enabledInventories, ArrayList<JSlider> inventoryProbabilities, ArrayList<JTextField> inventoryAttributes){
		
		return getItems(enabledInventories, inventoryProbabilities, inventoryAttributes, 1).get(0);
	}
	
	public ArrayList<Item> getItems(ArrayList<JRadioButton> enabledInventories, ArrayList<JSlider> inventoryProbabilities, ArrayList<JTextField> inventoryAttributes, int n){
		
		ArrayList<Item> items = new ArrayList<Item>();
		
		int totalProbabilities = 0;
		for (int i = 0; i < enabledInventories.size(); i++){
			if (enabledInventories.get(i).isSelected()){
				totalProbabilities += inventoryProbabilities.get(i).getValue();
			}
		}
		if (totalProbabilities == 0){
			return items;
		}
		
		
		while(n > 0){
			double selection = Math.random() * totalProbabilities;
			int count = 0;
			
			for (int i = 0; i < enabledInventories.size(); i++){
				if (enabledInventories.get(i).isSelected()){
					count += inventoryProbabilities.get(i).getValue();
					if (selection < count){
						selection = i;
						break;
					}
				}
			}
			items.add(inventories.get((int) selection).getItem());
			n--;
		}
		
		return items;
	}
	
	
	
	public Item getItemByAttribute(int attributeIndex, double lower, double upper){
		//Randomly select an inventory to draw from, but  using a specific set of parameters
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	public void displayInventories(){
		for (Inventory c : inventories){
			System.out.println(c.getName());
		}
	}
	
	public int getInventoryCount(){
		return inventories.size();
	}
	
	public String getInventoryName(int index){
		return inventories.get(index).getName();
	}
	
	public Inventory getInventory( int index ){
		return inventories.get(index);
	}

	
}

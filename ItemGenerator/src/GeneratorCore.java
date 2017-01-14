import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class GeneratorCore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNumberOfItems;
	private JTextField txtValueOfItems;
	private static MacroInventory inventories;
	
	private ArrayList<JRadioButton> enabledInventories;
	private ArrayList<JSlider> inventoryProbabilities;
	private ArrayList<JTextField> inventoryAttributes;
	


	public static void main(String[] args) {
		
		
		// Generate the inventories from a given file
 
		ArrayList<TypeList> typeLists =  new ArrayList<TypeList>();
		typeLists.add(new TypeList("data/TypeList_Spells_D&D_Fantasy.txt"));
		inventories = new MacroInventory("data/ItemList_D&D_Fantasy.txt", typeLists);
		

		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneratorCore frame = new GeneratorCore();
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create and run the JFrame
	public GeneratorCore() {
		setTitle("Item Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelInventories = new JPanel();
		getContentPane().add(panelInventories, BorderLayout.WEST);
		GridBagLayout gbl_panelInventories = new GridBagLayout();
		gbl_panelInventories.columnWidths = new int[]{0, 0};
		gbl_panelInventories.rowHeights = new int[]{0, 0, 0};
		gbl_panelInventories.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelInventories.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelInventories.setLayout(gbl_panelInventories);
		
		
		// Make sets of all the inventory inputs
		enabledInventories = new ArrayList<JRadioButton>();
		inventoryAttributes = new ArrayList<JTextField>();
		inventoryProbabilities = new ArrayList<JSlider>();
		
		// Create the interface for each of the inventories
		for(int i = 0; i < inventories.getInventoryCount(); i++){
			
			JPanel panelInventoryControl = new JPanel();
			panelInventoryControl.setBorder(new LineBorder(new Color(0, 0, 0)));
			GridBagConstraints gbc_panelInventoryControl = new GridBagConstraints();
			gbc_panelInventoryControl.fill = GridBagConstraints.VERTICAL;
			gbc_panelInventoryControl.anchor = GridBagConstraints.WEST;
			gbc_panelInventoryControl.insets = new Insets(0, 0, 5, 0);
			//gbc_panelInventoryControl.gridx = 0;
			//gbc_panelInventoryControl.gridy = 0;
			gbc_panelInventoryControl.gridx = i / 16; // The inputs will be in columns 16 high
			gbc_panelInventoryControl.gridy = i % 16;
			
			
			panelInventories.add(panelInventoryControl, gbc_panelInventoryControl);
			
			GridBagLayout gbl_panelInventoryControl = new GridBagLayout();
			gbl_panelInventoryControl.columnWidths = new int[] {10, 0, 0};
			gbl_panelInventoryControl.rowHeights = new int[] {20, 0};
			gbl_panelInventoryControl.columnWeights = new double[]{0.0, 1.0, 0.0};
			gbl_panelInventoryControl.rowWeights = new double[]{0.0, 0.0};
			panelInventoryControl.setLayout(gbl_panelInventoryControl);
			

			JLabel itemLabel = new JLabel(inventories.getInventoryName(i).replaceAll("[_]", " "));
			//JLabel itemLabel = new JLabel("Inventory");
			GridBagConstraints gbc_itemLabel = new GridBagConstraints();
			gbc_itemLabel.insets = new Insets(0, 0, 0, 5);
			gbc_itemLabel.gridx = 1;
			gbc_itemLabel.gridy = 0;
			panelInventoryControl.add(itemLabel, gbc_itemLabel);
			
			
			JTextField txtLevel = new JTextField();
			if (inventories.getInventory(i) instanceof TypeInventory){
				inventoryAttributes.add(txtLevel);
				GridBagConstraints gbc_txtLevel = new GridBagConstraints();
				gbc_txtLevel.insets = new Insets(5, 3, 5, 3);
				gbc_txtLevel.gridx = 2;
				gbc_txtLevel.gridy = 0;
				panelInventoryControl.add(txtLevel, gbc_txtLevel);
				txtLevel.setColumns(3);

			}else{
				inventoryAttributes.add(null);
			}

			
			JSlider sliderProbability = new JSlider();
			inventoryProbabilities.add(sliderProbability);
			GridBagConstraints gbc_sliderProbability = new GridBagConstraints();
			gbc_sliderProbability.gridwidth = 2;
			gbc_sliderProbability.insets = new Insets(0, 0, 0, 5);
			gbc_sliderProbability.gridx = 1;
			gbc_sliderProbability.gridy = 1;
			panelInventoryControl.add(sliderProbability, gbc_sliderProbability);
		

			JRadioButton rdbtnUseInventory = new JRadioButton("");
			enabledInventories.add(rdbtnUseInventory);
			rdbtnUseInventory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					itemLabel.setEnabled(rdbtnUseInventory.isSelected());
					txtLevel.setEnabled(rdbtnUseInventory.isSelected());
					sliderProbability.setEnabled(rdbtnUseInventory.isSelected());
					
				}
			});
			rdbtnUseInventory.setSelected(false);
			itemLabel.setEnabled(rdbtnUseInventory.isSelected());
			txtLevel.setEnabled(rdbtnUseInventory.isSelected());
			sliderProbability.setEnabled(rdbtnUseInventory.isSelected());
			
			GridBagConstraints gbc_rdbtnUseInventory = new GridBagConstraints();
			gbc_rdbtnUseInventory.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnUseInventory.gridx = 0;
			gbc_rdbtnUseInventory.gridy = 0;
			panelInventoryControl.add(rdbtnUseInventory, gbc_rdbtnUseInventory);
		
		}
			


		
		ScrollPane scrollPane = new ScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setPreferredSize(new Dimension(700, 100));
		
		
		JTextArea txtOutputBox = new JTextArea();
		txtOutputBox.setText("Items Generated Displayed Here");

		txtOutputBox.setLineWrap(true);
		scrollPane.add(txtOutputBox, BorderLayout.CENTER);
		txtOutputBox.setFont(new Font("Courier", Font.ROMAN_BASELINE, 12));
		
		JPanel panelControl = new JPanel();
		getContentPane().add(panelControl, BorderLayout.SOUTH);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				// Sanitize the input from the txtNumberOfItems
				int n = 0;
				try{
					n = Integer.parseInt(txtNumberOfItems.getText());
				}
				catch(java.lang.NumberFormatException e){
					
				}
				
				// Generate n items
				if (n > 0){
					ArrayList<Item> items = inventories.getItems(enabledInventories, inventoryProbabilities, inventoryAttributes, n);
					String output = "";
					for (Item c : items){
						
						output += c;

					}
					txtOutputBox.setText(output);
				}

				
			}
		});
		panelControl.add(btnGenerate);
		
		JPanel panelNumberOfItems = new JPanel();
		panelControl.add(panelNumberOfItems);
		GridBagLayout gbl_panelNumberOfItems = new GridBagLayout();
		gbl_panelNumberOfItems.columnWidths = new int[]{0, 0};
		gbl_panelNumberOfItems.rowHeights = new int[]{0, 0, 0};
		gbl_panelNumberOfItems.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelNumberOfItems.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelNumberOfItems.setLayout(gbl_panelNumberOfItems);
		
		txtNumberOfItems = new JTextField();
		
		GridBagConstraints gbc_txtNumberOfItems = new GridBagConstraints();
		gbc_txtNumberOfItems.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumberOfItems.gridx = 0;
		gbc_txtNumberOfItems.gridy = 1;
		panelNumberOfItems.add(txtNumberOfItems, gbc_txtNumberOfItems);
		txtNumberOfItems.setColumns(10);
		txtNumberOfItems.setText("10");
		
		JLabel lblNmber = new JLabel("Number of Items");
		GridBagConstraints gbc_lblNmber = new GridBagConstraints();
		gbc_lblNmber.gridx = 0;
		gbc_lblNmber.gridy = 0;
		panelNumberOfItems.add(lblNmber, gbc_lblNmber);
		
		JPanel panelValueOfItems = new JPanel();
		panelControl.add(panelValueOfItems);
		GridBagLayout gbl_panelValueOfItems = new GridBagLayout();
		gbl_panelValueOfItems.columnWidths = new int[]{0, 0};
		gbl_panelValueOfItems.rowHeights = new int[]{0, 0, 0};
		gbl_panelValueOfItems.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelValueOfItems.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelValueOfItems.setLayout(gbl_panelValueOfItems);
		
		JLabel lblValue = new JLabel("Value of Items");
		GridBagConstraints gbc_lblValue = new GridBagConstraints();
		gbc_lblValue.gridx = 0;
		gbc_lblValue.gridy = 0;
		panelValueOfItems.add(lblValue, gbc_lblValue);
		
		txtValueOfItems = new JTextField();
		txtValueOfItems.setColumns(10);
		GridBagConstraints gbc_txtValueOfItems = new GridBagConstraints();
		gbc_txtValueOfItems.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValueOfItems.gridx = 0;
		gbc_txtValueOfItems.gridy = 1;
		panelValueOfItems.add(txtValueOfItems, gbc_txtValueOfItems);
		
		
	}
}

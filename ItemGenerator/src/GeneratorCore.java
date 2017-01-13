import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class GeneratorCore extends JFrame {
	private JTextField txtLevel;
	private JTextField txtNumberOfItems;
	private JTextField txtValueOfItems;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
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
		
		JPanel panelInventoryControl = new JPanel();
		panelInventoryControl.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panelInventoryControl = new GridBagConstraints();
		gbc_panelInventoryControl.fill = GridBagConstraints.VERTICAL;
		gbc_panelInventoryControl.anchor = GridBagConstraints.WEST;
		gbc_panelInventoryControl.insets = new Insets(0, 0, 5, 0);
		gbc_panelInventoryControl.gridx = 0;
		gbc_panelInventoryControl.gridy = 0;
		panelInventories.add(panelInventoryControl, gbc_panelInventoryControl);
		GridBagLayout gbl_panelInventoryControl = new GridBagLayout();
		gbl_panelInventoryControl.columnWidths = new int[] {10, 0};
		gbl_panelInventoryControl.rowHeights = new int[] {20, 0, 0};
		gbl_panelInventoryControl.columnWeights = new double[]{0.0, 1.0};
		gbl_panelInventoryControl.rowWeights = new double[]{0.0, 0.0, 0.0};
		panelInventoryControl.setLayout(gbl_panelInventoryControl);
		
		JRadioButton rdbtnUseInventory = new JRadioButton("New radio button");
		GridBagConstraints gbc_rdbtnUseInventory = new GridBagConstraints();
		gbc_rdbtnUseInventory.gridx = 0;
		gbc_rdbtnUseInventory.gridy = 1;
		panelInventoryControl.add(rdbtnUseInventory, gbc_rdbtnUseInventory);
		
		txtLevel = new JTextField();
		GridBagConstraints gbc_txtLevel = new GridBagConstraints();
		gbc_txtLevel.insets = new Insets(0, 1, 1, 5);
		gbc_txtLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLevel.gridx = 1;
		gbc_txtLevel.gridy = 1;
		panelInventoryControl.add(txtLevel, gbc_txtLevel);
		txtLevel.setColumns(10);
		
		JSlider sliderProbability = new JSlider();
		GridBagConstraints gbc_sliderProbability = new GridBagConstraints();
		gbc_sliderProbability.gridwidth = 2;
		gbc_sliderProbability.gridx = 0;
		gbc_sliderProbability.gridy = 2;
		panelInventoryControl.add(sliderProbability, gbc_sliderProbability);
		
		JLabel itemLabel = new JLabel("New label");
		GridBagConstraints gbc_itemLabel = new GridBagConstraints();
		gbc_itemLabel.gridwidth = 2;
		gbc_itemLabel.gridx = 0;
		gbc_itemLabel.gridy = 0;
		panelInventoryControl.add(itemLabel, gbc_itemLabel);
		
		JPanel panelControl = new JPanel();
		getContentPane().add(panelControl, BorderLayout.SOUTH);
		
		JButton btnGenerate = new JButton("Generate");
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
		
		JTextPane txtOutputBox = new JTextPane();
		getContentPane().add(txtOutputBox, BorderLayout.CENTER);

	}
}

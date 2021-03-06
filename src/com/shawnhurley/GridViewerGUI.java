package com.shawnhurley;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GridViewerGUI extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	 private static final String ACTION_CALCULATE = "Calculate"; 
	
	//Title labels to identify groups of fields
	private JLabel EntryTitleLabel;
	private JLabel KeyPanelLabel;
	//private JLabel ResultTitleLabel;
	private JLabel RequiredInputLabel;
	//private JLabel OutPutTableLabel;
	private JLabel ValueClassLabel;
	private JLabel Grid_End_Pointslabel;
	private JLabel Grid_Namelabel;
	private JLabel ListOfValuesPanelLabel;
	
	//JPanels in which we the sub-areas of our GUI
	private JPanel EntryTitlePanel;
	//private JPanel ResultTitlePanel;
	private JPanel requiredInputPanel;
	//private JPanel OutPutTablePanel;
	private JPanel KeyPanel;
	private JPanel ListOfValuesPanel;
	
	//Fields for data entry
	//private JFormattedTextField EntryTitle;
	private JFormattedTextField classLookingfor;
	private JFormattedTextField KeyPanelTextField;
	//private JFormattedTextField Keytolookup;
	private JFormattedTextField ValueClass;
	private JFormattedTextField Grid_endpt;
	private JFormattedTextField Grid_Name;
	private JButton submitButton;
	//************ Need to add more here, attempting to make the first screen first*******/
	
	//Formats to format and parse numbers
	//private NumberFormat integerFormat = NumberFormat.getIntegerInstance();
	
	
	public GridViewerGUI() throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, IOException {
		//set that we are a grid layout type of JPanel
		super(new GridBagLayout());
		
		//Create a GridBagConstraints object we can reuse when adding componets
		GridBagConstraints c = new GridBagConstraints();
		
		//load our properties from the file in our .jar
		
		//loadProps();
		
		//********Construct sub-sections in main panel***************
		EntryTitlePanel = new JPanel(new GridBagLayout());
		requiredInputPanel = new JPanel(new GridBagLayout());
		KeyPanel = new JPanel(new GridBagLayout());
		ListOfValuesPanel = new JPanel(new GridBagLayout());
		
		fillYourEntryTitlePanel();
		c.fill = GridBagConstraints.FIRST_LINE_START;
		//c.anchor = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		EntryTitlePanel.setBackground(Color.pink);
		add(EntryTitlePanel,c);
		
		//Put Componentes within requiredInputPanel, then place it in main panel ("this")
		fillyourRequiredInputPanel();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx=0;
		c.gridy=2;
		requiredInputPanel.setBackground(Color.GRAY);
		add(requiredInputPanel,c);
		
		//Put componets in KeyPanel
		fillKeyPanel();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx=0;
		c.gridy=1;
		KeyPanel.setBackground(Color.green);
		add(KeyPanel,c);
		
		//Put componets in ListOfValues
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 1;
		c.gridy= 1;
		ListOfValuesPanel.setBackground(Color.BLUE);
		add(ListOfValuesPanel,c);
		
		
	}
	//private void loadProps() {
		//props = new Properties();
		//InputStream in = props.getClass().getResourceAsStream(propsFileName);
		//try {
			//props.load(in);
		//} catch (IOException e) {
			//e.printStackTrace();
		//}
	//}
	
	private void fillYourEntryTitlePanel(){
		//create a GridBagConstraints object we can reuse when adding componet
		GridBagConstraints c = new GridBagConstraints();
		
		//add the label
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		EntryTitleLabel = new JLabel("IBM Grid Viewer");
		EntryTitlePanel.add(EntryTitleLabel, c);
//		
//		//Add the text field
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridx = 0;
//		c.gridy = 0;
//		EntryTitle = new JFormattedTextField();
//		EntryTitle.setColumns(80);
//		EntryTitle.setEditable(false);
//		EntryTitlePanel.add(EntryTitle,c);
//		
		return;
	}
	
	private void fillyourRequiredInputPanel(){
		//create a GridBagConstraints object we can reuse when adding componet
		GridBagConstraints c = new GridBagConstraints();
		
		//add the label
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx=0;
		c.gridy=0;
		RequiredInputLabel = new JLabel("Key Class");
		requiredInputPanel.add(RequiredInputLabel, c);
		
		//Add the text field
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx=1;
		c.gridy=0;
		classLookingfor = new JFormattedTextField("Key_Class_Want");
		classLookingfor.setEditable(true);
		requiredInputPanel.add(classLookingfor, c);
		
		//add another label for the value class
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx=0;
		c.gridy=1;
		ValueClassLabel = new JLabel("Value_Class");
		requiredInputPanel.add(ValueClassLabel, c);
		
		//Add the text field to get value
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx=1;
		c.gridy=1;
		ValueClass = new JFormattedTextField("Value_Class_want");
		ValueClass.setEditable(true);
		requiredInputPanel.add(ValueClass, c);
		
		//add label for Catalog end points
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx=0;
		c.gridy=2;
		Grid_End_Pointslabel = new JLabel("Grid_end_PTS");
		requiredInputPanel.add(Grid_End_Pointslabel, c);
		//add Text field for Catalog end points
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx=1;
		c.gridy=2;
		Grid_endpt = new JFormattedTextField("Grid_End_Points");
		Grid_endpt.setEditable(true);
		requiredInputPanel.add(Grid_endpt, c);
		//add label for grid name
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx=0;
		c.gridy=3;
		Grid_Namelabel = new JLabel("Grid_Name");
		requiredInputPanel.add(Grid_Namelabel, c);
		
		//add text field for grid name
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx=1;
		c.gridy=3;
		Grid_Name = new JFormattedTextField("Grid_Name_Want");
		Grid_Name.setEditable(true);
		requiredInputPanel.add(Grid_Name, c);
		
		//Add the submit button
	    submitButton = new JButton("Submit");
	    Font cf = submitButton.getFont();
	    Font buttonFont = new Font(cf.getName(), cf.getStyle(), 12);
	    submitButton.setFont(buttonFont);
	    submitButton.setVerticalTextPosition(AbstractButton.CENTER);
	    submitButton.setHorizontalTextPosition(AbstractButton.CENTER); //aka LEFT, for left-to-right locales
//	    calcButton.setMnemonic(KeyEvent.VK_ENTER);
	    submitButton.setEnabled(true);
	    submitButton.setActionCommand(ACTION_CALCULATE);
	    //Listen for actions on buttons 1 and 3.
	    submitButton.addActionListener(this);
	    c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
	    requiredInputPanel.add(submitButton, c);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (ACTION_CALCULATE.equals(e.getActionCommand())){
			//JOptionPane.showMessageDialog(submitButton, "hello world");
			GridBagConstraints c = new GridBagConstraints();
			String inputs[] = {classLookingfor.getText(), ValueClass.getText(), Grid_endpt.getText(), Grid_Name.getText()};
			try {
				fillLisOfValuesPanel();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			c.fill = GridBagConstraints.VERTICAL;
			c.gridx = 1;
			c.gridy= 1;
			ListOfValuesPanel.setBackground(Color.BLUE);
			add(ListOfValuesPanel,c);
		}
	}
	public void fillKeyPanel(){
		GridBagConstraints c = new GridBagConstraints();
		
		//Add the Label 
		c.fill = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		KeyPanelLabel = new JLabel("Key");
		KeyPanel.add(KeyPanelLabel, c);
		
		//Add a text field
		c.fill = GridBagConstraints.EAST;
		c.gridx = 1;
		c.gridy = 0;
		KeyPanelTextField = new JFormattedTextField();
		KeyPanelTextField.setEditable(true);
		KeyPanelTextField.setColumns(20);
		KeyPanel.add(KeyPanelTextField,c);
	}
	public void fillLisOfValuesPanel() throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, IOException{
		GridBagConstraints c = new GridBagConstraints();
		//will use the XMLReader and call MySAXApp to return the panel
		Foo newfoo = new Foo();
		StringBuffer sb = null;
		sb = objectToXML.reflection(newfoo, sb);
		System.out.print(sb.toString());
		final MySAXApp handler = objectToXML.attempts(sb.toString());
		ListOfValuesPanel = handler.getTestPanel();
}		
	private GridBagConstraints choosewhattodo(String string){
		GridBagConstraints c = new GridBagConstraints();	
		return c;
		//Some interesting stuff here, We have to wait for the XML file to be transfered here and then we will have to build the panel, I am thinking sometime of event listener

	}
}
package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener{
	HashMap<Integer, String>logSearch = new HashMap<Integer, String>();
	JFrame frame = new JFrame("_02_LogSearch");
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Add Entry");
	JButton button2 = new JButton("Search by ID");
	JButton button3 = new JButton("View List");
	JButton button4= new JButton("Remove Entry");
	int idNum=0;
	String name="";
	public static void main(String[] args) {
_02_LogSearch logSearch02= new _02_LogSearch();	
logSearch02.setup();
	}
	public void setup() {
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		if(e.getSource()==button1) {
		String id=	JOptionPane.showInputDialog("Enter an ID number");
idNum=	Integer.parseInt(id);
		name=	JOptionPane.showInputDialog("Enter a name");
		logSearch.put(idNum, name);
		}
	
	if(e.getSource()==button2) {
		String searchingID= JOptionPane.showInputDialog("Enter the ID number you would like to search for");
		int searchID= Integer.parseInt(searchingID);
		System.out.println(idNum);
		if(searchID==idNum) {
			
		name=	logSearch.get(searchID);
			JOptionPane.showMessageDialog(null, "The name of the user is "+ name);
		}else {
			JOptionPane.showMessageDialog(null, "That ID number does not exist");
		}
	}
	if(e.getSource()==button3) {
		for (int i = 0; i < logSearch.keySet().size(); i++) {
		 idNum= (int) logSearch.keySet().toArray()[i];
		 name=logSearch.get(idNum);
			System.out.println("ID: "+ idNum+ " Name: " + name);
		}
	}
	if(e.getSource()==button4) {
		String searchingID= JOptionPane.showInputDialog("Enter the ID number you would like to search for");
		int searchID= Integer.parseInt(searchingID);
		System.out.println(idNum);
		if(searchID==idNum) {
			
			logSearch.remove(name, searchID);
			JOptionPane.showMessageDialog(null, "The person and ID have been removed");
		}else {
			JOptionPane.showMessageDialog(null, "That ID number does not exist");
		}
	}

	}
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
		
}

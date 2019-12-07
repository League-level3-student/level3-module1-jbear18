package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener{
	ArrayList<String> names = new ArrayList<String>();
	
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame= new JFrame ("Guest Book");
	JPanel panel= new JPanel ();
	JButton addname= new JButton("Add a Guest");
	JButton viewnames= new JButton ("View Guests");
	public static void main(String[] args) {
	_02_GuestBook guestbook= new _02_GuestBook();
	guestbook.setup();

	}
	public void setup() {
		frame.add(panel);
		panel.add(viewnames);
		panel.add(addname);
		addname.addActionListener(this);
		viewnames.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== addname) {
			String ans=JOptionPane.showInputDialog("Please enter your name into the Guest Book. Enjoy the feast:)");
			names.add(ans);

		}
		if(e.getSource()==viewnames) {
			String message= "";
			for (int i = 0; i < names.size(); i++) {
				message+= "Guest #"+ (i+1)+ " "+ names.get(i)+ "\n";
		
			}
			JOptionPane.showMessageDialog(null,message);
		}
	}
}

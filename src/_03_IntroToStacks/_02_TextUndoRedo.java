package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	JFrame frame = new JFrame("TextUndoRedo");
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> stack = new Stack<Character>();
	/*
	 * Create a JFrame with a JPanel and a JLabel. did that - check Every time a key
	 * is pressed, add that character to the JLabel. It should look like a basic
	 * text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	public static void main(String[] args) {
		new _02_TextUndoRedo().setup();
	}

	public void setup() {
		frame.add(panel);
		frame.addKeyListener(this);
		panel.add(label);
		frame.setVisible(true);
		frame.pack();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	
		
				System.out.println();
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			String x= label.getText();
String s= x.substring(0, x.length()-1);

stack.push(x.charAt(x.length()-1));
			label.setText(s);
	
		}else if (e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
			label.setText(label.getText()+ stack.pop());	
		}else {
		label.setText(label.getText()+ e.getKeyChar());	
		}

		
	}                                                      

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import _03_IntroToStacks._02_TextUndoRedo;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame("Hangman");
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> wordStack = new Stack<String>();
	int lives = 6;
	char character;
	String word;
	String underscores = "";
	String lettersFound = "";

//	Step 1: When the program starts, it will ask the user for a number (up to the total words in the file). Then the 
//    program will read that many words from the "dictionary.txt" file and push them to a Stack. 
//    Use the readRandomLineFromFile method in the Utilities class. The words should be selected randomly so 
//    not every game is played with the same set of words. You can use the Stack's contains() method to make sure
//    there are no duplicate words.
	public static void main(String[] args) {
		HangMan hangman = new HangMan();
		new HangMan().setup();
	}

	public void setup() {
		frame.add(panel);
		frame.addKeyListener(this);
		panel.add(label);
		frame.setVisible(true);
		frame.pack();
		String ans = JOptionPane.showInputDialog("How many words would you like to guess?");
		int numOfWords = Integer.parseInt(ans);
		for (int i = 0; i < numOfWords; i++) {
			String randomWord = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!wordStack.contains(randomWord)) {
				wordStack.push(randomWord);
			}

		}
		poppingOffWord();
	}

//Step 2: Pop the word off the top of the stack and use a JLabel to display a blank line for all the characters in the word. 
//    Collect key inputs from the user. If the user guesses a letter, fill in the blank space. Otherwise, take off a life.

	public void poppingOffWord() {
		word = wordStack.pop();
		lettersFound = "";
		JLabel charactersWordLabel = new JLabel();
		charactersWordLabel.setText(underscores);
//	System.out.println(word);
		for (int i = 0; i < word.length(); i++) {
			underscores += " _ ";
			lettersFound += "_";
		}

		label.setText(underscores);
		frame.pack();

//if(character==letter) {
//	underscores +-;
	}

	public void hangmanGame() {
		String newLabelText = "";
		String newLettersFound= "";
		for (int i = 0; i < word.length(); i++) {
			if(lettersFound.charAt(i)=='_') {
				if (word.charAt(i) == character) {
					newLabelText += " ";
					newLabelText+= character;
					newLettersFound+= character;
				}else {
					newLabelText+= " _";
					newLettersFound+= "_";
				}
			}
		}
		}
			


//	}
//Step 3: When a word has been solved, pop the next one off the stack and start a new round. It is up to you if you want to 
//    reset the lives. RESET LIVES
	public void solvedWord() {
		if (word.equals(word)) {
			wordStack.pop();
			lives = 6;
		} else if (lives == 0) {
			playAgain();
		}
	}

//
//Step 4: If they run out of lives, give them a game over message.
//
	public void playAgain() {
		if (lives == 0) {
			JOptionPane.showMessageDialog(null, "GAME OVER");
			String ans = JOptionPane
					.showInputDialog("Would you like to play again? Type yes to play again and no to end");
			if (ans == "yes") {
				solvedWord();

			} else if (ans == "no") {
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			}
		}
	}

//
//Step 5: Don't end the program on game over. Ask the user if they would like to play again and run the game again with new 
//    words if they choose yes.

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		character = e.getKeyChar();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

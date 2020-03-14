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
	String randomWord;

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

		String ans = JOptionPane.showInputDialog("How many words would you like to guess?");
		int numOfWords = Integer.parseInt(ans);
		for (int i = 0; i < numOfWords; i++) {
			randomWord = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!wordStack.contains(randomWord)) {
				wordStack.push(randomWord);
			}

		}
		poppingOffWord();
	}

//Step 2: Pop the word off the top of the stack and use a JLabel to display a blank line for all the characters in the word. 
//    Collect key inputs from the user. If the user guesses a letter, fill in the blank space. Otherwise, take off a life.

	public void poppingOffWord() {
		frame.add(panel);
		frame.addKeyListener(this);
		panel.add(label);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(!wordStack.isEmpty()) {
			word = wordStack.pop();
		

//		JLabel charactersWordLabel = new JLabel();
		underscores = "";
		// comment this out later (down below)
		System.out.println(word);
		for (int i = 0; i < word.length(); i++) {
			underscores += "_ ";
		}
//		charactersWordLabel.setText(underscores);

		label.setText(underscores);
		frame.pack();
		}else {
			JOptionPane.showMessageDialog(null, "There are no words on the stack");
		}
//if(character==letter) {
//	underscores +-;
	}

	public void hangmanGame() {
		boolean foundLetter = false;
		for (int i = 0; i < word.length(); i++) {

			if (word.charAt(i) == character) {

				String text = label.getText();
				String first = text.substring(0, i * 2);
				String last = text.substring((i + 1) * 2, text.length());
				label.setText(first + character + " " + last);
				foundLetter = true;

			}
				if (label.getText()!=underscores) {
					poppingOffWord();
					lives=6;
				}

		}
		if (!foundLetter) {
			lives--;
			if (lives == 0) {
				playAgain();
			}
		}
	}

//	}
//Step 3: When a word has been solved, pop the next one off the stack and start a new round. It is up to you if you want to 
//    reset the lives. RESET LIVES
//	public void solvedWord() {
//wordStack.pop();
////			if (!wordStack.contains(randomWord)) {
////				wordStack.push(randomWord);
////			}
//		}

//
//Step 4: If they run out of lives, give them a game over message.
//
	public void playAgain() {
		if (lives == 0) {
			JOptionPane.showMessageDialog(null, "GAME OVER");
			String ans = JOptionPane.showInputDialog(
					"Would you like to play again? Type yes to play again with new lives or no to exit.");
			if (ans == "yes") {
				frame.dispose();
				poppingOffWord();

			}
			if (ans == "no") {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		hangmanGame();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

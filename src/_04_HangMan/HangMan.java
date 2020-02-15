package _04_HangMan;

import javax.swing.JOptionPane;

public class HangMan{
//	Step 1: When the program starts, it will ask the user for a number (up to the total words in the file). Then the 
//    program will read that many words from the "dictionary.txt" file and push them to a Stack. 
//    Use the readRandomLineFromFile method in the Utilities class. The words should be selected randomly so 
//    not every game is played with the same set of words. You can use the Stack's contains() method to make sure
//    there are no duplicate words.
public static void main(String[] args) {
	HangMan hangman= new HangMan();
	String ans=JOptionPane.showInputDialog("please insert a number up to 17:");
	int numOfWords= Integer.parseInt(ans);
	
}
//Step 2: Pop the word off the top of the stack and use a JLable to display a blank line for all the characters in the word. 
//    Collect key inputs from the user. If the user guesses a letter, fill in the blank space. Otherwise, take off a life.
//
//
//	
//Step 3: When a word has been solved, pop the next one off the stack and start a new round. It is up to you if you want to 
//    reset the lives.
//
//
//
//Step 4: If they run out of lives, give them a game over message.
//
//
//
//Step 5: Don't end the program on game over. Ask the user if they would like to play again and run the game again with new 
//    words if they choose yes.
	
	
}

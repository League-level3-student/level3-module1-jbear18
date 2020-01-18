package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener {
	ArrayList<Song> songs = new ArrayList<Song>();
	Song s;

	public _06_IPodShuffle() {

		// 1. Use the Song class the play the demo.mp3 file.

		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */

	}

	public static void main(String[] args) {
		new _06_IPodShuffle().setup();
	}

	JFrame frame = new JFrame("iPod Shuffle");
	JPanel panel = new JPanel();
	JButton suprisemebutton = new JButton("Suprise Me!");

	public void setup() {
		frame.add(panel);
		panel.add(suprisemebutton);
		frame.setVisible(true);
		frame.pack();
		suprisemebutton.addActionListener(this);
		Song newsong= new Song("demo.mp3");
		songs.add(newsong);
		Song othersong= new Song("guitar.mp3");
		songs.add(othersong);
		Song nationalanthem= new Song("national.mp3");
		songs.add(nationalanthem);
		Song coolsong= new Song("808.mp3");
		songs.add(coolsong);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random generator = new Random();
		if (e.getSource() == suprisemebutton) {
			if(s!= null) {
				s.stop();	
			}
	
			int x = generator.nextInt(songs.size());
		s = songs.get(x);
			s.play();

		}
	}
}
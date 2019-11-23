package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
ArrayList<String> games = new ArrayList<String>();
		
		
		//2. Add five Strings to your list
games.add("Apples to Apples");
games.add("Monoply");
games.add("Risk");
games.add("Candyland");
games.add("Clue");
		//3. Print all the Strings using a standard for-loop
for(int i = 0; i < games.size(); i++){
	String j = games.get(i);
	System.out.println(j);
}
		
		//4. Print all the Strings using a for-each loop
for(String j : games){
	System.out.println(j);
}
System.out.println("\n");
		//5. Print only the even numbered elements in the list.
for (int i = 0; i < games.size(); i++) {
	String j= games.get(i);
	if (i%2==0) {
		System.out.println(j);
	}
}		
		//6. Print all the Strings in reverse order.
for(int i = games.size ()-1; i >= 0; i--){
	String j = games.get(i);
	System.out.println(j);
}
		//7. Print only the Strings that have the letter 'e' in them.
for (int i = 0; i < games.size(); i++) {
	String j= games.get(i);
	if (j.contains("e")) {
		System.out.println(j);
	}
}		
	}
}

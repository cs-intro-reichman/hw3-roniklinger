import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		int count = 0;
		boolean anagram = false;
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		if(str2.length() == str1.length()){
			for(int i=0;i < str1.length();i++){
				boolean let = false;
				for(int j=0;j < str2.length();j++){
					if((str1.charAt(i) == str2.charAt(j)) && let == false){
						count++;
						str2 = str2.substring(0, j) + str2.substring(j + 1);
						let = true;
					}
				}
			}
		}
		if(str1.length() == count){
			anagram = true;
		}
			return anagram;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		String new_str = "";
		for(int i=0; i<str.length();i++){
			if (Character.isLetter(str.charAt(i)) ){
			//|| (str.charAt(i) == ' ' )) {
				new_str = new_str + str.charAt(i);
			}
		}
		return new_str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		//int rand = 0;
		String newstr = "";
		Random rand = new Random();
		while(str.length() != 0){
			int random_num = rand.nextInt(str.length());
			//rand = Math.random();
			newstr = newstr + str.charAt(random_num);
			str = str.substring(0, random_num) + str.substring(random_num + 1);
		}
		return newstr;
	}
}

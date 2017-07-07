package org.sunnyslls.miscellanous;

public class PalindromePermutation {

	public static void main(String[] args) {
		PalindromePermutation pp = new PalindromePermutation();
		String s = "poop";
		pp.permutation(s, "");
	}
	
	void permutation(String word, String prefix){
		if(word.length() == 0){
			System.out.println(prefix);
		}
		else{
			for(int i = 0; i < word.length(); i++){
				String a = word.substring(0, i);
				String b = word.substring(i+1);
				String newWord = word.substring(0, i) + word.substring(i+1);
				permutation(newWord, prefix + word.charAt(i));
			}
		}
	}
}

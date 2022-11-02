package com.palindrome;

public class CheckIsPalindrome {

    public boolean checkPalindrome(String word) {
        StringBuilder sb = new StringBuilder();

        int[] charPos = word.chars().toArray();
        for (int i = charPos.length - 1; i >= 0; i--) {
            sb.append(word.charAt(i));
        }

        return word.equalsIgnoreCase(sb.toString());
    }

    public boolean checkPalindromeWithSB(String word) {
        return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
    }
}

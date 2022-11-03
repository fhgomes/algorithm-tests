package com.codility.threeletters;

/*
Write a function solution that, given two integers A and B,
returns a string containing exactly A letters 'a'
    and
    exactly B letters 'b' with no three consecutive letters being the same
    (in other words, neither "aaa" nor "bbb" may occur in the returned string).

Examples:

1. Given A = 5 and B = 3, your function may return "aabaabab".
    Note that "abaabbaa" would also be a correct answer.
    Your function may return any correct answer.

2. Given A = 3 and B = 3, your function should return "ababab", "aababb", "abaabb" or any of several other strings.

3. Given A = 1 and B = 4, your function should return "bbabb", which is the only correct answer in this case.

Assume that:

A and B are integers within the range [0..100];
at least one solution exists for the given A and B.
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class ThreeLettersSolution {


    public String distributeLetters(int as, int bs) {
        StringBuilder sb = new StringBuilder();

        int asLeft = as;
        int bsLeft = bs;

        int seqAs = 0;
        int seqBs = 0;

        boolean useA = true;

        if (bs > as) {
            useA = false;
        }

        while (asLeft+bsLeft > 0) {
            if (useA) {
                if (seqAs == 2 || asLeft == 0) {
                    useA = false;
                    seqAs = 0;
                    continue;
                }
                if (lastDoubleChar(sb, 'a') && bsLeft == 0) {
                    int lastBB = sb.lastIndexOf("bb");
                    if (lastBB != -1) {
                        sb.deleteCharAt(lastBB);
                        sb.append("b");
                    }
                }
                sb.append("a");
                asLeft--;
                seqAs++;

            } else {
                if (seqBs == 2 || bsLeft == 0) {
                    useA = true;
                    seqBs = 0;
                    continue;
                }
                if (lastDoubleChar(sb, 'b') && asLeft == 0) {
                    int lastAA = sb.lastIndexOf("aa");
                    if (lastAA != -1) {
                        sb.deleteCharAt(lastAA);
                        sb.append("a");
                    }
                }
                sb.append("b");
                bsLeft--;
                seqBs++;

            }
        }

        return sb.toString();
    }

    private boolean lastDoubleChar(StringBuilder sb, char letter) {
        if(sb.length() < 2) {
            return false;
        }
        return sb.charAt(sb.length() - 1) == letter && sb.charAt(sb.length() - 2) == letter;
    }
}

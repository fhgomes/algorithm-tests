package com.wordsearchermatrix;

import static java.lang.String.format;

/**
 * Given a word
 * Find the word char sequence in one of the 8 possibly direction in a Matrix of characters
 * Example 1:
 *  "EATS"
 *  {
 *    [A, C, (E), X,  W,  A ]
 *    [O, G,  A, (A), J,  S ]
 *    [C, P,  X,  Y, (T), X ]
 *    [V, Q,  I,  T,  J, (S)]
 *  }
 *
 * Example 2:
 *  "TODDY"
 *  {
 *    [A, C, (T), X, W, A]
 *    [O, G, (O), B, J, S]
 *    [C, P, (D), Y, E, X]
 *    [V, Q, (D), T, J, R]
 *    [X, A, (Y), E, A, T]
 *  }
 *
 * Word has to be min of 3 chars and maximum of 26
 *
 * It can exists duplicated same letters
 * Consider only lowercase letters
 *
 * OBS / DISCLAIMER
 * -> For now it is assuming that the first letter is only present ONCE. To cover other edge cases we will handle in the future
 * -> IT is missing two directions
 */
public class WordSearcherInMatrix {

  public static void main(String[] args) {}


  /**
   * Only can find O(m * n)
   * Cada um dos métodos de direção são O(k) on k é o tamanho da palavra buscada.
   * Complexidade combinada: O(m * n * k) no pior caso.
   * Se K tiver limite definido (ex 26), podemos simplificar O(m * n)
   */
  public boolean canFind(char[] word, char[][] matrix) {

    System.out.println(format("Start searching the word [%s], in the matrix \n\n { %s }"
        , String.valueOf(word), convertMatrixToString(matrix)));

    int firstCharIndex = 0;
    char firstChar = word[firstCharIndex];


    int firstWordCharLineIndex = -1;
    int firstWordCharColumnIndex = -1;

    //BigO (N x M)
    for (int matrixLine = 0; matrixLine < matrix.length; matrixLine++) {
      for (int matrixColumn = 0; matrixColumn < matrix[matrixLine].length; matrixColumn++) {
        char charAtPosition = matrix[matrixLine][matrixColumn];
        if (charAtPosition == firstChar) {
          firstWordCharLineIndex = matrixLine;
          firstWordCharColumnIndex = matrixColumn;
          break;
        }
      }

      if (firstWordCharColumnIndex != -1) {
        break;
      }
    }

    System.out.println(format("I found the first letter [%s] at position [%d, %d]"
        , firstChar, firstWordCharLineIndex, firstWordCharColumnIndex));

    //BigO (1 x M) == BigO (M)
    boolean isWordFound = findWordUsingRightSeq(word, firstCharIndex, matrix, firstWordCharLineIndex, firstWordCharColumnIndex);
    if (isWordFound) {
      return isWordFound;
    }

    //BigO (N x M)
    System.out.println("\n == Try to find using Right Down sequence ==");
    isWordFound = findWordUsingRightDownSeq(word, firstCharIndex, matrix, firstWordCharLineIndex, firstWordCharColumnIndex);
    if (isWordFound) {
      return isWordFound;
    }

    //BigO (N x 1)
    System.out.println("\n == Try to find using Down sequence ==");
    isWordFound = findWordUsingDownSeq(word, firstCharIndex, matrix, firstWordCharLineIndex, firstWordCharColumnIndex);
    if (isWordFound) {
      return isWordFound;
    }

    //BigO (1 x M) == BigO (N)
    System.out.println("\n == Try to find using Left sequence ==");
    isWordFound = findWordUsingLeftSeq(word, firstCharIndex, matrix, firstWordCharLineIndex, firstWordCharColumnIndex);
    if (isWordFound) {
      return isWordFound;
    }

    //BigO (N x M)
    System.out.println("\n == Try to find using Left Up sequence ==");
    isWordFound = findWordUsingLeftUpSeq(word, firstCharIndex, matrix, firstWordCharLineIndex, firstWordCharColumnIndex);
    if (isWordFound) {
      return isWordFound;
    }

    //BigO (N x 1) == BigO (N)
    System.out.println("\n == Try to find using UP sequence ==");
    isWordFound = findWordUsingUpSeq(word, firstCharIndex, matrix, firstWordCharLineIndex, firstWordCharColumnIndex);
    if (isWordFound) {
      return isWordFound;
    }

    return false;
  }

  private boolean findWordUsingLeftSeq(char[] word, int currentCharIndex, char[][] matrix, int currentWordCharLineIndex,
                                        int currentWordCharColumnIndex) {

    int localCurrentWordCharColumnIndex = currentWordCharColumnIndex;
    for (int nextWordCharIndex = currentCharIndex+1; nextWordCharIndex < word.length; nextWordCharIndex++) {
      boolean nextWordCharToFound = false;
      char nextWordCharToFind = word[nextWordCharIndex];
      System.out.println("Searching Left sequence for letter [" + nextWordCharToFind + "]");

      for (int nextColumnCharIndex = localCurrentWordCharColumnIndex-1; nextColumnCharIndex >= 0; nextColumnCharIndex--) {
        char nextCharAtColumnRight = matrix[currentWordCharLineIndex][nextColumnCharIndex];
        System.out.println("Comparing Left letter [" + nextWordCharToFind + "]==" + "[" +nextCharAtColumnRight +"]");
        if (nextWordCharToFind == nextCharAtColumnRight) {
          System.out.println("Letter found at [" + currentWordCharLineIndex + "]" + "[" + nextColumnCharIndex + "]");
          localCurrentWordCharColumnIndex = nextColumnCharIndex;
          nextWordCharToFound = true;
          break;
        }
        if (nextWordCharToFind != nextCharAtColumnRight) {
          return false;
        }
      }

      if (nextWordCharIndex == word.length-1) {
        return nextWordCharToFound;
      }
    }
    return false;
  }

  private boolean findWordUsingUpSeq(char[] word, int currentCharIndex, char[][] matrix, int currentWordCharLineIndex,
                                       int currentWordCharColumnIndex) {
    int localCurrentWordCharLineIndex = currentWordCharLineIndex;

    for (int nextWordCharIndex = currentCharIndex+1; nextWordCharIndex < word.length; nextWordCharIndex++) {
      boolean nextWordCharToFound = false;
      char nextWordCharToFind = word[nextWordCharIndex];
      System.out.println("Searching UP sequence for letter [" + nextWordCharToFind + "]");

      for (int nextLineCharIndex = localCurrentWordCharLineIndex-1; nextLineCharIndex >= 0; nextLineCharIndex--) {
        char nextCharAtColumnLineDown = matrix[nextLineCharIndex][currentWordCharColumnIndex];
        System.out.println("Comparing UP letter [" + nextWordCharToFind + "]==" + "[" +nextCharAtColumnLineDown +"]");
        if (nextWordCharToFind == nextCharAtColumnLineDown) {
          System.out.println("Letter found at [" + nextLineCharIndex + "]" + "[" + currentWordCharColumnIndex + "]");
          localCurrentWordCharLineIndex = nextLineCharIndex;
          nextWordCharToFound = true;
          break;
        }
        if (nextWordCharToFind != nextCharAtColumnLineDown) {
          return false;
        }
      }

      if (nextWordCharIndex == word.length-1) {
        return nextWordCharToFound;
      }
    }
    return false;
  }

  private boolean findWordUsingDownSeq(char[] word, int currentCharIndex, char[][] matrix, int currentWordCharLineIndex,
                                       int currentWordCharColumnIndex) {
    int localCurrentWordCharLineIndex = currentWordCharLineIndex;

    for (int nextWordCharIndex = currentCharIndex+1; nextWordCharIndex < word.length; nextWordCharIndex++) {
      boolean nextWordCharToFound = false;
      char nextWordCharToFind = word[nextWordCharIndex];
      System.out.println("Searching Down sequence for letter [" + nextWordCharToFind + "]");

      for (int nextLineCharIndex = localCurrentWordCharLineIndex+1; nextLineCharIndex < matrix.length; nextLineCharIndex++) {
        char nextCharAtColumnLineDown = matrix[nextLineCharIndex][currentWordCharColumnIndex];
        System.out.println("Comparing DownSeq letter [" + nextWordCharToFind + "]==" + "[" +nextCharAtColumnLineDown +"]");
        if (nextWordCharToFind == nextCharAtColumnLineDown) {
          System.out.println("Letter found at [" + nextLineCharIndex + "]" + "[" + currentWordCharColumnIndex + "]");
          localCurrentWordCharLineIndex = nextLineCharIndex;
          nextWordCharToFound = true;
          break;
        }
        if (nextWordCharToFind != nextCharAtColumnLineDown) {
          return false;
        }
      }

      if (nextWordCharIndex == word.length-1) {
        return nextWordCharToFound;
      }
    }
    return false;
  }

  private boolean findWordUsingLeftUpSeq(char[] word, int currentCharIndex, char[][] matrix, int currentWordCharLineIndex,
                                            int currentWordCharColumnIndex) {

    int localCurrentWordCharLineIndex = currentWordCharLineIndex;
    int localCurrentWordCharColumnIndex = currentWordCharColumnIndex;

    for (int nextWordCharIndex = currentCharIndex+1; nextWordCharIndex < word.length; nextWordCharIndex++) {
      boolean nextWordCharToFound = false;
      char nextWordCharToFind = word[nextWordCharIndex];
      System.out.println("Searching Left Up sequence for letter [" + nextWordCharToFind + "]");

      localCurrentWordCharLineIndex = localCurrentWordCharLineIndex - 1;
      if (localCurrentWordCharLineIndex < 0) {
        return false;
      }

      for (int nextLeftColumnCharIndex = localCurrentWordCharColumnIndex-1; nextLeftColumnCharIndex >= 0; nextLeftColumnCharIndex--) {
        char nextCharAtColumnRightDown = matrix[localCurrentWordCharLineIndex][nextLeftColumnCharIndex];
        System.out.println("Comparing left up letter [" + nextWordCharToFind + "]==" + "[" +nextCharAtColumnRightDown +"]"
            + " at [" + localCurrentWordCharLineIndex +"]" + "[" + nextLeftColumnCharIndex +"]");

        if (nextWordCharToFind == nextCharAtColumnRightDown) {
          System.out.println("Letter found at [" + localCurrentWordCharLineIndex + "]" + "[" + nextLeftColumnCharIndex + "]");
          localCurrentWordCharColumnIndex = nextLeftColumnCharIndex;
          nextWordCharToFound = true;
          break;
        }
        if (nextWordCharToFind != nextCharAtColumnRightDown) {
          return false;
        }
      }

      if (nextWordCharIndex == word.length-1) {
        return nextWordCharToFound;
      }
    }
    return false;
  }

  private boolean findWordUsingRightDownSeq(char[] word, int currentCharIndex, char[][] matrix, int currentWordCharLineIndex,
                                            int currentWordCharColumnIndex) {

    int localCurrentWordCharLineIndex = currentWordCharLineIndex;
    int localCurrentWordCharColumnIndex = currentWordCharColumnIndex;

    for (int nextWordCharIndex = currentCharIndex+1; nextWordCharIndex < word.length; nextWordCharIndex++) {
      boolean nextWordCharToFound = false;
      char nextWordCharToFind = word[nextWordCharIndex];
      System.out.println("Searching Right Down sequence for letter [" + nextWordCharToFind + "]");

      localCurrentWordCharLineIndex = localCurrentWordCharLineIndex + 1;
      if (localCurrentWordCharLineIndex >= matrix.length) {
        return false;
      }

      char[] matrixDownLineChars = matrix[localCurrentWordCharLineIndex];

      for (int nextRightColumnCharIndex = localCurrentWordCharColumnIndex+1; nextRightColumnCharIndex < matrixDownLineChars.length; nextRightColumnCharIndex++) {
        char nextCharAtColumnRightDown = matrix[localCurrentWordCharLineIndex][nextRightColumnCharIndex];
        System.out.println("Comparing right down letter [" + nextWordCharToFind + "]==" + "[" +nextCharAtColumnRightDown +"]"
          + " at [" + localCurrentWordCharLineIndex +"]" + "[" + nextRightColumnCharIndex +"]");

        if (nextWordCharToFind == nextCharAtColumnRightDown) {
          System.out.println("Letter found at [" + localCurrentWordCharLineIndex + "]" + "[" + nextRightColumnCharIndex + "]");
          localCurrentWordCharColumnIndex = nextRightColumnCharIndex;
          nextWordCharToFound = true;
          break;
        }
        if (nextWordCharToFind != nextCharAtColumnRightDown) {
          return false;
        }
      }

      if (nextWordCharIndex == word.length-1) {
        return nextWordCharToFound;
      }
    }
    return false;
  }

  private boolean findWordUsingRightSeq(char[] word, int currentCharIndex, char[][] matrix, int currentWordCharLineIndex,
                                        int currentWordCharColumnIndex) {

    int localCurrentWordCharColumnIndex = currentWordCharColumnIndex;
    for (int nextWordCharIndex = currentCharIndex+1; nextWordCharIndex < word.length; nextWordCharIndex++) {
      boolean nextWordCharToFound = false;
      char nextWordCharToFind = word[nextWordCharIndex];
      System.out.println("Searching Right sequence for letter [" + nextWordCharToFind + "]");

      char[] matrixLineChars = matrix[currentWordCharLineIndex];

      for (int nextColumnCharIndex = localCurrentWordCharColumnIndex+1; nextColumnCharIndex < matrixLineChars.length; nextColumnCharIndex++) {
        char nextCharAtColumnRight = matrix[currentWordCharLineIndex][nextColumnCharIndex];
        System.out.println("Comparing letter right letter [" + nextWordCharToFind + "]==" + "[" +nextCharAtColumnRight +"]");
        if (nextWordCharToFind == nextCharAtColumnRight) {
          System.out.println("Letter found at [" + currentWordCharLineIndex + "]" + "[" + nextColumnCharIndex + "]");
          localCurrentWordCharColumnIndex = nextColumnCharIndex;
          nextWordCharToFound = true;
          break;
        }
        if (nextWordCharToFind != nextCharAtColumnRight) {
          System.out.println("Letter not found at [" + currentWordCharLineIndex + "]" + "[" + nextColumnCharIndex + "], pause strategy");
          return false;
        }
      }
      if (nextWordCharIndex == word.length-1) {
        return nextWordCharToFound;
      }
    }

    return false;
  }




  public static String convertMatrixToString(char[][] matrix) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        sb.append(matrix[i][j]);
        if (j < matrix[i].length - 1) {
          sb.append(", "); // Adiciona uma vírgula e um espaço entre os caracteres
        }
      }
      sb.append(System.lineSeparator()); // Adiciona uma nova linha após cada linha da matriz
    }

    return sb.toString();
  }
}


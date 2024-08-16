package com.wordsearchermatrix;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WordSearcherInMatrixTest {

  @Test
  void shouldTestEatsWordInRightSequence() {
    WordSearcherInMatrix searcher = new WordSearcherInMatrix();

    char[][] matrix = {
        {'A', 'E', 'A', 'T', 'S', 'A'},
        {'O', 'G', 'V', 'B', 'J', 'S'},
        {'C', 'P', 'D', 'K', 'E', 'X'},
        {'V', 'Q', 'D', 'T', 'S', 'R'},
        {'X', 'A', 'Y', 'E', 'A', 'T'}
    };

    char[] eats = new char[] {'E', 'A', 'T', 'S'};
    assertTrue(searcher.canFind(eats, matrix));
  }

  @Test
  void shouldTestEatsWordInLeftSequence() {
    WordSearcherInMatrix searcher = new WordSearcherInMatrix();

    char[][] matrix = {
        {'A', 'S', 'T', 'A', 'E', 'A'},
        {'O', 'G', 'V', 'B', 'J', 'S'},
        {'C', 'P', 'D', 'K', 'E', 'X'},
        {'V', 'Q', 'D', 'T', 'S', 'R'},
        {'X', 'A', 'Y', 'E', 'A', 'T'}
    };

    char[] eats = new char[] {'E', 'A', 'T', 'S'};
    assertTrue(searcher.canFind(eats, matrix));
  }

  @Test
  void shouldTestEatsWordInRightDownSequence() {
    WordSearcherInMatrix searcher = new WordSearcherInMatrix();

    char[][] matrix = {
        {'A', 'E', 'T', 'X', 'W', 'A'},
        {'O', 'G', 'A', 'B', 'J', 'S'},
        {'C', 'P', 'D', 'T', 'E', 'X'},
        {'V', 'Q', 'D', 'T', 'S', 'R'},
        {'X', 'A', 'Y', 'E', 'A', 'T'}
    };

    char[] eats = new char[] {'E', 'A', 'T', 'S'};
    assertTrue(searcher.canFind(eats, matrix));
  }

  @Test
  void shouldTestEatsWordInLeftUpSequence() {
    WordSearcherInMatrix searcher = new WordSearcherInMatrix();

    char[][] matrix = {
        {'A', 'S', 'T', 'X', 'W', 'A'},
        {'O', 'G', 'T', 'B', 'J', 'S'},
        {'C', 'P', 'D', 'A', 'F', 'X'},
        {'V', 'Q', 'D', 'T', 'E', 'R'},
        {'X', 'A', 'Y', 'F', 'A', 'T'}
    };

    char[] eats = new char[] {'E', 'A', 'T', 'S'};
    assertTrue(searcher.canFind(eats, matrix));
  }

  @Test
  void shouldTestEatsWordInDownSequence() {
    WordSearcherInMatrix searcher = new WordSearcherInMatrix();

    char[][] matrix = {
        {'A', 'X', 'E', 'X', 'W', 'A'},
        {'O', 'G', 'A', 'B', 'J', 'S'},
        {'C', 'P', 'T', 'G', 'E', 'X'},
        {'V', 'Q', 'S', 'T', 'S', 'R'},
        {'X', 'A', 'Y', 'E', 'A', 'T'}
    };

    char[] eats = new char[] {'E', 'A', 'T', 'S'};
    assertTrue(searcher.canFind(eats, matrix));
  }

  @Test
  void shouldTestEatsWordInUPSequence() {
    WordSearcherInMatrix searcher = new WordSearcherInMatrix();

    char[][] matrix = {
        {'A', 'X', 'S', 'X', 'W', 'A'},
        {'O', 'G', 'T', 'B', 'J', 'S'},
        {'C', 'P', 'A', 'G', 'F', 'X'},
        {'V', 'Q', 'E', 'T', 'S', 'R'},
        {'X', 'A', 'Y', 'F', 'A', 'T'}
    };

    char[] eats = new char[] {'E', 'A', 'T', 'S'};
    assertTrue(searcher.canFind(eats, matrix));
  }
}
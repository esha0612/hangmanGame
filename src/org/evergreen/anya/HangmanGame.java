package org.evergreen.anya;

public class HangmanGame {
    private char[] discoveredChars;
    private String guessedLetters;
    private int remainingAttempts;
    private String currentWord;
    private String currentWordDescription;
    private Words words;

    public HangmanGame() {
        words = new Words();
        this.guessedLetters = "";
        this.remainingAttempts = 6; // Default number of attempts
    }

    public String[] getCategories() {
        return words.getCategories();
    }

    public void chooseCategory(String category) {

        String[] currentWordArr = words.PickWord(category);
        this.currentWord = currentWordArr[0];
        this.currentWordDescription = currentWordArr[1];
        this.discoveredChars = new char[currentWord.length()];
        java.util.Arrays.fill(discoveredChars, '_');

    }

    // Possiby add recurrsion
    public boolean guess(char letter) {
        boolean isCorrect = false;
        guessedLetters += letter;
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == letter) {
                discoveredChars[i] = letter;
                isCorrect = true;
            }
        }
        if (!isCorrect) {
            remainingAttempts--;
        }
        return isCorrect;
    }

    public void resetGame() {
        java.util.Arrays.fill(discoveredChars, '_');
        guessedLetters = "";
        remainingAttempts = 6;
    }

    public String getGuessedLetters() {
        return guessedLetters;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public String getCurrentProgress() {
        return new String(discoveredChars);
    }
}

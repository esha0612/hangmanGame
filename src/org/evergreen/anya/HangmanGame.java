package org.evergreen.anya;

public class HangmanGame {
    private char[] discoveredChars;
    private String guessedLetters;
    private int remainingAttempts;
    private String currentCategory;
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
        currentCategory = category;
        this.currentWord = currentWordArr[0].toLowerCase();
        this.currentWordDescription = currentWordArr[1];
        this.discoveredChars = new char[currentWord.length()];
        for (int i = 0; i < discoveredChars.length; i++) {
            discoveredChars[i] = ' ';
        }

        System.out.println("Selected word is " + currentWord);

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
        System.out.println("Discovered:" + String.valueOf(discoveredChars));
        return isCorrect;
    }

    public boolean isWordDiscovered() {
        return this.currentWord.equals(String.valueOf(discoveredChars));
    }

    public void resetGame() {
        java.util.Arrays.fill(discoveredChars, '_');
        guessedLetters = "";
        remainingAttempts = 6;
        currentCategory = "";
        currentWord = "";
        currentWordDescription = "";
        discoveredChars = null;
    }

    public String getGuessedLetters() {
        return guessedLetters;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public String getCurrentProgress() {
        return buildProgress(discoveredChars, 0, "");
    }

    // Build Progress String recursively
    private static String buildProgress(char[] discoveredChars, int index, String displayString) {
        // Base case: if the index is equal to the length of the array, return the
        // displayString.
        if (index == discoveredChars.length) {
            return displayString;
        }

        // Add a space before each character except the first.
        if (index > 0) {
            displayString += " ";
        }

        // Check the current character and update displayString accordingly.
        if (discoveredChars[index] != ' ') {
            displayString += " " + discoveredChars[index] + " ";
        } else {
            displayString += "___";
        }

        // Recursive call with the next index.
        return buildProgress(discoveredChars, index + 1, displayString);
    }

    public String getCurrentCategory() {
        return this.currentCategory;
    }

    public String getCurrentWordDescription() {
        return this.currentWordDescription;
    }

    public String getCurrentWord() {
        return this.currentWord;
    }

}

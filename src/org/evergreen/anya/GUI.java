package org.evergreen.anya;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI implements ActionListener {
    private JFrame frame;
    private JTextField inputField;
    private JButton guessButton, pickCategoryButton;
    private JLabel wordLabel, wordText, categoryLabel, categoryText, remaingAttemptsLabel,
            remaingAttemptsText, guessedLettersLabel, guessedLettersText, gameSuccessLabel, gameFailedLabel;
    private JComboBox categoryList;
    private int frameWidth = 500, frameHeight = 700;

    private HangmanGame game;

    public GUI() {

        // Initialize Backend
        game = new HangmanGame();
        showCategorySelectionScreen();

    }

    public static void main(String[] args) {
        new GUI();
    }

    private void showCategorySelectionScreen() {

        frame = new JFrame("Anya's Hangman Game: Select a Category");
        String[] categories = game.getCategories();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(new FlowLayout());

        categoryLabel = new JLabel("Category");
        frame.add(categoryLabel);

        categoryList = new JComboBox(categories);
        frame.add(categoryList);

        pickCategoryButton = new JButton("Go");
        pickCategoryButton.addActionListener(this);
        frame.add(pickCategoryButton);

        frame.setVisible(true);
    }

    private void showWordGuessScreen(String category) {
        frame.dispose();

        this.game.chooseCategory(category);

        frame = new JFrame("Anya's Hangman Game: Guess Word");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(new FlowLayout());

        categoryLabel = new JLabel("Category:");
        frame.add(categoryLabel);

        categoryText = new JLabel(category);
        frame.add(categoryText);

        wordLabel = new JLabel("Guessed Word:");
        frame.add(wordLabel);

        wordText = new JLabel("");
        frame.add(wordText);

        remaingAttemptsLabel = new JLabel("Remaining Attempts:");
        frame.add(remaingAttemptsLabel);

        remaingAttemptsText = new JLabel("");
        frame.add(remaingAttemptsText);

        guessedLettersLabel = new JLabel("Letters Guessed:");
        frame.add(guessedLettersLabel);

        guessedLettersText = new JLabel("");
        frame.add(guessedLettersText);

        inputField = new JTextField(20);
        frame.add(inputField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        frame.add(guessButton);

        setGameState();

        frame.setVisible(true);

    }

    private void showGameSuccessScreen() {
        frame.dispose();

        frame = new JFrame("Anya's Hangman Game: You did it");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(new FlowLayout());

        gameSuccessLabel = new JLabel("You correctly guessed the word");
        frame.add(gameSuccessLabel);
        frame.setVisible(true);

    }

    private void showGameFailedcreen() {
        frame.dispose();

        frame = new JFrame("Anya's Hangman Game: Better Luck Next Time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(new FlowLayout());

        gameFailedLabel = new JLabel("You could not guess it this time. Try again");
        frame.add(gameFailedLabel);
        frame.setVisible(true);

    }

    private void setGameState() {
        setDiscoveredWordText();
        setCategoryText();
        setRemaingAttemptsText();
        setGuessedLettersText();

        if (game.isWordDiscovered()) {
            showGameSuccessScreen();
        } else if (game.getRemainingAttempts() == 0) {
            showGameFailedcreen();
        }
    }

    private void setDiscoveredWordText() {
        wordText.setText(game.getCurrentProgress());
    }

    private void setCategoryText() {
        categoryText.setText(game.getCurrentCategory());
    }

    private void setRemaingAttemptsText() {
        remaingAttemptsText.setText(String.valueOf(game.getRemainingAttempts()));
    }

    private void setGuessedLettersText() {
        guessedLettersText.setText(game.getGuessedLetters());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == pickCategoryButton) {
            showWordGuessScreen((String) categoryList.getSelectedItem());
        } else if (e.getSource() == guessButton) {
            game.guess(inputField.getText().toLowerCase().charAt(0));
            inputField.setText(null);
            setGameState();
        }
    }

}

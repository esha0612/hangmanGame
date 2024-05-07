package org.evergreen.anya;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI implements ActionListener {
    private JFrame frame;
    private JTextField inputField;
    private JButton guessButton;
    private JLabel wordLabel, wordText, categoryLabel, categoryText, remaingAttemptsLabel,
            remaingAttemptsText, guessedLettersLabel, guessedLettersText;
    private JComboBox categoryList;

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
        frame.setSize(300, 200);
        frame.setLayout(new Flow

        frame.setVisible(true);
    }


    

    private void showWordGuessScreen(String category) {
        frame.dispose();

        this.game.chooseCategory(category);

        frame = new JFrame("Anya's Hangman Game: Guess Word");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
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

        inputField = new JTextField(20);
        frame.add(inputField);

        guessButton = new JButton("Guess");
     

 

    }

    private void setDiscoveredWordText() {
        wordLabel.setText(game.getCurrentProgress());

    }   


}


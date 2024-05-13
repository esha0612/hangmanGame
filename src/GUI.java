
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.*;

public class GUI implements ActionListener {
    private JFrame frame;
    private JTextField inputField;

    private JButton guessButton, pickCategoryButton, retryButton, learnMoreBtn;
    private JLabel wordLabel, wordText, categoryLabel, categoryText, remaingAttemptsLabel,
            remaingAttemptsText, guessedLettersLabel, guessedLettersText, gameSuccessLabel, gameFailedLabel,
            hangmanImageLabel, wordDescriptionLabel, learnMoreLabel,categoryIconLabel;
    private JComboBox categoryList;
    private int frameWidth = 700, frameHeight = 300;

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

        frame = new JFrame("Hangman Game: Select a Category");
        String[] categories = game.getCategories();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        panelNorth.add(new JLabel("Please select the desired category and clik on the 'Go' button to play"));
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelSouth = new JPanel();
        panelSouth.add(new JLabel("Enjoy"));
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel panelCenterGrid = new JPanel();
        panelCenterGrid.setLayout(new GridLayout(1, 2, 5, 5));
        panelCenter.add(panelCenterGrid);

        JPanel panelCenterLeft = new JPanel();
        JPanel panelCenterRight = new JPanel();
        panelCenterGrid.add(panelCenterLeft);
        panelCenterGrid.add(panelCenterRight);

        categoryLabel = new JLabel("Category");
        panelCenterLeft.add(categoryLabel);

        categoryList = new JComboBox(categories);
        panelCenterLeft.add(categoryList);

        pickCategoryButton = new JButton("Go");
        pickCategoryButton.addActionListener(this);
        panelCenterRight.add(pickCategoryButton);

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void showWordGuessScreen(String category) {
        frame.dispose();

        this.game.chooseCategory(category);

        frame = new JFrame("Hangman Game: Guess Word");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight + 300);
        frame.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        panelNorth.add(new JLabel("Guess an alphabet and press 'Guess'"));
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelSouth = new JPanel();
        panelSouth.add(new JLabel("Don't let him hang"));
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelCenter = new JPanel();
        JPanel panelCenterGrid = new JPanel();
        panelCenterGrid.setLayout(new GridLayout(1, 2, 5, 5));
        panelCenter.add(panelCenterGrid);

        JPanel panelCenterLeft = new JPanel();
        JPanel panelCenterRight = new JPanel();
        panelCenterRight.setLayout(new GridLayout(10, 1, 5, 5));
        panelCenterGrid.add(panelCenterLeft);
        panelCenterGrid.add(panelCenterRight);

        // HM Image
        hangmanImageLabel = new JLabel();
        panelCenterLeft.add(hangmanImageLabel);

        // Category
        JPanel categoryPanel = new JPanel();
        panelCenterRight.add(categoryPanel);
        categoryPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        categoryLabel = new JLabel("Category:");
        categoryPanel.add(categoryLabel);
        categoryText = new JLabel(category);
        categoryPanel.add(categoryText);
        categoryIconLabel = new JLabel();
        categoryPanel.add(categoryText);


        // Guessed Word
        JPanel guessedWordPanel = new JPanel();
        panelCenterRight.add(guessedWordPanel);
        guessedWordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        wordLabel = new JLabel("Guessed Word:");
        guessedWordPanel.add(wordLabel);
        wordText = new JLabel("");
        guessedWordPanel.add(wordText);

        // remaining Attempts
        JPanel remainingAttemptsPanel = new JPanel();
        panelCenterRight.add(remainingAttemptsPanel);
        remainingAttemptsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        remaingAttemptsLabel = new JLabel("Remaining Attempts:");
        remainingAttemptsPanel.add(remaingAttemptsLabel);
        remaingAttemptsText = new JLabel("");
        remainingAttemptsPanel.add(remaingAttemptsText);

        // Letters Guessed So Far
        JPanel guessedSoFarPanel = new JPanel();
        panelCenterRight.add(guessedSoFarPanel);
        guessedSoFarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        guessedLettersLabel = new JLabel("Letters Guessed:");
        guessedSoFarPanel.add(guessedLettersLabel);
        guessedLettersText = new JLabel("");
        guessedSoFarPanel.add(guessedLettersText);

        // Input
        JPanel inputPanel = new JPanel();
        panelCenterRight.add(inputPanel);
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        inputField = new JTextField(2);
        inputPanel.add(inputField);
        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        inputPanel.add(guessButton);

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);

        setGameState();

        frame.setVisible(true);

    }

    private void showGameSuccessScreen() {
        frame.dispose();

        frame = new JFrame("Hangman Game: Congratulations! You did it");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        panelNorth.add(new JLabel("Success"));
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelSouth = new JPanel();
        panelSouth.add(new JLabel("Your current streak is - Who is counting right?"));
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelCenter = new JPanel();
        JPanel panelCenterGrid = new JPanel();
        panelCenterGrid.setLayout(new GridLayout(4, 1, 5, 5));
        panelCenter.add(panelCenterGrid);

        gameSuccessLabel = new JLabel("You correctly guessed the word: " + game.getCurrentWord());
        panelCenterGrid.add(gameSuccessLabel);

        learnMoreBtn = new JButton("Learn more about: " + game.getCurrentWord());
        learnMoreBtn.addActionListener(this);
        panelCenterGrid.add(learnMoreBtn);

        retryButton = new JButton("Play Again");
        retryButton.addActionListener(this);
        panelCenterGrid.add(retryButton);

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);

        frame.setVisible(true);

    }

    private void showGameFailedcreen() {
        frame.dispose();

        frame = new JFrame("Hangman Game: Better Luck Next Time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        panelNorth.add(new JLabel("Tough Luck"));
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelSouth = new JPanel();
        panelSouth.add(new JLabel("Keep trying"));
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelCenter = new JPanel();
        JPanel panelCenterGrid = new JPanel();
        panelCenterGrid.setLayout(new GridLayout(4, 1, 5, 5));
        panelCenter.add(panelCenterGrid);

        gameFailedLabel = new JLabel("You could not guess it this time. The word was " + game.getCurrentWord());
        panelCenterGrid.add(gameFailedLabel);

        learnMoreBtn = new JButton("Learn more about: " + game.getCurrentWord());
        learnMoreBtn.addActionListener(this);
        panelCenterGrid.add(learnMoreBtn);

        retryButton = new JButton("Play Again");
        retryButton.addActionListener(this);
        panelCenterGrid.add(retryButton);

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    private void setGameState() {
        setDiscoveredWordText();
        setCategoryText();
        setRemaingAttemptsText();
        setGuessedLettersText();
        setHangmanImage();
        setCategoryIcon();

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

    private void setHangmanImage() {
        int failedAttempts = 6 - game.getRemainingAttempts();
        URL u = getClass().getResource("resources/hm" + failedAttempts + ".jpeg");
        hangmanImageLabel.setIcon(new ImageIcon(u));
    }

    private void setCategoryIcon() {
        URL u = game.getCurrentCategoryIcon();
         categoryIconLabel.setIcon(new ImageIcon(u));
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == pickCategoryButton) {
            showWordGuessScreen((String) categoryList.getSelectedItem());
        } else if (e.getSource() == guessButton) {
            game.guess(inputField.getText().toLowerCase().charAt(0));
            inputField.setText(null);
            setGameState();
        } else if (e.getSource() == retryButton) {
            game.resetGame();
            showCategorySelectionScreen();
        } else if (e.getSource() == learnMoreBtn) {

            final JDialog modalFrame = new JDialog(frame, game.getCurrentCategory() + " : " + game.getCurrentWord(),
                    true);
            modalFrame.setMinimumSize(new Dimension(500, 500));
            JPanel moreInfoPanel = new JPanel();
            moreInfoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            wordDescriptionLabel = new JLabel();
            moreInfoPanel.add(wordDescriptionLabel);
            wordDescriptionLabel.setText(game.getCurrentWordDescription());

            // learnMoreLabel = new JLabel("Here is some more information about: " +
            // game.getCurrentWord());
            // moreInfoPanel.add(learnMoreLabel);

            modalFrame.getContentPane().add(moreInfoPanel);
            modalFrame.pack();
            modalFrame.setVisible(true);
        }
    }

}

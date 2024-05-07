package org.evergreen.anya;

public class Animals extends WordCategory {

    public Animals() {
        this.category = "Animals";
        this.wordsWithDescription = new String[5][2];

        // Add Dog
        wordsWithDescription[0][0] = "Dog";
        wordsWithDescription[0][1] = "Dogs are cute";

        // Add Cat
        wordsWithDescription[1][0] = "Cat";
        wordsWithDescription[1][1] = "Cats are mean";

        // Add Cows
        wordsWithDescription[2][0] = "Cow";
        wordsWithDescription[2][1] = "Cows give milk";

        // Add Pig
        wordsWithDescription[3][0] = "Pig";
        wordsWithDescription[3][1] = "Pigs are not clean";

        // Add Lion
        wordsWithDescription[4][0] = "Lion";
        wordsWithDescription[4][1] = "Lion is the king of the Jungle";

    }

}
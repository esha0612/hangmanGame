package org.evergreen.anya;

public class Animals extends WordCategory {

    public Animals() {
        this.category = "Animals";
        this.wordsWithDescription = new String[5][2];
        for (int i = 0; i < 5; i++) {

            // Add Dog
            wordsWithDescription[i][0] = "Dog";
            wordsWithDescription[i][1] = "Dogs are cute";

            // Add Cat
            wordsWithDescription[i][0] = "Cat";
            wordsWithDescription[i][1] = "Cats are mean";

            // Add Cows
            wordsWithDescription[i][0] = "Cow";
            wordsWithDescription[i][1] = "Cows give milk";

            // Add Pig
            wordsWithDescription[i][0] = "Pig";
            wordsWithDescription[i][1] = "Pigs are not clean";

            // Add Lion
            wordsWithDescription[i][0] = "Lion";
            wordsWithDescription[i][1] = "Lion is the kind of the Jungle";

        }
    }

}
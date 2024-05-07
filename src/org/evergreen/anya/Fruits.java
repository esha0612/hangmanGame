package org.evergreen.anya;

public class Fruits extends WordCategory {

    public Fruits() {
        this.category = "Fruits";
        this.wordsWithDescription = new String[5][2];
        for (int i = 0; i < 5; i++) {

            // Add Dog
            wordsWithDescription[i][0] = "Apple";
            wordsWithDescription[i][1] = "Apple keeps a doctor away";

            // Add Cat
            wordsWithDescription[i][0] = "Banana";
            wordsWithDescription[i][1] = "Is sweet";

            // Add Cows
            wordsWithDescription[i][0] = "Strawberry";
            wordsWithDescription[i][1] = "The best berry";

            // Add Pig
            wordsWithDescription[i][0] = "Pears";
            wordsWithDescription[i][1] = "Fiber";

            // Add Lion
            wordsWithDescription[i][0] = "Watermelon";
            wordsWithDescription[i][1] = "Are huge";

        }
    }

}
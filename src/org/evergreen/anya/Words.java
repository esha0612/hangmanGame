package org.evergreen.anya;

public class Words {

    // Constructor()
    private WordCategory[] catogries;

    Words() {

        // Load Words
        catogries = new WordCategory[2];
        catogries[0] = new Animals();
        catogries[1] = new Fruits();

        // Sort Based on Categories
        this.sortCategories();

    }

    private void sortCategories() {
        int n = catogries.length;
        int i, j;
        WordCategory temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (catogries[j].getCategory().compareTo(catogries[j + 1].getCategory()) > 0) {

                    // Swap arr[j] and arr[j+1]
                    temp = catogries[j];
                    catogries[j] = catogries[j + 1];
                    catogries[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }

    }

    public String[] getCategories() {
        String[] categoryNames = new String[this.catogries.length];
        for (int i = 0; i < this.catogries.length; i++) {
            categoryNames[i] = this.catogries[i].getCategory();
        }
        return categoryNames;
    }

    public String[] PickWord(String category) {

        WordCategory wordCategory = this.searchCategory(category);

        int randomIndex = (int) (Math.random() * wordCategory.wordsWithDescription.length);
        return wordCategory.wordsWithDescription[randomIndex];
    }

    private WordCategory searchCategory(String category) {
        for (int i = 0; i < this.catogries.length; i++) {
            if (this.catogries[i].getCategory().equals(category)) {
                return this.catogries[i];
            }
        }
        return null;
    }

}
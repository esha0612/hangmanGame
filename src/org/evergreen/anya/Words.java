package org.evergreen.anya;

public class Words {

    // Constructor()
    private WordCategory[] catogries;

    Words() {

        // Load Words - Inheritence
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
        int i = 0;
        for (WordCategory wc : this.catogries) {
            categoryNames[i] = wc.getCategory();
            i++;
        }
        return categoryNames;
    }

    public String[] PickWord(String category) {

        WordCategory wordCategory = this.searchCategory(category);

        int randomIndex = (int) (Math.random() * wordCategory.wordsWithDescription.length);
        return wordCategory.wordsWithDescription[randomIndex];
    }

    private WordCategory searchCategory(String category) {
        WordCategory wc = null;
        int i = 0;
        while (wc == null) {
            if (this.catogries[i].getCategory().equals(category)) {
                wc = this.catogries[i];
            }
            i++;
        }
        return wc;
    }

}
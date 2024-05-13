public class WordInfo {

    private String word;
    private String description;
    private WordCategory category;

    public WordInfo(String word, String description,WordCategory category){
        this.word = word;
        this.description = description;
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription(){
        return this.description;
    }

    public String getWord(){
        return this.word;
    }

    public WordCategory getCategory(){
        return this.category;
    }
}



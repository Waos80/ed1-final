package ed.lab.ed1final.model;

public class GetWordCountRequest {
    private String word;
    private int wordCount;

    public GetWordCountRequest(String word, int wordCount) {
        this.word = word;
        this.wordCount = wordCount;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getWordsEqualTo() {
        return wordCount;
    }
    public void setWordsEqualTo(int wordCount) {
        this.wordCount = wordCount;
    }
}

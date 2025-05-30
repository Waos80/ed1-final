package ed.lab.ed1final.model;

public class GetPrefixCountRequest {
    private String prefix;
    private int wordsStartingWith;

    public GetPrefixCountRequest(String prefix, int wordsStartingWith) {
        this.prefix = prefix;
        this.wordsStartingWith = wordsStartingWith;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getWordsStartingWith() {
        return wordsStartingWith;
    }

    public void setWordsStartingWith(int prefixCount) {
        this.wordsStartingWith = prefixCount;
    }
}

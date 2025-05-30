package ed.lab.ed1final.service;

import ed.lab.ed1final.trie.Trie;
import org.springframework.stereotype.Service;

@Service
public class TrieService {
    public Trie trie;

    public TrieService() {
        this.trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public void eraseWord(String word) {
        trie.erase(word);
    }

    public int getWordCount(String word) {
        return trie.countWordsEqualTo(word);
    }

    public int getPrefixNumber(String prefix) {
        return trie.countWordsStartingWith(prefix);
    }
}

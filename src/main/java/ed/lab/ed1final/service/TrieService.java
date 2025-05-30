package ed.lab.ed1final.service;

import ed.lab.ed1final.entity.TrieEntity;
import ed.lab.ed1final.trie.Trie;
import org.springframework.stereotype.Service;

@Service
public class TrieService {
    public TrieEntity trie = new TrieEntity();

    public void insertWord(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("No entregar nulos");
        }

        TrieEntity current = trie;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (idx < 0 || idx > 25) {
                throw new IllegalArgumentException("No entregar nulos");
            }
            if (current.getChildren()[idx] == null) {
                current.getChildren()[idx] = new TrieEntity();
            }
            current = current.getChildren()[idx];
            current.setPrefixCount(current.getPrefixCount() + 1);
        }
        current.setWordCount(current.getWordCount() + 1);
    }

    public int countWordsEqualTo(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }

        TrieEntity current = trie;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (idx < 0 || idx > 25) {
                return 0;
            }
            if (current.getChildren()[idx] == null) {
                return 0;
            }
            current = current.getChildren()[idx];
        }
        return current.getWordCount();
    }

    public int countWordsStartingWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return 0;
        }

        TrieEntity current = trie;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (idx < 0 || idx > 25) {
                return 0;
            }
            if (current.getChildren()[idx] == null) {
                return 0;
            }
            current = current.getChildren()[idx];
        }
        return current.getPrefixCount();
    }

    public void eraseWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        if (!exists(word)) {
            return;
        }

        TrieEntity current = trie;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            TrieEntity next = current.getChildren()[idx];
            next.setPrefixCount(next.getPrefixCount() - 1);
            current = next;
        }
        current.setWordCount(current.getWordCount() - 1);
    }

    public boolean exists(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        TrieEntity current = trie;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (idx < 0 || idx > 25) {
                return false;
            }
            if (current.getChildren()[idx] == null) {
                return false;
            }
            current = current.getChildren()[idx];
        }
        return current.getWordCount() > 0;
    }
}

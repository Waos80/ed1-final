package ed.lab.ed1final.trie;

import org.springframework.stereotype.Component;

@Component
public class Trie {
    private static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public int wordCount = 0;
        public int prefixCount = 0;
    }
    public final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }

            current = current.children[idx];
            current.prefixCount++;
        }
        current.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (current.children[idx] == null) {
                return 0;
            }
            current = current.children[idx];
        }
        return current.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (current.children[idx] == null) {
                return 0;
            }
            current = current.children[idx];
        }
        return current.prefixCount;
    }

    public void erase(String word) {
        if (!exists(word)) return;

        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            TrieNode next = current.children[idx];
            next.prefixCount--;
            current = next;
        }
        current.wordCount--;
    }

    public boolean exists(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            current = current.children[idx];
        }
        return current.wordCount > 0;
    }
}

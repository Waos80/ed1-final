package ed.lab.ed1final.trie;

import org.springframework.stereotype.Component;

@Component
public class Trie {
    public boolean isEnd;
    public char val;
    public int count;
    public Trie[] children;

    public Trie() {
        this.isEnd = false;
        this.val = ' ';
        this.count = 0;
        this.children = new Trie[26];
    }

    public void insert(String word) {
        Trie current = this;
        int length = 0;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (idx > 25) {
                throw new IllegalArgumentException();
            }

            if (word.length() == length && current.isEnd) {
                current.count++;
                return;
            }

            if (current.children[idx] != null) {
                current = current.children[idx];
            } else {
                current.children[idx] = new Trie();
                current = current.children[idx];
                current.val = ch;
            }
            length++;
        }
        current.isEnd = true;
        current.count = 1;
    }

    public int countWordsEqualTo(String word) {
        Trie current = this;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (idx > 25) {
                throw new IllegalArgumentException();
            }
            if (current.children[idx] == null) {
                return 0;
            } else {
                current = current.children[idx];
            }
        }
        if (!current.isEnd) {
            return 0;
        }
        return current.count;
    }

    public int countWordsStartingWith(String prefix) {
        Trie current = this;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (idx > 25) {
                throw new IllegalArgumentException();
            }
            if (current.children[idx] == null) {
                return 0;
            } else {
                current = current.children[idx];
            }
        }
        int count = 0;
        if (current.isEnd) {
            count += current.count;
        }

        for (Trie child : current.children) {
            if (child != null) {

            }
        }
        return -1;
    }

    public void erase(String word) {

    }
}

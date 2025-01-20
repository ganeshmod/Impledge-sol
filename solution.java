import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Trie {
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    public List<String> getPrefixes(String word) {
        TrieNode current = root;
        List<String> prefixes = new java.util.ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                break;
            }
            current = current.children[index];
            prefix.append(c);
            if (current.isEndOfWord) {
                prefixes.add(prefix.toString());
            }
        }
        return prefixes;
    }
}

public class Solution {
    private Trie trie;
    private Deque<String[]> queue;

    public Solution() {
        trie = new Trie();
        queue = new ArrayDeque<>();
    }

    public void buildTrie(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String word = line.trim();
                List<String> prefixes = trie.getPrefixes(word);

                for (String prefix : prefixes) {
                    queue.add(new String[]{word, word.substring(prefix.length())});
                }
                trie.insert(word);
            }
        } catch (IOException e) {
            System.out.println("Error occured while reading the file");
            System.exit(0);
        }
    }

    public String[] findLongestCompoundWords() {
        String longestWord = "";
        String secondLongest = "";
        int longestLength = 0;

        while (!queue.isEmpty()) {
            String[] current = queue.poll();
            String word = current[0];
            String suffix = current[1];

            if (trie.search(suffix) && word.length() > longestLength) {
                secondLongest = longestWord;
                longestWord = word;
                longestLength = word.length();
            } else {
                List<String> prefixes = trie.getPrefixes(suffix);
                for (String prefix : prefixes) {
                    queue.add(new String[]{word, suffix.substring(prefix.length())});
                }
            }
        }

        return new String[]{longestWord, secondLongest};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long start = System.currentTimeMillis();

        solution.buildTrie("Input_01.txt");
        String[] result = solution.findLongestCompoundWords();

        long end = System.currentTimeMillis();

        System.out.println("Longest Compound Word: " + result[0]);
        System.out.println("Second Longest Compound Word: " + result[1]);
        System.out.println("Time taken: " + (end - start) / 1000.0 + " seconds");
        // start=System.currentTimeMillis();
        // solution.buildTrie("Input_02.txt");
        // result=solution.findLongestCompoundWords();
        // end=System.currentTimeMillis();
        // System.out.println("Longest Compound Word: " + result[0]);
        // System.out.println("Second Longest Compound Word: " + result[1]);
        // System.out.println("Time taken: " + (end - start) / 1000.0 + " seconds");

    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    private Character character;
    private Map<Character, Node> children;
    private boolean isTerminal;

    
    public Node(Character character) {
        this.character = character;
        this.children = new HashMap<>();
        this.isTerminal = false;
    }

    public Character getCharacter() {
        return character;
    }

    public Map<Character, Node> getChildren() {
        return children;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }
}

public class Trie {
    private final Node root;

    public Trie() {
        this.root = new Node(null);
    }

    
    public void insert(String word) {
        Node current = root;
        
        for (char ch : word.toCharArray()) {
           
            current.getChildren().putIfAbsent(ch, new Node(ch));
            current = current.getChildren().get(ch);
        }
        
        
        current.setTerminal(true);
    }

   
    public boolean contains(String word) {
        Node current = root;
        
        for (char ch : word.toCharArray()) {
        
            if (!current.getChildren().containsKey(ch)) {
                return false;
            }
            current = current.getChildren().get(ch);
        }
        return current.isTerminal();
    }

    
    public List<String> getPrefixes(String word) {
        StringBuilder prefix = new StringBuilder();
        List<String> prefixes = new ArrayList<>();
        Node current = root;

        for (char ch : word.toCharArray()) {
            
            if (!current.getChildren().containsKey(ch)) {
                return prefixes;
            }
            current = current.getChildren().get(ch);
            prefix.append(ch);
            if (current.isTerminal()) {
                prefixes.add(prefix.toString());
            }
        }
        return prefixes;
    }

   // strictly for testing 
    // public static void main(String[] args) {
    //     Trie trie = new Trie();
        
    //     // Test insert and contains
    //     trie.insert("hello");
    //     trie.insert("help");
    //     trie.insert("world");
        
    //     System.out.println("Contains 'hello': " + trie.contains("hello")); // true
    //     System.out.println("Contains 'help': " + trie.contains("help"));   // true
    //     System.out.println("Contains 'hell': " + trie.contains("hell"));   // false
        
    //     // Test getPrefixes
    //     String word = "helping";
    //     List<String> prefixes = trie.getPrefixes(word);
    //     System.out.println("Prefixes of '" + word + "': " + prefixes); // [help]
    // }
}
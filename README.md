# ReadMe: Longest Compound Words Finder

## Overview
This program is designed to identify the longest and second-longest compound words in a given file. A compound word is defined as a word that can be formed entirely from concatenating other words present in the file. The solution uses a **Trie** data structure for efficient prefix searching and compound word validation.

### Key Design Decisions
1. **Trie Data Structure**: The program uses a Trie to store all the words, enabling efficient prefix matching and word validation.
2. **Queue-Based Processing**: A queue is used to iteratively check potential compound words and their remaining suffixes.
3. **Efficient File Processing**: Words are read line by line from the input file, avoiding high memory usage for large files.

### Approach
1. **Build the Trie**: Read words from the input file and insert them into the Trie. For each word, check if any prefixes exist in the Trie and enqueue the remaining suffix for further processing.
2. **Identify Compound Words**: Process the queue to find compound words by checking if their suffixes are valid words in the Trie. Track the longest and second-longest compound words.

## Steps to Execute

1. **Setup**:
   - Ensure Java is installed on your machine.
   - Place the input file (e.g., `Input_02.txt`) in the same directory as the program or provide its full path.

2. **Compile the Code**:
   ```
   javac Solution.java
   ```

3. **Run the Program**:
   ```
   java Solution
   ```

4. **Output**:
   - The program will display the longest and second-longest compound words along with the time taken for execution.

### Input File Format
- The input file should contain one word per line.
- Example:
  ```
  cat
  cats
  catsdogcats
  dog
  dogs
  dogcatsdog
  ```

### Example Output
```
Longest Compound Word: catsdogcats
Second Longest Compound Word: dogcatsdog
Time taken: 0.012 seconds
```

## Dependencies
- No external libraries are required. The program uses Java's standard libraries for file handling and data structures.

## Notes
- If the file path is incorrect or the file cannot be read, the program will terminate with an error message.
- Ensure the input file does not contain invalid characters or empty lines.


# Longest Compound Words

**Impledge Technologies Interview Coding Test 2025**

This repository contains a solution to the Longest Compound Words problem, implemented in Java. The problem statement can be found in the `Exercise_Fresher_Word_Problem.pdf` file.

## Code Execution Procedure

### Prerequisites
- Java Development Kit (JDK) version 8 or newer must be installed.

### Steps to Execute
1. Clone or download the repository to your local machine.
2. Navigate to the directory containing the `Solution.java` file.
3. Replace the file path in the `buildTrie()` method call (in the `main` method) with the relative or absolute path of the input text file.
4. Compile the program:
   ```
   javac Solution.java
   ```
5. Run the program:
   ```
   java Solution
   ```

### Input Format
- The input file should contain one word per line, sorted alphabetically.

### Output
- The program outputs:
  - The longest compound word.
  - The second-longest compound word.
  - The time taken to find the results.

## Problem Description

Compound words are words formed by combining one or more valid words from the input file. Some key properties:
- The input file is sorted alphabetically.
- Compound words are constructed using words that appear earlier in the file (prefix and suffix).
- Words containing characters not part of any valid word in the file cannot be compound words.

## Approach and Algorithm

The solution uses a Trie-based approach, which is efficient and widely adopted for this class of problems. The steps are as follows:

1. **Build the Trie:**
   - Read words from the input file and insert them into the Trie.
   - Simultaneously, identify and enqueue `<word, suffix>` pairs, where the word can be divided into a prefix (already in the Trie) and a suffix.

2. **Initialize Variables:**
   - Track the longest and second-longest compound words, as well as the maximum length encountered.

3. **Process the Queue:**
   - While the queue is not empty, dequeue a `<word, suffix>` pair.
   - Check if the suffix is a valid word in the Trie:
     - If valid and the word's length exceeds the current maximum length, update the longest and second-longest compound words.
     - Otherwise, find prefixes of the suffix, compute new suffixes, and enqueue new `<word, suffix>` pairs.

4. **Output Results:**
   - Return the longest, second-longest compound words and the Time Taken.

## Example

Given the following input file:
```
ant
antman
bat
batman
man
super
superman
```

The output will be:
```
Longest Compound Word: superman
Second Longest Compound Word: batman
Time taken: 0.005 seconds
```

## File Structure
- `Solution.java`: Main Java implementation of the solution.
- `Input_01.txt`: Example input file.
- `Input_02.txt`: Example input file.
- `trie.java`: Trie implemation for the use

## License
This repository is licensed under the MIT License.


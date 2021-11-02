# Spell-Checker

This project uses a hash table to check the spellings of the words in an input file, referencing the provided dictionary file words.txt. The SpellChecker object has the following methods:

The constructor of the object must (itself or by calling other methods) parse the dictionary file, storing the words in a HashSet instance.

public SpellChecker(String filename) - constructor: parameter is the string of the dictionary file name. 

public List<String> getIncorrectWords(String filename) - returns a list of all words in the input file that are incorrectly spelled according to the dictionary file provided to the constructor. A word is defined as a sequence of characters with whitespace (one or more spaces and/or tabs) on either side.

public Set<String> getSuggestions(String word) - returns a set of all potential suggestions for the incorrectly spelled word that is provided as input as follows: 
  Add one character - add a character at every point in the string (including at the very beginning and end)
  Remove one character - remove one character at a time from each position in the string
  Swap adjacent characters - swap every pair of adjacent characters in the string

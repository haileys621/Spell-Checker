import java.io.*;
import java.util.*;

public class SpellChecker implements SpellCheckerInterface{
    HashSet<String> dict;
    public SpellChecker(String filename){
        File file = new File(filename);
        dict = new HashSet<String>(); 
        
        try{
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()){
                String str = fileReader.nextLine();
                String[] lineWords = str.toLowerCase().split("\\s+");
                for(int i = 0; i < lineWords.length; i++){
                    dict.add(lineWords[i]);
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public List<String> getIncorrectWords(String filename){
        File file = new File(filename);
        ArrayList<String> incorrectWords = new ArrayList<String>(); 
        
        try{
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()){
                String str = fileReader.nextLine();
                String[] lineWords = str.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split("\\s+");
                for(int i = 0; i < lineWords.length; i++){
                    if(!(dict.contains(lineWords[i])) && !(lineWords[i].equals(""))){
                        incorrectWords.add(lineWords[i]);
                    }
                }
            }
            return incorrectWords;
        }
        catch(FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

	public Set<String> getSuggestions(String word){
        HashSet<String> suggestions = new HashSet<String>();
        
        //inserts a character at every place in word
        for(int i = 0; i < word.length()+1; i++){
            for(char j = 'a'; j <= 'z'; j++){
                String newWord = word.substring(0, i) + String.valueOf(j) + word.substring(i);
                if(dict.contains(newWord)){
                    suggestions.add(newWord);
                }
            }
        }

        // removes a character at each place in word
        for(int i = 0; i < word.length(); i++){
            String newWord = word.substring(0, i) + word.substring(i+1);
            if(dict.contains(newWord)){
                suggestions.add(newWord);
            }
        }

        // swaps each adjacent pair of characters in word
        for(int i = 1; i < word.length(); i++){
            String newWord = word.substring(0, i-1) + word.substring(i, i+1) + word.substring(i-1, i)  + word.substring(i+1);
            if(dict.contains(newWord)){
                suggestions.add(newWord);
            }
        }
        return suggestions;
    }
}
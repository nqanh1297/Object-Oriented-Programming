import java.util.HashMap;
import java.util.Map;
public class WordCounter {
    public Map<String,Integer> countWordFrequency(String text) {
        Map<String,Integer> wordCount=new HashMap<>();

        text= normalizeText(text);
        String[] words = text.split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
        }

        return wordCount;
    }

    public String normalizeText(String text) {
        text = text.toLowerCase();
        text = text.replaceAll("[^a-z0-9\\s]", "");
        return text;
    }
}


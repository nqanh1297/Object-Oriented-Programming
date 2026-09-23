import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "Java is powerful. Java is simple, and Java is popular! "
                + "Python is also popular, but Java is widely used in enterprise applications.";

        WordCounter wordCounter = new WordCounter();
        WordAnalyzer wordAnalyzer = new WordAnalyzer();

        Map<String, Integer> wordCount = wordCounter.countWordFrequency(text);

        List<Map.Entry<String, Integer>> sortedList = wordAnalyzer.sortByFrequency(wordCount);

        wordAnalyzer.printAllWordCounts(sortedList);
        System.out.println();

        wordAnalyzer.printMostFrequentWord(sortedList);
        System.out.println();

        wordAnalyzer.printUniqueWords(wordCount);
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordAnalyzer {

    public List<Map.Entry<String, Integer>> sortByFrequency(Map<String, Integer> wordCount) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());

        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        return sortedList;
    }

    public void printAllWordCounts(List<Map.Entry<String, Integer>> sortedList) {
        System.out.println("Tan suat xuat hien cua tung tu:");
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void printMostFrequentWord(List<Map.Entry<String, Integer>> sortedList) {
        if (!sortedList.isEmpty()) {
            Map.Entry<String, Integer> mostFrequent = sortedList.get(0);
            System.out.println("Tu xuat hien nhieu nhat: "
                    + mostFrequent.getKey()
                    + " (" + mostFrequent.getValue() + " lan)");
        }
    }

    public void printUniqueWords(Map<String, Integer> wordCount) {
        System.out.println("Cac tu chi xuat hien 1 lan:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}
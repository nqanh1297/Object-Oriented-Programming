import java.util.*;

public class WordCounter {

    // Dùng HashMap
    public Map<String, Integer> analyze(String text) {
        Map<String, Integer> map = new HashMap<>();

        text = text.toLowerCase();
        text = text.replaceAll("[^a-z\\s]", "");

        String[] words = text.split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        return map;
    }

    public void displayResult(Map<String, Integer> map) {
        System.out.println("Danh sach tu va so lan xuat hien:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void findMaxWord(Map<String, Integer> map) {
        String maxWord = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        System.out.println("Tu xuat hien nhieu nhat: " + maxWord + " (" + max + " lan)");
    }
    public void analyzeWithList(String text) {
        List<String> list = new ArrayList<>();

        text = text.toLowerCase();
        text = text.replaceAll("[^a-z\\s]", "");
        String[] words = text.split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                boolean found = false;

                for (String w : list) {
                    if (w.equals(word)) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    list.add(word);
                }
            }
        }

        System.out.println("Danh sach tu (ArrayList): " + list);
    }
}
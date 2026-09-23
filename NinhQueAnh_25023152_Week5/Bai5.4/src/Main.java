import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String text = "Hello world. This is a java program. Hello java, hello world.";

        WordCounter wc = new WordCounter();

        Map<String, Integer> result = wc.analyze(text);
        wc.displayResult(result);
        System.out.println();
        wc.findMaxWord(result);

        System.out.println();

        wc.analyzeWithList(text);
    }
}
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileReader fr = null;
        BufferedReader br = null;
        Map<String, String> config = new LinkedHashMap<>();

        try {
            System.out.print("Nhap duong dan file config: ");
            String filePath = sc.nextLine();

            fr = new FileReader(filePath);
            br = new BufferedReader(fr);

            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                if (line.isEmpty()) continue;

                int pos = line.indexOf('=');
                if (pos == -1) {
                    throw new InvalidConfigException("dong " + lineNumber + " khong co dau '='");
                }

                String key = line.substring(0, pos).trim();
                String value = line.substring(pos + 1).trim();

                if (key.isEmpty()) {
                    throw new InvalidConfigException("dong " + lineNumber + " co key rong");
                }

                if (value.isEmpty()) {
                    throw new InvalidConfigException("dong " + lineNumber + " co value rong");
                }

                config.put(key, value);
            }

            if (!config.containsKey("username")) {
                throw new InvalidConfigException("thieu username");
            }

            if (!config.containsKey("timeout")) {
                throw new InvalidConfigException("thieu timeout");
            }

            int timeout = Integer.parseInt(config.get("timeout"));
            if (timeout <= 0) {
                throw new InvalidConfigException("timeout phai > 0");
            }

            if (config.containsKey("maxConnections")) {
                int maxConnections = Integer.parseInt(config.get("maxConnections"));
                if (maxConnections < 1) {
                    throw new InvalidConfigException("maxConnections phai >= 1");
                }
            }

            for (Map.Entry<String, String> entry : config.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }

            System.out.println("Config loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Loi dong BufferedReader.");
            }

            try {
                if (fr != null) fr.close();
            } catch (IOException e) {
                System.out.println("Loi dong FileReader.");
            }

            sc.close();
            System.out.println("Program finished.");
        }
    }
}
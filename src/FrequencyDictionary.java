import java.io.BufferedReader;
import java.util.Map;
import java.util.HashMap;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrequencyDictionary {
    public static Map<Character, Integer> createFrequencyDictionary(String inputFile) throws IOException {
        // Создаем словарь
        Map<Character, Integer> frequencyDictionary = new HashMap<>();

        // Инициализируем 0 частоту для всех строчных, а потом заглавных латинских букв
        for (char letter = 'a'; letter <= 'z'; letter++) {
            frequencyDictionary.put(letter, 0);
            frequencyDictionary.put(Character.toUpperCase(letter), 0);
        }

        // Читаем символы из входного файла
        try (BufferedReader r = new BufferedReader(new FileReader(inputFile))) {
            int character;
            while ((character = r.read()) != -1) {

                // Проверяем, является ли символ буквой латинского алфавита
                if (Character.isLetter(character)) {

                    // Увеличиваем частоты латинских букв
                    char curChar = (char) character;
                    frequencyDictionary.put(curChar, frequencyDictionary.getOrDefault(curChar, 0) + 1);
                }
            }
        }
        return frequencyDictionary;
    }
    // Метод записи словаря в выходной файл
    public static void writeFrequencyDictionary(Map<Character, Integer> frequencyDictionary, String outputFile) throws IOException {
        try (FileWriter w = new FileWriter(outputFile)) {
            for (Map.Entry<Character, Integer> entry : frequencyDictionary.entrySet()) {
                char letter = entry.getKey();
                if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {
                    w.write(entry.getKey() + ": " + entry.getValue() + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи в выходной файл: " + e.getMessage());
        }
    }
}

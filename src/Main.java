import java.util.Map;
import java.io.IOException;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Вводим имя входного файла с клавиатуры
        System.out.print("Введите имя входного файла: ");
        String inputFile = scan.nextLine();

        // Вводим имя выходного файла с клавиатуры
        System.out.print("Введите имя выходного файла: ");
        String outputFile = scan.nextLine();
        try {
            // Создаем частотный словарь для латинских букв
            Map<Character, Integer> frequencyDictionary = FrequencyDictionary.createFrequencyDictionary(inputFile);

            // Записываем этот словарь в выходной файл
            FrequencyDictionary.writeFrequencyDictionary(frequencyDictionary, outputFile);
        } catch (IOException e) {
            System.err.println("Ошибка в чтении входного файла: " + e.getMessage());
        }
    }
}
/*
Для тестирования созданы 3 файла. Файл Start.txt можно использовать, как пример входного файла.
Файл находится в том же каталоге, поэтому обращаемся к файлу через относительный путь (Start.txt).
Файл Finish.txt можно использовать, как выходной файл (тоже в рабочем каталоге). Можно создать файл
с ограниченным доступом, если использовать его как входной или выходной файл, то получим Exception, в
котором будет указано, что данный файл недоступен. Для чтения из файла нужен уже существующий файл,
иначе получаем Exception. Для записи необязательно существование выходного файла, если файл с введенным
именем не существует, то создается новый файл в рабочем каталоге с указанным пользователем именем.
 */
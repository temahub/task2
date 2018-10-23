import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TransformUtil {

    public static String readLine(String fileName, int lineNumber) {
        String result = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            for (int i = 0; i < lineNumber - 1; i++)
            {
                bufferedReader.readLine();
            }
            result = bufferedReader.readLine();
        }catch (FileNotFoundException e){
            System.err.println(String.format("File %s is missing."));
        }catch (IOException e){
            System.err.println(String.format("Line is missing."));
        }

        return result;
    }

    public static String readLine(String fileName) {
        String result = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            result = bufferedReader.readLine();
        }catch (FileNotFoundException e){
            System.err.println(String.format("File %s is missing."));
        }catch (IOException e){
            System.err.println(String.format("Line is missing."));
        }

        return result;
    }

    public static List<String> transformLineToListUnique(String fileName, int lineNumber){
        String line = readLine(fileName, lineNumber);

        List<String> lLine = new ArrayList<>();
        Stream.of(line.split("[^A-Za-zА-Яа-я]+"))
                .map(String::toLowerCase)
                .distinct().sorted()
                .forEach(lLine::add);

        return lLine;
    }

    public static List<String> transformLineToListNotUnique(String fileName, int lineNumber){
        String line = readLine(fileName, lineNumber);

        List<String> lLine = new ArrayList<>();
        Stream.of(line.split("[^A-Za-zА-Яа-я]+"))
                .map(String::toLowerCase)
                .forEach(lLine::add);

        return lLine;
    }
}

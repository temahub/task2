import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransformUtil {

    public static String readLineFromJSONFile(String fileName, String objectName, String arrayName, String stringName){
        String result = "";

        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader
                    (new FileInputStream(fileName), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            JSONObject jobject = new JSONObject(responseStrBuilder.toString());
            jobject = jobject.getJSONObject(objectName);
            JSONArray jarray = jobject.getJSONArray(arrayName);
            jobject = (JSONObject) jarray.get(0);
            result = jobject.get(stringName).toString();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String readLineFromTextFile(String fileName, int lineNumber) {
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

    public static String readLineFromTextFile(String fileName) {
        return readLineFromTextFile(fileName, 1);
    }

    public static List<String> transformLineToArrayList(String fileName, int lineNumber){
        String line = readLineFromTextFile(fileName, lineNumber);

        return splitStringToArrayList(line);
    }

    public static List<String> transformLineToArrayList(String fileName, String objectName, String arrayName,
                                                        String stringName){
        String line = readLineFromJSONFile(fileName, objectName, arrayName, stringName);

        return splitStringToArrayList(line);
    }

    private static List<String> splitStringToArrayList(String line){
        List<String> lLine = new ArrayList<>();
        Stream.of(line.split("[^A-Za-zА-Яа-я]+"))
                .map(String::toLowerCase)
                .forEach(lLine::add);

        return lLine;
    }

    public static List<String> transformLineToArrayListUnique(String fileName, int lineNumber){
        return transformLineToArrayList(fileName, lineNumber)
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> transformLineToArrayListUnique(String fileName, String objectName, String arrayName,
                                                              String stringName){
        return transformLineToArrayList(fileName, objectName, arrayName, stringName)
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
}

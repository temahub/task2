import java.util.List;

public class LineAndWordCompare {

    private String searchingWord;
    private int amountSearchingWord;
    private int amountPunctuation;

    public LineAndWordCompare(String fileName1, int iLine, String fileNameWord){
        searchingWord = TransformUtil.readLineFromTextFile(fileNameWord);
        amountSearchingWord = countWordInLine(TransformUtil
                .transformLineToArrayList(fileName1, iLine) , searchingWord);
        amountPunctuation = countPunctuation(TransformUtil.readLineFromTextFile(fileName1, iLine));
    }

    public LineAndWordCompare(String fileName, String objectName, String arrayName,
                              String stringName, String fileNameWord){
        searchingWord = TransformUtil.readLineFromTextFile(fileNameWord);
        amountSearchingWord = countWordInLine(TransformUtil.
                transformLineToArrayList(fileName, objectName, arrayName, stringName), searchingWord);
        amountPunctuation = countPunctuation(TransformUtil.
                readLineFromJSONFile(fileName, objectName, arrayName, stringName));
    }

    private int countWordInLine(List<String> line, String word){
        int count = 0;
        for (String s : line) {
            if (s.equalsIgnoreCase(word)){
                count++;
            }
        }
        return count;
    }

    private int countPunctuation(String line){
        return line.replaceAll("\\w+", "").replaceAll(" ", "").length();
    }

    public String getSearchingWord() {
        return searchingWord;
    }

    public int getAmountSearchingWord() {
        return amountSearchingWord;
    }

    public int getAmountPunctuation() {
        return amountPunctuation;
    }

    @Override
    public String toString() {
        return  "searchingWord = '" + searchingWord + '\'' +
                " found in text " + amountSearchingWord + " times" +
                "\nAmount punctuation in text = " + amountPunctuation;
    }
}

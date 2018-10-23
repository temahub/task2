import java.util.List;

public class TwoLinesCompare {

    static void compareTwoLines(String fileName, int iLine1, int iLine2){

        List<String> lLine1 = TransformUtil.transformLineToListUnique(fileName, iLine1);
        List<String> lLine2 = TransformUtil.transformLineToListUnique(fileName, iLine2);

        for (String s : lLine1) {
            if (!lLine2.contains(s)){
                System.out.println(s);
            }
        }
    }

    static void countWordAndPunctuation(String fileName1, int iLine, String fileNameWord){
        String sLine = TransformUtil.readLine(fileName1, iLine);
        String word = TransformUtil.readLine(fileNameWord);
        List<String> lLine = TransformUtil.transformLineToListNotUnique(fileName1, iLine);

        System.out.println(String.format("\"%s\" found %d times", word, countWordInLine(lLine, word)));
        System.out.println(String.format("Number of punctuation marks: %d", countPunctuation(sLine)));
    }

    private static int countWordInLine(List<String> line, String word){
        int count = 0;

        for (String s : line) {
            if (s.equalsIgnoreCase(word)){
                count++;
            }
        }

        return count;
    }

    private static int countPunctuation(String line){
        return line.replaceAll("\\w+", "").replaceAll(" ", "").length();
    }
}

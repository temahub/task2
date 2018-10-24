import java.util.List;

public class LineAndWordCompare {

    static void countWordAndPunctuation(String fileName1, int iLine, String fileNameWord){
        String sLine = TransformUtil.readLineFromTextFile(fileName1, iLine);
        String word = TransformUtil.readLineFromTextFile(fileNameWord);
        List<String> lLine = TransformUtil.transformLineToArrayList(fileName1, iLine);

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

import java.util.List;

public class TwoLinesCompare {

    static void compareTwoLines(String fileName, int iLine1, int iLine2){
        List<String> lLine1 = TransformUtil.transformLineToArrayListUnique(fileName, iLine1);
        List<String> lLine2 = TransformUtil.transformLineToArrayListUnique(fileName, iLine2);

        for (String s : lLine1) {
            if (!lLine2.contains(s)){
                System.out.println(s);
            }
        }
    }
}

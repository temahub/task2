import java.util.ArrayList;
import java.util.List;

public class TwoLinesCompare {

    private List<String> resultComparing = new ArrayList<>();

    public TwoLinesCompare(String fileName, int iLine1, int iLine2){
        compareTwoLists(TransformUtil.transformLineToArrayListUnique(fileName, iLine1),
                TransformUtil.transformLineToArrayListUnique(fileName, iLine2));
    }

    public TwoLinesCompare(String fileName, String objectName, String arrayName,
                           String stringName1, String stringName2){
        compareTwoLists(TransformUtil.transformLineToArrayListUnique(fileName, objectName, arrayName, stringName1),
                TransformUtil.transformLineToArrayListUnique(fileName, objectName, arrayName, stringName2));
    }

    private void compareTwoLists(List<String> list1, List<String> list2){
        for (String s : list1) {
            if (!list2.contains(s)){
                resultComparing.add(s);
            }
        }
    }

    public List<String> getResultComparing() {
        return resultComparing;
    }

    @Override
    public String toString() {
        return "Result of comparing two lines: " + resultComparing;
    }
}

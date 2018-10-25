public class Testing {

    public static void main(String[] args) {
        String text1 = "src\\main\\resources\\text1.txt";
        String text2Word = "src\\main\\resources\\text2.txt";
        String textJSON = "src\\main\\resources\\text.JSON";
        int line1 = 1, line2 = 2, line3 = 3;
        String jsonObject = "goal", jsonArray = "texts",
                jsonString1 = "line1", jsonString2 = "line2", jsonString3 = "line3";

        TwoLinesCompare textTwoLinesCompare = new TwoLinesCompare(text1, line1, line3);
        TwoLinesCompare jsonTwoLinesCompare = new TwoLinesCompare
                (textJSON, jsonObject, jsonArray, jsonString1, jsonString3);

        LineAndWordCompare textLineAndWordCompare = new LineAndWordCompare(text1, line2, text2Word);
        LineAndWordCompare jsonLineAndWordCompare = new LineAndWordCompare
                (textJSON, jsonObject, jsonArray, jsonString2, text2Word);

        System.out.println(textTwoLinesCompare + "\n" + jsonTwoLinesCompare +
                "\n\n" + textLineAndWordCompare + "\n" + jsonLineAndWordCompare + "\n");
        System.out.println(ParserPomXML.readMavenVariable("env.ABC"));
    }
}

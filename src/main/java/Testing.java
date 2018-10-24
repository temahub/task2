public class Testing {

    public static void main(String[] args) {
        String text1 = "src\\main\\resources\\text1.txt";
        String text2Word = "src\\main\\resources\\text2.txt";
        int line1 = 1, line2 = 2, line3 = 3;

        TwoLinesCompare.compareTwoLines(text1, line1, line3);
        System.out.println();
        LineAndWordCompare.countWordAndPunctuation(text1, line2, text2Word);
        System.out.println();

        System.out.println(ParserPomXML.readMavenVariable("env.ABC"));

    }
}

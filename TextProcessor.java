import java.util.Arrays;

public class TextProcessor {
    public static int countWords(String sentence) {
        if (sentence.isBlank()){
            System.out.println("please enter a sentence");
            return 0;
        }
        int countWords = sentence.split(" ").length;

        return countWords;

    }
    public static String replaceWord(String text, String oldWord, String newWord) {
        return text.replace(oldWord, newWord);
    }


    public static void main(String[] args) {
        String sentence ="Java is fun and Java is powerful";
        System.out.println("Number of words"+" "+countWords(sentence));
        System.out.println(replaceWord(sentence, "Java", "programing"));

    }
}

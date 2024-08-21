import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        GimatriaToWords gimatriaToWords = new GimatriaToWords(10);
        WordsToGimatria wordsToGimatria = new WordsToGimatria("Hאבא");
        System.out.println(wordsToGimatria.getValue());
//        System.out.println(gimatriaToWords.randMatchingWord());
//        System.out.println(Constants.getNounsToGimatria());
        System.out.println(gimatriaToWords.getGimatriaWords());
        System.out.println(gimatriaToWords.randMatchingWord());
    }
}
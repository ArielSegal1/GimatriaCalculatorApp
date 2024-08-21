import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GimatriaToWords {
    private int value;

    public GimatriaToWords(int v) {
        this.value = v;
    }

    public int getValue() {
        return value;
    }

    public List<String> getGimatriaWords() {
        HashMap<String, Integer> nounsGimatria = Constants.getNounsToGimatria();
        List<String> matchWords = new ArrayList<>();
        for (String word : nounsGimatria.keySet()) {
            if (nounsGimatria.get(word) == this.value) {
                matchWords.add(word);
            }
        }
        return matchWords;

    }

    public String randMatchingWord() {
        Random rand = new Random();
        if (getGimatriaWords().isEmpty()) {
            return "No matching word";
        }
        return getGimatriaWords().get(rand.nextInt(getGimatriaWords().size()));


    }
}

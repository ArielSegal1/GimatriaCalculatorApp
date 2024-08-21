import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GimatriaToWords {
    private final int value;

    public GimatriaToWords(int v) {
        this.value = v;
    }

    public int getValue() {
        return value;
    }

    public List<String> getGimatriaWords() {
        HashMap<Integer, ArrayList<String>> nounsGimatria = Constants.getNounsToGimatria();
        return nounsGimatria.get(this.value);

    }

    public String randMatchingWord() {
        Random rand = new Random();
        if (getGimatriaWords().isEmpty()) {
            return "No matching word";
        }
        return getGimatriaWords().get(rand.nextInt(getGimatriaWords().size()));


    }
}

public class WordsToGimatria {
    private final String word;
    private final int value;

    public WordsToGimatria(String w) {
        this.word = sanitizeWord(w);
        this.value = wordToGimatria();
    }
    private String sanitizeWord(String word) {
        return word.replaceAll("[^א-ת ]", ""); // Keep only Hebrew letters and spaces
    }
    public String getWord() {
        return word;
    }

    public int getValue() {
        return value;
    }

    private char[] wordToCharArray() {
        return this.word.toCharArray();
    }

    private int letterToGimatria(char letter) {
        Integer value = Constants.GIMATRIA_TRANSLATIONS.get(letter);
        if (value == null) {
            System.out.println("The letter " + letter + " is not in the keys.");
            return 0; // Default value
        }
        return value;
    }

    private int wordToGimatria() {
        char[] letters = wordToCharArray();
        int value = 0;
        for (char letter : letters) {
            value += letterToGimatria(letter);
        }
        return value;
    }

}

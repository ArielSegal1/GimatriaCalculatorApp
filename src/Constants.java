// File: src/Constants.java

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Constants {
    public static final Map<Character, Integer> GIMATRIA_TRANSLATIONS;

    static {
        GIMATRIA_TRANSLATIONS = new HashMap<>();
        GIMATRIA_TRANSLATIONS.put('א', 1);
        GIMATRIA_TRANSLATIONS.put('ב', 2);
        GIMATRIA_TRANSLATIONS.put('ג', 3);
        GIMATRIA_TRANSLATIONS.put('ד', 4);
        GIMATRIA_TRANSLATIONS.put('ה', 5);
        GIMATRIA_TRANSLATIONS.put('ו', 6);
        GIMATRIA_TRANSLATIONS.put('ז', 7);
        GIMATRIA_TRANSLATIONS.put('ח', 8);
        GIMATRIA_TRANSLATIONS.put('ט', 9);
        GIMATRIA_TRANSLATIONS.put('י', 10);
        GIMATRIA_TRANSLATIONS.put('כ', 20);
        GIMATRIA_TRANSLATIONS.put('ל', 30);
        GIMATRIA_TRANSLATIONS.put('מ', 40);
        GIMATRIA_TRANSLATIONS.put('נ', 50);
        GIMATRIA_TRANSLATIONS.put('ס', 60);
        GIMATRIA_TRANSLATIONS.put('ע', 70);
        GIMATRIA_TRANSLATIONS.put('פ', 80);
        GIMATRIA_TRANSLATIONS.put('צ', 90);
        GIMATRIA_TRANSLATIONS.put('ק', 100);
        GIMATRIA_TRANSLATIONS.put('ר', 200);
        GIMATRIA_TRANSLATIONS.put('ש', 300);
        GIMATRIA_TRANSLATIONS.put('ת', 400);
        GIMATRIA_TRANSLATIONS.put('ך', 20);
        GIMATRIA_TRANSLATIONS.put('ם', 40);
        GIMATRIA_TRANSLATIONS.put('ן', 50);
        GIMATRIA_TRANSLATIONS.put('ף', 80);
        GIMATRIA_TRANSLATIONS.put('ץ', 90);
        GIMATRIA_TRANSLATIONS.put(' ', 0);
    }

    private static HashMap<Integer, ArrayList<String>> nounToGimatria(String word) {

        WordsToGimatria wordsToGimatria = new WordsToGimatria(word);
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> wordArray = new ArrayList<>();
        wordArray.add(word);
        map.put(wordsToGimatria.getValue(), wordArray);
        return map;
    }

    private static boolean checkExist(HashMap<Integer, ArrayList<String>> map, int value) {
        return map.get(value) == null;
    }

    public static HashMap<Integer, ArrayList<String>> getNounsToGimatria() {
        List<String> nouns = getNouns();
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (String noun : nouns) {
            WordsToGimatria wordsToGimatria = new WordsToGimatria(noun);
            if (checkExist(map, wordsToGimatria.getValue())) {
                map.putAll(nounToGimatria(noun));
            } else {
                map.get(wordsToGimatria.getValue()).add(noun);
            }
        }
        return map;
    }


    private static List<String> getNouns() {
        List<String> words = new ArrayList<>();
        try {
            File hebrewFile = new File("Hebrewnouns.txt");
            Scanner myReader = new Scanner(hebrewFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                words.add(data);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return words;
    }

}
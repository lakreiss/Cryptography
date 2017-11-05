import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by liamkreiss on 11/5/17.
 */
public abstract class Language {
    private int alphabetSize;
    private HashMap<Character, Integer> reverseAlphabet;
    private HashMap<Integer, Character> alphabet;
    private double[] letterFrequencies;
    private String name;

    public abstract int getAlphabetSize();

    public abstract int getAlphabetValue(char c);

    public abstract char getAlphabetLetter(int i);

    public abstract double[] getLetterFrequencies();

    public abstract boolean isValidLetter(char c);

    public abstract String getName();

}
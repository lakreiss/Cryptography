import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by liamkreiss on 11/5/17.
 */
public class English extends Language {

    private int ALPHABET_SIZE = 26;
    private HashMap<Character, Integer> reverseAlphabet;
    private HashMap<Integer, Character> alphabet;
    private double[] letterFrequencies;
    private final String NAME = "ENGLISH";

    public English() throws FileNotFoundException {
        this.alphabet = makeEnglishAlphabet();
        this.reverseAlphabet = makeEnglishReverseAlphabet();
        this.letterFrequencies = makeLetterFrequencies();
    }

    @Override
    public boolean isValidLetter(char c) {
        return (c > 96 && c < 123);
    }

    @Override
    public String getName() {
        return NAME;
    }

    public double[] makeLetterFrequencies() throws FileNotFoundException {
        double[] letterFrequency = new double[ALPHABET_SIZE];
        Scanner lf = new Scanner(new File("english_letter_frequency.txt"));
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            letterFrequency[i] = lf.nextDouble();
        }
        return letterFrequency;
    }

    private HashMap<Character, Integer> makeEnglishReverseAlphabet() {
        HashMap<Character, Integer> reverseEnglishAlphabet = new HashMap<>();
        reverseEnglishAlphabet.put('a', 0);
        reverseEnglishAlphabet.put('b', 1);
        reverseEnglishAlphabet.put('c', 2);
        reverseEnglishAlphabet.put('d', 3);
        reverseEnglishAlphabet.put('e', 4);
        reverseEnglishAlphabet.put('f', 5);
        reverseEnglishAlphabet.put('g', 6);
        reverseEnglishAlphabet.put('h', 7);
        reverseEnglishAlphabet.put('i', 8);
        reverseEnglishAlphabet.put('j', 9);
        reverseEnglishAlphabet.put('k', 10);
        reverseEnglishAlphabet.put('l', 11);
        reverseEnglishAlphabet.put('m', 12);
        reverseEnglishAlphabet.put('n', 13);
        reverseEnglishAlphabet.put('o', 14);
        reverseEnglishAlphabet.put('p', 15);
        reverseEnglishAlphabet.put('q', 16);
        reverseEnglishAlphabet.put('r', 17);
        reverseEnglishAlphabet.put('s', 18);
        reverseEnglishAlphabet.put('t', 19);
        reverseEnglishAlphabet.put('u', 20);
        reverseEnglishAlphabet.put('v', 21);
        reverseEnglishAlphabet.put('w', 22);
        reverseEnglishAlphabet.put('x', 23);
        reverseEnglishAlphabet.put('y', 24);
        reverseEnglishAlphabet.put('z', 25);
        return reverseEnglishAlphabet;
    }

    private HashMap<Integer, Character> makeEnglishAlphabet() {
        HashMap<Integer, Character> englishAlphabet = new HashMap<>();
        englishAlphabet.put(0, 'a');
        englishAlphabet.put(1, 'b');
        englishAlphabet.put(2, 'c');
        englishAlphabet.put(3, 'd');
        englishAlphabet.put(4, 'e');
        englishAlphabet.put(5, 'f');
        englishAlphabet.put(6, 'g');
        englishAlphabet.put(7, 'h');
        englishAlphabet.put(8, 'i');
        englishAlphabet.put(9, 'j');
        englishAlphabet.put(10, 'k');
        englishAlphabet.put(11, 'l');
        englishAlphabet.put(12, 'm');
        englishAlphabet.put(13, 'n');
        englishAlphabet.put(14, 'o');
        englishAlphabet.put(15, 'p');
        englishAlphabet.put(16, 'q');
        englishAlphabet.put(17, 'r');
        englishAlphabet.put(18, 's');
        englishAlphabet.put(19, 't');
        englishAlphabet.put(20, 'u');
        englishAlphabet.put(21, 'v');
        englishAlphabet.put(22, 'w');
        englishAlphabet.put(23, 'x');
        englishAlphabet.put(24, 'y');
        englishAlphabet.put(25, 'z');
        return englishAlphabet;
    }

    public int getAlphabetSize() {
        return ALPHABET_SIZE;
    }

    public int getAlphabetValue(char c) {
        return reverseAlphabet.get(c);
    }

    public char getAlphabetLetter(int i) {
        return alphabet.get(i).charValue();
    }

    public double[] getLetterFrequencies() {
        return letterFrequencies;
    }
}
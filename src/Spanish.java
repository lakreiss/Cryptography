import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by liamkreiss on 11/5/17.
 */
public class Spanish extends Language {
    private int ALPHABET_SIZE = 33;
    private HashMap<Character, Integer> reverseAlphabet;
    private HashMap<Integer, Character> alphabet;
    private double[] letterFrequencies;
    private final String NAME = "SPANISH";


    public Spanish() throws FileNotFoundException {
        this.alphabet = makeSpanishAlphabet();
        this.reverseAlphabet = makeSpanishReverseAlphabet();
        this.letterFrequencies = makeLetterFrequencies();
    }

    @Override
    public boolean isValidLetter(char c) {
        //used UNICODE char conversion
        return (c > 96 && c < 123) || c == 225 || c == 233 || c == 237 || c == 243 || c == 250 || c == 252 || c == 241;
    }

    @Override
    public String getName() {
        return NAME;
    }

    public double[] makeLetterFrequencies() throws FileNotFoundException {
        double[] letterFrequency = new double[ALPHABET_SIZE];
        Scanner lf = new Scanner(new File("spanish_letter_frequency.txt"));
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            letterFrequency[i] = lf.nextDouble();
        }
        return letterFrequency;
    }

    private HashMap<Character, Integer> makeSpanishReverseAlphabet() {
        HashMap<Character, Integer> reverseSpanishAlphabet = new HashMap<>();
        reverseSpanishAlphabet.put('a', 0);
        reverseSpanishAlphabet.put('b', 1);
        reverseSpanishAlphabet.put('c', 2);
        reverseSpanishAlphabet.put('d', 3);
        reverseSpanishAlphabet.put('e', 4);
        reverseSpanishAlphabet.put('f', 5);
        reverseSpanishAlphabet.put('g', 6);
        reverseSpanishAlphabet.put('h', 7);
        reverseSpanishAlphabet.put('i', 8);
        reverseSpanishAlphabet.put('j', 9);
        reverseSpanishAlphabet.put('k', 10);
        reverseSpanishAlphabet.put('l', 11);
        reverseSpanishAlphabet.put('m', 12);
        reverseSpanishAlphabet.put('n', 13);
        reverseSpanishAlphabet.put('o', 14);
        reverseSpanishAlphabet.put('p', 15);
        reverseSpanishAlphabet.put('q', 16);
        reverseSpanishAlphabet.put('r', 17);
        reverseSpanishAlphabet.put('s', 18);
        reverseSpanishAlphabet.put('t', 19);
        reverseSpanishAlphabet.put('u', 20);
        reverseSpanishAlphabet.put('v', 21);
        reverseSpanishAlphabet.put('w', 22);
        reverseSpanishAlphabet.put('x', 23);
        reverseSpanishAlphabet.put('y', 24);
        reverseSpanishAlphabet.put('z', 25);
        reverseSpanishAlphabet.put('á', 26);
        reverseSpanishAlphabet.put('é', 27);
        reverseSpanishAlphabet.put('í', 28);
        reverseSpanishAlphabet.put('ñ', 29);
        reverseSpanishAlphabet.put('ó', 30);
        reverseSpanishAlphabet.put('ú', 31);
        reverseSpanishAlphabet.put('ü', 32);
        return reverseSpanishAlphabet;
    }

    private HashMap<Integer, Character> makeSpanishAlphabet() {
        HashMap<Integer, Character> spanishAlphabet = new HashMap<>();
        spanishAlphabet.put(0, 'a');
        spanishAlphabet.put(1, 'b');
        spanishAlphabet.put(2, 'c');
        spanishAlphabet.put(3, 'd');
        spanishAlphabet.put(4, 'e');
        spanishAlphabet.put(5, 'f');
        spanishAlphabet.put(6, 'g');
        spanishAlphabet.put(7, 'h');
        spanishAlphabet.put(8, 'i');
        spanishAlphabet.put(9, 'j');
        spanishAlphabet.put(10, 'k');
        spanishAlphabet.put(11, 'l');
        spanishAlphabet.put(12, 'm');
        spanishAlphabet.put(13, 'n');
        spanishAlphabet.put(14, 'o');
        spanishAlphabet.put(15, 'p');
        spanishAlphabet.put(16, 'q');
        spanishAlphabet.put(17, 'r');
        spanishAlphabet.put(18, 's');
        spanishAlphabet.put(19, 't');
        spanishAlphabet.put(20, 'u');
        spanishAlphabet.put(21, 'v');
        spanishAlphabet.put(22, 'w');
        spanishAlphabet.put(23, 'x');
        spanishAlphabet.put(24, 'y');
        spanishAlphabet.put(25, 'z');
        spanishAlphabet.put(26, 'á');
        spanishAlphabet.put(27, 'é');
        spanishAlphabet.put(28, 'í');
        spanishAlphabet.put(29, 'ñ');
        spanishAlphabet.put(30, 'ó');
        spanishAlphabet.put(31, 'ú');
        spanishAlphabet.put(32, 'ü');
        return spanishAlphabet;
    }

    public int getAlphabetSize() {
        return ALPHABET_SIZE;
    }

    public int getAlphabetValue(char c) {
        return reverseAlphabet.get(c);
    }

    public char getAlphabetLetter(int i) {
        return alphabet.get(i);
    }

    public double[] getLetterFrequencies() {
        return letterFrequencies;
    }
}

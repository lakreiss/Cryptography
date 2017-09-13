import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by liamkreiss on 9/3/17.
 */
public class Decrypter {
    private static final int NUM_LETTERS_IN_ALPHABET = 26;
    private static int numBestSolutions = 1;

    private static double[] letterFrequency = new double[NUM_LETTERS_IN_ALPHABET];

    public Decrypter(int numBestSolutions) throws FileNotFoundException {
        this.numBestSolutions = numBestSolutions;
        
        Scanner lf = new Scanner(new File("letter_frequency.txt"));
        for (int i = 0; i < NUM_LETTERS_IN_ALPHABET; i++) {
            letterFrequency[i] = lf.nextDouble();
        }

        System.out.println("\n\n\n");
    }

    public String decrypt(String encryptedMessage) {
        encryptedMessage = encryptedMessage.toLowerCase();
        ArrayList<Solution> allSolutions = new ArrayList<>();

        //try caesar shift
        ArrayList<CaesarCipherSolution> caesarShiftSolutions = tryCaesarShift(encryptedMessage);

        for (CaesarCipherSolution ccs : caesarShiftSolutions) {
            allSolutions.add((Solution) ccs);
        }

        Collections.sort(allSolutions);

        //when more attempts are added, this won't necessarily return caesarShiftSolution
        //perhaps checks against a dictionary to look for words?

        String bestSolutions = getNBestSolutions(numBestSolutions, encryptedMessage, allSolutions);
        return bestSolutions;
    }

    private String getNBestSolutions(int numBestSolutions, String origencryptedMessage, ArrayList<Solution> solutions) {
        String output = String.format("Original encryptedMessage: %s\n", origencryptedMessage);
        for (int i = 0; i < numBestSolutions; i++) {
            output += solutions.get(i).toString();
        }
        return output;
    }

    public ArrayList<CaesarCipherSolution> tryCaesarShift(String encryptedMessage) {
        ArrayList<CaesarCipherSolution> solutions = new ArrayList<>();

        int[] lettersInEncryptedMessage = new int[NUM_LETTERS_IN_ALPHABET];
        int counter = 0;
        for (char c : encryptedMessage.toCharArray()) {
            if (c > 96 && c < 123) {
                lettersInEncryptedMessage[reverseAlphabet.get(c)]++;
                counter++;
            }
        }

        double[] encryptedMessageLetterFrequency = new double[NUM_LETTERS_IN_ALPHABET];
        for (int i = 0; i < NUM_LETTERS_IN_ALPHABET; i++) {
            encryptedMessageLetterFrequency[i] = lettersInEncryptedMessage[i] * 1.0 / counter;
        }

        //i is number of shifts to get to the original message
        for (int i = 0; i < NUM_LETTERS_IN_ALPHABET; i++) {
            double curScore = 0;

            //j is letter index in encryptedMessage
            for (int j = 0; j < NUM_LETTERS_IN_ALPHABET; j++) {
                curScore += encryptedMessageLetterFrequency[j] *
                        letterFrequency[(j + i) % NUM_LETTERS_IN_ALPHABET];
            }

            int shiftsToReturnToOriginalMessage = NUM_LETTERS_IN_ALPHABET - i;

            solutions.add(new CaesarCipherSolution(encryptedMessage,
                    shiftEncryptedMessage(encryptedMessage, i),
                    curScore, i, NUM_LETTERS_IN_ALPHABET));
        }

        return solutions;
    }

    private String shiftEncryptedMessage(String encryptedMessage, int shiftsToReachOriginalMessage) {
        String output = "";
        for (char c : encryptedMessage.toCharArray()) {
            if (c > 96 && c < 123) {
                output += "" + alphabet.get((c + shiftsToReachOriginalMessage - 97 + 26) % 26);
            } else {
                output += "" + c;
            }
        }
        return output;
    }

    protected static HashMap<Character, Integer> reverseAlphabet = new HashMap<>();
    static {
        reverseAlphabet.put('a', 0);
        reverseAlphabet.put('b', 1);
        reverseAlphabet.put('c', 2);
        reverseAlphabet.put('d', 3);
        reverseAlphabet.put('e', 4);
        reverseAlphabet.put('f', 5);
        reverseAlphabet.put('g', 6);
        reverseAlphabet.put('h', 7);
        reverseAlphabet.put('i', 8);
        reverseAlphabet.put('j', 9);
        reverseAlphabet.put('k', 10);
        reverseAlphabet.put('l', 11);
        reverseAlphabet.put('m', 12);
        reverseAlphabet.put('n', 13);
        reverseAlphabet.put('o', 14);
        reverseAlphabet.put('p', 15);
        reverseAlphabet.put('q', 16);
        reverseAlphabet.put('r', 17);
        reverseAlphabet.put('s', 18);
        reverseAlphabet.put('t', 19);
        reverseAlphabet.put('u', 20);
        reverseAlphabet.put('v', 21);
        reverseAlphabet.put('w', 22);
        reverseAlphabet.put('x', 23);
        reverseAlphabet.put('y', 24);
        reverseAlphabet.put('z', 25);
    }

    protected static HashMap<Integer, Character> alphabet = new HashMap<>();
    static {
        alphabet.put(0, 'a');
        alphabet.put(1, 'b');
        alphabet.put(2, 'c');
        alphabet.put(3, 'd');
        alphabet.put(4, 'e');
        alphabet.put(5, 'f');
        alphabet.put(6, 'g');
        alphabet.put(7, 'h');
        alphabet.put(8, 'i');
        alphabet.put(9, 'j');
        alphabet.put(10, 'k');
        alphabet.put(11, 'l');
        alphabet.put(12, 'm');
        alphabet.put(13, 'n');
        alphabet.put(14, 'o');
        alphabet.put(15, 'p');
        alphabet.put(16, 'q');
        alphabet.put(17, 'r');
        alphabet.put(18, 's');
        alphabet.put(19, 't');
        alphabet.put(20, 'u');
        alphabet.put(21, 'v');
        alphabet.put(22, 'w');
        alphabet.put(23, 'x');
        alphabet.put(24, 'y');
        alphabet.put(25, 'z');
    }
}

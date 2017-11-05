import java.util.*;

/**
 * Created by liamkreiss on 9/3/17.
 */
public class Decrypter {
    private Language language;

    public Decrypter(Language language) throws Exception {
        this.language = language;
    }

    public ArrayList<Solution> decrypt(String encryptedMessage) {
        encryptedMessage = encryptedMessage.toLowerCase();
        ArrayList<Solution> allSolutions = new ArrayList<>();

        //try caesar shift
        ArrayList<CaesarCipherSolution> caesarShiftSolutions = tryCaesarShift(encryptedMessage);

        for (CaesarCipherSolution ccs : caesarShiftSolutions) {
            allSolutions.add(ccs);
        }

        Collections.sort(allSolutions);

        //when more attempts are added, this won't necessarily return caesarShiftSolution
        //perhaps checks against a dictionary to look for words?

        return allSolutions;
    }

    public ArrayList<CaesarCipherSolution> tryCaesarShift(String encryptedMessage) {
        ArrayList<CaesarCipherSolution> solutions = new ArrayList<>();

        int[] lettersInEncryptedMessage = new int[language.getAlphabetSize()];
        int counter = 0;
        for (char c : encryptedMessage.toCharArray()) {
            if (language.isValidLetter(c)) {
                lettersInEncryptedMessage[language.getAlphabetValue(c)]++;
                counter++;
            }
        }

        double[] encryptedMessageLetterFrequency = new double[language.getAlphabetSize()];
        for (int i = 0; i < language.getAlphabetSize(); i++) {
            encryptedMessageLetterFrequency[i] = lettersInEncryptedMessage[i] * 1.0 / counter;
        }

        //i is number of shifts to get to the original message
        for (int i = 0; i < language.getAlphabetSize(); i++) {
            double curScore = 0;

            //j is letter index in encryptedMessage
            for (int j = 0; j < language.getAlphabetSize(); j++) {
                curScore += encryptedMessageLetterFrequency[j] *
                        language.getLetterFrequencies()[(j + i) % language.getAlphabetSize()];
            }

//            int shiftsToReturnToOriginalMessage = language.getAlphabetSize() - i;

            solutions.add(new CaesarCipherSolution(encryptedMessage,
                    shiftEncryptedMessage(encryptedMessage, i),
                    curScore, i, language.getAlphabetSize(), language));
        }

        return solutions;
    }

    private String shiftEncryptedMessage(String encryptedMessage, int shiftsToReachOriginalMessage) {
        String output = "";
        for (char c : encryptedMessage.toCharArray()) {
            if (language.isValidLetter(c)) {
                int newValue = (language.getAlphabetValue(c) + shiftsToReachOriginalMessage) % language.getAlphabetSize();
                output += "" + language.getAlphabetLetter(newValue);
            } else {
                output += "" + c;
            }
        }
        return output;
    }
}

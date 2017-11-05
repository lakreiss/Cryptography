import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by liamkreiss on 9/3/17.
 */
public class Main {

    public static final boolean RANDOM_SHIFT = false;
    public static final int NUM_BEST_SOLUTIONS = 10;

    public static void main(String[] args) throws Exception {
        Language english = new English();
        Language spanish = new Spanish();

        String spanishSentence = "Tengo hambre. Quiero comer un burrito. yo fui a la parcela de calabazas ayer";
        String englishSentence = "I am hungry. I want to eat a burrito. I went to the pumpkin patch yesterday";

        Decrypter englishDecrypter = new Decrypter(english);
        Decrypter spanishDecrypter = new Decrypter(spanish);

        String encryptedEnglishSentence = caesarEncrypt(english,  englishSentence, 6);
        String encryptedSpanishSentence = caesarEncrypt(spanish,  spanishSentence, 6);

        //choose language
        String encryptedSentence = encryptedSpanishSentence;

        ArrayList<String> encryptedMessagesEnglish = new ArrayList<String>();
        encryptedMessagesEnglish.add(encryptedSentence);

        ArrayList<String> encryptedMessagesSpanish = new ArrayList<String>();
        encryptedMessagesSpanish.add(encryptedSentence);

        ArrayList<ArrayList<Solution>> allSolutionsList = new ArrayList<>();
        for (String s : encryptedMessagesEnglish) {
            allSolutionsList.add(englishDecrypter.decrypt(s));
        }

        for (String s : encryptedMessagesSpanish) {
            allSolutionsList.add(spanishDecrypter.decrypt(s));
        }

        System.out.println(getNBestSolutions(NUM_BEST_SOLUTIONS, allSolutionsList, encryptedSentence));
    }

    public static String caesarEncrypt(Language language, String message, int n) {
        if (RANDOM_SHIFT) {
            return new CaesarCipherEncrypter(language).encrypt(message);
        } else {
            return new CaesarCipherEncrypter(n, language).encrypt(message);
        }
    }

    private static String getNBestSolutions(int numBestSolutions, ArrayList<ArrayList<Solution>> allSolutionLists, String origEncryptedMessage) {
        String output = String.format("Original Encrypted Message: %s\n", origEncryptedMessage);
        ArrayList<Solution> allSolutions = new ArrayList<>();
        for (ArrayList<Solution> solution : allSolutionLists) {
            for (Solution s : solution) {
                allSolutions.add(s);
            }
        }

        Collections.sort(allSolutions);

        for (int i = 0; i < numBestSolutions; i++) {
            output += allSolutions.get(i).toString();
        }

        return output;
    }

}

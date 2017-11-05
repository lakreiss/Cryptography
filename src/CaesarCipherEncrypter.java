import java.util.Random;

/**
 * Created by liamkreiss on 9/3/17.
 */
public class CaesarCipherEncrypter {
    private int numShift;
    private Language language;

    //Creates a random Caesar Cipher Encrypter
    public CaesarCipherEncrypter(Language language) {
        this((new Random()).nextInt(language.getAlphabetSize() - 1) + 1, language);
    }

    public CaesarCipherEncrypter(int n, Language language) {
        this.language = language;
        if (n < 0) {
            this.numShift = (n % language.getAlphabetSize()) + language.getAlphabetSize();
        } else {
            this.numShift = n % language.getAlphabetSize();
        }
    }

    public String encrypt(String s) {
        s = s.toLowerCase();
        String output = "";
        for (char c : s.toCharArray()) {
            if (language.isValidLetter(c)) {
                int newValue = (language.getAlphabetValue(c) + numShift) % language.getAlphabetSize();
                output += "" + language.getAlphabetLetter(newValue);
            } else {
                output += "" + c;
            }
        }
        return output;
    }
}

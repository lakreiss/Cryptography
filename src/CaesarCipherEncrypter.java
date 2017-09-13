import java.util.Random;

/**
 * Created by liamkreiss on 9/3/17.
 */
public class CaesarCipherEncrypter extends SubstitutionCipher{
    private int numShift;
    private int alphabet_size;

    //Creates a random Caesar Cipher Encrypter
    public CaesarCipherEncrypter(int alphabet_size) {
        this((new Random()).nextInt(25) + 1, alphabet_size);
    }

    public CaesarCipherEncrypter(int n, int alphabet_size) {
        this.alphabet_size = alphabet_size;
        if (n < 0) {
            this.numShift = (n % 26) + alphabet_size;
        } else {
            this.numShift = n % 26;
        }
    }

    public String encrypt(String s) {
        s = s.toLowerCase();
        String output = "";
        for (char c : s.toCharArray()) {
            if (c > 96 && c < 123) {
                output += "" + alphabet.get(((c + numShift) - 97) % 26);
            } else {
                output += "" + c;
            }
        }
        return output;
    }
}

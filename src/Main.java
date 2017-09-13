import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by liamkreiss on 9/3/17.
 */
public class Main {

    public static final int ALPHABET_SIZE = 26;
    public static final boolean RANDOM_SHIFT = false;

    public static void main(String[] args) throws FileNotFoundException {
        Decrypter d = new Decrypter(2);

        ArrayList<String> encryptedMessages = new ArrayList<String>();
        encryptedMessages.add(tryInput("Hello, World! this is so cool. " +
                "I wonder if it will work if I write a ton of words. I do have to make sure that the words " +
                "are varied though, because I can't just repeat the same words over and over again and expect " +
                "the computer to learn any new information.", 100));
        encryptedMessages.add(tryInput("Once upon a time, there was a frisbee player named Mason. " +
                "Mason loved to take long walks on the beach and eat pumpkin pie with his friends.", 10));
        encryptedMessages.add(tryInput("One day, Mason encountered a turtle named Sydney. " +
                "The turtle lived near the water and decided to swim out into the ocean to see if she " +
                "could catch any fish.", -10));
        encryptedMessages.add(tryInput("After returning from the fishing trip, Sydney noticed Mason " +
                "eating his pumpkin pie on the beach. She said: 'Hey there. Can i have some of that pie?'", 0));


        for (String s : encryptedMessages) {
            System.out.println(d.decrypt(s));
        }
    }

    public static String tryInput(String message, int n) {
        if (RANDOM_SHIFT) {
            return new CaesarCipherEncrypter(ALPHABET_SIZE).encrypt(message);
        } else {
            return new CaesarCipherEncrypter(n, ALPHABET_SIZE).encrypt(message);
        }
    }

}

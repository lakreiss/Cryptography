/**
 * Created by liamkreiss on 9/3/17.
 */
public class CaesarCipherSolution extends Solution {
    private int shifts;
    private int alphabetSize;

    public CaesarCipherSolution(String originalMessage, String decryptedMessage, double score, int shifts, int alphabetSize) {
        super(originalMessage, decryptedMessage, score);
        this.shifts = shifts;
        this.alphabetSize = alphabetSize;
    }

    public String toString() {
        return String.format("Score: %f *** Shifts to decrypt message: %d *** Shifts to encrypt message: %d" +
                "\nAnswer: %s\n", this.score, this.shifts % 26, (this.alphabetSize - this.shifts) % 26, this.decryptedMessage);
    }
}

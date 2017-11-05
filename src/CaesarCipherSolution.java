/**
 * Created by liamkreiss on 9/3/17.
 */
public class CaesarCipherSolution extends Solution {
    private int shifts;
    private int alphabetSize;
    private Language language;

    public CaesarCipherSolution(String originalMessage, String decryptedMessage, double score, int shifts, int alphabetSize, Language language) {
        super(originalMessage, decryptedMessage, score, language);
        this.shifts = shifts;
        this.alphabetSize = alphabetSize;
        this.language = language;
    }

    public String toString() {
        return String.format("Score: %f *** Language: %s *** Shifts to decrypt message: %d *** Shifts to encrypt message: %d" +
                "\nAnswer: %s\n", this.score, this.language.getName(), this.shifts % alphabetSize, (this.alphabetSize - this.shifts) % alphabetSize, this.decryptedMessage);
    }
}

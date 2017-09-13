import java.util.Comparator;
import java.util.InputMismatchException;

/**
 * Created by liamkreiss on 9/3/17.
 */
public class Solution implements Comparable{
    protected String originalMessage;
    protected String decryptedMessage;
    protected double score;

    public Solution(String originalMessage, String decryptedMessage, double score) {
        this.originalMessage = originalMessage;
        this.decryptedMessage = decryptedMessage;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Solution) {
            if (this.score - ((Solution) o).score > 0) {
                return -1;
            } else if (this.score - ((Solution) o).score < 0) {
                return 1;
            }
            return 0;
        } else {
            throw new InputMismatchException();
        }
    }

    public String toString() {
        return String.format("Score: %f\nAnswer: %s\n", this.score, this.decryptedMessage);
    }

//    @Override
//    public int compare(Object o1, Object o2) {
//        if (o1 instanceof Solution && o2 instanceof Solution) {
//            if (((Solution) o1).score - ((Solution) o2).score > 0) {
//                return 1;
//            } else if (((Solution) o1).score - ((Solution) o2).score < 0) {
//                return -1;
//            }
//            return 0;
//        } else {
//            throw new InputMismatchException();
//        }
//    }
}

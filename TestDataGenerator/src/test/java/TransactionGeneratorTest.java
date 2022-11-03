import org.example.models.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class TransactionGeneratorTest {

    private final static String TRANSACTION_PREFIX = "PerfTxn";

    @Test
    public void generateTransaction() {

        for (int i = 0; i < 5; i++) {
            Transaction txn = Transaction.builder().id(1L).number(generateTxnUniqueIdentifier()).currency("GBP").build();
            System.out.println(txn);
            Assert.assertEquals("GBP", txn.getCurrency());
        }
    }


    public String generateTxnUniqueIdentifier() {
        Random random = ThreadLocalRandom.current();
        return TRANSACTION_PREFIX + random.nextInt();
    }

public void genId(){
    int length = 10;
    boolean useLetters = true;
    boolean useNumbers = false;
//    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
//    System.out.println(generatedString);
}


}

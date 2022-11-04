import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.generator.enums.CurrencyEnum;
import org.generator.models.Transaction;
import org.generator.random.RandomStringGenerator;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class TransactionGeneratorTest {
    private static final String CSV_FILE = "C:\\Users\\spostolachi\\IdeaProjects\\PerformanceTestDataGenerator\\TestDataGenerator\\src\\main\\resources\\writeDemo.csv";
    private static final String CSV_FILE_2 = "C:\\Users\\spostolachi\\IdeaProjects\\PerformanceTestDataGenerator\\TestDataGenerator\\src\\main\\resources\\writeDemo2.csv";

    @Test
    public void generateTransaction() throws FileNotFoundException {

        List<Transaction> transactions = generateTransactions(2000);

        generateCsv(transactions, CSV_FILE_2);

    }


    private static void generateCsv(List<Transaction> transactions, String file) {

        try (
                Writer writer = Files.newBufferedWriter(Paths.get(file));
        ) {
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            beanToCsv.write(transactions);
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static List<Transaction> generateTransactions(int numberOfTransactions) {
        List<Transaction> transactions = new ArrayList<>();

        for (int i = 0; i < numberOfTransactions; i++) {
            Transaction txn = Transaction
                    .builder()
                    .id(RandomStringGenerator.randomNumeric(8))
                    .tNumber(RandomStringGenerator.randomString(8))
                    .currency(CurrencyEnum.generateCurrency())
                    .build();
            transactions.add((txn));
        }
        return transactions;
    }





    @Test
    public void testRandom() {
        for (int i = 0; i < 5; i++) {
            System.out.println(RandomStringGenerator.randomNumeric(8));
        }


    }


}

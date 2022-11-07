import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.generator.EnvironmentProperty;
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
import java.util.Properties;


public class TransactionGeneratorTest {
    private static final String CSV_PATH = "C:\\Users\\spostolachi\\IdeaProjects\\PerformanceTestDataGenerator\\TestDataGenerator\\src\\main\\resources\\csv\\";
    private static final String TRANSACTION_PATH = CSV_PATH + "transactions.csv";


    @Test
    public void generateTransaction() throws FileNotFoundException {

        List<Transaction> transactions = generateTransactions(3);

        generateCsv(transactions, TRANSACTION_PATH);

    }

    @Test
    public void readProperties() throws IOException {
        Properties prop = EnvironmentProperty.readPropertiesFile("C:\\Users\\spostolachi\\IdeaProjects\\PerformanceTestDataGenerator\\src\\main\\resources\\TestEnvironment.properties");
        System.out.println("username: "+ prop.getProperty("app.username"));
        System.out.println("password: "+ prop.getProperty("app.password"));
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

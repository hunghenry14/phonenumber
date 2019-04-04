
package interview.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interview.io.impl.FileInput;
import interview.io.impl.FileOutput;
import interview.service.IFindAcutualActivationDateService;
import interview.service.impl.FindActualActivationDateService;

public class FindActualActivationDateTests {

    IFindAcutualActivationDateService service;

    @Before
    public void setup() {
        service = new FindActualActivationDateService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidStartDate() {
        service.find(
                new FileInput(this.getClass().getClassLoader().getResource("test_invalid_activ_date.csv").getPath()),
                new FileOutput(this.getClass().getClassLoader().getResource("test_invalid_activ_date.csv").getPath()
                        .replaceFirst("test_invalid_activ_date.csv", "test_invalid_activ_date_result.csv")));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidStartDateEmpty() {
        service.find(
                new FileInput(this.getClass().getClassLoader().getResource("test_invalid_activ_date_empty.csv").getPath()),
                new FileOutput(this.getClass().getClassLoader().getResource("test_invalid_activ_date_empty.csv").getPath()
                        .replaceFirst("test_invalid_activ_date_empty.csv", "test_invalid_activ_date_result.csv")));
    }

    @Test
    public void testloadLargeFile() {
        service.find(new FileInput(this.getClass().getClassLoader().getResource("test_large_file.csv").getPath()),
                new FileOutput(this.getClass().getClassLoader().getResource("test_large_file.csv").getPath()
                        .replaceFirst("test_large_file.csv", "test_large_file_result.csv")));
    }

    @Test
    public void testValid() throws IOException {
        String fileOutputPath = this.getClass().getClassLoader().getResource("test_valid.csv").getPath()
                .replaceFirst("test_valid.csv", "test_valid_result.csv");
        service.find(new FileInput(this.getClass().getClassLoader().getResource("test_valid.csv").getPath()),
                new FileOutput(fileOutputPath));
        Map<String, String> dates = new HashMap<>();
        dates.put("0987000001", "2016-06-01");
        dates.put("0987000002", "2016-02-01");
        dates.put("0987000003", "2016-01-01");
        checkTestCase(fileOutputPath, dates);
    }

    private void checkTestCase(String fileOutputPath, Map<String, String> testCase)
            throws IOException, FileNotFoundException {
        try (FileInputStream inputStream = new FileInputStream(fileOutputPath);
                Scanner sc = new Scanner(inputStream, "UTF-8");) {
            int i = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (i == 0) {
                    continue;
                }
                String[] split = line.split(",");
                String date = testCase.get(split[0]);
                Assert.assertTrue(date != null && !date.isEmpty());
                Assert.assertEquals(split[1], date);
            }

        }
    }
}

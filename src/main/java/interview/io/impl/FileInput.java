package interview.io.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import interview.io.Input;
import interview.model.PhoneData;
import interview.model.Validity;

public class FileInput implements Input {

    boolean isHeader = true;

    FileInputStream inputStream;

    Scanner sc = null;

    
    public FileInput(String filePath) {
        init(filePath);
    }

    public void init(String filePath) {
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (sc != null) {
            sc.close();
        }
    }

    @Override
    public PhoneData readNext() {
        String line = sc.nextLine();
        if (isHeader) {
            // Ignore header;
            line = sc.nextLine();
            isHeader = false;
        }
        String[] split = line.split(",");
        String endDate = null;
        if (split.length > 2) {
            endDate = split[2];
        }

        return new PhoneData(split[0], new Validity(split[1], endDate));
    }

    @Override
    public boolean hasNext() {
        return sc.hasNextLine();
    }

}

/*
 * FileOutput
 * 
 * Project: iRating
 *
 *
 * This software is the confidential and proprietary information
 * of iRating ("Confidential Information"). You 
 * shall not disclose such "Confidential Information" and shall
 * use it only in accordance with the terms of the license
 * agreement you entered into with iRating.
 */

package interview.io.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import interview.io.Output;
import interview.model.PhoneData;

public class FileOutput implements Output {

    private PrintWriter writer;

    private boolean isHeader = true;

    public FileOutput(String filePath) {
        init(filePath);
    }

    public void init(String filePath) {
        try {
            writer = new PrintWriter(new FileWriter(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(PhoneData data) {
        if (isHeader) {
            writer.println("PHONE_NUMBER,REAL_ACTIVATION_DATE");
            isHeader = false;
        }
        writer.println(
                String.format("%s,%s", data.getPhoneNumber(), data.getValidity().getActivationDate().toString()));
    }

    @Override
    public void close() {
        if (writer != null) {
            writer.close();
        }

    }

}

package org.platform3solutions.writer;

import com.opencsv.CSVWriter;
import org.platform3solutions.export.CommonWriter;

import java.io.BufferedWriter;

public class CSVFileWriter implements CommonWriter {
    private   CSVWriter csvWriter;

    public CSVFileWriter(BufferedWriter writer) {
        this.csvWriter = new CSVWriter(writer);
    }

    @Override
    public void HeaderWriter(String[] columns, BufferedWriter writer) {

    }

    @Override
    public void DataWriter(String[] datum) {

    }
}

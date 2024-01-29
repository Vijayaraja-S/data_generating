package org.platform3solutions.export;

import java.io.BufferedWriter;

public interface CommonWriter {
    void HeaderWriter(String[] columns, BufferedWriter writer);
    void DataWriter(String[] datum);
}

package org.platform3solutions.export;

import java.io.IOException;

public interface CommonWriter {
    void HeaderWriter(String[] columns) throws IOException;
    void DataWriter(String[] datum);
}

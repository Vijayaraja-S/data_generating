package org.platform3solutions.bean;

import lombok.Builder;
import lombok.Data;
import org.platform3solutions.writer.CSVFileWriter;
import org.platform3solutions.export.CommonWriter;
import org.platform3solutions.util.FileUtil;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.*;

@Builder
@Data
public class BeanProcessor {
    private Integer fileCount = 0;


    public BeanProcessor() {
    }

    public InputBean buildInputBean(String ymlFile) throws IOException {
        try (FileInputStream input = new FileInputStream(ymlFile)) {
            String yamlString = new String(input.readAllBytes());
            InputBean inputBean = new Yaml().loadAs(yamlString, InputBean.class);
            return inputBean;
        } catch (IOException exception) {
            throw exception;
        }
    }

    public Map<String, String> makeColumnsTypeOfDataCombination( String [] columnNames,
                                                                String [] typesOfData) {
        Map<String, String> columnDataTypeMap = new LinkedHashMap<>();
        for (int i = 0; i < columnNames.length; i++) {
            columnDataTypeMap.put(columnNames[i], typesOfData[i]);
        }
        return columnDataTypeMap;
    }

    public CommonWriter writeData(InputBean inputBean) throws IOException {
        String outputPath = getOutputPath(inputBean);
        assert outputPath != null;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))){
            switch (inputBean.getFormat().toUpperCase()){
                case "CSV":
                    return new CSVFileWriter(writer);
                case "TXT":
                    return null;
            }
            return null;
        }
    }


    private String getOutputPath(InputBean inputBean) throws IOException {
        Date startTime = new Date();
        String jobFolder = inputBean.getOutputPath() + File.separator + "DUMMY_DATA_" + startTime.getTime();
        FileUtil.checkCreateDirectory(jobFolder);
        fileCount++;
        switch (inputBean.getFormat().toUpperCase()) {
            case "CSV":
                return jobFolder + File.separator + "DUMMY_DATA" + String.format("%05d", fileCount) + ".csv";
        }
        return null;
    }
}

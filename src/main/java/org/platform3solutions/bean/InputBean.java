package org.platform3solutions.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InputBean {
    private  String [] columnNames;
    private  String [] TypesOfData;
    private Integer rowCount;
    private String format;
    private String outputPath;
    private Boolean header;
}

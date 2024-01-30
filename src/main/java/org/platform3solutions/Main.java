package org.platform3solutions;
import com.github.javafaker.Faker;
import org.platform3solutions.bean.BeanProcessor;
import org.platform3solutions.bean.InputBean;
import org.platform3solutions.export.CommonWriter;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        args = new String[1];
        args[0] = "C:\\Users\\P3INDW52\\data_generating\\input.yml";
        String configFile = args[0];
        BeanProcessor beanProcessor = new BeanProcessor();
        InputBean inputBean = beanProcessor.buildInputBean(configFile);
        if (inputBean.getColumnNames().length != inputBean.getTypesOfData().length){
            throw new Exception("missing columnNames or Types of data");
        }
        Map<String, String> columnNamesDataTypes = beanProcessor.makeColumnsTypeOfDataCombination(inputBean.getColumnNames(), inputBean.getTypesOfData());
        CommonWriter commonWriter = beanProcessor.writeData(inputBean);
        if (inputBean.getHeader()){
            commonWriter.HeaderWriter(inputBean.getColumnNames());
        }
        beanProcessor.writeActualData(inputBean,commonWriter);
        Faker faker = new Faker();
        String streetName = faker.address().streetName();
        String number = faker.address().buildingNumber();
        String city = faker.address().city();
        String country = faker.address().country();
        System.out.println(String.format("%s\n%s\n%s\n%s",
                number,
                streetName,
                city,
                country));
    }
}
package uk.ac.ucl.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataLoader {
    public DataFrame readFile(String filename) {
        filename = "data/patients100.csv";
        DataFrame df = new DataFrame();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String headerLine = br.readLine();
            if (br.readLine()!=null){
                String[] headerNames = headerLine.split(",");
                for (String headerName : headerNames){
                    df.addColumn(new Column(headerName));
                }
            }
            String currentLine;
            List<String> columnNames = df.getColumnNames();
            while ((currentLine = br.readLine())!=null){
                String[] values = currentLine.split(",");
                for (int i=0;i < values.length ;i++){
                    df.addValue(columnNames.get(i), values[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);}
        return df;
    }
}

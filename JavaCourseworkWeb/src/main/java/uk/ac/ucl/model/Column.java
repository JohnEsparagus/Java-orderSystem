package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;

public class Column {
    private String name;
    private ArrayList<String> rows;

    public Column(String name){
        this.name = name;
        this.rows = new ArrayList<String>();
    }
    public String getName(){
        return name;
    }
    public int getSize(){
        return rows.size();
    }
    public String getRowValue(int rowIndex){
        return rows.get(rowIndex);
    }
    public void setRowValue(int rowIndex, String value){
        rows.set(rowIndex,value);
    }
    public void addRowValue(String value){
        rows.add(value);
    }
    public List<String> getAllRows(){
        return new ArrayList<>(rows);
    }

}

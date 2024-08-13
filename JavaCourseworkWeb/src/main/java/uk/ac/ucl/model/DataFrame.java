package uk.ac.ucl.model;
import java.util.ArrayList;
import java.util.List;
public class DataFrame {
    private ArrayList<Column> columns;
    public DataFrame() {
        columns = new ArrayList<>();
    }

    public void addColumn(Column newColumn) {
        columns.add(newColumn);
    }

    public List<String> getColumnNames() {
        List<String> names = new ArrayList<>();
        for (Column column : columns){
            names.add(column.getName());
        }
        return names;
    }

    public int getRowCount() {
        if (columns.isEmpty()){
            return 0;
        }
        return columns.get(0).getSize();
    }

    public String getValue(String columnName, int row) {
        for (Column column : columns) {
            if (column.getName().equals(columnName)) {
                return column.getRowValue(row);
            }
        }
        System.out.println("Error, invalid input type");
        return null;
    }
    public void putValue(String columnName, int row, String value) {
        for (Column column : columns) {
            if (column.getName().equals(columnName)) {
                column.setRowValue(row, value); // Call setRowValue on the found Column
                return; // Exit the method after the value has been set
            }
        }
        return;
    }
    public List<String> getColumnRowsString(String columnName) {
        List<String> rowsInColumnNamesList = null;
        for (Column column : columns) {
            if (column.getName().equals(columnName)) {
                rowsInColumnNamesList = column.getAllRows();
            }
        }
        return rowsInColumnNamesList;
    }
    public void addValue(String columnName, String value){
        for (Column column : columns) {
            if (column.getName().equals(columnName)) {
                column.addRowValue(value);
            }
        }
    }

}

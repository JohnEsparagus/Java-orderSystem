package uk.ac.ucl.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model
{
  private DataFrame dataFrame;
  private DataLoader dataLoader;
  public Model() {
    dataLoader = new DataLoader();
    dataFrame = dataLoader.readFile("data/patients100.csv"); // Load the data
  }

  public void loadFile(String fileName){
    dataFrame = dataLoader.readFile(fileName);
  }
  public boolean isDataLoaded(){
    return dataFrame != null;
  }
  public List<String> searchFor(String keyword)
  {
    List<String> searchResults = new ArrayList<>();
    List<Map<String, String>> allPatientData = getAllPatientData();

    if (keyword.isEmpty() || keyword.equalsIgnoreCase("all")) {
      for (Map<String, String> patient : allPatientData) {
        searchResults.add(patient.toString());
      }
    } else {
      for (Map<String, String> patient : allPatientData) {
        String firstName = patient.get("FIRST");
        String lastName = patient.get("LAST");

        if (firstName != null && firstName.toLowerCase().contains(keyword.toLowerCase()) ||
                lastName != null && lastName.toLowerCase().contains(keyword.toLowerCase())) {
          searchResults.add(patient.toString());
        }
      }
    }

    return searchResults;
  }
  public List<Map<String, String>> getAllPatientData() {
    List<Map<String, String>> allPatientData = new ArrayList<>();
    List<String> columnNames = dataFrame.getColumnNames();
    int numRows = 100;
    //dataFrame.getRowCount();

    System.out.println("Number of columns: " + columnNames.size()); // Verify column detection
    System.out.println("Number of rows: " + numRows);  // Verify row count

    for (int rowIndex = 0; rowIndex < numRows-1; rowIndex++) {
      Map<String, String> patient = new HashMap<>();
      for (String columnName : columnNames) {
        String cellValue = dataFrame.getValue(columnName, rowIndex);
        patient.put(columnName, cellValue);

        // Print for debugging
        System.out.println("Column: " + columnName + ", Value: " + cellValue);
      }
      allPatientData.add(patient);
    }
    return allPatientData;
  }

  public List<String> displayAllPatientData(){
    List<String> patientData = new ArrayList<>();
    List<Map<String, String>> allPatientData = getAllPatientData();

    for (Map<String, String> patient : allPatientData) {
      patientData.add(patient.toString());
      }
    return patientData;
  }
  public List<String> getPatientNames() {
    List<String> fullNames = new ArrayList<>();
    List<String> firstNames = dataFrame.getColumnRowsString("FIRST");
    List<String> lastNames = dataFrame.getColumnRowsString("LAST");
    if (firstNames != null && lastNames != null && firstNames.size() == lastNames.size()) {
      for (int i = 0; i < firstNames.size(); i++) {
        String fullName = firstNames.get(i) + " " + lastNames.get(i);
        fullNames.add(fullName);
      }
    }
    return fullNames;
  }
  public List<String> getAllColumnsHeaders(){
    return dataFrame.getColumnNames();
  }

  public DataFrame getDataFrame() {
    return dataFrame;
  }
}

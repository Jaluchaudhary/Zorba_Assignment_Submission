

import java.io.*;
import java.nio.file.*;
import java.util.Properties;

public class WriteToPropFile {
    public static void main(String[] args) {
        try {

            Path filePath = Paths.get("src", "main", "resources", "employee.properties");


            Properties props = new Properties();


            props.setProperty("name", "Robert");
            props.setProperty("address", "NYC");
            props.setProperty("salary", "2398.23");
            props.setProperty("mobile", "57575757");
            props.setProperty("department", "Finance");
            props.setProperty("dateOfJoining", "2021-02-03");
            props.setProperty("policy_id", "1003");


            try (Writer writer = Files.newBufferedWriter(filePath)) {
                props.store(writer, "Employee details");
            }

            System.out.println("employee.properties updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


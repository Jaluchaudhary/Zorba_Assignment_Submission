import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WriteToTextFileFromPropFile {

    public static void main(String[] args) {
        Properties props = new Properties();


        try (InputStream input = WriteToTextFileFromPropFile.class
                .getClassLoader()
                .getResourceAsStream("test.properties")) {

            if (input == null) {
                System.out.println("Sorry, unable to find test.properties");
                return;
            }

            props.load(input);

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        String name       = props.getProperty("name", "Unknown");
        String address    = props.getProperty("address", "N/A");
        String salary     = props.getProperty("salary", "0");
        String mobile     = props.getProperty("mobile", "N/A");
        String department = props.getProperty("department", "N/A");
        String doj        = props.getProperty("dateOfJoining", "N/A");


        String content = String.format(
                "My name is %s. Address is %s, Mobile number %s, having salary %s. " +
                        "%s has joined the organisation on %s under %s Department.",
                name, address, mobile, salary, name, doj, department
        );

        try (FileWriter writer = new FileWriter("src/main/resources/employee.txt")) {
            writer.write(content);
            System.out.println("employee.txt file updated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }















}

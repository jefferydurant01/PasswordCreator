import java.io.FileWriter;
import java.io.IOException;

public class ListOfPasswords {
    public void saveToFile(String password){
        try {
            FileWriter writer = new FileWriter("List.txt", true);
            writer.write(password + "\n");
            writer.close();
            System.out.println("Password successfully copied");
        }catch(IOException e){
            System.out.println("Error copying password.");
            e.printStackTrace();
        }
    }
}

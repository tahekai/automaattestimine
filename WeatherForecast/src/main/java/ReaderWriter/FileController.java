package ReaderWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileController {

    public  List<String> fileReader (String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }

    public void fileWriter(ArrayList<String> weatherdata) {
        try {
                for (String cityname : weatherdata) {
                java.io.FileWriter fileWriter = new java.io.FileWriter(cityname.substring(0, cityname.indexOf(" "))+ ".txt");
                    fileWriter.write(cityname.toString());
                    fileWriter.flush();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

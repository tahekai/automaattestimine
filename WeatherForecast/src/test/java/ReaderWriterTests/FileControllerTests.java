package ReaderWriterTests;

import ReaderWriter.FileController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FileControllerTests {
    private String filePath;
    private FileController fileController;

    @Before public void init(){
        filePath = "/Users/anonapsep/IdeaProjects/WeatherForecast/src/test/resources/input.txt";
        fileController = new FileController();


    }

    @Test
    public void doesFileReaderReadFile () throws IOException {

        List<String> linesInFile = fileController.fileReader(filePath);

        assertEquals("Tallinn", linesInFile.get(0));
    }

    @Test
    public void doesFileReaderReadFileFromRightocation () throws IOException {
        assertEquals("/Users/anonapsep/IdeaProjects/WeatherForecast/src/test/resources/input.txt", filePath);
    }



}

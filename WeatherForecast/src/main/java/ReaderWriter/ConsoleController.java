package ReaderWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import Main.ServiceRunner;
import org.json.JSONException;

public class ConsoleController {


        public ArrayList<String> letUserChooseInputType() throws IOException {

            Scanner scanner0 = new Scanner(System.in);
            System.out.println("Kui soovite sisestada linna nime konsoolist, valige 1, kui soovite linna nimed sisse lugeda failist, valige 2:");
            String forecast = scanner0.next();
            ArrayList<String> citynames = new ArrayList<>();

            if (Objects.equals(forecast, "1")) {
                String name = this.getCityNameFromUserInput();
                citynames.add(name);
            }
            else if (Objects.equals(forecast, "2")){

                FileController filereader = new FileController();
                String filePath = "/Users/anonapsep/IdeaProjects/WeatherForecast/src/main/resources/input.txt";
                List<String> fileRead = filereader.fileReader(filePath);
                citynames.addAll(fileRead);
                System.out.println("Linnad mille kohta andmeid hakatakse pärima: " + citynames);
            }
            else {
                System.out.println("See ei valik ei ole võimalik, proovi uuesti!");
                letUserChooseInputType();
            }
            return citynames;
        }

        public String getCityNameFromUserInput() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Sisesta linna nimi: ");
            String name = scanner.next();
            return name;

        }

       
        }
    




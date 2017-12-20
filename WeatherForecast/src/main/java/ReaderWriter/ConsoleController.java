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

        public void getDataAndPrintToConsoleOrFile () throws IOException,JSONException{

            FileController writeFile = new FileController();
            ArrayList <String> citynames = letUserChooseInputType();
            ServiceRunner serviceRunner = new ServiceRunner();

            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Kui soovite hetke ilma, vajutage 1, kui soovite kolme päeva ennustust, vajutage 3:");
            String forecast = scanner1.next();

            if (Objects.equals(forecast, "1")) {
                serviceRunner.getOnlyDataThatYouNeedFromJSONCurrentWeather(citynames);
            }else if (Objects.equals(forecast, "3")) {
                serviceRunner.getOnlyDataThatYouNeedFromJSONForecast(citynames);
            }

            /*Scanner scanner2 = new Scanner(System.in);
            System.out.println("Kui soovite andmeid näha konsoolis, kirjutage console, kui soovite andmeid lugeda failist, kirjutage file:");
            String forecastToFile = scanner2.next();

            if (Objects.equals(forecast, "1")) {
                if (Objects.equals(forecastToFile, "console")) {

                    System.out.println(serviceRunner.getOnlyDataThatYouNeedFromJSONCurrentWeather(citynames));

                } else if (Objects.equals(forecastToFile, "file")) {

                    writeFile.fileWriter(serviceRunner.getOnlyDataThatYouNeedFromJSONCurrentWeather(citynames));

                    System.out.println("Andmed kirjutatud faili");

                }
                else {
                    System.out.println("See ei valik ei ole võimalik, proovi uuesti!");
                    getDataAndPrintToConsoleOrFile();
                }
            } else if (Objects.equals(forecast, "3")) {
                if (Objects.equals(forecastToFile, "console")) {

                    System.out.println(serviceRunner.getOnlyDataThatYouNeedFromJSONForecast(citynames));

                } else if (Objects.equals(forecastToFile, "file")) {

                    writeFile.fileWriter(serviceRunner.getOnlyDataThatYouNeedFromJSONForecast(citynames));

                    System.out.println("Andmed kirjutatud faili");
                }
                else {
                    System.out.println("See ei valik ei ole võimalik, proovi uuesti!");
                    getDataAndPrintToConsoleOrFile();
                }
            } else {
                System.out.println("See ei valik ei ole võimalik, proovi uuesti!");
                getDataAndPrintToConsoleOrFile();
            }*/

        }
    }




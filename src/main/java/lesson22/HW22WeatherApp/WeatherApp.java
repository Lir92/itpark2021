package lesson22.HW22WeatherApp;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WeatherApp  {

    private static final String city = getCity();
    private static final String appID = "5aa9e4746e1c4a7e3745a36e12161fef";
    private static final String API = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&lang=ru&appid=" + appID;


    public static void main(String[] args) {

        StringBuilder weatherInfo = new StringBuilder();

        try {
            URL weatherURL = new URL(API);
            URLConnection urlConnection = weatherURL.openConnection();
            String line;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while ((line = bufferedReader.readLine()) != null) {
                weatherInfo.append(line + "\n");
            }
            bufferedReader.close();
            JSONObject jObject = new JSONObject(String.valueOf(weatherInfo));
            System.out.println("Город: " + jObject.getString("name"));
            System.out.println("Температура: " + getTemperature(jObject) + " C, " +
                    "ощущается, как " + getFeelTemperature(jObject) + " C");
            System.out.println("Ветер: " + getWindDirection(jObject) + " " + jObject.getJSONObject("wind").getInt("speed") + " м/сек");
            System.out.println("Облачность: " + jObject.getJSONArray("weather").getJSONObject(0).getString("description"));
        } catch (Exception e) {
            System.out.println("Город " + city + " не найден");
        }

    }

    private static String getCity() {
        System.out.print("Введите название города, чтобы узнать погоду: ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            String number = scanner.next();
            System.out.println(number + " - вы ввели число, а не название города");
        }
        return scanner.next();
    }

    private static String getWindDirection(JSONObject jObject) {
        int direction = jObject.getJSONObject("wind").getInt("deg");
        if (direction < 90) {
            return "Северо-восточный";
        } else if (direction == 90) {
            return "Восточный";
        } else if (direction > 90 && direction < 180) {
            return "Юго-восточный";
        } else if (direction == 180) {
            return "Южный";
        } else if (direction > 180 && direction < 270) {
            return "Юго-западный";
        } else if (direction == 270) {
            return "Западный";
        } else if (direction > 270 && direction < 360) {
            return "Северо-западный";
        } else if (direction == 360) {
            return "Северный";
        }
        return null;
    }

    private static String getTemperature(JSONObject jObject) {
        if (jObject.getJSONObject("main").getInt("temp") > 0) {
            return "+" + jObject.getJSONObject("main").getInt("temp");
        } else {
            return "" + jObject.getJSONObject("main").getInt("temp");
        }
    }

    private static String getFeelTemperature(JSONObject jObject) {
        if (jObject.getJSONObject("main").getInt("feels_like") > 0) {
            return "+" + jObject.getJSONObject("main").getInt("feels_like");
        } else {
            return "" + jObject.getJSONObject("main").getInt("feels_like");
        }
    }
}
package lesson33.HW33CurrencyConverter.service.impl;

import lesson33.HW33CurrencyConverter.service.CurrencyConverterService;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;

@Service
public class CurrencyConverterServiceImpl implements CurrencyConverterService {

    @SneakyThrows
    private static String readFromURI() {
        StringBuilder currencyInfo = new StringBuilder();
        URL currencyURL = new URL("https://www.cbr-xml-daily.ru/daily_json.js");
        URLConnection urlConnection = currencyURL.openConnection();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));) {
            while ((line = bufferedReader.readLine()) != null) {
                currencyInfo.append(line + "\n");
            }
        }
        return String.valueOf(currencyInfo);
    }

    @Override
    public String getCurrencyName(String name) {
        JSONObject jObject = new JSONObject(readFromURI());
        return jObject.getJSONObject("Valute").getJSONObject(name).getString("CharCode");
    }

    @Override
    public BigDecimal convertCurrency(String name, int qtty) {
        JSONObject jObject = new JSONObject(readFromURI());
        return BigDecimal.valueOf(jObject.getJSONObject("Valute").getJSONObject(name).getDouble("Value") * qtty)
                .setScale(2, RoundingMode.UP);
    }
}

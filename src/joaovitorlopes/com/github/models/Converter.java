package joaovitorlopes.com.github.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.Map;

public class Converter {
    public String toConversion(String entryCurrency, String convertedCurrency, double conversionValue) throws ConnectException {
        String key = "61efa23748b1eb6477c19fc3";

        try {
            URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/latest/" + entryCurrency);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            if (response.statusCode() != 200) {
                throw new ConnectException("Response error: Code " + response.statusCode());
            }

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            EntryCurrency entryCurrencyObj = gson.fromJson(json, EntryCurrency.class);
            double coinValue = getCoinValue(convertedCurrency, conversionValue, entryCurrencyObj);
            String coinValueFinal = formatValue(coinValue);
            String finalValue = formatValue(conversionValue);

            return "The value of "  + finalValue + " " + entryCurrency + " is equals " + coinValueFinal + " " + convertedCurrency + ".\n";
        } catch (IOException e) {
            throw new RuntimeException("Error: API I/O Exception -> " + e.getMessage(), e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error: Connection was interrupted -> " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage(), e);
        }
    }

    private static double getCoinValue(String currencyToConvert, double convertedCurrency, EntryCurrency entryCurrencyObj) {
        Map<String, Double> currencyConverter = entryCurrencyObj.conversionRates();

        if (currencyConverter == null || currencyConverter.isEmpty()) {
            throw new RuntimeException("Error: Conversion data not available.");
        }

        Double conversionTax = currencyConverter.get(currencyToConvert);

        if (conversionTax == null) {
            throw new RuntimeException("Error: Conversion rate for specified currency not available.");
        }

        return conversionTax * convertedCurrency;
    }

    private String formatValue(double convertedCurrency) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(convertedCurrency);
    }
}

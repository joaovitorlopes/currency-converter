package joaovitorlopes.com.github.models;

import java.util.Map;

public record EntryCurrency(String result, String baseCode, Map<String, Double> conversionRates) {

}

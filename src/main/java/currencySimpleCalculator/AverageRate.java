package currencySimpleCalculator;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class AverageRate {
    public static double downloadAverageActualValue(String currencyCode) throws IOException {


        String address = new String("http://api.nbp.pl/api/exchangerates/rates/a/" + currencyCode + "/");
        URL urlUSD = new URL(address);
        URLConnection connection = urlUSD.openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        String info = scanner.nextLine();
        Gson gson = new Gson();

        //System.out.println(info);
        CurrencyRateInfo currencyRateInfo = gson.fromJson(info, CurrencyRateInfo.class);
        // Rates rateInfo = gson.fromJson(info,Rates.class);
        //String rates = currencyRateInfo.getRates().toString();
        //System.out.println(rates);
        return currencyRateInfo.showActualCurrencyValue();

    }

    public static void showActualAverageValuesUsaEurGbpChf() throws IOException {
       /*
       show actual market average rate for USD; EUR, GBP, CHF
      */
        System.out.println("Today average currency value in PLN: ");
        System.out.println("USD: " + downloadAverageActualValue("USD"));
        System.out.println("EUR: " + downloadAverageActualValue("EUR"));
        System.out.println("GBP: " + downloadAverageActualValue("GBP"));
        System.out.println("CHF: " + downloadAverageActualValue("CHF"));
    }

    public static void showActualValue(String currencyCode) throws IOException {
       /*
       show actual market average rate for currencyCode
      */
        System.out.println(currencyCode + downloadAverageActualValue(currencyCode));
    }
}

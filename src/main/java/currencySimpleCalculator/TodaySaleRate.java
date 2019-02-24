package currencySimpleCalculator;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class TodaySaleRate {

    public static double calculateHowMuchIsWorth100zlToday(String currencyCode, double amount) throws IOException {
        return (amount / downloadActualSaleValue(currencyCode));
    }

    public static void showHowMuchIsWorth100zlToday(String currencyCode, double amount) throws IOException {
        System.out.println("sale rate: " + amount + " zł, today is worth: "
                + calculateHowMuchIsWorth100zlToday(currencyCode, amount)
                + " " + currencyCode);
    }

    public static double downloadActualSaleValue(String currencyCode) throws IOException {
        String address = new String("http://api.nbp.pl/api/exchangerates/rates/c/" + currencyCode + "/");
        URL urlUSD = new URL(address);
        URLConnection connection = urlUSD.openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        String info = scanner.nextLine();
        Gson gson = new Gson();
        //System.out.println(info);
        CurrencyRateInfo currencyRateInfo = gson.fromJson(info, CurrencyRateInfo.class);
        return (currencyRateInfo.actualBuyCurrencyValue());

    }
}


package currencySimpleCalculator;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class LastMonth {

    public static double downloadHistorySaleValue(String currencyCode) throws IOException {

        LocalDate date = LocalDate.now().minusMonths(1);

        String address = new String("http://api.nbp.pl/api/exchangerates/rates/c/" + currencyCode + "/" +  date + "/");

        URL urlUSD = new URL(address);
        URLConnection connection = urlUSD.openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        String info = scanner.nextLine();
        Gson gson = new Gson();

        CurrencyRateInfo currencyRateInfo = gson.fromJson(info, CurrencyRateInfo.class);
        return currencyRateInfo.actualBuyCurrencyValue();

    }

    public static void compareRate(String currencyCode, double amount ) throws IOException {
        DecimalFormat df = new DecimalFormat("#.##");

        double lastMonth = downloadHistorySaleValue(currencyCode);
        double today = TodaySaleRate.downloadActualSaleValue(currencyCode);
        double remainder = 0;

        System.out.println("One month ago " + currencyCode + " cost " + df.format(lastMonth) + " PLN.");
        System.out.println("Today " + currencyCode + " cost " + df.format(today) + " PLN.");

        if (lastMonth==today){
            System.out.println("Today currency sale rate is the same like one month ago.");
        }
        else if (lastMonth > today) {
            remainder = (lastMonth-today)*amount;
            System.out.println("If you exchange " + amount + " PLN for a " + currencyCode + " in last month, would you earn " + df.format(remainder) +" PLN!");
        }else {
            remainder = (today - lastMonth)*amount;
            System.out.println("If you exchange " + amount + " PLN for a " + currencyCode + " in last month, would you lost " + df.format(remainder) +" PLN!");
        }

    }


}

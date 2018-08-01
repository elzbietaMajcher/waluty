package przelicznikWalut;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


/*
show aktual market average rate for USD; EUR, GPB, CHF
 */
public class KalkulatorWalut {
    public static void main(String[] args) throws IOException {


        double amount = 100.00; // 100.00 PLN
        String currecncyCode;

        downloadRate("USD");
        downloadRate("EUR");
        downloadRate("GBP");
        downloadRate("CHF");


    }

    public static void downloadRate(String currecncyCode) throws IOException {


        String  adres = new String("http://api.nbp.pl/api/exchangerates/rates/a/" + currecncyCode+"/");


        URL urlUSD = new URL(adres);


                URLConnection connection = urlUSD.openConnection();


                Scanner scanner = new Scanner(connection.getInputStream());
                String info = scanner.nextLine();

                Gson gson = new Gson();


                System.out.println(info);


               CurrencyRateInfo currencyRateInfo = gson.fromJson(info, CurrencyRateInfo.class);
               // Rates rateInfo = gson.fromJson(info,Rates.class);


                String rates=currencyRateInfo.rates.toString();
                //String rates=rateInfo.mid;
        System.out.println(rates);
        System.out.println(currencyRateInfo.showActualCurrencyValue());

       // System.out.printf("jakis tekst wstaw to %s", "cos");


    }
}



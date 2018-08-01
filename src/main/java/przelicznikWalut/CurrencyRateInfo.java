package przelicznikWalut;


import java.lang.reflect.Array;
import java.util.List;

public class CurrencyRateInfo {

    String table, currency, code;
    public List<Rates> rates;


    public double showActualCurrencyValue(){
       return rates.get(0).mid;
    }


}

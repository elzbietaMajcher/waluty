package currencySimpleCalculator;

import java.util.List;

public class CurrencyRateInfo {

    private String table, currency, code;
    private List<Rates> rates;


    public double showActualCurrencyValue(){
       return rates.get(0).getMid();
    }

    public double actualSaleCurrencyValue(){
        return rates.get(0).getAsk();
    }
    public double actualBuyCurrencyValue(){
        return rates.get(0).getBid();
    }

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public List<Rates> getRates() {
        return rates;
    }
}

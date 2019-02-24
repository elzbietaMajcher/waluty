package currencySimpleCalculator;

public class Rates {

    private String no;
    private String effectiveDate;
    private double mid;
    private double bid;
    private double ask;

    @Override
    public String toString() {
        return no + ", " + effectiveDate + ", " + mid;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public double getMid() {
        return mid;
    }


}

package przelicznikWalut;

import javafx.scene.input.DataFormat;

public class Rates{

    String no;
    String effectiveDate;
    double mid;

    @Override
    public String toString() {
        return no +", " + effectiveDate +", " + mid;
    }
// public double showActualCurrencyValue(){
//        double value= Double.parseDouble(mid);
//        return value;
// }

}

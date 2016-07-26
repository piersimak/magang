package diginetmedia.com.sikedes;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.NumberFormat;

/**
 * Created by PIER on 7/22/2016.
 */
public class AutoFormatCurrency {

    static String current = "";

    public AutoFormatCurrency() {
    }

    public static void Format(CharSequence charSequence, TextInputEditText editText, TextWatcher txtwatcher)
    {
        if(!charSequence.toString().equals(current)){
            editText.removeTextChangedListener(txtwatcher);

            String cleanString = charSequence.toString().replaceAll("[Rp,.]", "");
            double parsed=0;
            String formatted="";
            if(!cleanString.equals("")) {
                parsed = Double.parseDouble(cleanString);
                formatted = NumberFormat.getCurrencyInstance().format((parsed));
            }
            else
                formatted="Rp";



            current = formatted;
            editText.setText(formatted);
            editText.setSelection(formatted.length());

            editText.addTextChangedListener(txtwatcher);
        }
    }

}

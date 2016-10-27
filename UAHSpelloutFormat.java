package ua.com.etg.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.RuleBasedNumberFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UAHSpelloutFormat {
    
    public static String format(BigDecimal money) {
        money = money.setScale(2, RoundingMode.HALF_UP);
        String textMoney = money.toPlainString();
        int radixLoc = textMoney.indexOf('.');
        String kopeck = textMoney.substring(radixLoc + 1, textMoney.length());
        
        NumberFormat numberFormat = new RuleBasedNumberFormat(new Locale("uk"), RuleBasedNumberFormat.SPELLOUT);
        String formattedMoney = numberFormat.format(money.intValue());
        formattedMoney = formattedMoney.substring(0, 1).toUpperCase() + formattedMoney.substring(1);
        
        formattedMoney += " грн. " + kopeck + " коп.";
        log.debug("{} = {}", money, formattedMoney);
        
        return formattedMoney;
    }

}

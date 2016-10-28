package ua.com.etg.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

import com.ibm.icu.text.RuleBasedNumberFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UAHSpelloutFormat {
    
    public static String format(BigDecimal money) {
        BigDecimal roundedMoney = money.setScale(2, RoundingMode.HALF_UP);
        String textMoney = roundedMoney.toPlainString();
        int radixLoc = textMoney.indexOf('.');
        String kopeck = textMoney.substring(radixLoc + 1, textMoney.length());
        
        RuleBasedNumberFormat numberFormat = new RuleBasedNumberFormat(new Locale("uk"), RuleBasedNumberFormat.SPELLOUT);
        numberFormat.setDefaultRuleSet("%spellout-cardinal-feminine");
        String formattedIntegerPartOfMoney = numberFormat.format(roundedMoney.intValue());
        
        formattedIntegerPartOfMoney = formattedIntegerPartOfMoney.substring(0, 1).toUpperCase() + formattedIntegerPartOfMoney.substring(1);
        
        String formattedMoney = formattedIntegerPartOfMoney + " грн. " + kopeck + " коп.";
        
        log.debug("{} = {}", money, formattedMoney);
        
        return formattedMoney;
    }

}

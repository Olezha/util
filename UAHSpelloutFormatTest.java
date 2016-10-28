package ua.com.etg.util;

import java.math.BigDecimal;

import org.junit.Test;
import static org.junit.Assert.*;

public class UAHSpelloutFormatTest {
    
    @Test
    public void testFormat() {
        assertEquals("Нуль грн. 33 коп.", UAHSpelloutFormat.format(new BigDecimal("0.33")));
        assertEquals("Одна грн. 65 коп.", UAHSpelloutFormat.format(new BigDecimal("1.65")));
        assertEquals("Дві грн. 97 коп.", UAHSpelloutFormat.format(new BigDecimal("2.97")));
        assertEquals("Три грн. 63 коп.", UAHSpelloutFormat.format(new BigDecimal("3.63123")));
        assertEquals("Чотири грн. 29 коп.", UAHSpelloutFormat.format(new BigDecimal("4.285")));
        assertEquals("Пʼять грн. 94 коп.", UAHSpelloutFormat.format(new BigDecimal("5.94")));
        assertEquals("Шість грн. 60 коп.", UAHSpelloutFormat.format(new BigDecimal("6.5968")));
        assertEquals("Сім грн. 59 коп.", UAHSpelloutFormat.format(new BigDecimal("7.590001")));
        assertEquals("Вісім грн. 25 коп.", UAHSpelloutFormat.format(new BigDecimal("8.25")));
        assertEquals("Девʼять грн. 90 коп.", UAHSpelloutFormat.format(new BigDecimal("9.9")));
        assertEquals("Десять грн. 00 коп.", UAHSpelloutFormat.format(new BigDecimal("10")));
        assertEquals("Одинадцять грн. 00 коп.", UAHSpelloutFormat.format(new BigDecimal("11")));
        assertEquals("Дванадцять грн. 21 коп.", UAHSpelloutFormat.format(new BigDecimal("12.21")));
        assertEquals("Тринадцять грн. 53 коп.", UAHSpelloutFormat.format(new BigDecimal("13.53")));
        assertEquals("Чотирнадцять грн. 19 коп.", UAHSpelloutFormat.format(new BigDecimal("14.1899")));
        assertEquals("Пʼятнадцять грн. 84 коп.", UAHSpelloutFormat.format(new BigDecimal("15.84")));
        assertEquals("Шістнадцять грн. 17 коп.", UAHSpelloutFormat.format(new BigDecimal("16.17")));
        assertEquals("Сімнадцять грн. 16 коп.", UAHSpelloutFormat.format(new BigDecimal("17.16")));
        assertEquals("Вісімнадцять грн. 15 коп.", UAHSpelloutFormat.format(new BigDecimal("18.15")));
        assertEquals("Девʼятнадцять грн. 47 коп.", UAHSpelloutFormat.format(new BigDecimal("19.47")));
        assertEquals("Двадцять грн. 79 коп.", UAHSpelloutFormat.format(new BigDecimal("20.79")));
        assertEquals("Двадцять одна грн. 12 коп.", UAHSpelloutFormat.format(new BigDecimal("21.12")));
        assertEquals("Двадцять дві грн. 11 коп.", UAHSpelloutFormat.format(new BigDecimal("22.11")));
        assertEquals("Двадцять три грн. 10 коп.", UAHSpelloutFormat.format(new BigDecimal("23.1")));
        assertEquals("Тридцять грн. 03 коп.", UAHSpelloutFormat.format(new BigDecimal("30.03")));
        assertEquals("Тридцять вісім грн. 61 коп.", UAHSpelloutFormat.format(new BigDecimal("38.61")));
        assertEquals("Пʼятдесят дві грн. 80 коп.", UAHSpelloutFormat.format(new BigDecimal("52.800999999999999999999999")));
        assertEquals("Сімдесят девʼять грн. 53 коп.", UAHSpelloutFormat.format(new BigDecimal("79.53")));
        assertEquals("Сто грн. 00 коп.", UAHSpelloutFormat.format(new BigDecimal("100")));
        assertEquals("Сто сімдесят пʼять грн. 23 коп.", UAHSpelloutFormat.format(new BigDecimal("175.23")));
        assertEquals("Пʼятсот пʼятдесят одна грн. 38 коп.", UAHSpelloutFormat.format(new BigDecimal("551.38")));
        assertEquals("Девʼятсот двадцять сім грн. 53 коп.", UAHSpelloutFormat.format(new BigDecimal("927.53")));
        assertEquals("Одна тисяча триста сімдесят пʼять грн. 23 коп.", UAHSpelloutFormat.format(new BigDecimal("1375.23")));
        assertEquals("Дві тисячі сто двадцять пʼять грн. 69 коп.", UAHSpelloutFormat.format(new BigDecimal("2125.69")));
        assertEquals("Дві тисячі пʼятсот грн. 92 коп.", UAHSpelloutFormat.format(new BigDecimal("2500.9199")));
        assertEquals("Чотири тисячі одна грн. 84 коп.", UAHSpelloutFormat.format(new BigDecimal("4001.83984375")));
        assertEquals("Девʼять тисяч шістсот тридцять грн. 29 коп.", UAHSpelloutFormat.format(new BigDecimal("9630.291015625")));
        assertEquals("Одна тисяча триста тридцять три грн. 33 коп.", UAHSpelloutFormat.format(new BigDecimal("1333.3333000")));
        assertEquals("Дві тисячі триста тридцять три грн. 33 коп.", UAHSpelloutFormat.format(new BigDecimal("2333.3332000")));
        assertEquals("Три тисячі девʼятсот девʼяносто девʼять грн. 00 коп.", UAHSpelloutFormat.format(new BigDecimal("3998.9997")));
        assertEquals("Шість тисяч триста тридцять три грн. 33 коп.", UAHSpelloutFormat.format(new BigDecimal("6333.3328")));
        assertEquals("Девʼять тисяч триста тридцять три грн. 33 коп.", UAHSpelloutFormat.format(new BigDecimal("9333.3325")));
        assertEquals("Дванадцять тисяч девʼятсот девʼяносто девʼять грн. 00 коп.", UAHSpelloutFormat.format(new BigDecimal("12998.9988")));
        assertEquals("Сімнадцять тисяч триста тридцять три грн. 33 коп.", UAHSpelloutFormat.format(new BigDecimal("17333.331699999998")));
        assertEquals("Двадцять дві тисяч триста тридцять три грн. 33 коп.", UAHSpelloutFormat.format(new BigDecimal("22333.33")));
        assertEquals("Двадцять сім тисяч девʼятсот девʼяносто девʼять грн. 00 коп.", UAHSpelloutFormat.format(new BigDecimal("27998.997")));
        assertEquals("Тридцять чотири тисяч триста тридцять три грн. 33 коп.", UAHSpelloutFormat.format(new BigDecimal("34333.33")));
        assertEquals("Сорок одна тисяч триста тридцять три грн. 33 коп.", UAHSpelloutFormat.format(new BigDecimal("41333.329")));
        assertEquals("Сорок вісім тисяч девʼятсот девʼяносто девʼять грн. 00 коп.", UAHSpelloutFormat.format(new BigDecimal("48998.9952")));
        assertEquals("Пʼятдесят сім тисяч триста тридцять три грн. 33 коп.", UAHSpelloutFormat.format(new BigDecimal("57333.3277")));
        assertEquals("Шістдесят шість тисяч триста тридцять три грн. 33 коп.", UAHSpelloutFormat.format(new BigDecimal("66333.3267")));
        assertEquals("Сімдесят пʼять тисяч девʼятсот девʼяносто девʼять грн. 99 коп.", UAHSpelloutFormat.format(new BigDecimal("75999.992499")));
        assertEquals("Вісімдесят шість тисяч триста тридцять три грн. 32 коп.", UAHSpelloutFormat.format(new BigDecimal("86333.324800")));
        assertEquals("Девʼяносто сім тисяч триста тридцять три грн. 32 коп.", UAHSpelloutFormat.format(new BigDecimal("97333.323700")));
        assertEquals("Сто вісім тисяч девʼятсот девʼяносто девʼять грн. 99 коп.", UAHSpelloutFormat.format(new BigDecimal("108999.9892")));
        assertEquals("Сто двадцять одна тисяч триста тридцять три грн. 32 коп.", UAHSpelloutFormat.format(new BigDecimal("121333.32129999999597")));
    }

}

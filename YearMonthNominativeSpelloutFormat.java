package ua.abc.util;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;
import org.joda.time.YearMonth;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimePrinter;

import com.google.common.collect.ImmutableList;

public class YearMonthNominativeSpelloutFormat {
    
    public static String format(YearMonth yearMonth, String pattern, Locale locale) {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        if (pattern.contains("MMMM")) {
            if (locale.equals(new Locale("uk"))) {
                dateTimeFormatterBuilder.append(new UkrainianNominativeMonthPrinter());
                pattern = pattern.replace("MMMM", "");
            }
            else if (locale.equals(new Locale("ru"))) {
                dateTimeFormatterBuilder.append(new RussianNominativeMonthPrinter());
                pattern = pattern.replace("MMMM", "");
            }
        }
        dateTimeFormatterBuilder.appendPattern(pattern);
        DateTimeFormatter dateTimeFormatter = dateTimeFormatterBuilder.toFormatter().withLocale(locale);
        return dateTimeFormatter.print(yearMonth);
    }
    
    public static class UkrainianNominativeMonthPrinter extends SimpleDateTimePrinter {
        private static final ImmutableList<String> MONTH_NAMES =
                ImmutableList.of("січень", "лютий", "березень", "квітень", "травень", "червень",
                        "липень", "серпень", "вересень", "жовтень", "листопад", "грудень");
        
        private static final int MAX_MONTH_LENGTH;
        
        static {
            int max = 0;
            for (String month : MONTH_NAMES) {
                if (month.length() > max) {
                    max = month.length();
                }
            }
            MAX_MONTH_LENGTH = max;
        }

        @Override
        public int estimatePrintedLength() {
            return MAX_MONTH_LENGTH;
        }

        protected String getText(ReadablePartial partial, Locale locale) {
            int month = partial.get(DateTimeFieldType.monthOfYear());
            return MONTH_NAMES.get(month - 1);
        }
    }
    
    public static class RussianNominativeMonthPrinter extends SimpleDateTimePrinter {
        private static final ImmutableList<String> MONTH_NAMES =
                ImmutableList.of("январь", "февраль", "март", "апрель", "май", "июнь",
                    "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь");
        
        private static final int MAX_MONTH_LENGTH;
        
        static {
            int max = 0;
            for (String month : MONTH_NAMES) {
                if (month.length() > max) {
                    max = month.length();
                }
            }
            MAX_MONTH_LENGTH = max;
        }

        @Override
        public int estimatePrintedLength() {
            return MAX_MONTH_LENGTH;
        }

        protected String getText(ReadablePartial partial, Locale locale) {
            int month = partial.get(DateTimeFieldType.monthOfYear());
            return MONTH_NAMES.get(month - 1);
        }
    }
    
    public static abstract class SimpleDateTimePrinter implements DateTimePrinter {
        
        protected abstract String getText(ReadablePartial partial, Locale locale);

        @Override
        public void printTo(StringBuffer buf, long instant, Chronology chrono, int displayOffset,
                DateTimeZone displayZone, Locale locale) {
            DateTime dateTime = new DateTime(instant, chrono.withZone(displayZone));
            String text = getText(dateTime.toLocalDateTime(), locale);
            buf.append(text);
        }

        @Override
        public void printTo(Writer out, long instant, Chronology chrono, int displayOffset, DateTimeZone displayZone,
                Locale locale) throws IOException {
            DateTime dateTime = new DateTime(instant, chrono.withZone(displayZone));
            String text = getText(dateTime.toLocalDateTime(), locale);
            out.write(text);
        }

        @Override
        public void printTo(StringBuffer buf, ReadablePartial partial, Locale locale) {
            buf.append(getText(partial, locale));
        }

        @Override
        public void printTo(Writer out, ReadablePartial partial, Locale locale) throws IOException {
            out.write(getText(partial, locale));
        }
        
    }

}

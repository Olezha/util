
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/* http://1cinfo.com.ua/Articles/Proverka_koda_po_EDRPOU.aspx */
/* TODO: ten digit algorithm */
public class EDRPOUValidator implements ConstraintValidator<EDRPOU, String> {
    private static final int THIRTY_MILLION = 30000000;
    private static final int SIXTY_MILLION = 60000000;
    private static final int[] LESS_THAN_30_AND_MORE_THAN_60_MILLION_WEIGHTS = {1, 2, 3, 4, 5, 6, 7};
    private static final int[] BETWEEN_30_AND_60_MILLION_WEIGHTS = {7, 1, 2, 3, 4, 5, 6};
    private static final int INCREASE_IN_VALUE = 2;

    @Override
    public void initialize(EDRPOU constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!value.matches("^\\d{8}$"))
            return false;

        int edrpou = Integer.parseInt(value);
        int checksum = 10;
        if (edrpou < THIRTY_MILLION || edrpou > SIXTY_MILLION) {
            checksum = checksum(value, LESS_THAN_30_AND_MORE_THAN_60_MILLION_WEIGHTS, false);
            if (checksum > 9)
                checksum = checksum(value, LESS_THAN_30_AND_MORE_THAN_60_MILLION_WEIGHTS, true);
        }
        else if (edrpou > THIRTY_MILLION && edrpou < SIXTY_MILLION) {
            checksum = checksum(value, BETWEEN_30_AND_60_MILLION_WEIGHTS, false);
            if (checksum > 9)
                checksum = checksum(value, BETWEEN_30_AND_60_MILLION_WEIGHTS, true);
        }

        return edrpou % 10 == checksum;
    }

    private int checksum(String edrpou, int[] weights, boolean increased) {
        int sum = 0;
        for (int i = 0; i < edrpou.length() - 1; i++) {
            int edrpouDigit = Character.digit(edrpou.charAt(i), 10);
            int weight = weights[i];
            if (increased)
                weight += INCREASE_IN_VALUE;
            sum += edrpouDigit * weight;
        }

        return sum % 11;
    }
}

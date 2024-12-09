package util;

import model.Pracownik;

import java.util.List;

public class IdentifierUtil {

    public static boolean isValidPesel(String pesel) {
        if (pesel == null || pesel.length() != 11) {
            return false;
        }

        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(pesel.charAt(i)) * weights[i];
        }

        int checksum = (10 - (sum % 10)) % 10;
        return checksum == Character.getNumericValue(pesel.charAt(10));
    }

    public static boolean isUniquePesel(String pesel, List<Pracownik> employees) {
        for (Pracownik employee : employees) {
            if (employee.getIdentifier().equals(pesel)) {
                return false;
            }
        }
        return true;
    }
}
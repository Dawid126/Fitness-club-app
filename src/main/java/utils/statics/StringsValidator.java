package utils.statics;

import java.util.ArrayList;
import java.util.List;

public class StringsValidator {
    public static boolean validateInfo (String name, String surname, String email) {
        return validateName(name) || validateName(surname) || validateEmail(email);
    }
    public static boolean validateName (String name) {
        if(name.length() <= 0)
            return true;
        List<Character> specialSigns = new ArrayList<>();
        for(Character c : "{}()[]<>;:=+_*/|0123456789,.!?~`@#$%^&*".toCharArray())
            specialSigns.add(c);

        char[] nameArray = name.toCharArray();

        for(int i=0; i<name.length(); i++) {
            if(specialSigns.contains(nameArray[i]))
                return true;
            if(i == 0) {
                if(Character.isLowerCase(nameArray[i]))
                    return true;
            }
        }
        return false;
    }
    public static boolean validateEmail (String email) {
        if(email.length() <= 0)
            return true;
        List<Character> specialSigns = new ArrayList<>();
        for(Character c : "{}()[]<>;:=+_*/|,!?~`#$%^&*".toCharArray())
            specialSigns.add(c);
        int atNumber = 0, dotsAfterAtNumber = 0, emailLength = email.length();

        char[] emailArray = email.toCharArray();
        if(emailArray[0] == '@' || emailArray[0] == '.')
            return true;
        if(emailArray[emailLength-1] == '@' || emailArray[emailLength-1] == '.')
            return true;
        for(int i=0; i<emailLength; i++) {
            if(specialSigns.contains(emailArray[i]))
                return true;
            if(emailArray[i] == '@') {
                if(atNumber == 0)
                    atNumber = 1;
                else
                    return true;
            }
            if(emailArray[i] == '.' && atNumber == 1) {
                dotsAfterAtNumber++;
            }
        }
//        return atNumber == 1 && dotsAfterAtNumber >= 1;
        return atNumber != 1 || dotsAfterAtNumber < 1;
    }
}

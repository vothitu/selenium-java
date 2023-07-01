package tvn.day1;

import java.util.regex.Pattern;

public class Basic {
    public static boolean checkNguyenAm(String letter) {
        if (letter.length() == 1) {
            if ("ueoai".contains(letter.toLowerCase())) {
                return true;
            } else return false;
        } else throw new IllegalArgumentException("Please input letter only!");
    }

    public static boolean checkPasswordPolicy(String password) {
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@$!%*?&])[A-Za-z\\\\d@$!%*?&]{9,}$";
        Pattern re = Pattern.compile(pattern);
        return re.matcher(password).find();
    }
    public static boolean isPalindrome(String input) {
        for (int i = 0; i <= input.length() / 2 - 1; i++) { // i 0 -> 1
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String password = "P@aword1";
    }
}

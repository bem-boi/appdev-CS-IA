package Util;

import java.security.SecureRandom;
import java.util.regex.*;

// this checks for the password's conditions
// https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/ 

public final class PasswordGenUtils {

    private static SecureRandom rand = new SecureRandom();
    
    private PasswordGenUtils(){
        throw new AssertionError("Instantiating utility class.");    
    }

    // generates the password
    public static String generatePassword(int n){
        int num = rand.nextInt(126-33) + 33; // convert in to ascii
        if(n == 1){
            return (char)num + "";
        }else{
            return generatePassword(n-1) + (char)num;
        }
    }

    // checks for the password's condition
    public static boolean isValidPassword(String password){
        if (password == null){
            return false;
        }

        String PasswordConditions = "^(?=.*[0-9])"
                        + "(?=.*[a-z])(?=.*[A-Z])"
                        + "(?=.*[@#$%^&+-=(),/:;_~<>{}|])" // special characters password need to have
                        + "(?=\\S+$).{12,50}$";

        Pattern patt = Pattern.compile(PasswordConditions);
        return patt.matcher(password).matches();
    }

    public static boolean isValidEmail(String email) // https://www.geeksforgeeks.org/check-email-address-valid-not-java/#:~:text=Given%20a%20string%2C%20find%20if,is%20an%20extra%20dot(.)
    {
        if (email == null)
            return false;
        String EmailCondition = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
        Pattern patt = Pattern.compile(EmailCondition);
        return patt.matcher(email).matches();
    }

}

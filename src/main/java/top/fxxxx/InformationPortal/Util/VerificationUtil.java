package top.fxxxx.InformationPortal.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificationUtil {

    public static boolean isEmail(String email)
    {
        String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

        if (match(regex,email))System.out.println(email);
        return match( regex ,email );
    }
    private static boolean match( String regex ,String str ){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher( str );
        return matcher.matches();
    }
    public static boolean isHomepage( String str ){
        String regex = "http://(([a-zA-z0-9]|-){1,}\\.){1,}[a-zA-z0-9]{1,}-*" ;
        return match( regex ,str );
    }
    public static boolean isPower(int holder,int geter)
    {
        while ( geter>0)
        {
            if(geter%2>holder%2)return false;
            geter/=2;
            holder/=2;
        }
        return true;
    }
}

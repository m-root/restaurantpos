/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package other;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 457226
 */
public class StringMod {

    /**
     * adds spaces to the end of a string
     * @param s  the string that spaces will be added to
     * @param spaces  the number of spaces
     * @return the string with added spaces
     */
    public String addSpace(String s, int spaces){
        int l = s.length();
        while(l+spaces>s.length()){
            s+=" ";
        }
        return s;
    }

    /**
     * takes a string and adds spaces infront and at the end
     * to center the string
     * @param s the string that is to be centerd
     * @param space the amount of space then the string needs to be centered into
     * @return the string centered in spaces
     * @throws java.lang.Exception
     */
    public String center(String s, int space){
        String str = "";
        Exception toBig = new Exception();
        int spacesToFill = space-s.length();
        if(spacesToFill<0){
            try {
                throw toBig;
            } catch (Exception ex) {
                Logger.getLogger(StringMod.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int begin = spacesToFill/2;
        while(str.length()<begin)
            str+=" ";
        str+=s;
        while(str.length()<spacesToFill)
            str+=" ";
        return str;
    }



    //Date Stuff (Calendar)

    public String twentyFourToAMPM(int time){
        String str = "";
        if(time<12){
            str = time+"AM";
        }else{
            str = (time-12)+"PM";
        }
        return str;
    }
    /**
     * takes in a int from 0-11 and will return a corrasponding 3 letter String for the month that corrasponds to the int
     * @param mm the month 0-11
     * @return the month in letters
     */
    public String numToMonth(int mm){
        String str = "";
        if(mm==0){
            str = "Jan";
        }else if(mm==1){
            str = "Feb";
        }else if(mm==2){
            str = "Mar";
        }else if(mm==3){
            str = "Apr";
        }else if(mm==4){
            str = "May";
        }else if(mm==5){
            str = "Jun";
        }else if(mm==6){
            str = "Jul";
        }else if(mm==7){
            str = "Aug";
        }else if(mm==8){
            str = "Sep";
        }else if(mm==9){
            str = "Oct";
        }else if(mm==10){
            str = "Nov";
        }else if(mm==11){
            str = "Dec";
        }
        return str;
    }

    /**
     * takes in an int 1-7 and will return a a corrasponding 3 letter String for the day that corrasponds to the int
     * @param mm the day of the week 1-7
     * @return the day of the week in letters
     */
    public String numToWeekDay(int mm){
        String str = "";
        if(mm==1){
            str = "SUN";
        }else if(mm==2){
            str = "MON";
        }else if(mm==3){
            str = "TUE";
        }else if(mm==4){
            str = "WED";
        }else if(mm==5){
            str = "THU";
        }else if(mm==6){
            str = "FRI";
        }else if(mm==7){
            str = "SAT";
        }
        return str;
    }
}

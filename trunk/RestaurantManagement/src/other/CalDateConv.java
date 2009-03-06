/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package other;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 457226
 */
public class CalDateConv {
    /**
     * takes in a Calendar and returns it as Date
     * @param cal the Calendar to be converted
     * @return a date that is the same time as the Calendar
     */
    public Date calToDate(Calendar cal){
        Date dt = new Date();
        dt.setDate(cal.get(cal.DAY_OF_MONTH));
        dt.setHours(cal.get(cal.HOUR_OF_DAY));
        dt.setMinutes(cal.get(cal.MINUTE));
        dt.setMonth(cal.get(cal.MONTH));
        dt.setSeconds(cal.get(cal.SECOND));
        dt.setYear(cal.get(cal.YEAR));
        return dt;
    }
    /**
     * takes in a date and returns it as a Calendar
     * @param dt the Date to be converted
     * @return a Calendar that is the same time as the date
     */
    public Calendar dateToCal(Date dt){
        Calendar cal = Calendar.getInstance();
        cal.set(cal.DAY_OF_MONTH, dt.getDate());
        cal.set(cal.HOUR_OF_DAY, dt.getHours());
        cal.set(cal.MINUTE, dt.getMinutes());
        cal.set(cal.MONTH, dt.getMonth());
        cal.set(cal.SECOND, dt.getMonth());
        cal.set(cal.YEAR, dt.getYear());
        return cal;
    }
}

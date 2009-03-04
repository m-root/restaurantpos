/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesscalendar;

import businessobjects.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author 457226
 */
public class TimeKeeper {

    public ArrayList<ArrayList<Shift>> times;


    public static TimeKeeper timeKeeper;
    public TimeKeeper() {
        times = new ArrayList();
    }
    public static TimeKeeper getTimeKeeper(){
        if(timeKeeper==null)
        {
            timeKeeper = new TimeKeeper();
        }
        return timeKeeper;
    }

    /**
     * looks threw the times array and looks for empty ids
     * @return a id that is not in use yet
     */
    public int getNextID(){
        int id = 0;
        boolean free = false;
        while(!free){
            free = true;
            id++;
            for(int i = 0;i<times.size();i++){
                for(int j = 0;j<times.get(i).size();j++){
                    if(id==times.get(i).get(j).getId()){
                        free = false;
                        break;
                    }
                }
                if(!free)
                    break;
            }
        }
        return id;
    }


    /**
     * takes in a Shift object and if the times array is not empty then it finds the place for the new Shift and adds it
     * each shift is added to an array(time slot), if there is no array at the time slot of the new shift then a new array is created
     * @param sf the Shift object to be added to the times array
     */
    public void addShift(Shift sf){
        int i = 0;
        System.out.println("adding");
        if(times.size()>0){
            System.out.println("adding addition");
            while(i<times.size()){
                ArrayList<Shift> sfs = times.get(i);
                int j = 0;
                int dif = sf.compareTo(sfs.get(j));
                if(dif==0){
                    System.out.println("adding with");
                    sfs.add(sf);
                    times.set(i, sfs);
                    break;
                }else if(dif>0){
                    if(i+1==times.size()){
                        System.out.println("adding end");
                        sfs = new ArrayList();
                        sfs.add(sf);
                        times.add(sfs);
                        break;
                    }else{
                        i++;
                    }
                }else if(dif<0){
                    System.out.println("adding in");
                    sfs = new ArrayList();
                    sfs.add(sf);
                    times.add(i, sfs);
                    break;
                }
            }
        }else{
            System.out.println("adding 1st");
            ArrayList<Shift> sfs = new ArrayList();
            sfs.add(sf);
            times.add(sfs);
        }
    }

    /**
     * used for testing
     * prints to the command line the time slots in the times arrayList and employs that work at the time slot
     */
    public void print(){
        int i = 0;
        System.out.println(times.size());
        while(i<times.size()){
            System.out.println(times.get(i).get(0).getIn().get(Calendar.YEAR)+"/"+times.get(i).get(0).getIn().get(Calendar.MONTH)+"/"+times.get(i).get(0).getIn().get(Calendar.DAY_OF_MONTH)+" : "+times.get(i).get(0).getIn().get(Calendar.HOUR_OF_DAY));
            for(int j = 0;j<times.get(i).size();j++){
                System.out.println("\t"+times.get(i).get(j).getEmployee().getFName());
            }
            i++;
        }
    }

}

package ski_passes;

import abonement.Time_Of_Week_Abonement;
import abonement.By_Tries_Abonement;

import java.util.Calendar;

abstract class Pass {

    private Time_Of_Week_Abonement what_days_of_week;
    private By_Tries_Abonement how_many_tries;
    public Calendar end_date;


    void use() {

    }

    private Calendar getEndDate(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        return cal;
    }

    Pass(Time_Of_Week_Abonement what_days_of_week, By_Tries_Abonement how_many_tries) {

        this.what_days_of_week = what_days_of_week;
        this.how_many_tries = how_many_tries;
        this.end_date = getEndDate();
    }
}

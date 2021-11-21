package ski_passes;

import abonement.By_Days_Abonement;
import abonement.Week_Days;
import abonement.By_Type_Abonement;
import lombok.Getter;

import java.util.Calendar;

@Getter
public abstract class Pass {

    protected Week_Days what_days;
    protected By_Type_Abonement type_of_tries;

    protected Integer id;
    protected Calendar end_date;
    protected boolean isBlocked = false;

    Pass(Week_Days days_of_week, By_Type_Abonement type_of_tries) {
        what_days = days_of_week;
        type_of_tries = type_of_tries;
        end_date = setEndDate();
    }
    Calendar getToday(){
        Calendar cal  = Calendar.getInstance();
        return cal;
    }

    private Calendar setEndDate(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        return cal;
    }
}

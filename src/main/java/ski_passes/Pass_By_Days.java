package ski_passes;

import abonement.By_Type_Abonement;
import abonement.Week_Days;
import lombok.Getter;

import java.util.Calendar;

@Getter
class Pass_By_Days extends Pass{

//    protected Week_Days what_days;
//    protected By_Type_Abonement type_of_tries;
//
//    protected Integer id;
//    protected Calendar end_date;
//    protected boolean isBlocked = false;

    protected Calendar last_used_date;

    int days_balance;

    Pass_By_Days(Week_Days days_of_week,
                        By_Type_Abonement how_much_days) {
        super(days_of_week, how_much_days);

        last_used_date = Calendar.getInstance();
        last_used_date.add(Calendar.DAY_OF_MONTH, -1);

        days_balance = how_much_days.getTries();
    }

    public boolean use() {
        if (last_used_date.equals(this.getToday())){
            return true;

        } else if (days_balance > 0){
            days_balance --;
            return true;
        }
        return false;

    }
}

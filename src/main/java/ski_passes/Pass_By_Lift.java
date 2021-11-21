package ski_passes;

import abonement.By_Type_Abonement;
import abonement.Week_Days;
import lombok.Getter;


class Pass_By_Lift extends Pass{
    @Getter
    private int lifts_balance;

    Pass_By_Lift(Week_Days days_of_week, By_Type_Abonement type_of_tries) {
        super(days_of_week, type_of_tries);
        lifts_balance = type_of_tries.getTries();
    }

    boolean use() {
        if (lifts_balance > 0){
            lifts_balance --;
            return true;
        }
        return false;
    }

}

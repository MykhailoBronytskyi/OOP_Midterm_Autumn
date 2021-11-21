package ski_passes;

import abonement.By_Type_Abonement;
import abonement.Week_Days;

public class Pass_By_Season extends Pass{

    Pass_By_Season(Week_Days days_of_week, By_Type_Abonement type_of_tries) {
        super(days_of_week, type_of_tries);
    }

    boolean use() {
        return true;
    }
}

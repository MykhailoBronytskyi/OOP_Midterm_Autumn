import abonement.*;
import ski_passes.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

    Ski_System system = Ski_System.getSki_System();
    Tourniquet gate = new Tourniquet(system);

//  Shouldn't work
//  Pass season_card_forbidden = system.getCard(Working_Days.WORKING_DAYS, By_Season_Abonement.SEASON_DAYS);
//  Pass card = new Pass_By_Days(Weekend.WEEKEND, By_Days_Abonement.FIVE_DAYS);

    Pass lift_card =  system.getCard(Weekend.WEEKEND, By_Lift_Abonement.TEN_TRIES);
    Pass day_card = system.getCard(Weekend.WEEKEND, By_Days_Abonement.ONE_DAY);
    Pass season_card = system.getCard(Weekend.WEEKEND, By_Days_Abonement.FIVE_DAYS);
    System.out.println(day_card.getClass());
//    System.out.println(((Pass_By_Days) day_card).getLifts_balance());
        

    System.out.println(gate.checkId(day_card)+"\n"+
                            gate.checkEndDate(day_card)+"\n"+
                            gate.checkDayOfWeek(day_card)+"\n"+
                            gate.checkSeasonCase(day_card)+"\n");

    System.out.println(gate.goThrough(day_card));
    System.out.println(system.getUser_ids());
    System.out.println(system.getUser_logs());




    }
}

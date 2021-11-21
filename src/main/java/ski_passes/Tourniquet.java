package ski_passes;

import abonement.By_Lift_Abonement;
import abonement.By_Season_Abonement;
import abonement.Weekend;
import abonement.Working_Days;

import java.util.Calendar;

public class Tourniquet {

    private Ski_System system;

    public Tourniquet(Ski_System system){
        this.system = system;
    }

    public boolean checkId(Pass pass_card){
        if (system.user_ids.containsKey(pass_card.id)){
            return true;
        }
        return false;
    }

    public boolean checkEndDate(Pass pass_card){
        if (pass_card.end_date.after(system.getToday())){
            return true;
        }
        return false;
    }

    public boolean checkDayOfWeek(Pass pass_card){

        int today = system.getToday().get(Calendar.DAY_OF_WEEK);

        if ((pass_card.what_days instanceof Weekend) &&
           ((today == Calendar.SATURDAY) || (today == Calendar.SUNDAY))){
            return true;

        } else if ((pass_card.what_days instanceof Working_Days) &&
                ((today != Calendar.SATURDAY) && (today != Calendar.SUNDAY))){
            return true;
        }
        return false;
    }

    //Season-card can be only for weekends
    public boolean checkSeasonCase(Pass pass_card){
        if (pass_card instanceof Pass_By_Season){
            if (pass_card.what_days instanceof Working_Days){
                return false;
            }
        }
        return true;
    }

    public boolean goThrough(Pass card){

        if (!checkId(card) || !checkEndDate(card) || !checkSeasonCase(card)){
            system.blockCard(card);
        }
        if (!card.isBlocked && checkDayOfWeek(card)){
            system.use_logs_Adder(card, "Access allowed");
            return true;
        }
        system.use_logs_Adder(card, "Access denied");
        return false;


    }
}

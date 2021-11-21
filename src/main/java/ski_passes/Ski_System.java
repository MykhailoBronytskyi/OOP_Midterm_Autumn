package ski_passes;

import abonement.*;
import com.sun.org.apache.xml.internal.security.signature.ReferenceNotInitializedException;
import lombok.Getter;
import lombok.Setter;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.concurrent.ExecutionException;


public class Ski_System {

    static Ski_System ski_system;
    @Getter
    Hashtable<Integer, Pass> user_ids = new Hashtable<>();
    @Getter
    Hashtable<Integer, ArrayList<String>> user_logs = new Hashtable<>();
    Integer number_of_cards = 0;

    private Ski_System(){
    }

    public static Ski_System getSki_System(){
        if (ski_system == null){
            ski_system = new Ski_System();
        }
        return ski_system;
    }

    //Create new id for new pass_card
    private void create_Id(Pass pass_card){
        number_of_cards += 1;
        pass_card.id = number_of_cards;
        user_ids.put(pass_card.id, pass_card);

    }

    //Remember active history of pass_cards
    void use_logs_Adder(Pass pass_card, String message){
        ArrayList log_list = user_logs.get(pass_card.id);

        String date = " : " + pass_card.getToday().getTime().toString();
        log_list.add(message + date);

        user_logs.put(pass_card.id, log_list);
    }

    Calendar getToday(){
        Calendar cal  = Calendar.getInstance();
        return cal;
    }


    public Pass getCard(Week_Days what_days, By_Type_Abonement type_of_pass) {

        Pass pass_card = null;

        //check if we don't make impossible card
        if (what_days instanceof Working_Days &&
                type_of_pass instanceof By_Season_Abonement) {
            throw new InvalidParameterException(
                    "You can't create card_pass on Season on working days");
        }

        // create Days-card
        if (type_of_pass instanceof By_Days_Abonement) {
            pass_card = new Pass_By_Days(what_days, type_of_pass);

        // create Lifts-card
        } else if (type_of_pass instanceof By_Lift_Abonement) {
            pass_card = new Pass_By_Lift(what_days, type_of_pass);

        // create Season-card
        } else if (type_of_pass instanceof By_Season_Abonement){
            pass_card = new Pass_By_Season(what_days, type_of_pass);
        }

        if (pass_card == null){
            throw new ExceptionInInitializerError("Pass card didn't initialise");
        }

        this.create_Id(pass_card);
        user_logs.put(pass_card.id, new ArrayList<String>());

        this.use_logs_Adder(pass_card, "Card was made");

        return pass_card;
    }

    void blockCard(Pass pass_card){
        pass_card.isBlocked = true;
        this.use_logs_Adder(pass_card, "Card was blocked");
    }

}

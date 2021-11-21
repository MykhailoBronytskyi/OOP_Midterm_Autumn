package abonement;

public enum By_Lift_Abonement implements By_Type_Abonement {

    TEN_TRIES (10),
    TWENTY_TRIES(20),
    FIFTY_TRIES(50),
    HUNDRED_TRIES(100);

    private int lifts;

    By_Lift_Abonement(int tries){
        this.lifts = tries;
    }
    public int getTries(){
        return lifts;
    }
}

package abonement;

public enum By_Lift_Abonement implements By_Tries_Abonement {

    TEN_TRIES (10),
    TWENTY_TRIES(20),
    FIFTY_TRIES(50),
    HUNDRED_TRIES(100);

    private int tries;

    By_Lift_Abonement(int tries){
        this.tries = tries;
    }
    public int getTries(){
        return tries;
    }
}

package abonement;

public enum By_Days_Abonement implements By_Tries_Abonement {
    ONE_DAY (1),
    TWO_DAYS (2),
    FIVE_DAYS (5),

    SEASON_DAYS (365);


    private int tries;

    public int getTries(){
        return tries;
    }
//  construct abonement on a few days
    By_Days_Abonement(int tries){
        this.tries = tries;
    }

}

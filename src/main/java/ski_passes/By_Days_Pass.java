package ski_passes;

public enum By_Days_Pass implements Ski_Pass {
    ONE_DAY (1),
    TWO_DAYS (2),
    FIVE_DAYS (5),

    SEASON_DAYS (365);


    private int tries;

    By_Days_Pass(int tries){
        this.tries = tries;
    }
    public int getTries(){
        return tries;
    }
}

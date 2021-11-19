package ski_passes;

public enum By_Tries_Pass implements Ski_Pass {

    TEN_TRIES (10),
    TWENTY_TRIES(20),
    FIFTY_TRIES(50),
    HUNDRED_TRIES(100);

    private int tries;
    public int getTries(){
        return tries;
    }
//  construct abonement on a few tries
    By_Tries_Pass(int tries){
        this.tries = tries;
    }

}

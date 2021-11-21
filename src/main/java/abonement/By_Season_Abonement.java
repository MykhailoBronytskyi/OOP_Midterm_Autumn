package abonement;

public enum By_Season_Abonement implements By_Type_Abonement {

    SEASON_DAYS (365);


    private int tries;
    public int getTries(){
        return tries;
    }

    By_Season_Abonement(int tries){
        this.tries = tries;
    }

}

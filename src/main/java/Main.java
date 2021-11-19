import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Date date = new Date();
        Date date_2 = new Date();

        System.out.println(date_2.getTime() +"\n"+ date.getTime());
        System.out.println(date_2+"\n"+date);

        Sub sub = new Sub();
        System.out.println(sub.getNum());
        System.out.println(sub.getNum(2f));
        System.out.println(sub.getNum(2f,2));
//        System.out.println(sub.getNum());


    }
}

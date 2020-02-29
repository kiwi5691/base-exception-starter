package exception.demo.base;

public class Case {

    public static void var1(Integer a,Integer b){


        if(a.equals(b)){
            String message =" a cant to be b";
            Throwable throwable = new Throwable(message);
            throw new MyException("fucked",throwable);
        }
    }
}

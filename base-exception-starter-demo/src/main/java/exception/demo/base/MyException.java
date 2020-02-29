package exception.demo.base;

public class MyException extends RuntimeException   {

    public MyException(String a){
        super(a);
    }

    public MyException(Throwable b){
        super(b);
    }

    public MyException(String a,Throwable b){
        super(a,b);
    }

}

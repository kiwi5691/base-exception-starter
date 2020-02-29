package exception.demo.base;


public class test {


    public static void main(String[] args){
        try {
            Case.var1(1, 1);
        }catch (MyException e){
            System.out.println(e);
            throw new MyException("fuck",e);

        }
        }
}

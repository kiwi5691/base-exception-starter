package exception;

public class GetHashCodeClass {
    private String targe;
    public GetHashCodeClass(String target){
        this.targe = target;
    }

    public String getHashCode(){
        return String.valueOf(this.targe.hashCode());
    }
    public String getName(){
        return String.valueOf(this.targe);
    }
}

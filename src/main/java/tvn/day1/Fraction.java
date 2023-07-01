package tvn.day1;

public class Fraction {
    int tu;
    int mau;



    public Fraction(int tu, int mau){
        if(mau ==0){
            throw new IllegalArgumentException("Mau so phai khac 0");
        }
        this.tu = tu;
        this.mau = mau;
    }
    public int getTu() {
        return tu;
    }

    public int getMau() {
        return mau;
    }
    public Fraction Sum(Fraction f){
        int t = f.getTu() *f.getMau() + f.getTu() *f.getMau();
        int m = f.getMau()*f.getMau();
        System.out.println("Tong 2 phan so la: " + t+"/"+m);
        return f;
    }
    public void info(){

    }
    public void compare(Fraction f){
        if(this.tu * f.getMau()== this.mau * f.getTu()){
            System.out.println("Hai phân số bằng nhau");
        } else if(this.tu * f.getMau()> this.mau * f.getTu()){
            System.out.println("Phân số lớn hơn");
        }else {
            System.out.println("Phân số nhỏ hơn ");
        }
    }

}

package cn.edu.lingnan.demo02;

public class LandlordProxy implements Rent {
    private Landlord landlord;

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    @Override
    public void rent() {
        seeHouse();
        landlord.rent();
        signContract();
    }

    public  void seeHouse(){
        System.out.println("哈哈哈2");
    }

    public  void signContract(){
        System.out.println("哈哈哈3");
    }
}

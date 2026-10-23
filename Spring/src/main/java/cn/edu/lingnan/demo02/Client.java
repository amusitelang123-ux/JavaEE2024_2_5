package cn.edu.lingnan.demo02;

public class Client {
    public static void main(String[] args) {
//        Landlord landlord = new Landlord();
//        landlord.seeHouse();
//        landlord.rent();
//        landlord.signContract();
        Landlord landlord = new Landlord();
        LandlordProxy landlordProxy = new LandlordProxy();
        landlordProxy.setLandlord(landlord);
        landlordProxy.rent();
    }
}

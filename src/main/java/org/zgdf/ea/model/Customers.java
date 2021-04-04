package org.zgdf.ea.model;

public class Customers {

    private int customerID;
    private String cName;
    private int cZip;
    private String cCity;
    private String cAddress;
    private String cUser;

    public String getcUser() {
        return cUser;
    }

    public void setcUser(String cUser) {
        this.cUser = cUser;
    }

    public String getcPass() {
        return cPass;
    }

    public void setcPass(String cPass) {
        this.cPass = cPass;
    }
    private String cPass;

//    public Customers(int id, String name, int zip, String city, String address) {
//        super();
//        this.customerID = id;
//        this.cName = name;
//        this.cZip = zip;
//        this.cCity = city;
//        this.cAddress = address;
//    }
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getcZip() {
        return cZip;
    }

    public void setcZip(int cZip) {
        this.cZip = cZip;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    @Override
    public String toString() {
        return "Customers{" + "customerID=" + customerID + ", cName=" + cName + ", cZip=" + cZip + ", cCity=" + cCity + ", cAddress=" + cAddress + ", cUser=" + cUser + ", cPass=" + cPass + '}';
    }

}

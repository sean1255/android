package com.example.test;

public class Memberinfo {

    private String name;
    private String phoneNumber;
    private String birthDay;
    private String address;

    public Memberinfo(String name, String phoneNumber, String birthDay, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.address = address;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getphoneNumber(){
        return this.phoneNumber;
    }
    public void setphoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getbirthDay(){
        return this.birthDay;
    }
    public void setbirthDay(String birthDay){
        this.birthDay = birthDay;
    }

    public String getaddress(){
        return this.address;
    }
    public void setaddress(String address){
        this.address = address;
    }

}

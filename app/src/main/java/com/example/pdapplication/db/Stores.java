package com.example.pdapplication.db;

public class Stores {
    private int id = 0;
    private String name = "";
    private String address = "";
    private String tel = "";

    public  Stores(int id, String name, String address, String tel){
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getTel(){
        return tel;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setTel(String tel){
        this.tel = tel;
    }
}

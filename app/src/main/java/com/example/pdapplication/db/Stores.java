package com.example.pdapplication.db;

public class Stores {
    private int id = 0;
    private String name = "";
    private String address = "";
    private String tel = "";
    private String option = "";
    private String area = "";
    private String url = "";

    public  Stores(int id, String name, String address, String tel, String option, String area, String url){
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.option = option;
        this.area = area;
        this.url = url;
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

    public String getOption(){
        return option;
    }

    public String getArea(){
        return area;
    }

    public String getUrl(){
        return url;
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

    public void setOption(String option){
        this.option = option;
    }

    public void setArea(String area){
        this.area = area;
    }

    public void setUrl(String url){
        this.url = url;
    }
}

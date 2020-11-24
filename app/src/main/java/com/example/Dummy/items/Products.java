package com.example.Dummy.items;

public class Products {
    private String mName;
    private String mPrice;
    private Integer mImage;

    public Products(){}
    public Products(String Name, String Price, Integer Image) {

        this.mName = Name;
        this.mPrice =Price;
        this.mImage = Image;
    }

    public void setName(String name) {
        this.mName= name;
    }
    public void setImage(Integer image) {
        this.mImage= image;
    }
    public void setPrice(String price) {
        this.mPrice= price;
    }


    public String getName() {
        return mName;
    }
    public Integer getImage() {
        return mImage;
    }
    public String getPrice() {
        return mPrice;
    }

}
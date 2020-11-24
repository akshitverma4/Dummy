package com.example.Dummy.items;

public class MyPetsItem {
        private String petName;
        private String petType;

        public MyPetsItem(String name, String pettype){
            petName = name;
            petType = pettype;
        }
        public MyPetsItem(){

        }

        public void setPetName(String name) {
            this.petName= name;
        }
        public String getPetName() {
            return petName;
        }


    public String getPetType() {
        return petType;
    }

    public void setPetType(String pettype) {
        petType = pettype;
    }
}
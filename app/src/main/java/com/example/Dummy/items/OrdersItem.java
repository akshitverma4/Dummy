package com.example.Dummy.items;

public class OrdersItem {
        private String mName;
        private Integer mImage;
        private String mStatus;

        public OrdersItem(){}
        public OrdersItem(String Name, Integer Image, String Status) {

            this.mName = Name;
            this.mImage = Image;
            this.mStatus= Status;
        }

        public void setName(String name) {
            this.mName= name;
        }
        public void setImage(Integer image) {
            this.mImage= image;
        }
        public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
             }

        public String getName() {
            return mName;
        }
        public Integer getImage() {
            return mImage;
        }
        public String getmStatus() {
            return mStatus;
        }


}
package com.example.Dummy.items;

public class ProvidersFeedback {
        private String mName;
       private String Feedback;

        public ProvidersFeedback(){}
        public ProvidersFeedback(String Name, Integer Image, String feedback) {

            this.mName = Name;

            Feedback = feedback;
        }

        public void setName(String name) {
            this.mName= name;
        }
        public String getName() {
            return mName;
        }
        public String getFeedback() {
            return Feedback;
        }
        public void setFeedback(String feedback) {
            Feedback = feedback;
        }
}
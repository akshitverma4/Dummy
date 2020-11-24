package com.example.Dummy.Payments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.braintreepayments.cardform.view.CardForm;

import com.example.Dummy.R;


public class CardPayment extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_payment);


        CardForm cardForm = (CardForm) findViewById(R.id.card_form);
        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .cardholderName(CardForm.FIELD_REQUIRED)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("SMS is required on this number")
                .actionLabel("Purchase")
                .setup(CardPayment.this);


        cardForm.getCardNumber();
        cardForm.getExpirationMonth();
        cardForm.getExpirationYear();
        cardForm.getCvv();
        cardForm.getCardholderName();
        cardForm.getPostalCode();
        cardForm.getCountryCode();
        cardForm.getMobileNumber();

    }
}
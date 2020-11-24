package com.example.Dummy;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Dummy.Dialog.CustomDialogClassSuccess;

public class EditPet extends AppCompatActivity {

    EditText petName;
    EditText petAge;
    RadioGroup gender;
    RadioGroup petType;
    RadioGroup petSize;
    RadioButton male;
    RadioButton female;
    RadioButton dog;
    RadioButton cat;
    RadioButton small;
    RadioButton medium;
    RadioButton large;
    RadioButton notSure;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_pet);

        petName = findViewById(R.id.pet_name);
        petType = findViewById(R.id.pet_type);
        cat = findViewById(R.id.cat);
        petAge = findViewById(R.id.petAge);
        gender =findViewById(R.id.gender);
        petSize = findViewById(R.id.petSize);
        male =findViewById(R.id.male);
        female =findViewById(R.id.female);
        small =findViewById(R.id.small);
        medium =findViewById(R.id.medium);
        large =findViewById(R.id.large);
        notSure =findViewById(R.id.notSure);

        Button next = findViewById(R.id.finish_add_pet);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petName.setError(null);
                cat.setError(null);
                female.setError(null);
                notSure.setError(null);
                petAge.setError(null);
                if(petType.getCheckedRadioButtonId()==-1){
                    cat.setError("choose one");

                }
                else if(petName.getText().toString().equals("")){
                    petName.setError("Can't be empty");
                }
                else if(gender.getCheckedRadioButtonId()==-1){
                    female.setError("choose one");
                }
                else if(petAge.getText().toString().equals("")) {
                    petAge.setError("Can't be empty");
                    petAge.requestFocus();
                }
                else if(petSize.getCheckedRadioButtonId()==-1){
                    notSure.setError("choose one");
                }
                else {
                    CustomDialogClassSuccess cdd = new CustomDialogClassSuccess(EditPet.this);
                    cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    cdd.show();
//                    Intent intent = new Intent(AddNewPet.this, BookForm2.class);
//                    startActivity(intent);
                }
            }
        });
        //back Button
        ImageView back =findViewById(R.id.back_add_pet);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

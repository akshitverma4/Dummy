package com.example.Dummy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AddNewPet extends AppCompatActivity {

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
    RadioGroup allergies;
    RadioButton others;
    EditText othersText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pet);

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
        allergies=findViewById(R.id.allergies);
        others =findViewById(R.id.allergyothers);
        othersText = findViewById(R.id.otherAllergyText);
        othersText.setVisibility(View.GONE);
        allergies.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(allergies.getCheckedRadioButtonId()==others.getId()){
                    othersText.setVisibility(View.VISIBLE);
                }
                else{
                    othersText.setVisibility(View.GONE);
                }
            }
        });

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
                else if(petAge.getText().toString().equals("") || Integer.parseInt(petAge.getText().toString())>25)
                    petAge.setError("Please enter a valid Age");
                else if(petAge.getText().toString().equals("")) {
                    petAge.setError("Can't be empty");
                    petAge.requestFocus();
                }
                else if(petSize.getCheckedRadioButtonId()==-1){
                    notSure.setError("choose one");
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddNewPet.this);
                    builder.setCancelable(true);
                    builder.setTitle("Add new pet");
                    builder.setMessage("Are you sure?");
                    builder.setPositiveButton("Confirm",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();

//                    CustomDialogClassSuccess cdd = new CustomDialogClassSuccess(AddNewPet.this);
//                    cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                    cdd.show();
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

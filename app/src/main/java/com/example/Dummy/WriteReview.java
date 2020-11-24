package com.example.Dummy;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class WriteReview extends AppCompatActivity {


    ImageView choose;
    Button upload;
    int PICK_IMAGE_REQUEST = 111;
    String URL ="http://192.168.1.101/JavaRESTfullWS/DemoService/upload";
    Bitmap bitmap;
    ProgressDialog progressDialog;
    RatingBar ratingBar;
    EditText head;
    EditText main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_review);


        choose = findViewById(R.id.upload_image);
        upload = (Button)findViewById(R.id.upload);
        ratingBar = findViewById(R.id.ratingBar);
        head = findViewById(R.id.review_head);
        main = findViewById(R.id.review_main);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating<1.0f) {
                   // Toast.makeText(WriteReview.this, "Please give 1 or more stars", Toast.LENGTH_SHORT).show();
                    ratingBar.setRating(0f);
                }
            }
        });

        //opening image chooser option
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
                AlertDialog.Builder builder = new AlertDialog.Builder(WriteReview.this);
                builder.setTitle("Add Photo!");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (options[item].equals("Take Photo"))
                        {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, 1);
                        }
                        else if (options[item].equals("Choose from Gallery"))
                        {
                            Intent intent = new Intent();
                            intent.setType("image/*");
                            intent.setAction(Intent.ACTION_PICK);
                            startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
                        }
                        else if (options[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });


        ImageView back = findViewById(R.id.back_write_review);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ratingBar.getRating()==0f)
                {
                    new AlertDialog.Builder(v.getContext())
                            .setTitle("Rating can't be zero!")
                            .setMessage("Please give 1 or more stars")
                            .show();
                }
                else if(head.getText().toString().equals(""))
                {
                    Log.d("head", "onClick: "+head.getText());
                    head.setError("Can't be empty");
                    head.requestFocus();
                   head.setBackground(ContextCompat.getDrawable(v.getContext(),R.drawable.error_tab));
                    new AlertDialog.Builder(v.getContext())
                            .setTitle("Heading can't be empty")
                            .setMessage("Please write a suitable heading")
                            .show();
                }
                if(!head.getText().toString().equals(""))
                    head.setBackground(ContextCompat.getDrawable(v.getContext(),R.drawable.search_tab));
                //converting image to base64 string
                if(bitmap!=null) {
                    progressDialog = new ProgressDialog(WriteReview.this);
                    progressDialog.setMessage("Uploading, please wait...");
                    progressDialog.show();

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] imageBytes = baos.toByteArray();
                    final String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);

                    //sending image to server
                    StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            progressDialog.dismiss();
                            if (s.equals("true")) {
                                Toast.makeText(WriteReview.this, "Uploaded Successful", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(WriteReview.this, "Some error occurred!", Toast.LENGTH_LONG).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            Toast.makeText(WriteReview.this, "Some error occurred -> " + volleyError, Toast.LENGTH_LONG).show();
                            ;
                        }
                    }) {
                        //adding parameters to send
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> parameters = new HashMap<String, String>();
                            parameters.put("image", imageString);
                            return parameters;
                        }
                    };

                    RequestQueue rQueue = Volley.newRequestQueue(WriteReview.this);
                    rQueue.add(request);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();

            try {
                //getting image from gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                //Setting image to ImageView
                choose.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (requestCode == 1 && resultCode == RESULT_OK && data != null ) {
            Log.d("capture", "onActivityResult: capture image");
            bitmap = (Bitmap) data.getExtras().get("data");
            choose.setImageBitmap(bitmap);
        }
    }
}

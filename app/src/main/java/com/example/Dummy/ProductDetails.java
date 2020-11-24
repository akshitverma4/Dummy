package com.example.Dummy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import com.example.Dummy.adapter.RecyclerViewAdapterReviewPics;
import com.example.Dummy.adapter.RecyclerViewAdapterReviews;
import com.example.Dummy.adapter.ViewPagerAdapter;
import com.example.Dummy.items.ReviewPics;
import com.example.Dummy.items.Reviews;

public class ProductDetails extends AppCompatActivity {
    public Boolean isLike =false;
    public Integer Qty= 1;
    public int n=3;

    private ArrayList<ReviewPics> ReviewPicsList;
    private RecyclerView reviewPicsRecyclerView;
    private RecyclerViewAdapterReviewPics mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

   private ArrayList<Reviews> ReviewList;
    private RecyclerView reviewRecyclerView;
    private RecyclerViewAdapterReviews mAdapter2;
    private RecyclerView.LayoutManager mLayoutManager2;
    private ImageButton back;
    Button desc;
    Button rev;
    TextView desc_view;
    LinearLayout linearLayout;
    ConstraintSet mConstraintSet;
    ConstraintLayout mConstraintLayout ;
    TextView qty;
    TextView qtyAdd;
    TextView qtySub;
    Integer iQty=1;

    private String[] imageUrls = new String[]{
            "https://stuffycare.com/wp-content/uploads/2020/06/61xFTcEHBEL._SL1000_.jpg",
            "https://stuffycare.com/wp-content/uploads/2020/06/91S7CaN0otL._SL1500_-500x500.jpg",
            "https://stuffycare.com/wp-content/uploads/2020/06/DogTreat002-500x500.jpg",
            "https://stuffycare.com/wp-content/uploads/2020/06/DogTreat003.jpg",

    };
  //  String[] qty2= {"1", "2", "3","4", "5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        TextView originalPrice = (TextView) findViewById(R.id.original_price);
        originalPrice.setPaintFlags(originalPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        //ViewPager Photos Slide Implementation
        slideImage();

        //RecyclerViewForCart

        //Like button implementation
        final ImageButton like = findViewById(R.id.like_button2);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isLike) {
                    like.setColorFilter(Color.LTGRAY);
                    isLike = false;
                }
                else {
                    like.setColorFilter(Color.RED);
                    isLike = true;
                    Toast.makeText(view.getContext(),"Added to Favourites",Toast.LENGTH_SHORT).show();
                }
            }
        });

        back = findViewById(R.id.back_product_details);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //Add to Cart

        Button addToCart = findViewById(R.id.addToCart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Cart cart =new Cart();
                cart.addToCart(n);
                Toast.makeText(ProductDetails.this, "Added to the Cart", Toast.LENGTH_SHORT).show();
                n++;
            }
        });


        //Cart button
        ImageButton cart = findViewById(R.id.cart_button);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProductDetails.this, Cart.class);
                startActivity(intent);
            }
        });

        //Quantity Implementation
        qty = findViewById(R.id.qty_pd);
        qty.setText(iQty.toString());
        qtyAdd = findViewById(R.id.add_qty_pd);
        qtySub = findViewById(R.id.sub_qty_pd);
        qtyAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iQty++;
                qty.setText(iQty.toString());
            }
        });
        qtySub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(iQty>1) {
                    iQty--;
                    qty.setText(iQty.toString());
                }
            }
        });


        //Description and Review Tab
        desc= findViewById(R.id.description);
        rev= findViewById(R.id.reviews);
        desc_view = findViewById(R.id.description_view);
        linearLayout = findViewById(R.id.linearLayoutReview);
        mConstraintSet = new ConstraintSet();
        mConstraintLayout = findViewById(R.id.constraintLayout);
        mConstraintSet.clone(mConstraintLayout);
        desc_view.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);

        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rev.setBackgroundColor(getResources().getColor(R.color.grey_20));
                desc.setBackgroundColor(getResources().getColor(R.color.white));
                mConstraintSet.connect(R.id.linearLayout9, ConstraintSet.TOP,
                        R.id.description_view, ConstraintSet.BOTTOM);
                mConstraintSet.applyTo(mConstraintLayout);
                desc_view.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.GONE);
            }
        });
        rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rev.setBackgroundColor(getResources().getColor(R.color.white));
                desc.setBackgroundColor(getResources().getColor(R.color.grey_20));
                mConstraintSet.connect(R.id.linearLayout9, ConstraintSet.TOP,
                        R.id.linearLayoutReview, ConstraintSet.BOTTOM);
                 mConstraintSet.applyTo(mConstraintLayout);
                desc_view.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
            }
        });


        ReviewPicsList = new ArrayList<>();

            ReviewPics reviewPics = new ReviewPics();
            reviewPics.setImage(R.drawable.dog_food);
            ReviewPicsList.add(reviewPics);

            ReviewPics reviewPics2 = new ReviewPics();
            reviewPics2.setImage(R.drawable.dog_food2);
            ReviewPicsList.add(reviewPics2);

            ReviewPics reviewPics3 = new ReviewPics();
            reviewPics3.setImage(R.drawable.dog_food3);
            ReviewPicsList.add(reviewPics3);

            ReviewPics reviewPics4 = new ReviewPics();
            reviewPics4.setImage(R.drawable.dog_food);
            ReviewPicsList.add(reviewPics4);



         ReviewList = new ArrayList<>();

            Reviews reviews = new Reviews();
            reviews.setRatings("3.4");
            reviews.setReviewHead("Great");
            reviews.setReviewBody("My doggo just loved the product");
            reviews.setReviewer("Anurag Kumar, Jharkhand");
            ReviewList.add(reviews);

            Reviews reviews2 = new Reviews();
            reviews2.setRatings("4.5");
            reviews2.setReviewHead("Awesome");
            reviews2.setReviewBody("Nice packaging.");
            reviews2.setReviewer("Utkarsh Saxena, Lucknow");
            ReviewList.add(reviews2);

            Reviews reviews3 = new Reviews();
            reviews3.setRatings("4.0");
            reviews3.setReviewHead("Superb");
            reviews3.setReviewBody("Great Delivery. Got product on time");
            reviews3.setReviewer("Amit Pandey, Rudrapur");
            ReviewList.add(reviews3);

            Reviews reviews4 = new Reviews();
            reviews4.setRatings("5.0");
            reviews4.setReviewHead("Amazing!!");
            reviews4.setReviewBody("The quality of the belt is simply awesome");
            reviews4.setReviewer("Sachin Bisht, Uttarakhand");
            ReviewList.add(reviews4);


        buildRecyclerviewPics();
        buildRecyclerviewReview();
    }




    public void slideImage(){
        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);
        LinearLayout sliderDotspanel = findViewById(R.id.SliderDots);

        final int dotscount = adapter.getCount();
        final ImageView[] dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.inactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.inactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    public void buildRecyclerviewPics() {

       reviewPicsRecyclerView = findViewById(R.id.recyclerview_review_pics);
       reviewPicsRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, true);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(suggestionsRecyclerView.getContext(),
//                DividerItemDecoration.VERTICAL);
//       reviewPicsRecyclerView.addItemDecoration(dividerItemDecoration);
        mAdapter = new RecyclerViewAdapterReviewPics(ReviewPicsList);
       reviewPicsRecyclerView.setLayoutManager(mLayoutManager);
       reviewPicsRecyclerView.setAdapter(mAdapter);

    }

    public void buildRecyclerviewReview() {

        reviewRecyclerView = findViewById(R.id.recyclerview_reviews);
        reviewRecyclerView.setHasFixedSize(true);
        mLayoutManager2 = new LinearLayoutManager(getApplicationContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(reviewRecyclerView.getContext(),
                DividerItemDecoration.HORIZONTAL);
        reviewRecyclerView.addItemDecoration(dividerItemDecoration);
        mAdapter2 = new RecyclerViewAdapterReviews(ReviewList);
        reviewRecyclerView.setLayoutManager(mLayoutManager2);
        reviewRecyclerView.setAdapter(mAdapter2);

    }

}
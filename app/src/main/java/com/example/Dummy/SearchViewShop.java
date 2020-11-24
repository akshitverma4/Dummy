package com.example.Dummy;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

import com.example.Dummy.adapter.RecyclerViewAdapterSuggestions;
import com.example.Dummy.items.Suggestions;

public class SearchViewShop extends AppCompatActivity {

    private ArrayList<Suggestions> SuggestionsList;
    private RecyclerView suggestionsRecyclerView;
    private RecyclerViewAdapterSuggestions mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view);
        SuggestionsList = new ArrayList<>();
        Suggestions suggestions = new Suggestions();
        suggestions.setSuggestion("Dog Food");
        SuggestionsList.add(suggestions);

        Suggestions suggestions1 = new Suggestions();
        suggestions1.setSuggestion("Cat Food");
        SuggestionsList.add(suggestions1);

        Suggestions suggestions2 = new Suggestions();
        suggestions2.setSuggestion("Pedigree");
        SuggestionsList.add(suggestions2);

        Suggestions suggestions3 = new Suggestions();
        suggestions3.setSuggestion("Dog Chain");
        SuggestionsList.add(suggestions3);

        buildRecyclerView();

        EditText searchView =findViewById(R.id.SearchView);
        searchView.setFocusableInTouchMode(true);
        searchView.requestFocus();
//        final InputMethodManager inputMethodManager = (InputMethodManager) SearchViewShop.this
//                .getSystemService(Context.INPUT_METHOD_SERVICE);
//        inputMethodManager.showSoftInput(searchView, InputMethodManager.SHOW_IMPLICIT);
        searchView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Intent intent = new Intent(SearchViewShop.this, ShopNowResult.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                suggestionsRecyclerView.setVisibility(View.VISIBLE);
                filter(s.toString());
            }
        });


    }
    private void filter(String text) {
        ArrayList<Suggestions> filteredList = new ArrayList<>();
        for (Suggestions item : SuggestionsList) {
            if (item.getSuggestion().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }

    public void buildRecyclerView() {

        suggestionsRecyclerView = findViewById(R.id.suggestions_recyclerview);
        suggestionsRecyclerView.setVisibility(View.INVISIBLE);
        suggestionsRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(suggestionsRecyclerView.getContext(),
//                DividerItemDecoration.VERTICAL);
//        suggestionsRecyclerView.addItemDecoration(dividerItemDecoration);
        mAdapter = new RecyclerViewAdapterSuggestions(SuggestionsList);
        suggestionsRecyclerView.setLayoutManager(mLayoutManager);
        suggestionsRecyclerView.setAdapter(mAdapter);

    }

}

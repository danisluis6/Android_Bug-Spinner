package com.lorence.notificationdemo.fix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spNation;
    private EditText edtNation;
    private MainActivity mActivity;
    private NationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call widget
        spNation = (Spinner)this.findViewById(R.id.spNation);
        edtNation = (EditText)this.findViewById(R.id.edtNation);

        // mActivity = (MainActivity) getActivity(); for Fragment inside Activity
        mActivity = this;

        setupNationSpinner();
        edtNation.setText(Constants.EMPTY);
        edtNation.setKeyListener(null);
//        edtNation.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                if (b) {
//                    spNation.performClick();
//                    selectionCountrySpinner();
//                }
//            }
//        });
        edtNation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spNation.performClick();
                selectionCountrySpinner();
            }
        });
    }

    private void selectionCountrySpinner() {
        spNation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    edtNation.setText(getAllNations().get(position).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO
            }
        });
    }

    private void setupNationSpinner() {
        try {
            adapter = new NationAdapter(mActivity, getAllNations());
            spNation.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> getAllNations() throws JSONException {
        String[] allCountries = getResources().getStringArray(R.array.countries_array);
        ArrayList<String> allNations = new ArrayList<>();
        for (int i = 0; i < allCountries.length; i++) {
            allNations.add(allCountries[i]);
        }
        return allNations;
    }
}

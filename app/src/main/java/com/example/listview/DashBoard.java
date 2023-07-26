package com.example.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.List;

public class DashBoard extends AppCompatActivity {
    private FrameLayout fragmentContainer;
    private DataBaseHelper dataBaseHelper;
    SharePreference sharedpreferences;
    private View textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        sharedpreferences = new SharePreference(getApplicationContext());
        dataBaseHelper = new DataBaseHelper(getApplicationContext());
        List<String> records = dataBaseHelper.getAllRecords();

        CustomGridAdapter gridAdapter = new CustomGridAdapter(this, records);
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(gridAdapter);

//        int i;
//        for (i = 0; i < records.size(); i++) {
//            TextView textView = new TextView(this);
//            textView.setText("Item " + (i + 1));
//        }

//        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
//        params.rowSpec = GridLayout.spec(i / 2);
//        params.columnSpec = GridLayout.spec(i % 2);
//        textView.setLayoutParams(params);
//
//        gridLayout.addView(textView);

//        CustomGridAdapter gridAdapter = new CustomGridAdapter(this,records);
//
//        gridLayout.setAdapter(gridAdapter);
//        int numColumns = 2;
//        gridLayout.setColumnCount(numColumns);

//        int gridItemWidth = getResources().getDisplayMetrics().widthPixels / numColumns;
//
//        for (String record : records) {
//            View gridItemView = getLayoutInflater().inflate(R.layout.grid_item_layout, gridLayout, false);
//            TextView gridItemTextView = gridItemView.findViewById(R.id.gridItemTextView);
//            gridItemTextView.setText(record);
//
//            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
//            params.width = gridItemWidth;
//            gridItemView.setLayoutParams(params);
//
//            gridLayout.addView(gridItemView);
//        }


//
//        ListView listView = findViewById(R.id.listView);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,records);
//        listView.setAdapter(adapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                if (item.getItemId() == R.id.navigation_fragment1) {
                    selectedFragment = new Fragment1();
                } else if (item.getItemId() == R.id.navigation_fragment2) {
                    selectedFragment = new Fragment2();
                } else if (item.getItemId() == R.id.navigation_fragment3) {
                    selectedFragment = new Fragment3();
                } else if (item.getItemId() == R.id.navigation_fragment4) {
                    selectedFragment = new Fragment4();
                }

                if (selectedFragment != null) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.fragmentContainer, selectedFragment);
                    transaction.commit();
                }
            }
        });
//        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation);
    }
}

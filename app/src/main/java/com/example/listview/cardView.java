package com.example.listview;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class cardView extends AppCompatActivity {
    TextView detailsText;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
    detailsText = findViewById(R.id.details);
    layout = findViewById(R.id.layout);
    layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
    }
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public void expand(View view){
        int v = (detailsText.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

    TransitionManager.beginDelayedTransition(layout,new AutoTransition());
    detailsText.setVisibility(v);
    }
}


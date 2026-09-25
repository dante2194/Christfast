package com.christfast.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DevotionalActivity extends AppCompatActivity {

    private TextView devotionalTitle, devotionalContent;
    private Button previousButton, nextButton;
    private int current = 0;

    private final String[] titles = {
        "The Purpose of Fasting", "Fasting with the Right Heart",
        "Prayer and Fasting Together", "Breaking Your Fast",
        "Fasting for Breakthrough"
    };

    private final String[] contents = {
        "Fasting is not about earning God's favor but about drawing closer to Him. When we fast, we deny our flesh to feed our spirit. Jesus assumed His followers would fast, saying 'WHEN you fast' not 'IF you fast' (Matthew 6:16).",
        "God looks at the heart, not the outward appearance. Isaiah 58 teaches that true fasting involves loosing chains of injustice, feeding the hungry, and providing for the poor. Our fast should produce compassion and action.",
        "Fasting without prayer is just a diet. The power of fasting comes when we replace mealtime with prayer time. Use your hunger as a reminder to pray and seek God's face.",
        "How you break your fast matters. Begin with light foods and plenty of water. More importantly, carry the spiritual lessons learned into your daily life. The goal is lasting transformation, not just a temporary experience.",
        "Throughout Scripture, God's people fasted for breakthroughs\u2014Esther for her people, Daniel for understanding, Jehoshaphat for victory. When you face impossible situations, fasting positions you to hear from God and see His deliverance."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devotional);
        devotionalTitle = findViewById(R.id.devotionalTitle);
        devotionalContent = findViewById(R.id.devotionalContent);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        load();
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { if (current > 0) { current--; load(); } }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (current < titles.length - 1) { current++; load(); }
            }
        });
    }

    private void load() {
        devotionalTitle.setText(titles[current]);
        devotionalContent.setText(contents[current]);
        previousButton.setEnabled(current > 0);
        nextButton.setEnabled(current < titles.length - 1);
    }
}

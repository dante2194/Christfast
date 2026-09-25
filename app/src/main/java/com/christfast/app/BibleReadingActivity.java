package com.christfast.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BibleReadingActivity extends AppCompatActivity {

    private static final String PREFS = "BibleReadingPrefs";
    private static final String KEY_DAY = "current_day";

    private TextView readingPlanText, passageText;
    private SharedPreferences prefs;
    private int currentDay = 1;

    // 30-day plan focused on fasting, prayer, repentance, and devotion.
    // Format: "Book chapter:verse-verse|Title/theme"
    private final String[] readings = {
        "Matthew 6:1-18|Teaching on Fasting, Prayer, and Giving",
        "Isaiah 58:1-14|True Fasting That Pleases God",
        "Daniel 1:1-21|Daniel's Faithfulness and Self-Control",
        "Daniel 9:1-19|Daniel's Prayer of Confession",
        "Daniel 10:1-21|Twenty-One Days of Fasting",
        "Esther 4:1-17|Esther Calls the People to Fast",
        "Jonah 3:1-10|Nineveh Repents with Fasting",
        "2 Samuel 12:15-23|David Fasts for His Child",
        "1 Kings 19:1-18|Elijah Fasts at Horeb",
        "Exodus 34:27-35|Moses Fasts on Sinai",
        "Ezra 8:21-23|Ezra Proclaims a Fast",
        "Nehemiah 1:1-11|Nehemiah Weeps and Fasts",
        "Joel 1:13-20|A Call to Mourning and Fasting",
        "Joel 2:12-17|Rend Your Heart, Not Your Garments",
        "Jonah 1:1-17|Jonah Flees from the LORD",
        "Psalm 51:1-19|A Prayer of Repentance",
        "Psalm 32:1-11|The Joy of Forgiveness",
        "Psalm 63:1-11|Thirsting for God",
        "Psalm 42:1-11|As the Deer Pants for Water",
        "Psalm 130:1-8|Out of the Depths",
        "Lamentations 3:19-33|Great Is Thy Faithfulness",
        "Luke 2:36-38|Anna Worships with Fasting",
        "Luke 4:1-13|Jesus Fasts in the Wilderness",
        "Luke 18:9-14|The Pharisee and the Tax Collector",
        "Acts 9:1-19|Saul's Conversion and Fasting",
        "Acts 13:1-3|Fasting and Sending Missionaries",
        "Acts 14:21-23|Appointing Elders with Prayer and Fasting",
        "Romans 12:1-21|Living Sacrifices",
        "2 Corinthians 6:1-13|Commending Ourselves as Servants",
        "Hebrews 12:1-17|Fix Your Eyes on Jesus"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible_reading);

        prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        currentDay = prefs.getInt(KEY_DAY, 1);

        readingPlanText = findViewById(R.id.readingPlanText);
        passageText = findViewById(R.id.passageText);
        Button markCompleteButton = findViewById(R.id.markCompleteButton);
        Button prevButton = findViewById(R.id.prevDayButton);

        loadDailyReading();

        markCompleteButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (currentDay < readings.length) {
                    currentDay++;
                    prefs.edit().putInt(KEY_DAY, currentDay).commit();
                    loadDailyReading();
                }
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (currentDay > 1) {
                    currentDay--;
                    prefs.edit().putInt(KEY_DAY, currentDay).commit();
                    loadDailyReading();
                }
            }
        });
    }

    private void loadDailyReading() {
        readingPlanText.setText("Day " + currentDay + " of " + readings.length);

        String[] parts = readings[(currentDay - 1) % readings.length].split("\\|");
        String ref = parts[0];
        String theme = parts.length > 1 ? parts[1] : "";

        // Build display text with the reference first, then the theme
        String display = ref + "\n\n" + theme +
                "\n\n(Tap the reference to open in Bible.com)";

        // Make the Bible reference clickable
        BibleLinkUtils.linkify(this, passageText, display);
    }
}

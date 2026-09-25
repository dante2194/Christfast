package com.christfast.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class AgpeyaActivity extends AppCompatActivity {

    private TextView hourName, hourTime, openingText, psalmText, gospelText, closingText;
    private int currentHour = 0;

    private static final String[] NAMES = {
        "Prime (First Hour)", "Terce (Third Hour)", "Sext (Sixth Hour)",
        "None (Ninth Hour)", "Vespers (Eleventh Hour)",
        "Compline (Twelfth Hour)", "Midnight"
    };

    private static final String[] TIMES = {
        "~ 6 AM  \u00b7  Dawn", "~ 9 AM", "~ 12 PM  \u00b7  Noon",
        "~ 3 PM", "~ 6 PM  \u00b7  Sunset", "~ 9 PM", "~ 12 AM"
    };

    private static final String[] OPENINGS = {
        "In the name of the Father, and of the Son, and of the Holy Spirit, one God. Amen.\n\nOur Father who art in heaven, hallowed be Thy name. Thy kingdom come. Thy will be done, on earth as it is in heaven. Give us this day our daily bread. And forgive us our trespasses, as we forgive those who trespass against us. And lead us not into temptation, but deliver us from evil. For Thine is the kingdom, the power, and the glory, forever. Amen.",
        "In the name of the Father, and of the Son, and of the Holy Spirit, one God. Amen.\n\nO heavenly King, the Comforter, the Spirit of truth, who art everywhere and fillest all things, treasury of blessings and giver of life: come and abide in us, cleanse us from every impurity, and save our souls, O Good One.",
        "In the name of the Father, and of the Son, and of the Holy Spirit, one God. Amen.\n\nO Christ our God, who at this sixth hour wast crucified upon the cross for our sins: have mercy upon us and save us, for Thou art good and lovest mankind.",
        "In the name of the Father, and of the Son, and of the Holy Spirit, one God. Amen.\n\nO Christ our God, who at the ninth hour didst taste death in the flesh for our sake: put to death our carnal mind, and save us, for Thou art good and lovest mankind.",
        "In the name of the Father, and of the Son, and of the Holy Spirit, one God. Amen.\n\nO Christ our God, who at the eleventh hour didst ascend the cross and blot out the handwriting of our sins: have mercy on us, O Word made flesh, and save our souls.",
        "In the name of the Father, and of the Son, and of the Holy Spirit, one God. Amen.\n\nO Christ our God, who at the twelfth hour wast laid in the tomb for our sake: grant us a peaceful night and a rest without sin, and save us, O our Savior.",
        "In the name of the Father, and of the Son, and of the Holy Spirit, one God. Amen.\n\nO Christ our God, who at midnight wast wrapped in swaddling cloths and laid in the manger, and didst rise from the dead at dawn: enable us to watch with Thee, and to praise Thee with joy, O our Savior."
    };

    private static final String[] PSALMS = {
        "Psalm 5:3 (NIV)\n\u201CIn the morning, LORD, you hear my voice; in the morning I lay my requests before you and wait expectantly.\u201D\n\nPsalm 63:1 (NIV)\n\u201CYou, God, are my God, earnestly I seek you; I thirst for you, my whole being longs for you, in a dry and parched land where there is no water.\u201D",
        "Psalm 25:4-5 (NIV)\n\u201CShow me your ways, LORD, teach me your paths. Guide me in your truth and teach me, for you are God my Savior, and my hope is in you all day long.\u201D\n\nPsalm 51:10 (NIV)\n\u201CCreate in me a pure heart, O God, and renew a steadfast spirit within me.\u201D",
        "Psalm 91:1-2 (NIV)\n\u201CWhoever dwells in the shelter of the Most High will rest in the shadow of the Almighty. I will say of the LORD, \u2018He is my refuge and my fortress, my God, in whom I trust.\u2019\u201D\n\nPsalm 121:1-2 (NIV)\n\u201CI lift up my eyes to the mountains \u2014 where does my help come from? My help comes from the LORD, the Maker of heaven and earth.\u201D",
        "Psalm 23:1-3 (NIV)\n\u201CThe LORD is my shepherd, I lack nothing. He makes me lie down in green pastures, he leads me beside quiet waters, he refreshes my soul. He guides me along the right paths for his name\u2019s sake.\u201D",
        "Psalm 141:2 (NIV)\n\u201CMay my prayer be set before you like incense; may the lifting up of my hands be like the evening sacrifice.\u201D\n\nPsalm 4:8 (NIV)\n\u201CIn peace I will lie down and sleep, for you alone, LORD, make me dwell in safety.\u201D",
        "Psalm 4:8 (NIV)\n\u201CIn peace I will lie down and sleep, for you alone, LORD, make me dwell in safety.\u201D\n\nPsalm 51:1-2 (NIV)\n\u201CHave mercy on me, O God, according to your unfailing love; according to your great compassion blot out my transgressions. Wash away all my iniquity and cleanse me from my sin.\u201D",
        "Psalm 119:62 (NIV)\n\u201CAt midnight I rise to give you thanks for your righteous laws.\u201D\n\nPsalm 134:1 (NIV)\n\u201CPraise the LORD, all you servants of the LORD who minister by night in the house of the LORD.\u201D"
    };

    private static final String[] GOSPELS = {
        "John 8:12 (NIV)\n\u201CI am the light of the world. Whoever follows me will never walk in darkness, but will have the light of life.\u201D",
        "Luke 11:13 (NIV)\n\u201CIf you then, though you are evil, know how to give good gifts to your children, how much more will your Father in heaven give the Holy Spirit to those who ask him!\u201D",
        "John 1:29 (NIV)\n\u201CLook, the Lamb of God, who takes away the sin of the world!\u201D",
        "Luke 23:46 (NIV)\n\u201CFather, into your hands I commit my spirit.\u201D When he had said this, he breathed his last.",
        "Luke 2:29-32 (NIV)\n\u201CSovereign Lord, as you have promised, you may now dismiss your servant in peace. For my eyes have seen your salvation, which you have prepared in the sight of all nations: a light for revelation to the Gentiles, and the glory of your people Israel.\u201D",
        "Matthew 11:28-29 (NIV)\n\u201CCome to me, all you who are weary and burdened, and I will give you rest. Take my yoke upon you and learn from me, for I am gentle and humble in heart, and you will find rest for your souls.\u201D",
        "Matthew 25:6 (NIV)\n\u201CAt midnight the cry rang out: \u2018Here\u2019s the bridegroom! Come out to meet him!\u2019\u201D"
    };

    private static final String[] CLOSINGS = {
        "Holy God, Holy Mighty, Holy Immortal, have mercy on us.\nHoly God, Holy Mighty, Holy Immortal, have mercy on us.\nHoly God, Holy Mighty, Holy Immortal, have mercy on us.\n\nGlory be to the Father, and to the Son, and to the Holy Spirit, now and forever and unto the ages of ages. Amen.\n\nThrough the prayers of the Theotokos, O Savior, save us. Amen.",
        "Holy God, Holy Mighty, Holy Immortal, have mercy on us.\n\nGlory be to the Father, and to the Son, and to the Holy Spirit, now and forever and unto the ages of ages. Amen.\n\nThrough the prayers of the Theotokos, O Savior, save us. Amen.",
        "Holy God, Holy Mighty, Holy Immortal, have mercy on us.\n\nGlory be to the Father, and to the Son, and to the Holy Spirit, now and forever and unto the ages of ages. Amen.\n\nO Christ our God, who wast crucified at the sixth hour for our sins, have mercy on us. Amen.",
        "Holy God, Holy Mighty, Holy Immortal, have mercy on us.\n\nGlory be to the Father, and to the Son, and to the Holy Spirit, now and forever and unto the ages of ages. Amen.\n\nO Christ our God, who didst taste death in the flesh at the ninth hour, put to death our carnal mind. Amen.",
        "Holy God, Holy Mighty, Holy Immortal, have mercy on us.\n\nGlory be to the Father, and to the Son, and to the Holy Spirit, now and forever and unto the ages of ages. Amen.\n\nThrough the prayers of the Theotokos, O Savior, save us. Amen.",
        "Holy God, Holy Mighty, Holy Immortal, have mercy on us.\n\nGlory be to the Father, and to the Son, and to the Holy Spirit, now and forever and unto the ages of ages. Amen.\n\nO Christ our God, grant us a peaceful night and a rest without sin. Amen.",
        "Holy God, Holy Mighty, Holy Immortal, have mercy on us.\n\nGlory be to the Father, and to the Son, and to the Holy Spirit, now and forever and unto the ages of ages. Amen.\n\nO Christ our God, who didst rise from the dead at dawn, enable us to watch with Thee. Amen."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agpeya);

        hourName    = findViewById(R.id.agpeyaHourName);
        hourTime    = findViewById(R.id.agpeyaHourTime);
        openingText = findViewById(R.id.agpeyaOpening);
        psalmText   = findViewById(R.id.agpeyaPsalms);
        gospelText  = findViewById(R.id.agpeyaGospel);
        closingText = findViewById(R.id.agpeyaClosing);

        Button prevBtn = findViewById(R.id.agpeyaPrevButton);
        Button nextBtn = findViewById(R.id.agpeyaNextButton);
        Button nowBtn  = findViewById(R.id.agpeyaNowButton);

        currentHour = currentCanonicalHour();
        render();

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (currentHour > 0) { currentHour--; render(); }
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (currentHour < NAMES.length - 1) { currentHour++; render(); }
            }
        });
        nowBtn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                currentHour = currentCanonicalHour();
                render();
            }
        });
    }

    private int currentCanonicalHour() {
        int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (h >= 5  && h < 8)  return 0;
        if (h >= 8  && h < 11) return 1;
        if (h >= 11 && h < 14) return 2;
        if (h >= 14 && h < 17) return 3;
        if (h >= 17 && h < 20) return 4;
        if (h >= 20 && h < 23) return 5;
        return 6;
    }

    private void render() {
        hourName.setText(NAMES[currentHour]);
        hourTime.setText(TIMES[currentHour]);
        openingText.setText(OPENINGS[currentHour]);
        closingText.setText(CLOSINGS[currentHour]);
        BibleLinkUtils.linkify(this, psalmText, PSALMS[currentHour]);
        BibleLinkUtils.linkify(this, gospelText, GOSPELS[currentHour]);
    }
}

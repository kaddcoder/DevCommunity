package cat.urv.deim.asm.p2.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class TutorialActivity extends AppCompatActivity {

    private int[] tutorial_pages = {R.layout.tutorial_1, R.layout.tutorial_2, R.layout.tutorial_3};
    private int percentageStatus = 0;
    private int percentageSum = 100 / tutorial_pages.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        final ViewPager viewPager = findViewById(R.id.help_viewPager);
        final ProgressBar progressBar = findViewById(R.id.progressBar);
        Button end_button = findViewById(R.id.end_help_button);
        Button next_button = findViewById(R.id.next_help_button);

        CustomPagerAdapter adapter = new CustomPagerAdapter(getApplicationContext(), tutorial_pages);
        viewPager.setAdapter(adapter);

        end_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(TutorialActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", percentageStatus, percentageStatus+percentageSum);
                progressAnimator.setDuration(1000);
                progressAnimator.start();

                percentageStatus += percentageSum;
                if(viewPager.getCurrentItem()+1 < tutorial_pages.length) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    progressBar.setSecondaryProgress(percentageStatus+percentageSum);

                }else {
                    Intent loginIntent = new Intent(TutorialActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                    finish();
                }

            }
        });

        progressBar.setSecondaryProgress(percentageStatus + percentageSum);
    }


}

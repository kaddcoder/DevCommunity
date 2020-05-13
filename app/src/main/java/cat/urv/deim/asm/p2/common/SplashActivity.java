package cat.urv.deim.asm.p2.common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIMEOUT = 4000;
    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefs = getSharedPreferences("cat.urv.deim.asm.p2.DevCommunity", MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (prefs.getBoolean("firstRun", false)) {

                    Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                    finish();

                } else {

                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("firstRun", false);
                    editor.commit();

                    Intent tutorialIntent = new Intent(SplashActivity.this, TutorialActivity.class);
                    startActivity(tutorialIntent);
                    finish();

                }

            }
        }, SPLASH_TIMEOUT);

    }

}

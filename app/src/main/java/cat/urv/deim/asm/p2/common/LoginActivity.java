package cat.urv.deim.asm.p2.common;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginBtn = findViewById(R.id.login);
        Button loginGuestBtn = findViewById(R.id.guest);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(existsLoginParams()) {
                    if(authenticate()) {
                        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                        mainIntent.putExtra("USER_LOGGED", true);
                        startActivity(mainIntent);
                    } else {
                        Intent errorLoginIntent = new Intent(LoginActivity.this, ErrorLoginActivity.class);
                        startActivity(errorLoginIntent);
                    }
                } else Toast.makeText(LoginActivity.this, "Email or password field remaining.", Toast.LENGTH_SHORT).show();

            }
        });

        loginGuestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                mainIntent.putExtra("USER_LOGGED", false);
                startActivity(mainIntent);

            }
        });
    }

    private boolean existsLoginParams() {
        EditText loginEmail = findViewById(R.id.email);
        EditText loginPassword = findViewById(R.id.password);

        String email = loginEmail.getText().toString();
        String password = loginPassword.getText().toString();

        if(!(TextUtils.isEmpty(email) || TextUtils.isEmpty(password))) return true;

        return false;
    }

    private boolean authenticate() {
        EditText loginEmail = findViewById(R.id.email);
        EditText loginPassword = findViewById(R.id.password);

        String email = loginEmail.getText().toString();
        String password = loginPassword.getText().toString();

        if(email.equals("test@gmail.com") && password.equals("test")) return true;

        return false;
    }
}

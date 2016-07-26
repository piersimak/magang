package diginetmedia.com.sikedes.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import diginetmedia.com.sikedes.Main2Activity;
import diginetmedia.com.sikedes.MainActivity;
import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.fragment.RegisterFragment;

public class LoginActivity extends AppCompatActivity {
    private TextView txtDaftar;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        initForm();
    }
    private void initForm()
    {
        txtDaftar = (TextView)findViewById(R.id.txtDaftar);
        txtDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, Main2Activity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

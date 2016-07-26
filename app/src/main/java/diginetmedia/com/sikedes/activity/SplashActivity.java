package diginetmedia.com.sikedes.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import diginetmedia.com.sikedes.Main2Activity;
import diginetmedia.com.sikedes.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler myHandler = new Handler();
        myHandler.postDelayed(mMyRunnable, 3000);
    }
    private Runnable mMyRunnable = new Runnable()
    {
        @Override
        public void run()
        {
       /*     if(sharedPref.getBoolean("success_login", false)) {
                Intent i = new Intent(getApplicationContext(), MainSystemActivity.class);
                startActivity(i);
                finish();
            }
            else
            {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            } */
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
            finish();
        }
    };
}

package diginetmedia.com.sikedes.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import diginetmedia.com.sikedes.R;

public class RegisterActivity extends AppCompatActivity {
    private FrameLayout Register1,Register2;
    private Button tombolLanjutkan,tombolKembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initForm();
    }
    private void initForm()
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Daftar");
        Register1 = (FrameLayout)findViewById(R.id.Register1);
        Register2 = (FrameLayout)findViewById(R.id.Register2);
        Register1.setVisibility(View.VISIBLE);
        Register2.setVisibility(View.GONE);

        tombolKembali=(Button)findViewById(R.id.tombolKembali);
        tombolLanjutkan=(Button)findViewById(R.id.tombolLanjutkan);
        tombolLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register1.setVisibility(View.GONE);
                Register2.setVisibility(View.VISIBLE);
            }
        });
        tombolKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register1.setVisibility(View.VISIBLE);
                Register2.setVisibility(View.GONE);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id)
        {
            case android.R.id.home:
                this.finish();
        }
        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}

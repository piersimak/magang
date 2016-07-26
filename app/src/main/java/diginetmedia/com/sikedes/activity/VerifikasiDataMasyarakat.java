package diginetmedia.com.sikedes.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import diginetmedia.com.sikedes.R;

public class VerifikasiDataMasyarakat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi_data_masyarakat);
        init();
    }
    private void init()
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Verifikasi Data Masyarakat");
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

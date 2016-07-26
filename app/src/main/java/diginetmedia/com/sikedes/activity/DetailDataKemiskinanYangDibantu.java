package diginetmedia.com.sikedes.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import diginetmedia.com.sikedes.R;

public class DetailDataKemiskinanYangDibantu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data_kemiskinan_yang_dibantu);
        init();
    }
    private void init()
    {
        EditText txtJumlahUang = (EditText)  findViewById(R.id.txtJumlahUang);
        EditText txtBarang = (EditText)  findViewById(R.id.txtBarang);
        EditText txtKeterangan = (EditText)  findViewById(R.id.txtKeterangan);
        Bundle b = getIntent().getExtras();
        boolean disable = b.getBoolean("disable",false);
        if(disable)
        {
            txtJumlahUang.setEnabled(false);
            txtBarang.setEnabled(false);
            txtKeterangan.setEnabled(false);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Deskripsi");
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
                break;
        }
        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.



      //  getMenuInflater().inflate(R.menu.menu_cart, menu);

        return true;
    }


}

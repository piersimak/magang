package diginetmedia.com.sikedes.activity;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.adapter.DataKemiskinanAdapter;
import diginetmedia.com.sikedes.adapter.NormalListDataKeranjangAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;
import diginetmedia.com.sikedes.model.DataKemiskinan;

public class KeranjangActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);
        init();
    }

    private void init(){
        context=this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle b = getIntent().getExtras();
        getSupportActionBar().setTitle("Keranjang Bantuan");

        RecyclerView recyclerViewKeranjang;

        List<DataKemiskinan> listdataKeranjang = new ArrayList<DataKemiskinan>();
        for(int i=0; i<20 ; i++)
        {
            DataKemiskinan temp = new DataKemiskinan();
            temp.setAlamat("alamat");
            temp.setImageurl("http://iconshow.me/media/images/ui/ios7-icons/png/512/social-android-outline.png");
            temp.setNamakeluarga("nama");
            listdataKeranjang.add(temp);
        }
        recyclerViewKeranjang = (RecyclerView) findViewById(R.id.RecyclerViewKeranjang);
        recyclerViewKeranjang.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewKeranjang.setLayoutManager(layoutManager);

        NormalListDataKeranjangAdapter dataKeranjangAdapter = new NormalListDataKeranjangAdapter(listdataKeranjang,recyclerViewKeranjang,this);
        recyclerViewKeranjang.setAdapter(dataKeranjangAdapter);

        recyclerViewKeranjang.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }
                })
        );

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

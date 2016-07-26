package diginetmedia.com.sikedes.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.adapter.DataKemiskinanYangDibantuAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;

public class DataKemiskinanYangDibantu extends AppCompatActivity {

    private RecyclerView recyclerViewKemiskinanYangDibantu;
    private List<String> listdataKemiskinanYangDibantu;
    private RecyclerView.LayoutManager layoutManager;
    private DataKemiskinanYangDibantuAdapter dataKemiskinanYangDibantu;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kemiskinan_yang_dibantu);

        init();


    }
    private void init(){
        context=this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Daftar Bantuan");

        recyclerViewKemiskinanYangDibantu = (RecyclerView) findViewById(R.id.RecyclerViewDusun);

        listdataKemiskinanYangDibantu = new ArrayList<String>();
        for(int i=0; i<5 ; i++)
        {
            String temp = "Bantuan...";
            listdataKemiskinanYangDibantu.add(temp);
        }
        recyclerViewKemiskinanYangDibantu = (RecyclerView) findViewById(R.id.RecyclerViewDataYangDibantu);
        recyclerViewKemiskinanYangDibantu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewKemiskinanYangDibantu.setLayoutManager(layoutManager);

        dataKemiskinanYangDibantu = new DataKemiskinanYangDibantuAdapter(listdataKemiskinanYangDibantu, recyclerViewKemiskinanYangDibantu,this);
        recyclerViewKemiskinanYangDibantu.setAdapter(dataKemiskinanYangDibantu);

        recyclerViewKemiskinanYangDibantu.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(context,DetailDataKemiskinanYangDibantu.class);
                        Bundle b = new Bundle();
                        b.putBoolean("disable",false);
                        i.putExtras(b);
                        startActivity(i);
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
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.



      //  getMenuInflater().inflate(R.menu.menu_cart, menu);

        return true;
    }


}

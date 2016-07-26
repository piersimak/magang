package diginetmedia.com.sikedes.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.adapter.DataKemiskinanAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;
import diginetmedia.com.sikedes.model.DataKemiskinan;

public class ListDataKemiskinan extends AppCompatActivity {

    private RecyclerView recyclerViewKemiskinan;
    private List<DataKemiskinan> listdataKemiskinan;
    private RecyclerView.LayoutManager layoutManager;
    private DataKemiskinanAdapter dataKemiskinanAdapter;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data_kemiskinan);

        init();
    }
    private void init(){
        context=this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle b = getIntent().getExtras();
        getSupportActionBar().setTitle(b.getString("title",""));

        recyclerViewKemiskinan = (RecyclerView) findViewById(R.id.RecyclerViewDusun);

        listdataKemiskinan = new ArrayList<DataKemiskinan>();
        for(int i=0; i<5 ; i++)
        {
            DataKemiskinan temp = new DataKemiskinan("http://iconshow.me/media/images/ui/ios7-icons/png/512/social-android-outline.png","tes");
            listdataKemiskinan.add(temp);
        }
        recyclerViewKemiskinan = (RecyclerView) findViewById(R.id.RecyclerViewDusun);
        recyclerViewKemiskinan.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        recyclerViewKemiskinan.setLayoutManager(layoutManager);

        dataKemiskinanAdapter = new DataKemiskinanAdapter(listdataKemiskinan,recyclerViewKemiskinan,this);
        recyclerViewKemiskinan.setAdapter(dataKemiskinanAdapter);

        recyclerViewKemiskinan.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(context, DeskripsiDataKemiskinan.class);
                        Bundle b = new Bundle();
                        b.putString("gambar",listdataKemiskinan.get(position).getImageurl());
                        b.putString("namakeluarga",listdataKemiskinan.get(position).getNamakeluarga());
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
            case R.id.action_cart:
                openCart();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.



        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    private void openCart()
    {
        Intent i = new Intent(this, KeranjangActivity.class);
        startActivity(i);
    }
}

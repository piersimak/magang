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
import diginetmedia.com.sikedes.adapter.ListDusunAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;

public class ListDusunActivity extends AppCompatActivity {
    private RecyclerView recyclerViewDusun;
    private List<String> listDusun;
    private RecyclerView.LayoutManager layoutManager;
    private ListDusunAdapter dataDusun;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dusun);
        init();
    }
    private void init(){
        context=this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Daftar Dusun");


        listDusun = new ArrayList<String>();
        listDusun.add("Dusun Sukamandi");
        listDusun.add("Dusun Sukamaju");
        listDusun.add("Dusun Sambirejo");
        listDusun.add("Dusun Sukoharjo");
        listDusun.add("Dusun Tambakbayan");

        recyclerViewDusun = (RecyclerView) findViewById(R.id.RecyclerViewDusun);
        recyclerViewDusun.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewDusun.setLayoutManager(layoutManager);

        dataDusun = new ListDusunAdapter(listDusun, recyclerViewDusun,this);
        recyclerViewDusun.setAdapter(dataDusun);

        recyclerViewDusun.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(context,ListDataKemiskinan.class);
                        Bundle b = new Bundle();
                        b.putString("title",listDusun.get(position));
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

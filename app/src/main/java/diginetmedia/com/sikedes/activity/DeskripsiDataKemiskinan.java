package diginetmedia.com.sikedes.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.adapter.ImageAdapter;
import diginetmedia.com.sikedes.adapter.ImageGridAdapter;
import diginetmedia.com.sikedes.adapter.ListGambarAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;

public class DeskripsiDataKemiskinan extends AppCompatActivity {
    private GridView imageGrid;
    private ArrayList<Integer> bitmapList;
    private ImageView gambarDeskripsiKemiskinan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_data_kemiskinan);
        //init();
        bitmapList = new ArrayList<>();

        try {
            bitmapList.add(R.drawable.miskin1);
            bitmapList.add(R.drawable.miskin2);
            bitmapList.add(R.drawable.miskin3);
            bitmapList.add(R.drawable.miskin4);
            bitmapList.add(R.drawable.miskin5);
            bitmapList.add(R.drawable.miskin6);
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<Integer> listBitmap = new ArrayList<>();

        listBitmap.add(R.drawable.miskin1);
        listBitmap.add(R.drawable.miskin2);
        listBitmap.add(R.drawable.miskin3);
        listBitmap.add(R.drawable.miskin4);
        listBitmap.add(R.drawable.miskin5);
        listBitmap.add(R.drawable.miskin6);


        RecyclerView RecyclerViewGambar = (RecyclerView) findViewById(R.id.gridgambar);
        //RecyclerViewKategori.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3);
        RecyclerViewGambar.setLayoutManager(layoutManager);

        ImageGridAdapter gambarAdapter = new ImageGridAdapter(listBitmap,RecyclerViewGambar,this);
        RecyclerViewGambar.setAdapter(gambarAdapter);

        RecyclerViewGambar.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }
                })
        );
    }

    private void init()
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Deskripsi");
        Bundle b = getIntent().getExtras();
        gambarDeskripsiKemiskinan = (ImageView) findViewById(R.id.gambarDeskripsiKemiskinan);
        Glide.with(this).load(b.getString("gambar",""))
                .placeholder(R.drawable.loading)
                .into(gambarDeskripsiKemiskinan);

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
        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.



        getMenuInflater().inflate(R.menu.menu_cart, menu);

        return true;
    }

    private void openCart()
    {
        Intent i = new Intent(this, KeranjangActivity.class);
        startActivity(i);
    }
}

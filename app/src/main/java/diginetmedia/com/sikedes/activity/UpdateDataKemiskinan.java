package diginetmedia.com.sikedes.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.adapter.ListGambarAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;

public class UpdateDataKemiskinan extends AppCompatActivity {

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_kemiskinan);
        init();
    }
    private void init()
    {
        context=this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Perbarui Data Kemiskinan");

        List<Bitmap> listBitmap = new ArrayList<Bitmap>();
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.plus);
        for(int i=0; i<5 ; i++)
        {

            listBitmap.add(icon);
        }
        RecyclerView RecyclerViewGambar = (RecyclerView) findViewById(R.id.RecyclerViewGambar);
        //RecyclerViewKategori.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        RecyclerViewGambar.setLayoutManager(layoutManager);

        ListGambarAdapter gambarAdapter = new ListGambarAdapter(listBitmap,RecyclerViewGambar,context);
        RecyclerViewGambar.setAdapter(gambarAdapter);

        RecyclerViewGambar.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
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

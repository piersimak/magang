package diginetmedia.com.sikedes.adapter;

/**
 * Created by PIER on 7/18/2016.
 */

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.model.Kategori;


public class KategoriAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Kategori> listKategori;
    RecyclerView recyclerView;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    public KategoriAdapter(List<Kategori> kategori, RecyclerView recyclerViewKategori, Context con) {
        this.listKategori = kategori;
        this.recyclerView=recyclerViewKategori;
        this.context=con;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.cardview_kategori, parent, false);
            return new KategoriViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            Kategori kategori = listKategori.get(position);
            KategoriViewHolder kategoriViewHolder = (KategoriViewHolder) holder;

            kategoriViewHolder.txtKategori.setText(kategori.getNama());
            kategoriViewHolder.gambarKategori.setImageResource(kategori.getGambar());
            kategoriViewHolder.cardviewkategori.setCardBackgroundColor(Color.BLACK);
           // Picasso.with(context).load(kategori.getImageurl())
          //          .placeholder(R.drawable.defaultpic).error(R.drawable.defaultpic)
          //          .into(userViewHolder.photoprofile);

    }

    @Override
    public int getItemCount() {
        return listKategori == null ? 0 : listKategori.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    static class KategoriViewHolder extends RecyclerView.ViewHolder {
        public TextView txtKategori;
        public ImageView gambarKategori;
        public CardView cardviewkategori;
        public KategoriViewHolder(View itemView) {
            super(itemView);
            txtKategori = (TextView) itemView.findViewById(R.id.txtKategori);
            gambarKategori = (ImageView) itemView.findViewById(R.id.gambarKategori);
            cardviewkategori = (CardView) itemView.findViewById(R.id.cardviewkategori);
        }
    }


}
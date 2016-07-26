package diginetmedia.com.sikedes.adapter;

/**
 * Created by PIER on 7/18/2016.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
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


public class ListGambarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Bitmap> listBitmap;
    RecyclerView recyclerView;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    public ListGambarAdapter(List<Bitmap> bitmaps, RecyclerView recyclerViewKategori, Context con) {
        this.listBitmap = bitmaps;
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

        View view = LayoutInflater.from(context).inflate(R.layout.list_gambar_horizontal, parent, false);
        return new GambarViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Bitmap bitmap = listBitmap.get(position);
        GambarViewHolder gambarViewHolder = (GambarViewHolder) holder;
        gambarViewHolder.gambarList.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return listBitmap == null ? 0 : listBitmap.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    static class GambarViewHolder extends RecyclerView.ViewHolder {
        public ImageView gambarList;
        public GambarViewHolder(View itemView) {
            super(itemView);
            gambarList = (ImageView) itemView.findViewById(R.id.gambarList);
        }
    }


}
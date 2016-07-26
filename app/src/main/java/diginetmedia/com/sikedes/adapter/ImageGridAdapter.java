package diginetmedia.com.sikedes.adapter;

/**
 * Created by PIER on 7/25/2016.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import diginetmedia.com.sikedes.R;


/**
 * Created by PIER on 7/18/2016.
 */



public class ImageGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Integer> listBitmap;
    RecyclerView recyclerView;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    public ImageGridAdapter(List<Integer> bitmaps, RecyclerView recyclerViewGambar, Context con) {
        this.listBitmap = bitmaps;
        this.recyclerView=recyclerViewGambar;
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

        View view = LayoutInflater.from(context).inflate(R.layout.list_gambar_grid, parent, false);
        return new GambarViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Integer bitmap = listBitmap.get(position);
        GambarViewHolder gambarViewHolder = (GambarViewHolder) holder;

     //   Glide.with(context).load("")
     //           .placeholder(bitmap)
     //           .into(gambarViewHolder.gambargrid);

        gambarViewHolder.gambargrid.setImageResource(bitmap);//.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return listBitmap == null ? 0 : listBitmap.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    static class GambarViewHolder extends RecyclerView.ViewHolder {
        public ImageView gambargrid;
        public GambarViewHolder(View itemView) {
            super(itemView);
            gambargrid = (ImageView) itemView.findViewById(R.id.gambargrid);
        }
    }


}
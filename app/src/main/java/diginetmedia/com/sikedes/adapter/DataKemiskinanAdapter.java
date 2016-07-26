package diginetmedia.com.sikedes.adapter;

/**
 * Created by PIER on 7/18/2016.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.model.DataKemiskinan;


public class DataKemiskinanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    Context context;
    List<DataKemiskinan> listDataKemiskinan;
    RecyclerView recyclerView;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    public DataKemiskinanAdapter(List<DataKemiskinan> dataKemiskinan, RecyclerView recyclerViewDataKemiskinan, Context con) {
        this.listDataKemiskinan = dataKemiskinan;
        this.recyclerView=recyclerViewDataKemiskinan;
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

        View view = LayoutInflater.from(context).inflate(R.layout.cardview_data_kemiskinan, parent, false);
        return new DataKemiskinanViewHolder(view);

    }
    private SparseBooleanArray selectedItems;
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        DataKemiskinan dataKemiskinan = listDataKemiskinan.get(position);
        DataKemiskinanViewHolder dataKemiskinanViewHolder = (DataKemiskinanViewHolder) holder;

        dataKemiskinanViewHolder.txtDataKemiskinan.setText(dataKemiskinan.getNamakeluarga());
      //   Glide.with(context).load(dataKemiskinan.getImageurl())
      //            .placeholder(R.drawable.loading)
      //            .into(dataKemiskinanViewHolder.gambarDataKemiskinan);
        dataKemiskinanViewHolder.gambarDataKemiskinan.setImageResource(Integer.parseInt(dataKemiskinan.getImageurl()));
        dataKemiskinanViewHolder.cardViewDataKemiskinan.setTag(position);
        dataKemiskinanViewHolder.cardViewDataKemiskinan.setOnClickListener(this);


        selectedItems.put(Integer.parseInt(v.getTag().toString(), true);
    }


    @Override
    public void onClick(View v) {
        // Save the selected positions to the SparseBooleanArray
        if (selectedItems.get(Integer.parseInt(v.getTag().toString()), false)) {
            //selectedItems.delete(pos);
            v.setSelected(false);
        }
        else {
            selectedItems.put(Integer.parseInt(v.getTag().toString()), true);
            v.setSelected(true);
        }
       // Toast.makeText(context, "CLICKED",
        //        Toast.LENGTH_LONG).show();
    }




    @Override
    public int getItemCount() {
        return listDataKemiskinan == null ? 0 : listDataKemiskinan.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    static class DataKemiskinanViewHolder extends RecyclerView.ViewHolder {
        public TextView txtDataKemiskinan;
        public ImageView gambarDataKemiskinan;
        public CardView cardViewDataKemiskinan;
        public DataKemiskinanViewHolder(View itemView) {
            super(itemView);
            txtDataKemiskinan = (TextView) itemView.findViewById(R.id.namaKeluarga);
            gambarDataKemiskinan = (ImageView) itemView.findViewById(R.id.gambarDataKemiskinan);
            cardViewDataKemiskinan = (CardView) itemView.findViewById(R.id.cardViewDataKemiskinan);
        }
    }


}
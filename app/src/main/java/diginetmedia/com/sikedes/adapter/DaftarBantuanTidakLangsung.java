package diginetmedia.com.sikedes.adapter;

/**
 * Created by PIER on 7/18/2016.
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.model.DataKemiskinan;


public class DaftarBantuanTidakLangsung extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<DataKemiskinan> listDataKemiskinan;
    RecyclerView recyclerView;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    public DaftarBantuanTidakLangsung(List<DataKemiskinan> dataKemiskinan, RecyclerView recyclerViewDataKemiskinan, Context con) {
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

        View view = LayoutInflater.from(context).inflate(R.layout.cardview_daftar_bantuan_tidaklangsung, parent, false);
        return new DataKemiskinanViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        DataKemiskinan dataKemiskinan = listDataKemiskinan.get(position);
        DataKemiskinanViewHolder dataKemiskinanViewHolder = (DataKemiskinanViewHolder) holder;

        dataKemiskinanViewHolder.txtNama.setText(dataKemiskinan.getNamakeluarga());

    }

    @Override
    public int getItemCount() {
        return listDataKemiskinan == null ? 0 : listDataKemiskinan.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    static class DataKemiskinanViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNama;
        public TextView txtNik;
        public DataKemiskinanViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtNik = (TextView) itemView.findViewById(R.id.nik);
        }
    }


}
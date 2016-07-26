package diginetmedia.com.sikedes.adapter;

/**
 * Created by PIER on 7/18/2016.
 */

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.model.DataKemiskinan;
import diginetmedia.com.sikedes.model.Laporan;
import diginetmedia.com.sikedes.model.Pengguna;


public class NormalListDataKeranjangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<DataKemiskinan> listDataKemiskinan;
    RecyclerView recyclerView;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    public NormalListDataKeranjangAdapter(List<DataKemiskinan> dataKemiskinen, RecyclerView recyclerViewDataMasyarakat, Context con) {
        this.listDataKemiskinan = dataKemiskinen;
        this.recyclerView=recyclerViewDataMasyarakat;
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

        View view = LayoutInflater.from(context).inflate(R.layout.cardview_data_keranjang, parent, false);
        return new DataMasyarakatViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        DataKemiskinan dataKemiskinan = listDataKemiskinan.get(position);
        DataMasyarakatViewHolder dataMasyarakatViewHolder = (DataMasyarakatViewHolder) holder;

        dataMasyarakatViewHolder.txtAlamat.setText(dataKemiskinan.getAlamat());
        dataMasyarakatViewHolder.txtNama.setText(dataKemiskinan.getNamakeluarga());
    }

    @Override
    public int getItemCount() {
        return listDataKemiskinan == null ? 0 : listDataKemiskinan.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    static class DataMasyarakatViewHolder extends RecyclerView.ViewHolder {
        public TextView txtAlamat,txtNama;
        public DataMasyarakatViewHolder(View itemView) {
            super(itemView);
            txtAlamat = (TextView) itemView.findViewById(R.id.txtAlamat);
            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
        }
    }


}
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
import diginetmedia.com.sikedes.model.Laporan;
import diginetmedia.com.sikedes.model.Pengguna;


public class NormalListDataLaporanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Laporan> listDataLaporan;
    RecyclerView recyclerView;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    public NormalListDataLaporanAdapter(List<Laporan> dataLaporan, RecyclerView recyclerViewDataMasyarakat, Context con) {
        this.listDataLaporan = dataLaporan;
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

        View view = LayoutInflater.from(context).inflate(R.layout.normal_list, parent, false);
        return new DataMasyarakatViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Laporan dataLaporan = listDataLaporan.get(position);
        DataMasyarakatViewHolder dataMasyarakatViewHolder = (DataMasyarakatViewHolder) holder;

        dataMasyarakatViewHolder.txtLaporan.setText(dataLaporan.getIsi_laporan());
        dataMasyarakatViewHolder.txtNama.setText(dataLaporan.getNama_pelapor());
    }

    @Override
    public int getItemCount() {
        return listDataLaporan == null ? 0 : listDataLaporan.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    static class DataMasyarakatViewHolder extends RecyclerView.ViewHolder {
        public TextView txtLaporan,txtNama;
        public DataMasyarakatViewHolder(View itemView) {
            super(itemView);
            txtLaporan = (TextView) itemView.findViewById(R.id.txtNama);
            txtNama = (TextView) itemView.findViewById(R.id.nik);
        }
    }


}
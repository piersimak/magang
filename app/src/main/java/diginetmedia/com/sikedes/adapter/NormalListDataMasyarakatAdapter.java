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
import diginetmedia.com.sikedes.model.Pengguna;


public class NormalListDataMasyarakatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Pengguna> listDataMasyarakat;
    RecyclerView recyclerView;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    public NormalListDataMasyarakatAdapter(List<Pengguna> dataMasyarakat, RecyclerView recyclerViewDataMasyarakat, Context con) {
        this.listDataMasyarakat = dataMasyarakat;
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

        Pengguna dataMasyarakat = listDataMasyarakat.get(position);
        DataMasyarakatViewHolder dataMasyarakatViewHolder = (DataMasyarakatViewHolder) holder;

        dataMasyarakatViewHolder.txtNamaMasyarakat.setText(dataMasyarakat.getNamauser());
        dataMasyarakatViewHolder.txtNik.setText(dataMasyarakat.getNik());
    }

    @Override
    public int getItemCount() {
        return listDataMasyarakat == null ? 0 : listDataMasyarakat.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    static class DataMasyarakatViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNamaMasyarakat,txtNik;
        public DataMasyarakatViewHolder(View itemView) {
            super(itemView);
            txtNamaMasyarakat = (TextView) itemView.findViewById(R.id.txtNama);
            txtNik = (TextView) itemView.findViewById(R.id.nik);
        }
    }


}
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

import java.util.ArrayList;
import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.model.Bantuan;


public class DataKemiskinanYangDibantuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<String> listjenisBantuan = new ArrayList<>();
    RecyclerView recyclerView;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    public DataKemiskinanYangDibantuAdapter(List<String> listjenisBantuan, RecyclerView recyclerViewBantuan, Context con) {

        this.listjenisBantuan = listjenisBantuan;
        this.recyclerView=recyclerViewBantuan;
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

        View view = LayoutInflater.from(context).inflate(R.layout.cardview_list_data_kemiskinan_yang_dibantu, parent, false);
        return new BantuanViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        String jenisBantuan = listjenisBantuan.get(position);
        BantuanViewHolder dataBantuanViewHolder = (BantuanViewHolder) holder;

        dataBantuanViewHolder.txtJenisBantuan.setText(jenisBantuan);
    }

    @Override
    public int getItemCount() {
        return listjenisBantuan == null ? 0 : listjenisBantuan.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    static class BantuanViewHolder extends RecyclerView.ViewHolder {
        public TextView txtJenisBantuan;
        public TextView txtNamaDonatur;
        public BantuanViewHolder(View itemView) {
            super(itemView);
            txtJenisBantuan = (TextView) itemView.findViewById(R.id.txtJenisBantuan);
        }
    }


}
package diginetmedia.com.sikedes.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.activity.DetailLaporan;
import diginetmedia.com.sikedes.activity.VerifikasiDataKemiskinan;
import diginetmedia.com.sikedes.adapter.NormalListDataLaporanAdapter;
import diginetmedia.com.sikedes.adapter.NormallListDataKemiskinanAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;
import diginetmedia.com.sikedes.model.DataKemiskinan;
import diginetmedia.com.sikedes.model.Laporan;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarLaporanMasyarakat extends Fragment {


    public DaftarLaporanMasyarakat() {
        // Required empty public constructor
    }

    private View rootview;
    private Context context;
    private RecyclerView recyclerViewLaporan;
    private List<Laporan> listLaporan;
    private RecyclerView.LayoutManager layoutManager;
    private NormalListDataLaporanAdapter dataLaporanAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview =  inflater.inflate(R.layout.fragment_daftar_laporan_masyarakat, container, false);
        init();
        return rootview;
    }

    private void init()
    {

        context = getActivity().getApplicationContext();
        recyclerViewLaporan = (RecyclerView) rootview.findViewById(R.id.RecyclerViewDataLaporan);
        listLaporan = new ArrayList<Laporan>();
        for(int i=0; i<5 ; i++)
        {
            Laporan temp = new Laporan("nama "+i,"laporan "+i);
            listLaporan.add(temp);
        }
        recyclerViewLaporan.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        recyclerViewLaporan.setLayoutManager(layoutManager);

        dataLaporanAdapter = new NormalListDataLaporanAdapter(listLaporan,recyclerViewLaporan,context);
        recyclerViewLaporan.setAdapter(dataLaporanAdapter);

        recyclerViewLaporan.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(context, DetailLaporan.class);


                        startActivity(i);
                    }
                })
        );
    }

}

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
import diginetmedia.com.sikedes.activity.VerifikasiDataKemiskinan;
import diginetmedia.com.sikedes.adapter.NormallListDataKemiskinanAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;
import diginetmedia.com.sikedes.model.DataKemiskinan;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarBantuanTidakLangsung extends Fragment {


    public DaftarBantuanTidakLangsung() {
        // Required empty public constructor
    }

    private View rootview;
    private RecyclerView recyclerViewKemiskinan;
    private RecyclerView.LayoutManager layoutManager;
    private List<DataKemiskinan> listdataKemiskinan;
    private NormallListDataKemiskinanAdapter dataKemiskinanAdapter;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_daftar_bantuan_tidak_langsung, container, false);
        init();
        return rootview;
    }
    private void init()
    {
        context = getActivity().getApplicationContext();
        recyclerViewKemiskinan = (RecyclerView) rootview.findViewById(R.id.RecyclerViewDataKemiskinan);
        listdataKemiskinan = new ArrayList<DataKemiskinan>();
        for(int i=0; i<5 ; i++)
        {
            DataKemiskinan temp = new DataKemiskinan("http://iconshow.me/media/images/ui/ios7-icons/png/512/social-android-outline.png","tes");
            listdataKemiskinan.add(temp);
        }
        recyclerViewKemiskinan.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        recyclerViewKemiskinan.setLayoutManager(layoutManager);

        dataKemiskinanAdapter = new NormallListDataKemiskinanAdapter(listdataKemiskinan,recyclerViewKemiskinan,context);
        recyclerViewKemiskinan.setAdapter(dataKemiskinanAdapter);

        recyclerViewKemiskinan.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }
                })
        );
    }

}
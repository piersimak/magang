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
import diginetmedia.com.sikedes.activity.DetailDataKemiskinanYangDibantu;
import diginetmedia.com.sikedes.adapter.DataKemiskinanYangDibantuAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarTagihanFragment extends Fragment {


    public DaftarTagihanFragment() {
        // Required empty public constructor
    }

    private View rootview;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_daftar_tagihan, container, false);
        init();
        return rootview;
    }
    private void init(){
        context=getActivity().getApplicationContext();

        RecyclerView recyclerViewKemiskinanYangDibantu = (RecyclerView) rootview.findViewById(R.id.RecyclerViewDusun);

        List<String> listdataKemiskinanYangDibantu = new ArrayList<String>();
        for(int i=0; i<5 ; i++)
        {
            String temp = "Bantuan...";
            listdataKemiskinanYangDibantu.add(temp);
        }
        recyclerViewKemiskinanYangDibantu = (RecyclerView) rootview.findViewById(R.id.RecyclerViewDataYangDibantu);
        recyclerViewKemiskinanYangDibantu.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerViewKemiskinanYangDibantu.setLayoutManager(layoutManager);

        DataKemiskinanYangDibantuAdapter dataKemiskinanYangDibantu = new DataKemiskinanYangDibantuAdapter(listdataKemiskinanYangDibantu, recyclerViewKemiskinanYangDibantu,context);
        recyclerViewKemiskinanYangDibantu.setAdapter(dataKemiskinanYangDibantu);

        recyclerViewKemiskinanYangDibantu.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(context,DetailDataKemiskinanYangDibantu.class);
                        Bundle b = new Bundle();
                        b.putBoolean("disable",true);
                        i.putExtras(b);
                        startActivity(i);
                    }
                })
        );

    }
}

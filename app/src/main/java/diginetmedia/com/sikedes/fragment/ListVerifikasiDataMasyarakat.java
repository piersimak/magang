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
import diginetmedia.com.sikedes.activity.VerifikasiDataMasyarakat;
import diginetmedia.com.sikedes.adapter.NormalListDataMasyarakatAdapter;
import diginetmedia.com.sikedes.adapter.NormallListDataKemiskinanAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;
import diginetmedia.com.sikedes.model.Pengguna;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListVerifikasiDataMasyarakat extends Fragment {


    public ListVerifikasiDataMasyarakat() {
        // Required empty public constructor
    }


    private View rootview;
    private RecyclerView RecyclerViewDataMasyarakat;
    private RecyclerView.LayoutManager layoutManager;
    private List<Pengguna> listdataMasyarakat;
    private NormalListDataMasyarakatAdapter dataMasyarakatAdapter;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_verifikasi_data_masyarakat, container, false);
        init();
        return rootview;
    }
    private void init()
    {
        context = getActivity().getApplicationContext();
        RecyclerViewDataMasyarakat = (RecyclerView) rootview.findViewById(R.id.RecyclerViewDataMasyarakat);
        listdataMasyarakat = new ArrayList<>();
        for(int i=0; i<5 ; i++)
        {
            Pengguna temp = new Pengguna("id user","nik", "namauser");
            listdataMasyarakat.add(temp);
        }
        RecyclerViewDataMasyarakat.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        RecyclerViewDataMasyarakat.setLayoutManager(layoutManager);

        dataMasyarakatAdapter = new NormalListDataMasyarakatAdapter(listdataMasyarakat,RecyclerViewDataMasyarakat,context);
        RecyclerViewDataMasyarakat.setAdapter(dataMasyarakatAdapter);

        RecyclerViewDataMasyarakat.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(context, VerifikasiDataMasyarakat.class);
                        Bundle b = new Bundle();
                        i.putExtras(b);

                        startActivity(i);
                    }
                })
        );
    }

}



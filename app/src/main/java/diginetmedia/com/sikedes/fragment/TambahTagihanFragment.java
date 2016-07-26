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
import diginetmedia.com.sikedes.activity.DataKemiskinanYangDibantu;
import diginetmedia.com.sikedes.adapter.ListDataInvoiceAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;
import diginetmedia.com.sikedes.model.Bantuan;

/**
 * A simple {@link Fragment} subclass.
 */
public class TambahTagihanFragment extends Fragment {


    public TambahTagihanFragment() {
        // Required empty public constructor
    }

    private View rootview;
    private RecyclerView RecyclerViewDataInvoice;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> listnamaDonatur,listjenisBantuan;
    private ListDataInvoiceAdapter dataBantuanAdapter;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_tambah_tagihan, container, false);
        init();
        return rootview;
    }
    private void init()
    {
        context = getActivity().getApplicationContext();
        RecyclerViewDataInvoice = (RecyclerView) rootview.findViewById(R.id.RecyclerViewDataInvoice);
        listnamaDonatur = new ArrayList<>();
        listjenisBantuan = new ArrayList<>();
        for(int i=0; i<5 ; i++)
        {
            String tempnama = "nama donatur", tempjenis = "jenis bantuan" ;
            listjenisBantuan.add(tempjenis);
            listnamaDonatur.add(tempnama);
        }
        RecyclerViewDataInvoice.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        RecyclerViewDataInvoice.setLayoutManager(layoutManager);

        dataBantuanAdapter = new ListDataInvoiceAdapter(listnamaDonatur,listjenisBantuan,RecyclerViewDataInvoice,context);
        RecyclerViewDataInvoice.setAdapter(dataBantuanAdapter);

        RecyclerViewDataInvoice.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(context, DataKemiskinanYangDibantu.class);
                        startActivity(i);
                    }
                })
        );
    }

}
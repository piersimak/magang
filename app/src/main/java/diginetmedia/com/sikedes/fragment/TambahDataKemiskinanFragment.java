package diginetmedia.com.sikedes.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.activity.ListDataKemiskinan;
import diginetmedia.com.sikedes.adapter.KategoriAdapter;
import diginetmedia.com.sikedes.adapter.ListGambarAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;
import diginetmedia.com.sikedes.model.Kategori;

/**
 * A simple {@link Fragment} subclass.
 */
public class TambahDataKemiskinanFragment extends Fragment {


    public TambahDataKemiskinanFragment() {
        // Required empty public constructor
    }

    private View rootview;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_tambah_data_kemiskinan, container, false);
        init();
        return rootview;
    }
    private void init()
    {
        context=getActivity().getApplicationContext();
        List<Bitmap> listBitmap = new ArrayList<Bitmap>();
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.plus);
        for(int i=0; i<5 ; i++)
        {

            listBitmap.add(icon);
        }
        RecyclerView RecyclerViewGambar = (RecyclerView) rootview.findViewById(R.id.RecyclerViewGambar);
        //RecyclerViewKategori.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        RecyclerViewGambar.setLayoutManager(layoutManager);

        ListGambarAdapter gambarAdapter = new ListGambarAdapter(listBitmap,RecyclerViewGambar,context);
        RecyclerViewGambar.setAdapter(gambarAdapter);

        RecyclerViewGambar.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }
                })
        );
    }

}

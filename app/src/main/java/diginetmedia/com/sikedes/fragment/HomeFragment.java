package diginetmedia.com.sikedes.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.List;

import diginetmedia.com.sikedes.R;
import diginetmedia.com.sikedes.activity.ListDataKemiskinan;
import diginetmedia.com.sikedes.activity.ListDusunActivity;
import diginetmedia.com.sikedes.adapter.GridAutofitLayoutManager;
import diginetmedia.com.sikedes.adapter.KategoriAdapter;
import diginetmedia.com.sikedes.adapter.RecyclerItemClickListener;
import diginetmedia.com.sikedes.adapter.SpacesItemDecoration;
import diginetmedia.com.sikedes.model.Kategori;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    private Context context;
    private List<Kategori> listKategori;
    private KategoriAdapter katAdapter;
    private GridLayoutManager layoutManager;
    private View rootview;
    private RecyclerView RecyclerViewKategori;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_home, container, false);
        context = getActivity().getApplicationContext();
        initForm();
        return rootview;
    }
    private void initForm()
    {
        SliderLayout sliderShow = (SliderLayout) rootview.findViewById(R.id.slider);
        TextSliderView textSliderView = new TextSliderView(context);
        textSliderView.image(R.drawable.loading);
        sliderShow.addSlider(textSliderView);
        sliderShow.addSlider(textSliderView);
        sliderShow.setPresetTransformer(SliderLayout.Transformer.Accordion);
        listKategori = new ArrayList<Kategori>();
        int Drawable[] = {
                R.drawable.ic_air,
                R.drawable.ic_kategoribangunan,
                R.drawable.ic_listrik,
                R.drawable.ic_makanan,
                R.drawable.ic_pendidikan
        };
        String Kategori[] = {
                "Air",
                "Bangunan",
                "Listrik",
                "Makanan",
                "Pendidikan"
        };
        for(int i=0; i<5 ; i++)
        {
            Kategori temp = new Kategori(Kategori[i],Drawable[i]);
            listKategori.add(temp);
        }
        RecyclerViewKategori = (RecyclerView) rootview.findViewById(R.id.RecyclerViewKategori);

        layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),3);
        //RecyclerViewKategori.setHasFixedSize(true);
        RecyclerViewKategori.setLayoutManager(layoutManager);

        katAdapter = new KategoriAdapter(listKategori,RecyclerViewKategori,context);
        RecyclerViewKategori.setAdapter(katAdapter);

        RecyclerViewKategori.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(context, ListDusunActivity.class);
                        Bundle b = new Bundle();
                        b.putString("title","Kategori "+position);
                        i.putExtras(b);
                        startActivity(i);
                    }
                })
        );
    }

}

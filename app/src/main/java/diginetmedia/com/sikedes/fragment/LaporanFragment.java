package diginetmedia.com.sikedes.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import diginetmedia.com.sikedes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LaporanFragment extends Fragment {


    public LaporanFragment() {
        // Required empty public constructor
    }

    private View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_laporan, container, false);
        init();
        return rootview;
    }
    private void init()
    {

    }
}

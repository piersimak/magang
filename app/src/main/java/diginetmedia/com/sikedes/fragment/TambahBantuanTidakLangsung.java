package diginetmedia.com.sikedes.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.NumberFormat;

import diginetmedia.com.sikedes.AutoFormatCurrency;
import diginetmedia.com.sikedes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TambahBantuanTidakLangsung extends Fragment {


    public TambahBantuanTidakLangsung() {
        // Required empty public constructor
    }

    private Context context;
    private View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_tambah_bantuan_tidak_langsung, container, false);
        init();
        return rootview;
    }
    private void init()
    {
        context = getActivity().getApplicationContext();
        final TextInputEditText txtJumlahDonasi = (TextInputEditText) rootview.findViewById(R.id.txtJumlahDonasi);
        txtJumlahDonasi.addTextChangedListener(new TextWatcher() {
            private String current = "";
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                AutoFormatCurrency.Format(charSequence,txtJumlahDonasi,this);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}

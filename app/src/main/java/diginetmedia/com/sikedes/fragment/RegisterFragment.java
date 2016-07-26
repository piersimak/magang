package diginetmedia.com.sikedes.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import diginetmedia.com.sikedes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }

    private FrameLayout Register1,Register2;
    private Button tombolLanjutkan,tombolKembali;
    private View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_register, container, false);
        initForm();
        return rootview;
    }
    private void initForm()
    {
        Register1 = (FrameLayout)rootview.findViewById(R.id.Register1);
        Register2 = (FrameLayout)rootview.findViewById(R.id.Register2);
        Register1.setVisibility(View.VISIBLE);
        Register2.setVisibility(View.GONE);

        tombolKembali=(Button)rootview.findViewById(R.id.tombolKembali);
        tombolLanjutkan=(Button)rootview.findViewById(R.id.tombolLanjutkan);
        tombolLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register1.setVisibility(View.GONE);
                Register2.setVisibility(View.VISIBLE);
            }
        });
        tombolKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register1.setVisibility(View.VISIBLE);
                Register2.setVisibility(View.GONE);
            }
        });
    }
}

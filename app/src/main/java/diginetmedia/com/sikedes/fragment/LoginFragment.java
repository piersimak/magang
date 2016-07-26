package diginetmedia.com.sikedes.fragment;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import diginetmedia.com.sikedes.MainActivity;
import diginetmedia.com.sikedes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }
    private TextView txtDaftar;
    private View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_login, container, false);
        initForm();
        return rootview;
    }
    private void initForm()
    {
        txtDaftar = (TextView)rootview.findViewById(R.id.txtDaftar);
        txtDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new RegisterFragment();
                String title = "Daftar";
                ((MainActivity)getActivity()).selectMenu("Daftar",R.id.nav_register);
                if(fragment!=null) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.commit();
                   // getActivity().getSupportActionBar().setTitle(title);
                }
            }
        });
    }

}

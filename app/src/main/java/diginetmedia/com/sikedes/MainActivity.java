package diginetmedia.com.sikedes;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularimageview.CircularImageView;

import diginetmedia.com.sikedes.activity.KeranjangActivity;
import diginetmedia.com.sikedes.fragment.DaftarBantuanTidakLangsung;
import diginetmedia.com.sikedes.fragment.DaftarLaporanMasyarakat;
import diginetmedia.com.sikedes.fragment.DaftarTagihanFragment;
import diginetmedia.com.sikedes.fragment.HomeFragment;
import diginetmedia.com.sikedes.fragment.LoginFragment;
import diginetmedia.com.sikedes.fragment.ProfilFragment;
import diginetmedia.com.sikedes.fragment.RegisterFragment;
import diginetmedia.com.sikedes.fragment.TambahBantuanTidakLangsung;
import diginetmedia.com.sikedes.fragment.TambahDataKemiskinanFragment;
import diginetmedia.com.sikedes.fragment.ListUpdateDataKemiskinan;
import diginetmedia.com.sikedes.fragment.ListVerifikasiDataKemiskinan;
import diginetmedia.com.sikedes.fragment.ListVerifikasiDataMasyarakat;
import diginetmedia.com.sikedes.fragment.TambahTagihanFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private NavigationView navigationView;
    private CircularImageView imgProfil;
    private Menu nav_Menu;
    private boolean inHome=false;
    private String m_Text = "";
    private View headerLayout;
    private Menu menugrup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_main);

        Fragment fragment = new HomeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_body, fragment);
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Beranda");

        init();
        changeItem("guest");
    }
    private void init()
    {

        imgProfil = (CircularImageView) headerLayout.findViewById(R.id.imgProfil3);
        imgProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfil();
            }
        });

        selectMenu("Beranda", R.id.nav_home);
       // nav_Menu.setGroupVisible(R.id.guestmenu,false);
        //nav_Menu.setGroupVisible(R.id.masyarakatmenu,false);


    }
    public void selectMenu(String title, int Menuid)
    {
        if(Menuid!=0)
        {
            navigationView = (NavigationView) findViewById(R.id.nav_view);
            nav_Menu = navigationView.getMenu();
            MenuItem menu = nav_Menu.findItem(Menuid);
            menu.setChecked(true);
        }
        getSupportActionBar().setTitle(title);
    }
    private void openProfil()
    {
        inHome=false;
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();
        for(int i=0; i<nav_Menu.size();i++)
        {
            nav_Menu.getItem(i).setChecked(false);
        }

        Fragment fragment = null;
        String title = null;

        fragment = new ProfilFragment();
        title="Profil";

        openFragment(title,fragment,0);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
           // super.onBackPressed();
            Fragment fragment = new HomeFragment();
            openFragment("Beranda",fragment,R.id.nav_home);
            if(!inHome)
                inHome=true;
            else
                finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.



        this.menugrup = menu;
        getMenuInflater().inflate(R.menu.main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo( searchManager.getSearchableInfo(getComponentName()) );
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "TES",
                        Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        SearchView searchView2 = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView2.setQueryHint("Cari");

        MenuItem searchMenuItem = menu.findItem(R.id.action_search);

        MenuItemCompat.setOnActionExpandListener(searchMenuItem, new MenuItemCompat.OnActionExpandListener() {

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do whatever you need
                return true; // KEEP IT TO TRUE OR IT DOESN'T OPEN !!
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do whatever you need
                return true; // OR FALSE IF YOU DIDN'T WANT IT TO CLOSE!
            }
        });
        return true;
    }
    @Override
    public boolean onSearchRequested() {
        Bundle appData = new Bundle();
        appData.putString("hello", "world");
        startSearch(null, false, appData, false);
        return true;
    }
    public void showOverflowMenu(boolean showMenu){
        if(menugrup == null)
            return;
        menugrup.setGroupVisible(R.id.main_menu_group, showMenu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id)
        {
            case R.id.action_search:
                onSearchRequested();
                break;
            case R.id.action_cart:
                openCart();
                break;
        }


        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
    private void openCart()
    {
        Intent i = new Intent(this, KeranjangActivity.class);
        startActivity(i);
    }
    private void changeItem(String role)
    {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();

        switch (role)
        {
            case "masyarakat" :
                nav_Menu.setGroupVisible(R.id.masyarakatmenu,true);
                break;
            case "guest" :
                nav_Menu.setGroupVisible(R.id.guestmenu,true);
                break;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        inHome=false;
        Fragment fragment = null;
        String title = null;
        if (id == R.id.nav_login) {
            fragment = new LoginFragment();
            title="Masuk";
            openFragment(title,fragment,R.id.nav_login);
        } else if (id == R.id.nav_register) {
            fragment = new RegisterFragment();
            title="Daftar";
            openFragment(title,fragment,R.id.nav_register);
        } else if (id == R.id.nav_home) {
            fragment = new HomeFragment();
            title="Beranda";
            inHome=true;
            openFragment(title,fragment,R.id.nav_home);
        } else if (id == R.id.nav_lapor) {
            displayAlertDialog();
        } else if (id == R.id.nav_verif_data_kemiskinan) {
            fragment = new ListVerifikasiDataKemiskinan();
            title="Verifikasi Data Kemiskinan";
            openFragment(title,fragment,R.id.nav_verif_data_kemiskinan);
        } else if (id == R.id.nav_tambah_data_kemiskinan) {
            fragment = new TambahDataKemiskinanFragment();
            title="Tambah Data Kemiskinan";
            openFragment(title,fragment,R.id.nav_tambah_data_kemiskinan);
        } else if (id == R.id.nav_update_data_kemiskinan) {
            fragment = new ListUpdateDataKemiskinan();
            title="Perbarui Data Kemiskinan";
            openFragment(title,fragment,R.id.nav_update_data_kemiskinan);
        } else if (id == R.id.nav_verif_data_masyarakat) {
            fragment = new ListVerifikasiDataMasyarakat();
            title="Verifikasi Data Masyarakat";
            openFragment(title,fragment,R.id.nav_verif_data_masyarakat);
        } else if (id == R.id.nav_lihat_laporan) {
            fragment = new DaftarLaporanMasyarakat();
            title="Daftar Laporan Masyarakat";
            openFragment(title,fragment,R.id.nav_lihat_laporan);
        } else if (id == R.id.nav_tambah_bantuan_tidaklangsung) {
            fragment = new TambahBantuanTidakLangsung();
            title="Tambah Bantuan Tidak Langsung";
            openFragment(title,fragment,R.id.nav_tambah_bantuan_tidaklangsung);
        } else if (id == R.id.nav_daftar_bantuan) {
            fragment = new DaftarBantuanTidakLangsung();
            title="Daftar Bantuan Tidak Langsung";
            openFragment(title,fragment,R.id.nav_daftar_bantuan);
        } else if (id == R.id.nav_input_invoice) {
            fragment = new TambahTagihanFragment();
            title="Tambah Tagihan";
            openFragment(title,fragment,R.id.nav_input_invoice);
        } else if (id == R.id.nav_daftar_tagihan) {
            fragment = new DaftarTagihanFragment();
            title="Daftar Tagihan";
            openFragment(title,fragment,R.id.nav_daftar_tagihan);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void openFragment(String title, Fragment fragment, int Menuid)
    {
        if(Menuid==R.id.nav_home || Menuid==R.id.nav_update_data_kemiskinan || Menuid==R.id.nav_verif_data_masyarakat
                || Menuid==R.id.nav_verif_data_kemiskinan)
            showOverflowMenu(true);
        else showOverflowMenu(false);
        if(fragment!=null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }
        selectMenu(title,Menuid );
    }

    public void displayAlertDialog() {
        //LayoutInflater inflater = getLayoutInflater();
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View alertLayout = inflater.inflate(R.layout.cardview_lapor, null);

        TextInputLayout textContainer = (TextInputLayout) alertLayout.findViewById(R.id.textContainer);
        textContainer.setCounterEnabled(true);
        textContainer.setCounterMaxLength(1000);


        TextInputEditText txtLapor = (TextInputEditText) alertLayout.findViewById(R.id.txtLapor);

       // final EditText txtkomen = (EditText) alertLayout.findViewById(R.id.txtLapor);
        final ProgressBar progressBar = (ProgressBar) alertLayout.findViewById(R.id.progresBar);
        final TextView txttimeout = (TextView) alertLayout.findViewById(R.id.txttimeout);
        final Button tombolLapor = (Button) alertLayout.findViewById(R.id.tombolLapor);
        final Button tombolBatal = (Button) alertLayout.findViewById(R.id.tombolBatal);


        android.app.AlertDialog.Builder alert = new android.app.AlertDialog.Builder(this);
        alert.setView(alertLayout);
        alert.setCancelable(false);
        final android.app.AlertDialog dialog = alert.create();
        dialog.show();


        tombolBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.setOnCancelListener(new android.app.AlertDialog.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                //Log.d("tombol", "masuk");


            }
        });
        tombolLapor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tombolLapor.setMode(ActionProcessButton.Mode.PROGRESS);

            }
        });

    }
}

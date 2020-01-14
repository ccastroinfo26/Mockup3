package com.example.mockup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mockup.ui.Buscar.BuscarFragment;
import com.example.mockup.ui.MinhasDiligências.MinhasFragment;
import com.example.mockup.ui.Sair.SairFragment;
import com.example.mockup.ui.Sobre.SobreFragment;
import com.example.mockup.ui.Termos.TermosFragment;
import com.example.mockup.ui.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class telaComMapa extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_com_mapa);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_home);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_home, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_buscar:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_buscar, new BuscarFragment()).commit();
                break;
            case R.id.nav_sobre:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_sobre, new SobreFragment()).commit();
                break;
            case R.id.nav_my:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_minhas, new MinhasFragment()).commit();
                break;
            case R.id.nav_terms:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_terms, new TermosFragment()).commit();
                break;
            case R.id.nav_exit:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_exit, new SairFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

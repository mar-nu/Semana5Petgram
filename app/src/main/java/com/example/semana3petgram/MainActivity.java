package com.example.semana3petgram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;



import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


        private TabLayout tabLayout;
        private ViewPager viewPager;
        private Toolbar miActionBar;



    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            miActionBar = (Toolbar) findViewById(R.id.miActionBar);
            setSupportActionBar(miActionBar);
            tabLayout = (TabLayout) findViewById(R.id.tabLayout);
            viewPager = (ViewPager) findViewById(R.id.viewPager);
            setUpViewPager();
    /*

*/

        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.menu_opciones, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item){

            switch (item.getItemId()){

                case R.id.mAcercaDe:
                    Intent intent = new Intent (this, AcercaDe.class);
                    startActivity(intent);
                    break;

                case R.id.mContacto:
                    Intent i = new Intent (this, Contacto.class);
                    startActivity(i);
                    break;

            }

            return super.onOptionsItemSelected(item);
        }



        public void irFavoritos(View v){
            Intent intent = new Intent (this, Favoritos.class);
            startActivity(intent);
        }

        private ArrayList<Fragment> AgregarFragments(){
            ArrayList<Fragment> fragments = new ArrayList<>();
            fragments.add(new RecyclerViewFragment());
            fragments.add(new PerfilFragment());

            return fragments;
        }

        private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), AgregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.perfil);
        }

    }
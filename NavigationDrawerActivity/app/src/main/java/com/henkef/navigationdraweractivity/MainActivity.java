package com.henkef.navigationdraweractivity;

import android.os.Bundle;
//import android.widget.Toolbar;   //veio com essa biblioteca carregada, porem não estava abrindo o app então tive que remove-lá e incluir a biblioteca abaixo import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //configura barra de navegação
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //cria referencia para toda a area deo NavigationDrawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        //cria referencia para area de navegação
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        //define configurações do NavigationDrawer
        mAppBarConfiguration = new AppBarConfiguration.Builder(   //aqui é colocado os identificadores de todos os menus que serão utilizados, caso seja acrescentado deve-se incluir aqui
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_cartoes)
                .setOpenableLayout(drawer)
                .build();

        //configura a area que irá carregar os fragments
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);


        //inclui o botão de navegação dos menus, sem esse comando não será exibido o menu superior. obs: ele pode ser removido
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        //configura a navegação para o NavigationView. Sem esse comando o menu será exibido mas não será feito nada.
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
package com.jeanpiere.trabajo.Onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.jeanpiere.trabajo.LoginActivity;
import com.jeanpiere.trabajo.R;



import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;

    private LinearLayout laoutOnboardingIndicators;




    ViewPager2 viewPager2;

    Button btnsiguiente,btnanterior,btnomitir;


    boolean empezoClick = false;


    int page = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);



        //indicador

        laoutOnboardingIndicators = findViewById(R.id.LayoutOnboardingIndicators);

        //botones
        btnanterior = findViewById(R.id.butnanterior);
        btnsiguiente = findViewById(R.id.butnsiguiente);
        btnomitir = findViewById(R.id.butnomitir);

        //demas
        viewPager2 = findViewById(R.id.onboardingViewPager);


        setupOnboardingItems();

        //indicadordepuntos

        setupOnboardingIndicators();
        setCurrentOnboardingIndicators(0);



        viewPager2.setAdapter(onboardingAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicators(position);

            }
        });



        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    btnanterior.setVisibility(View.INVISIBLE);
                } else {
                    btnanterior.setVisibility(View.VISIBLE);
                }

            }
        });

        //logica de boton anterior

        btnanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int paginaanterior = viewPager2.getCurrentItem();
                if (paginaanterior > 0){
                    viewPager2.setCurrentItem(paginaanterior - 1);
                    setCurrentOnboardingIndicators(paginaanterior - 1);
                }
            }
        });

        //logica de boton siguiente

        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager2.getCurrentItem() + 1 < onboardingAdapter.getItemCount()) {

                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                } else {

                    Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


        btnomitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager2.getCurrentItem() + 1< onboardingAdapter.getItemCount()){
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem()+ 3);
                }
            }

        });




    }

    private void setupOnboardingItems() {

        List<OnboardingItem> onboardingItems = new ArrayList<>();


        OnboardingItem itemtextinfo2 = new OnboardingItem();
        itemtextinfo2.setImage(R.drawable.img_gamer1);
        itemtextinfo2.setTitle(getString(R.string.pag1info));
        String title2 = getString(R.string.pag1kamp);
        itemtextinfo2.setDescription(getString(R.string.pag1info2));
        itemtextinfo2.setTitle2(title2);


        OnboardingItem itemOntheWay = new OnboardingItem();
        itemOntheWay.setTitle(getString(R.string.pag2info));
        itemOntheWay.setTitle5(getString(R.string.pag2info2));
        itemOntheWay.setImage(R.drawable.img_gamer2);


        OnboardingItem itemEatTogueter = new OnboardingItem();
        itemEatTogueter.setTitle6(getString(R.string.pag3info));
        String title7 = getString(R.string.pag3kamp);
        itemEatTogueter.setTitle7(title7);
        itemEatTogueter.setTitle8(getString(R.string.pag3te));
        itemEatTogueter.setTitle9(getString(R.string.pag3info_info));
        itemEatTogueter.setDescription(getString(R.string.pag3info2));
        itemEatTogueter.setImage(R.drawable.img_gamer3);

        onboardingItems.add(itemtextinfo2);
        onboardingItems.add(itemOntheWay);
        onboardingItems.add(itemEatTogueter);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);

    }

    private void setupOnboardingIndicators() {

        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );

        layoutParams.setMargins(8,0,0,0);
        for (int i = 0 ; i < indicators.length; i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            laoutOnboardingIndicators.addView(indicators[i]);
        }

    }


    private void setCurrentOnboardingIndicators(int index){
        int childCount = laoutOnboardingIndicators.getChildCount();
        for (int i = 0 ; i < childCount; i++){
            ImageView imageView = (ImageView) laoutOnboardingIndicators.getChildAt(i);
            if (i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive)
                );
            }
        }



        //funciona pero el boton siguiente te redirecciona a launcheractivity

        if (index == onboardingAdapter.getItemCount() - 1) {
            btnsiguiente.setText("Empezar");
            /*btnsiguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (getitem(0) < 3){
                        viewPager2.setCurrentItem(getitem(1),true);

                        if (getitem(0) <3){

                            Intent intent = new Intent(IntroActivity.this, PreviewActivity.class);
                            startActivity(intent);
                            finish();
                        }

                    }
                }
            });*/
        } else {


            btnsiguiente.setText("Siguiente");


            /*btnsiguiente.setText("Empezar");
            Intent intent = new Intent(IntroActivity.this, PreviewActivity.class);
            startActivity(intent);
            finish();*/
        }








        //funciona pero no te redirecciona a ningun lado
        /*if (index == onboardingAdapter.getItemCount() - 1) {
            btnsiguiente.setText("Empezar");
        } else{
            if (index == onboardingAdapter.getItemCount() - 1){
                btnsiguiente.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        }*/
        //

        /*Intent intent = new Intent(IntroActivity.this, PreviewActivity.class);
        startActivity(intent);
        finish();*/

    }



    /*private int getitem (int i){

        return viewPager2.getCurrentItem() + i;
    }*/
}
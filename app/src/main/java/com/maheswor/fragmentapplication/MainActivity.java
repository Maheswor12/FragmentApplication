package com.maheswor.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.maheswor.fragmentapplication.fragments.FirstFragment;
import com.maheswor.fragmentapplication.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnfragment;
    private Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnfragment = findViewById(R.id.btnfragment);
        btnfragment.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(status) {
            FirstFragment firstFragment = new FirstFragment();
            fragmentTransaction.replace(R.id.btnlinearlayout,firstFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btnfragment.setText("Load second fragment");
            status=false;
        }else{
            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.replace(R.id.btnlinearlayout,secondFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btnfragment.setText("Load first fragment");
            status=true;
        }


    }
}

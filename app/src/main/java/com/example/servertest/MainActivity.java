package com.example.servertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servertest.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Human> person;

    public static TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        CustomRecycleViewAdapter customRecycleViewAdapter =new CustomRecycleViewAdapter(getApplicationContext(), (ArrayList) person);
        binding.recycleView.setAdapter(customRecycleViewAdapter);

        getHuman();
    }

    private void getHuman() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api =retrofit.create(Api.class);
        Call<List<Human>> call = api.getHumans();

        call.enqueue(new Callback<List<Human>>() {
            @Override
            public void onResponse(Call<List<Human>> call, Response<List<Human>> response) {
                List<Human> humanList = response.body();

                String[] humans = new String[humanList.size()];
                String[] family = new String[humanList.size()];
                for (int i = 0; i < humanList.size(); i++) {
                    humans[i] = humanList.get(i).getName();
                    family[i] = humanList.get(i).getFamily();
                }

            }

            @Override
            public void onFailure(Call<List<Human>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

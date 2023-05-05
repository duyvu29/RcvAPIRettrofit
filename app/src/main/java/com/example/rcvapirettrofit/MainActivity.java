package com.example.rcvapirettrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.rcvapirettrofit.AdapterAPI.ApdapterRcvAPI;
import com.example.rcvapirettrofit.apiServierce.apiJSON;
import com.example.rcvapirettrofit.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvAPI;
    private List<User> list;
    private ApdapterRcvAPI apdapterRcvAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping ();
        setRcv();
        callApi();
    }

    private void callApi() {
        apiJSON.api.getDataJson(1).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                list = new ArrayList<>();
                list = response.body();
                apdapterRcvAPI = new ApdapterRcvAPI(list);
                rcvAPI.setAdapter(apdapterRcvAPI);

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Errol", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setRcv() {
        LinearLayoutManager linearLayou = new LinearLayoutManager(this);
        rcvAPI.setLayoutManager(linearLayou);

        list= new ArrayList<>();
        apdapterRcvAPI = new ApdapterRcvAPI(list);
        rcvAPI.setAdapter(apdapterRcvAPI);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvAPI.addItemDecoration(dividerItemDecoration);
    }

    private void mapping() {
        rcvAPI = findViewById(R.id.rcvAPI);
    }
}
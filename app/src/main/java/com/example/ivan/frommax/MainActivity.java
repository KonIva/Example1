package com.example.ivan.frommax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {

    private static MurzinmaApi murzinmaApi;
    PersonModel person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        murzinmaApi = Controller.getApi();
        murzinmaApi.getData().enqueue(new Callback<PersonModel>() {
            @Override
            public void onResponse(Call<PersonModel> call, Response<PersonModel> response) {
                person = response.body();
        Button resetBtn=(Button)findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        TextView textView=(TextView)findViewById(R.id.textView);
                        TextView textView1=(TextView)findViewById(R.id.textView2);
                        TextView textView2=(TextView)findViewById(R.id.textView3);
                        textView.setText("Ф.И.О. "+person.getName());
                        textView1.setText("Дата рождения "+person.getBirthday());
                        textView2.setText("Доп. инфо "+ person.getDesc());
                    }


                }
        );





}

            @Override
            public void onFailure(Call<PersonModel> call, Throwable t) {

            }
        });}}


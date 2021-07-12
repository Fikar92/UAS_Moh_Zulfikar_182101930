package com.mohzulfikar.crudproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mohzulfikar.crudproject.model.PostPutDetUser;
import com.mohzulfikar.crudproject.rest.ApiClient;
import com.mohzulfikar.crudproject.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    EditText editName,editEmail;
    Button btnInsert,btnBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        editName = (EditText) findViewById(R.id.editNamaDepan);
        editName = (EditText) findViewById(R.id.editNamaBelakang);
        editEmail = (EditText) findViewById(R.id.editEmail);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener( ) {

            @Override
            public void onClick(View view) {
                Call<PostPutDetUser> postUserCall = mApiInterface.postUser(editName.getText().toString(),editEmail.getText().toString());
                postUserCall.enqueue(new Callback<PostPutDetUser>( ) {
                    @Override
                    public void onResponse(Call<PostPutDetUser> call, Response<PostPutDetUser> response) {
                        MainActivity.ma.refresh( );
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDetUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext( ), "error", Toast.LENGTH_LONG).show( );
                    }
                });
            }
        });

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                MainActivity.ma.refresh();
                finish();
            }
        });
    }
}
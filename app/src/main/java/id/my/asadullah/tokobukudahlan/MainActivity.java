package id.my.asadullah.tokobukudahlan;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import id.my.asadullah.tokobukudahlan.network.ApiServices;
import id.my.asadullah.tokobukudahlan.network.InitRetrofit;
import id.my.asadullah.tokobukudahlan.response.DataBukuItem;
import id.my.asadullah.tokobukudahlan.response.ResponseDaftarBuku;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView listBuku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo inisialisasi
        listBuku = (RecyclerView) findViewById(R.id.list_buku);

        //todo method get daftar buku
        getDaftarBuku();

        //todo set layout manager
        listBuku.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDaftarBuku() {
        //todo panggil api services
        ApiServices api = InitRetrofit.getInstance();

        //todo siapkan request
        Call<ResponseDaftarBuku> call = api.request_tampil_buku();

        //todo kirim request
        call.enqueue(new Callback<ResponseDaftarBuku>() {
            @Override
            public void onResponse(Call<ResponseDaftarBuku> call, Response<ResponseDaftarBuku> response) {
                Log.d("Response" , " " + response.body().toString());
                //todo tampung dalam variable
                Boolean status = response.body().isStatus();

                //todo cek nilai status true / false
                if (status==true){
                    //todo tampilkan data buku
                    List<DataBukuItem> data_buku = response.body().getDataBuku();

                    // todo coba log
                    Log.d("Data buku", data_buku.toString());

                    //todo buat adapter
                    BukuAdapter adapter = new BukuAdapter(MainActivity.this, data_buku);

                    //todo set adapter ke recycler view
                    listBuku.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDaftarBuku> call, Throwable t) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ProgressDialog dialog = ProgressDialog.show(MainActivity.this, "", "Loading", false);
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Tidak ada koneksi", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}
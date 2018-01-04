package id.my.asadullah.tokobukudahlan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.cover_buku)
    ImageView coverBuku;
    @BindView(R.id.nama_buku)
    TextView namaBuku;
    @BindView(R.id.tgl_terbit)
    TextView tglTerbit;
    @BindView(R.id.harga_buku)
    TextView hargaBuku;
    @BindView(R.id.pengarang_buku)
    TextView pengarangBuku;
    @BindView(R.id.desk_buku)
    TextView deskBuku;

    public static String setImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        // todo membuat url
        String url_gambar = "http://192.168.1.62/toko_buku_api/image/";

        // todo terima data dari adapter
        Intent terimadata = getIntent();

        setImage = getIntent().getStringExtra("COVER");
        namaBuku.setText(terimadata.getStringExtra("NAMA"));
        tglTerbit.setText("Tanggal terbit \t: "+terimadata.getStringExtra("TGL_TERBIT"));
        hargaBuku.setText("Harga \t\t\t\t\t: Rp."+terimadata.getStringExtra("HARGA"));
        pengarangBuku.setText("Pengarang \t\t\t: "+terimadata.getStringExtra("PENGARANG"));
        deskBuku.setText(terimadata.getStringExtra("DESKRIPSI"));
        Glide.with(DetailActivity.this)
                .load(url_gambar+ setImage)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(coverBuku);

        // todo menampilkan icon back
        getSupportActionBar().setHomeButtonEnabled(true);


/*        // todo get data dari intent
        id_buku = getIntent().getStringExtra("tampil_detail");

        // todo membuat client
        InitRetrofit network = new InitRetrofit();
        OkHttpClient networkHttp = new OkHttpClient();


        // todo post method
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("tampil_detail", id_buku)
                .build();

        // todo put request
        Request request = new Request.Builder()
                .url(url)
                .method("POST", RequestBody.create(null, new byte[0]))
                .post(requestBody)
                .build();

        // todo eksekusi
        networkHttp.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //todo ketika error
                        Toast.makeText(DetailActivity.this, "Koneksi error", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //todo ketika berhasil
                String result = response.body().string();
                try{
                    JSONObject object = new JSONObject(result);
                    String success = object.getString("success");

                    if (success.equalsIgnoreCase("true")){
                        JSONArray array = object.getJSONArray("buku");
                        DataBukuItem dataBukuItem = null;

                        for (int i = 0 ; i < array.length(); i ++){
                            JSONObject jsonObject = array.getJSONObject(i);
                            dataBukuItem = new DataBukuItem(jsonObject);
                        }
                        final DataBukuItem dataBuku = dataBukuItem;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                namaBuku.setText(dataBuku.getNamaBuku());
                                tglTerbit.setText(dataBuku.getTglTerbitBuku());
                                hargaBuku.setText(dataBuku.getHargaBuku());
                                pengarangBuku.setText(dataBuku.getPengarangBuku());
                                deskBuku.setText(dataBuku.getPengarangBuku());
                                String url_gambar = BukuAdapter.BASE_URL+"image/"+dataBuku.getCoverBuku();
                                Glide.with(DetailActivity.this)
                                        .load(url_gambar)
                                        .placeholder(R.mipmap.ic_launcher)
                                        .error(R.mipmap.ic_launcher)
                                        .into(coverBuku);
                            }
                        });
                    }

                }catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
*/
    }
}

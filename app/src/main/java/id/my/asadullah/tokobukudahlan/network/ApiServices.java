package id.my.asadullah.tokobukudahlan.network;

import id.my.asadullah.tokobukudahlan.response.ResponseDaftarBuku;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by asadullah on 12/29/17.
 */

public interface ApiServices {

    //todo request pertama tampil semua buku
    @GET("lihat_buku.php")
    Call<ResponseDaftarBuku> request_tampil_buku();

    //todo request kedua lihat detail buku


}

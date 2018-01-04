package id.my.asadullah.tokobukudahlan.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asadullah on 12/29/17.
 */

public class InitRetrofit {

    public static String SERVER_URL = "http://192.168.1.62/toko_buku_api/";

    public static Retrofit setInit(){
        return new Retrofit.Builder().baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiServices getInstance(){
        return setInit().create(ApiServices.class);
    }

}
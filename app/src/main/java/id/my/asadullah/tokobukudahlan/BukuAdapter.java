package id.my.asadullah.tokobukudahlan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.my.asadullah.tokobukudahlan.response.DataBukuItem;

/**
 * Created by asadullah on 12/29/17.
 */

class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.MyViewHolder>{

    public static final String BASE_URL = "http://192.168.1.62/toko_buku_api/";

    //todo variable global
    Context con;
    List<DataBukuItem> data_buku;

    //
    public BukuAdapter(Context context, List<DataBukuItem> data_buku) {
        this.con = context;
        this.data_buku = data_buku;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //todo layout inflater
        View view = LayoutInflater.from(con).inflate(R.layout.list_item, parent, false);

        //todo Buat object view holder
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        final String url_image = BASE_URL + "image/" + data_buku.get(position).getCoverBuku();

        // todo menampilkan gambar
        Glide.with(con)
                .load(url_image)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.coverBuku);


        holder.tvJudul.setText(data_buku.get(position).getNamaBuku());
        holder.tvPenerbit.setText("Pengarang : " + data_buku.get(position).getPengarangBuku());
        holder.tvTglTerbit.setText("Terbit : " + data_buku.get(position).getTglTerbitBuku());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo aksi untuk menuju detail activity
                Intent kirimdata = new Intent(con, DetailActivity.class);

                //todo kirim data ke detail activiy
                kirimdata.putExtra("COVER",data_buku.get(position).getCoverBuku());
                kirimdata.putExtra("NAMA", data_buku.get(position).getNamaBuku());
                kirimdata.putExtra("TGL_TERBIT", data_buku.get(position).getTglTerbitBuku());
                kirimdata.putExtra("HARGA", data_buku.get(position).getHargaBuku());
                kirimdata.putExtra("PENGARANG", data_buku.get(position).getPengarangBuku());
                kirimdata.putExtra("DESKRIPSI", data_buku.get(position).getDeskBuku());

                //todo eksekusi
                con.startActivity(kirimdata);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data_buku.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //todo inisialisasi
        ImageView coverBuku;
        TextView tvJudul, tvPenerbit, tvTglTerbit;
        public MyViewHolder(View itemView) {
            super(itemView);

            coverBuku = (ImageView) itemView.findViewById(R.id.coverBuku);
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvPenerbit = (TextView) itemView.findViewById(R.id.tvPenerbit);
            tvTglTerbit = (TextView) itemView.findViewById(R.id.tvTglTerbit);
        }
    }
}
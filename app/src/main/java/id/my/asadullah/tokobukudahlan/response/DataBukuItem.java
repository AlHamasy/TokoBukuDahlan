package id.my.asadullah.tokobukudahlan.response;

import com.google.gson.annotations.SerializedName;

public class DataBukuItem{

	@SerializedName("cover_buku")
	private String coverBuku;

	@SerializedName("harga_buku")
	private String hargaBuku;

	@SerializedName("nama_buku")
	private String namaBuku;

	@SerializedName("tgl_terbit_buku")
	private String tglTerbitBuku;

	@SerializedName("pengarang_buku")
	private String pengarangBuku;

	@SerializedName("id")
	private String id;

	@SerializedName("desk_buku")
	private String deskBuku;


	public void setCoverBuku(String coverBuku){
		this.coverBuku = coverBuku;
	}

	public String getCoverBuku(){
		return coverBuku;
	}

	public void setHargaBuku(String hargaBuku){
		this.hargaBuku = hargaBuku;
	}

	public String getHargaBuku(){
		return hargaBuku;
	}

	public void setNamaBuku(String namaBuku){
		this.namaBuku = namaBuku;
	}

	public String getNamaBuku(){
		return namaBuku;
	}

	public void setTglTerbitBuku(String tglTerbitBuku){
		this.tglTerbitBuku = tglTerbitBuku;
	}

	public String getTglTerbitBuku(){
		return tglTerbitBuku;
	}

	public void setPengarangBuku(String pengarangBuku){
		this.pengarangBuku = pengarangBuku;
	}

	public String getPengarangBuku(){
		return pengarangBuku;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setDeskBuku(String deskBuku){
		this.deskBuku = deskBuku;
	}

	public String getDeskBuku(){
		return deskBuku;
	}

	@Override
 	public String toString(){
		return 
			"DataBukuItem{" + 
			"cover_buku = '" + coverBuku + '\'' + 
			",harga_buku = '" + hargaBuku + '\'' + 
			",nama_buku = '" + namaBuku + '\'' + 
			",tgl_terbit_buku = '" + tglTerbitBuku + '\'' + 
			",pengarang_buku = '" + pengarangBuku + '\'' + 
			",id = '" + id + '\'' + 
			",desk_buku = '" + deskBuku + '\'' + 
			"}";
		}
}
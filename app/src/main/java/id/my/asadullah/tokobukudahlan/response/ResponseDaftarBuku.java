package id.my.asadullah.tokobukudahlan.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDaftarBuku{

	@SerializedName("data_buku")
	private List<DataBukuItem> dataBuku;

	@SerializedName("status")
	private boolean status;

	public void setDataBuku(List<DataBukuItem> dataBuku){
		this.dataBuku = dataBuku;
	}

	public List<DataBukuItem> getDataBuku(){
		return dataBuku;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDaftarBuku{" + 
			"data_buku = '" + dataBuku + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
package basics;

import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class PostResponse {
	
    public @JsonProperty("page") int page;
    public @JsonProperty("per_page") int per_page;
    public @JsonProperty("total") int total;
    public @JsonProperty("total_pages") int total_pages;
    public  @JsonProperty("data") ArrayList<User> data;
    public @JsonProperty("support") Support support;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostResponse)) return false;
        PostResponse that = (PostResponse) o;
        ArrayList<User> actuals = that.getData();
        ArrayList<User> excepted = this.getData();
        for (int i = 0; i < that.getData().size();i++) {
			if(!actuals.get(i).equals(excepted.get(i))){
				
				return false;
				
			}
        	
		}
        return getPage() == that.getPage() && getPer_page() == that.getPer_page() && getTotal_pages() == that.getTotal_pages() && Objects.equals(getSupport(), that.getSupport());
    }

    public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
    public int hashCode() {
        return Objects.hash(getPage(), getPer_page(), getTotal_pages(), getData(), getSupport());
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<User> getData() {
        return data;
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
    @Override
    public String toString() {
        return "PostResponse{" +
                "page=" + page +
                ", per_page=" + per_page +
                ", total_pages=" + total_pages +
                ", data=" + data +
                ", support=" + support +
                '}';
    }
}

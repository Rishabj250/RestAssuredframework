package basics;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties
public class Support {
	
	
	
    public @JsonProperty("url") String url;
    public @JsonProperty("text") String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Support)) return false;
        Support support = (Support) o;
        return Objects.equals(getUrl(), support.getUrl()) && Objects.equals(getText(), support.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getText());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

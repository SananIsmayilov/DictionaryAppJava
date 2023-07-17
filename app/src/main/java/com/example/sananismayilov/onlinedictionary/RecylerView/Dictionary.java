
package com.example.sananismayilov.onlinedictionary.RecylerView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Dictionary {

    @SerializedName("text_az")
    @Expose
    private String textAz;
    @SerializedName("text_en")
    @Expose
    private String textEn;

    public String getTextAz() {
        return textAz;
    }

    public void setTextAz(String textAz) {
        this.textAz = textAz;
    }

    public String getTextEn() {
        return textEn;
    }

    public void setTextEn(String textEn) {
        this.textEn = textEn;
    }

}

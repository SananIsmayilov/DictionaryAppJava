
package com.example.sananismayilov.onlinedictionary.RecylerView;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ConteynerToWord {

    @SerializedName("dictionary")
    @Expose
    private List<Dictionary> dictionary;
    @SerializedName("success")
    @Expose
    private Integer success;

    public List<Dictionary> getDictionary() {
        return dictionary;
    }

    public void setDictionary(List<Dictionary> dictionary) {
        this.dictionary = dictionary;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

}

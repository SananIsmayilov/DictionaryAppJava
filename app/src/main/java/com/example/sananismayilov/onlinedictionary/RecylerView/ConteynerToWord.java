package com.example.sananismayilov.onlinedictionary.RecylerView;

import java.io.Serializable;

public class ConteynerToWord  implements Serializable {
    private String az_word;
    private String en_word;

    public ConteynerToWord(String az_word, String en_word) {
        this.az_word = az_word;
        this.en_word = en_word;
    }

    public String getAz_word() {
        return az_word;
    }

    public void setAz_word(String az_word) {
        this.az_word = az_word;
    }

    public String getEn_word() {
        return en_word;
    }

    public void setEn_word(String en_word) {
        this.en_word = en_word;
    }
}

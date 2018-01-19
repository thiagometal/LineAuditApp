package com.lge.lineauditapp;

/**
 * Created by jose.filho on 18/01/2018.
 */

public class ItemChecklist {
    // Fields
    private int itemChecklistID;
    private String secao;
    private String item;
    private String detalhe;
    private String especificacao;
    private String linha;

    // constructors
    public ItemChecklist() {}

    public ItemChecklist(int itemChecklistID, String secao, String item, String detalhe, String especificacao) {
        this.itemChecklistID = itemChecklistID;
        this.secao = secao;
        this.item = item;
        this.detalhe = detalhe;
        this.especificacao = especificacao;
    }

    //properties
    public void setID(int id) {
        this.itemChecklistID = id;
    }
    public int getID() {
        return this.itemChecklistID;
    }

    public void setSecao(String secao){
        this.secao = secao;
    }
    public String getSecao() {
        return this.secao;
    }

    public void setItem(String item){
        this.item = item;
    }
    public String getItem() {
        return this.item;
    }

    public void setDetalhe(String detalhe){
        this.detalhe = detalhe;
    }
    public String getDetalhe() {
        return this.detalhe;
    }

    public void setEspecificacao(String especificacao){
        this.especificacao = especificacao;
    }
    public String getEspecificacao() {
        return this.especificacao;
    }

    public void setLinha(String linha){
        this.linha = linha;
    }
    public String getLinha() {
        return this.linha;
    }
}

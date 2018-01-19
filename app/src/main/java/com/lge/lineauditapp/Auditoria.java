package com.lge.lineauditapp;

/**
 * Created by jose.filho on 18/01/2018.
 */

public class Auditoria {
    // Fields
    private int auditoriaID;
    private int totalPontuacao;
    private String linha;
    private String data;
    private String status;

    // constructors
    public Auditoria() {}

    public Auditoria(int auditoriaID, int totalPontuacao, String linha, String data, String status) {
        this.auditoriaID = auditoriaID;
        this.totalPontuacao = totalPontuacao;
        this.linha = linha;
        this.data = data;
        this.status = status;
    }

    //properties
    public void setID(int id) {
        this.auditoriaID = id;
    }
    public int getID() {
        return this.auditoriaID;
    }

    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }

    public void setTotalPontuacao(int totalPontuacao){
        this.totalPontuacao = totalPontuacao;
    }
    public int getTotalPontuacao() {
        return this.totalPontuacao;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }
    public String getLinha() {
        return this.linha;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return this.data;
    }
}

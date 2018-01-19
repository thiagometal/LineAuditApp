package com.lge.lineauditapp;

/**
 * Created by jose.filho on 18/01/2018.
 */

public class ContraMedida {
    // Fields
    private int contraMedidaID;
    private String foto;
    private String descricao;
    private int checklistID;

    // constructors
    public ContraMedida() {}

    public ContraMedida(int contraMedidaID, String foto, String descricao, int checklistID) {
        this.contraMedidaID = contraMedidaID;
        this.foto = foto;
        this.descricao = descricao;
        this.checklistID = checklistID;
    }

    //properties
    public void setID(int id) {
        this.contraMedidaID = id;
    }
    public int getID() {
        return this.contraMedidaID;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getFoto(){
        return this.foto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return this.descricao;
    }

    public void setChecklistID(int checklistID) {
        this.checklistID = checklistID;
    }
    public int getChecklistID() {
        return this.checklistID;
    }
}

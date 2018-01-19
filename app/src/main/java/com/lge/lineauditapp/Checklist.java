package com.lge.lineauditapp;

/**
 * Created by jose.filho on 18/01/2018.
 */

public class Checklist {
    // Fields
    private int checklistID;
    private int auditoriaID;
    private int itemChecklistID;
    private String status;
    private String foto;

    // constructors
    public Checklist() {}

    public Checklist(int checklistID, int auditoriaID, int itemChecklistID, String status, String foto) {
        this.checklistID = checklistID;
        this.itemChecklistID = itemChecklistID;
        this.auditoriaID = auditoriaID;
        this.status = status;
        this.foto = foto;
    }

    //properties
    public void setID(int id) {
        this.checklistID = id;
    }
    public int getID() {
        return this.checklistID;
    }

    public void setItemChecklistID(int id) {
        this.itemChecklistID = id;
    }
    public int getItemChecklistID() {
        return this.itemChecklistID;
    }

    public void setAuditoriaID(int auditoriaID) {
        this.auditoriaID = auditoriaID;
    }
    public int getAuditoriaID() {
        return this.auditoriaID;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getFoto() {
        return this.foto;
    }
}

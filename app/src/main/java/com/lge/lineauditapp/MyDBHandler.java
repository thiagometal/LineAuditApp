package com.lge.lineauditapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.KeyCharacterMap;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "lineAudit";

    // Contacts tables names
    private static final String TABLE_AUDITORIA = "auditoria";
    private static final String TABLE_ITEM_CHECKLIST = "item_checklist";
    private static final String TABLE_CHECKLIST = "checklist";
    private static final String TABLE_CONTRA_MEDIDA = "contra_medida";

    // Common Table Columns names
    private static final String KEY_ID = "id";

    // AUDITORIA Table - Columns names
    private static final String KEY_STATUS = "status";
    private static final String KEY_TOTAL_PONTUACAO = "total_pontuacao";
    private static final String KEY_LINHA = "linha";
    private static final String KEY_DATA = "data";

    private static final String KEY_SECAO = "secao";
    private static final String KEY_ITEM = "item";
    private static final String KEY_DETALHE = "detalhe";
    private static final String KEY_ESPECIFICACAO = "especificacao";
    // private static final String KEY_LINHA = "linha";

    private static final String KEY_ID_AUDITORIA = "id_auditoria";
    private static final String KEY_ID_ITEM_CHECKLIST = "id_item_checklist";
    // private static final String KEY_STATUS = "status";
    private static final String KEY_FOTO = "foto";

    // private static final String KEY_FOTO = "foto";
    private static final String KEY_DESCRICAO = "descricao";
    private static final String KEY_ID_CHECKLIST = "id_checklist";

    private static final String CREATE_TABLE_AUDITORIA = "CREATE TABLE " + TABLE_AUDITORIA
            + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_STATUS + " CHARACTER,"
            + KEY_TOTAL_PONTUACAO + " INTEGER,"
            + KEY_DATA + " DATETIME,"
            + ")";

    private static final String CREATE_TABLE_ITEM_CHECKLIST = "CREATE TABLE " + TABLE_ITEM_CHECKLIST
            + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_SECAO + " TEXT,"
            + KEY_ITEM + " TEXT,"
            + KEY_DETALHE + " TEXT,"
            + KEY_ESPECIFICACAO + " TEXT,"
            + KEY_LINHA + " TEXT"
            + ")";

    private static final String CREATE_TABLE_CHECKLIST = "CREATE TABLE " + TABLE_CHECKLIST
            + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_ID_AUDITORIA + " INTEGER,"
            + KEY_ID_ITEM_CHECKLIST + " INTEGER,"
            + KEY_STATUS + " CHARACTER,"
            + KEY_FOTO + " TEXT"
            + ")";

    private static final String CREATE_TABLE_CONTRA_MEDIDA = "CREATE TABLE " + TABLE_CONTRA_MEDIDA
            + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_ID_AUDITORIA + " INTEGER,"
            + KEY_ID_CHECKLIST + " INTEGER,"
            + KEY_DESCRICAO + " CHARACTER,"
            + KEY_FOTO + " TEXT"
            + ")";

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_AUDITORIA);
        db.execSQL(CREATE_TABLE_ITEM_CHECKLIST);
        db.execSQL(CREATE_TABLE_CHECKLIST);
        db.execSQL(CREATE_TABLE_CONTRA_MEDIDA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AUDITORIA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM_CHECKLIST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHECKLIST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTRA_MEDIDA);

        onCreate(db);
    }

    public long createAuditoria(Auditoria auditoria){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STATUS, auditoria.getStatus());
        values.put(KEY_TOTAL_PONTUACAO, auditoria.getTotalPontuacao());
        values.put(KEY_LINHA, auditoria.getLinha());
        values.put(KEY_DATA, auditoria.getData());

        long auditoria_id = db.insert(TABLE_AUDITORIA, null, values);

        return auditoria_id;
    }

    public long createItemChecklist(ItemChecklist itemChecklist) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SECAO, itemChecklist.getSecao());
        values.put(KEY_ITEM, itemChecklist.getItem());
        values.put(KEY_DETALHE, itemChecklist.getDetalhe());
        values.put(KEY_ESPECIFICACAO, itemChecklist.getEspecificacao());
        values.put(KEY_LINHA, itemChecklist.getLinha());

        long itemChecklist_id = db.insert(TABLE_ITEM_CHECKLIST, null, values);

        return itemChecklist_id;
    }

    public long createContraMedida(ContraMedida contraMedida) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FOTO, contraMedida.getFoto());
        values.put(KEY_DESCRICAO, contraMedida.getDescricao());
        values.put(KEY_ID_CHECKLIST, contraMedida.getChecklistID());

        long contraMedida_id = db.insert(TABLE_CONTRA_MEDIDA, null, values);

        return contraMedida_id;
    }

    public long createChecklist(Checklist checklist) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_AUDITORIA, checklist.getAuditoriaID());
        values.put(KEY_ID_ITEM_CHECKLIST, checklist.getItemChecklistID());
        values.put(KEY_STATUS, checklist.getStatus());
        values.put(KEY_FOTO, checklist.getFoto());

        long checklist_id = db.insert(TABLE_CHECKLIST, null, values);

        return checklist_id;
    }

    public List<Auditoria> getAuditoriaByLinha(String linha) {
        List<Auditoria> auditorias = new ArrayList<Auditoria>();
        String selectQuery = "SELECT * FROM " + TABLE_AUDITORIA
                + " WHERE LINHA = '" + linha + "';";

        Log.e("LOG", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Auditoria auditoria = new Auditoria();
                auditoria.setID(c.getInt(c.getColumnIndex(KEY_ID)));
                auditoria.setStatus(c.getString(c.getColumnIndex(KEY_STATUS)));
                auditoria.setTotalPontuacao((c.getInt(c.getColumnIndex(KEY_TOTAL_PONTUACAO))));
                auditoria.setLinha(c.getString(c.getColumnIndex(KEY_LINHA)));
                auditoria.setData(c.getString(c.getColumnIndex(KEY_DATA)));

                auditorias.add(auditoria);
            } while (c.moveToNext());
        }
        return auditorias;
    }

    public List<ItemChecklist> getItemChecklistByLinha(String linha) {
        List<ItemChecklist> itensChecklist = new ArrayList<ItemChecklist>();
        String selectQuery = "SELECT * FROM " + TABLE_ITEM_CHECKLIST
                + " WHERE LINHA = '" + linha + "';";

        Log.e("LOG", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                ItemChecklist itemChecklist = new ItemChecklist();
                itemChecklist.setID(c.getInt(c.getColumnIndex(KEY_ID)));
                itemChecklist.setSecao(c.getString(c.getColumnIndex(KEY_SECAO)));
                itemChecklist.setItem((c.getString(c.getColumnIndex(KEY_ITEM))));
                itemChecklist.setDetalhe(c.getString(c.getColumnIndex(KEY_DETALHE)));
                itemChecklist.setEspecificacao(c.getString(c.getColumnIndex(KEY_ESPECIFICACAO)));
                itemChecklist.setLinha(c.getString(c.getColumnIndex(KEY_LINHA)));

                itensChecklist.add(itemChecklist);
            } while (c.moveToNext());
        }
        return itensChecklist;
    }

    public List<Checklist> getChecklist(int auditoriaID, int itemChecklistID) {
        List<Checklist> checklist = new ArrayList<Checklist>();
        String selectQuery = "SELECT * FROM " + TABLE_CHECKLIST
                + " WHERE id_auditoria = '" + auditoriaID + "'"
                + " AND id_item_checklist = '" + itemChecklistID + "';";

        Log.e("LOG", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Checklist check = new Checklist();
                check.setID(c.getInt(c.getColumnIndex(KEY_ID)));
                check.setItemChecklistID(c.getInt(c.getColumnIndex(KEY_ID_ITEM_CHECKLIST)));
                check.setAuditoriaID((c.getInt(c.getColumnIndex(KEY_ID_AUDITORIA))));
                check.setStatus(c.getString(c.getColumnIndex(KEY_STATUS)));
                check.setFoto(c.getString(c.getColumnIndex(KEY_FOTO)));

                checklist.add(check);
            } while (c.moveToNext());
        }
        return checklist;
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen()) {
            db.close();
        }
    }
}
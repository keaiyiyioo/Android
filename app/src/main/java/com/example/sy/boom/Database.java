package com.example.sy.boom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yiyi on 2017/5/11.
 */

public class Database extends SQLiteOpenHelper {
    private ArrayList<Player> players;
    private ArrayList<IModelListener> listeners;

    private final String tabScore = "score";
    private final String colName="playerName";
    private final String colScore="playerScore";

    public Database(Context context, String name,int score) {
        super(context, "scorelist.db", null, 1);
        this.players=new ArrayList<Player>();
        this.listeners = new ArrayList<IModelListener>();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create SnakeData
        db.execSQL("CREATE TABLE " + tabScore +
                "(_id INTEGER PRIMARY KEY," +
                colName + " String,"+
                colScore + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void save(int score,String name){
        ContentValues s = new ContentValues();
        s.put(colName, name);
        s.put(colScore, score);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(tabScore, null, s);
        db.close();
        // Notify all listeners that a change has occurred with the bank’s data.
        notifyAllModelListeners();
    }

    public ArrayList<Player> read() {
        int i=0;
        ArrayList<Player> players = new ArrayList<Player>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql ="SELECT " + colName +" , "+ colScore +" FROM "+ tabScore;
        Cursor s = db.rawQuery(sql, null);
        while (s.moveToNext()) {
            Player p = new Player();
            p.setName(s.getString(0));
            p.setSocre(s.getInt(1));
            players.add(p);
            i++;
        }
        s.close();
        db.close();
        return players;
    }
    public void addListener(IModelListener listener) {
        listeners.add(listener);
    }

    private void notifyAllModelListeners(){
        for(IModelListener listener : listeners){
            listener.notifyModelListener();
        }
    }
}

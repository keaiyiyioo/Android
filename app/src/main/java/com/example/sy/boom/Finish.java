package com.example.sy.boom;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Finish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Bundle bundle = new Bundle();
        bundle = this.getIntent().getExtras();
        final int score=bundle.getInt("socre");

        Button re = (Button) findViewById(R.id.returnmain);
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);;
            }
        });

        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database(score);
            }
        });
    }
    public void database(int score){
        //store
        TextView n = (TextView)findViewById(R.id.name);
        String name=n.getText().toString();
        System.out.println(name);
        Database db= new Database(this,name,score);
        db.save(score,name);

        //show
        LinearLayout ll=(LinearLayout) findViewById(R.id.list);
        ArrayList<Player> players = new ArrayList<Player>();
        players=db.read();
        for(Player p:players)
        {
            TextView tv=new TextView(this);
            tv.setText(p.getName()+" "+p.getSocre());
            tv.setTextSize(18);
            ll.addView(tv);
        }
    }
}

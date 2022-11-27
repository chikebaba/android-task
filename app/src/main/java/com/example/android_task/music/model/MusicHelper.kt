package com.example.android_task.music.model


import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase

class MusicHelper(context: Context?) : SQLiteOpenHelper (context, "MDB" , null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("DROP TABLE IF EXISTS MUSICTABLE");
        db?.execSQL("CREATE TABLE MUSICTABLE(_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, ARTIST TEXT, GENRE TEXT, PATH TEXT)")
        db?.execSQL("INSERT INTO MUSICTABLE(NAME,ARTIST,GENRE,PATH) VALUES('durak_so_stajem','vodokachka','rock','durak_so_stajem')")
        db?.execSQL("INSERT INTO MUSICTABLE(NAME,ARTIST,GENRE,PATH) VALUES('sacudir','flooaw','pop','flooaw_sacudir')")
        db?.execSQL("INSERT INTO MUSICTABLE(NAME,ARTIST,GENRE,PATH) VALUES('contingency','zimmer','epic','hans_zimmer_call_of_duty_modern_warfare_2_contingency')")
        db?.execSQL("INSERT INTO MUSICTABLE(NAME,ARTIST,GENRE,PATH) VALUES('code_of_conduct','zimmer','epic','hans_zimmer_code_of_conduct')")
        db?.execSQL("INSERT INTO MUSICTABLE(NAME,ARTIST,GENRE,PATH) VALUES('end_credits','zimmer','epic','mw3_end_credits')")
        db?.execSQL("INSERT INTO MUSICTABLE(NAME,ARTIST,GENRE,PATH) VALUES('oogway_ascends','zimmer','epic','oogway_ascends')")
        db?.execSQL("INSERT INTO MUSICTABLE(NAME,ARTIST,GENRE,PATH) VALUES('dreamin','score','rock','score_dreamin')")
        db?.execSQL("INSERT INTO MUSICTABLE(NAME,ARTIST,GENRE,PATH) VALUES('ceur','thomas','epic','thomas_barrandon_le_feu_dans_leur_coeur')")
        db?.execSQL("INSERT INTO MUSICTABLE(NAME,ARTIST,GENRE,PATH) VALUES('main_menu','forza_horizon','epic','title_song_forza_horizon_5_soundtrack')")
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}

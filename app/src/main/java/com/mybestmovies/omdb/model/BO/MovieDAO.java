package com.mybestmovies.omdb.model.BO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mybestmovies.omdb.model.BO.interfaces.DAOInterface;

/**
 * Created by Wisley on 12/03/2016.
 */
public class MovieDAO extends SQLiteOpenHelper implements DAOInterface {

    private SQLiteDatabase mDataBase;


    public MovieDAO(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }

    /**
     * This method create table from movies data base
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS movies ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "title VARCHAR(256), "
                + "year NUMBER, "
                + "released VARCHAR(16), "
                + "duration NUMBER, "
                + "genre VARCHAR(128), "
                + "director VARCHAR(128), "
                + "writer VARCHAR(256), "
                + "actors TEXT, "
                + "plot TEXT, "
                + "country VARCHAR(128), "
                + "awards VARCHAR(128), "
                + "poster VARCHAR(512), "
                + "rate VARCHAR(16), unique(title) "
                + ")");

    }

    /**
     * it`s not necessary implemetation
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    /**
     * This method insert nem item in movie table
     *
     * @param title
     * @param year
     * @param released
     * @param duration
     * @param genre
     * @param director
     * @param writer
     * @param actors
     * @param plot
     * @param country
     * @param awards
     * @param poster
     * @param rate
     */
    @Override
    public void insertMovie(final String title, final int year, final String released, final String duration,
                            final String genre, final String director, final String writer, final String actors,
                            final String plot, final String country, final String awards,
                            final String poster, final String rate) {


        this.mDataBase = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("title", title);
        content.put("year", year);
        content.put("released", released);
        content.put("duration", duration);
        content.put("genre", genre);
        content.put("director", director);
        content.put("writer", writer);
        content.put("actors", actors);
        content.put("plot", plot);
        content.put("country", country);
        content.put("awards", awards);
        content.put("poster", poster);
        content.put("rate", rate);
        this.mDataBase.insert("movies", null, content);
        this.mDataBase.close();


    }

    /**
     * remove movie by id
     *
     * @param id
     */
    @Override
    public void removeMovie(int id) {
        this.mDataBase = this.getWritableDatabase();
        this.mDataBase.execSQL("DELETE FROM movies WHERE id = " + id);
    }

    /**
     * return one cursor contain all movies
     *
     * @return Cursor
     */
    @Override
    public Cursor findAllMovies() {
        this.mDataBase = getReadableDatabase();
        //zapytanie

        String sql = "SELECT * FROM movies";
        Cursor cursor = this.mDataBase.rawQuery(sql, null);

        return cursor;
    }

    /**
     * Return one register of movie by identify
     *
     * @param idMovie
     * @return movie
     */
    @Override
    public Cursor findMovieById(final int movie) {
        this.mDataBase = getReadableDatabase();
        String sql = "SELECT * FROM movies WHERE id = " + movie;
        Cursor cursor = this.mDataBase.rawQuery(sql, null);

        return cursor;
    }


    public void insertMovieTrial(){
        insertMovie(
                "Star Wars",
                1983,
                "1983-01-05",
                "104 min",
                "Action, Adventure, Sci-Fi",
                "N/A",
                "Lucas",
                "Harrison Ford",
                "N/A",
                "N/A",
                "N/A",
                "http://ia.media-imdb.com/images/M/MV5BMjQwODIzMDI0M15BMl5BanBnXkFtZTgwOTA0OTcwMzE@._V1_SX300.jpg",
                "10.0"
        );
    }
}

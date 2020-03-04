/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermproject;

import java.util.ArrayList;

/**
 *
 * @author valmi
 */
public class DVDMedia extends Media {
    ArrayList<String> coStars; 
    String year;
    String movie;

    public DVDMedia(String year, String artistName, String mediaName, ArrayList coStars, String movie) {
        super(artistName, mediaName);
        this.year = year;
        this.coStars = coStars;
        this.movie = movie;
    }

    public ArrayList<String> getCoStrars() {
        return coStars;
    }

    public void setCoStrars(ArrayList<String> coStrars) {
        this.coStars = coStrars;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<String> getCoStars() {
        return coStars;
    }

    public void setCoStars(ArrayList<String> coStars) {
        this.coStars = coStars;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
    

    @Override
    public String toString() {
        return super.toString()+ " Movie Name: " + movie + " Year : " + year + " CoStars " + getCoStars();
    }
    
  

    
    
}

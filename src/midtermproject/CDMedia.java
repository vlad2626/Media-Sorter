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
public class CDMedia  extends Media{
    String album;
    ArrayList <String> song;

    public CDMedia(String album, String artistName, String mediaName,ArrayList song) {
        super(artistName, mediaName);
        this.song= song;
        this.album = album;
    }

    public ArrayList getSong() {
        return song;
    }

    public void setSong(ArrayList<String> song) {
        this.song = song;
    }

    

    
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
    

    @Override
    public String toString() {
        return super.toString() +" ,Album: " + album +  " Songs: " + getSong() ;
    }
    
   
    
    
    
}

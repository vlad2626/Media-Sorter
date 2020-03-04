/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermproject;

/**
 *
 * @author valmi
 */
public class Media {
    String artistName, mediaName;

    public Media(String artistName, String mediaName) {
        this.artistName = artistName;
        this.mediaName = mediaName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    
    public String toString() {
        return   mediaName + " Artist Name: " + artistName ;
        
    }
    
    
    
    
    
    
    
}

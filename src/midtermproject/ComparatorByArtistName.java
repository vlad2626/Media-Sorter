/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermproject;

import java.util.Comparator;

/**
 *
 * @author valmi
 */
public class ComparatorByArtistName implements Comparator <Media> {
    
    /**
     *
     * @param a
     * @param b
     * @return 
     */
    @Override
    public int compare(Media a, Media b)
    {
        return a.getArtistName().compareToIgnoreCase(b.getArtistName());
    }
    
}

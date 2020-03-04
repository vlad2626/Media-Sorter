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
public class ComparatorByMediaName  implements Comparator <Media> {
    
    @Override
    public int compare(Media a, Media b)
    {
        return  a.getMediaName().compareToIgnoreCase(b.mediaName);
    }
          
    
        
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Tazam
 */
public class PictureManager {
    protected Map <Picture,List<String>> collection;
    public List<Picture> currentPictures;
    
    public PictureManager()
    {
        
    }
    
    public void addPicture (Picture picture)
    {
        if (!collection.containsKey(picture))
            collection.put(picture, new ArrayList<>());
    }
    
    public void addKeyword (Picture picture,String key)
    {
        if (!collection.get(picture).contains(key))
        {
            collection.get(picture).add(key);
        }
    }
    
    public void save()
    {
        
    }
    
    
    
    
}

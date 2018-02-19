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
    private Map <String,List<Picture>> collection;
    
    public PictureManager()
    {
        
    }
    
    public void addElement(String keyword,Picture picture)
    {
        if (!collection.containsKey(keyword))
        {
            collection.put(keyword, new ArrayList<>());  
        }
        collection.get(keyword).add(picture);
    }
    
    
}

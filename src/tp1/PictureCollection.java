/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tazam
 */
public class PictureCollection {
    // kayword: picture data: keyword[]
    private final Map<String,ArrayList<String>> library;
    
    public PictureCollection()
    {
        library = new HashMap();
    }
    
    public void addElement(String picture, String keyWord)
    {
        if (!library.containsKey(picture))
        {
            ArrayList<String> al = new ArrayList();
            al.add(keyWord);
            library.put(picture, al);
        }else
        {
            library.get(picture).add(keyWord);
        }
    }
    
    public void deleteKeyWord(String picture, String keyWord)
    {
        library.get(picture).remove(keyWord);
        if (library.get(picture).isEmpty())
            library.remove(picture);
    }
    
    public ArrayList<String> keyWordsByPicture(String picture)
    {
        if (library.isEmpty())
            return null;
        return library.get(picture);
    }
    
    @Override
    public String toString()
    {
        String ret = "";
         for (String picture : library.keySet())
         {
             ret+=picture+": "+library.get(picture).toString()+"\\n";
         }
        
        return ret;
    }
    
    public ArrayList<String> picturesByKeyWords (String[] keyWords,String currentPath)
    {
        ArrayList ret = new ArrayList();
        
        for (String picture : library.keySet())
        {
            String [] s;
            s = picture.split("\\\\");
            String path="";
            for (int i=0; i<s.length-1;i++)
                path+=s[i];
            
            // si l'image n'appartient pas au rep courrant on passe cette image.
            if (!path.equals(currentPath))
                break;
            
            for (String keyWord : keyWords)
            {
                if (library.get(picture).contains(keyWord))
                {
                    ret.add(picture);
                    break;
                }
            }
        }
        return ret;
    }
}

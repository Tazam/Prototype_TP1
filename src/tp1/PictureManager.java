/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;
import java.io.BufferedWriter;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tazam
 */
public class PictureManager {
    // map contient des images avec les mots clés assosiés
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("colSaveKW.txt", true))) {
            
            // pour chaque element de map
            collection.forEach((img ,setKeyWords)->{
                try {
                    bw.write(img.getName());
                    bw.newLine();
                    bw.write(img.getPath());
                    bw.newLine();
                    
                    // pour chaque mot clé
                    for(String keyWord : setKeyWords){
                        bw.write(keyWord);
                        bw.newLine();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PictureManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
       
}

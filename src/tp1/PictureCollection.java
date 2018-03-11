/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
             ret+=picture+": "+library.get(picture).toString()+"\n";
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
            for (int i=0; i<s.length-2;i++)
                path+=s[i]+"\\";
            path+=s[s.length-2];
            System.out.println("path ---> "+path);
            System.out.println(currentPath);
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
    
    public boolean isEmpty()
    {
        if (library == null)
        {return true;}
        return library.isEmpty();
    }
    
    public void save() throws IOException
    {
        if (!this.isEmpty())
        {
            BufferedWriter buffer;
            FileWriter fw = new FileWriter("picturesData.txt", true);
            buffer = new BufferedWriter(fw);
            for (String picture : library.keySet())
            {
                buffer.write(picture+" ");
                for (String keyWord : library.get(picture))
                {
                    buffer.write(keyWord+" ");
                }
                buffer.newLine();
            }
            buffer.flush();
        }
    }
    
    public void load() throws FileNotFoundException, IOException
    {
        File f = new File("picturesData.txt");
        if (f.exists())
        {
            BufferedReader buffer = new BufferedReader(new FileReader("picturesData.txt"));
            String line;
            while ((line = buffer.readLine()) != null)
            {
                String[] lineSplit = line.split(" ");
                for (int i=1;i<lineSplit.length;i++)
                {
                    this.addElement(lineSplit[0], lineSplit[i]);
                }
            }
        }
        
    }
}

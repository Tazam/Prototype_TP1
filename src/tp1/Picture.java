/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.Objects;

/**
 *
 * @author Tazam
 */
public class Picture {
    private String path;
    private String name;
    
    public Picture(String name, String path)
    {
        this.name = name;
        this.path = path;
    }
    
    public String getPath()
    {
        return this.path;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o instanceof Picture)) {
            return false;
        }
        Picture p = (Picture) o;
        
        return ((this.name.equals(p.getName()))&&(this.path.equals(p.getPath())));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.path);
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    
    
    
}

package org.zgdf;

import org.zgdf.Users;

public class UsersDao {
    
    public Users getUser(String u, String p){
        
        Users user = new Users();
        user.setUserName("semmi");
        user.setPassword("ezis");
        return user;
        
    }
    
}

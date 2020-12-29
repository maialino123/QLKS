/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.QLKS.model.usersModel;

/**
 *
 * @author Admin
 */
public class security {
    public static final String bcryptHashString(){
        usersModel model = usersModel.getInstance();
        model.setPassword(BCrypt.withDefaults().hashToString(15, model.getPassword().toCharArray()));
        return model.getPassword();
    }
    
    public static final BCrypt.Result result(){
        usersModel model = usersModel.getInstance();
        BCrypt.Result result = BCrypt.verifyer().verify(model.getPassword().toCharArray(), bcryptHashString());
        return result;
    }
}

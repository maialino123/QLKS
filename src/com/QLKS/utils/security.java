/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.QLKS.model.nhan_vienModel;


/**
 *
 * @author Admin
 */
public class security {
    public static final String bcryptHashString(String T){
        return (BCrypt.withDefaults().hashToString(15, T.toCharArray()));
    }
    
//    public static final BCrypt.Result result(){
//        nhan_vienModel model = nhan_vienModel.getInstance();
//        BCrypt.Result result = BCrypt.verifyer().verify(model.getPassword().toCharArray(), bcryptHashString(model.getPassword()));
//        return result;
//    }
}

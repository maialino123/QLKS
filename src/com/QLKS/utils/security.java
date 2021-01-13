/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.utils;

import com.QLKS.DAO.helper.BCrypt;

/**
 *
 * @author Admin
 */
public class security {

    private static int workload = 12;

    public static String hashPassword(String passWord) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(passWord, salt);
        return (hashed_password);
    }

    public static boolean checkPassword(String passWord_plaintext, String stored_hash) {
        boolean password_verified = false;
        if (stored_hash == null || !stored_hash.startsWith("$2a$")) {
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        }

        password_verified = BCrypt.checkpw(passWord_plaintext, stored_hash);
        return (password_verified);
    }

//    public static final String bcryptHashString(String T){
//        return (BCrypt.withDefaults().hashToString(15, T.toCharArray()));
//    }
//    
//    public static final BCrypt.Result result(){
//        nhan_vienModel model = nhan_vienModel.getInstance();
//        BCrypt.Result result = BCrypt.verifyer().verify(model.getPassword().toCharArray(), bcryptHashString(model.getPassword()));
//        return result;
//    }
}

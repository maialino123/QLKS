/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.utils;

/**
 *
 * @author Admin
 */
public class randomCode {

    public static int randomCodeCheck(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}

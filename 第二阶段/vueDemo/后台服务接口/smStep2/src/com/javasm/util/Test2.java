package com.javasm.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test2 {

    public static void main(String[] args) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            md5.update("abc123".getBytes());
            String str = new BigInteger(1,md5.digest()).toString(16);
            System.out.println(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}

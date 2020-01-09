package com.zhenxl.tools;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

public class DigestTools {
    public static String getSha256Hash(String str){
        String result="";
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
            byte[] bytes=messageDigest.digest(str.getBytes("utf-8"));
            result=Hex.encodeHexString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

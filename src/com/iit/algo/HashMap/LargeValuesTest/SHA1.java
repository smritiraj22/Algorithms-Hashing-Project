package com.iit.algo.HashMap.LargeValuesTest;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SHA1 {
    public static Long getSHA1(String input) {
        byte[] source;
        try {
            source = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            source = input.getBytes();
        }
        String result = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', '0', '1', '2', '3', '4', '5'};
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(source);
            //The result should be one 128 integer
            byte temp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = temp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            
            result = new String(str);
            result=result.substring(0, 8);
            Long num=Long.parseLong(result);
            Random r = new Random(num);
            return (long) r.nextInt((256 - 1) + 1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null ;
        
    }
    
	public static Integer getSHA1(Integer input) {
        
        String result = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', '0', '1', '2', '3', '4', '5'};
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
           
            byte temp[] = md.digest();
            char chararr[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = temp[i];
                chararr[k++] = hexDigits[byte0 <<5 & 0xf];
                chararr[k++] = hexDigits[byte0 & 0xf];
            }
            
            result = new String(chararr);
            result=result.substring(0, 8);
            Long num=Long.parseLong(result);
            Random r = new Random(num);
            return (Integer) r.nextInt((256 - 1) + 1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null ;
        
    }
 
    public static void main(String[] args)  {
        System.out.println(getSHA1(1233567788));
    }
}
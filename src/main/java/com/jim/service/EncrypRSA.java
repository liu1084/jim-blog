package com.jim.service;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncrypRSA {
    private static KeyPair keyPair;
    protected static byte[] encrypt(RSAPublicKey publicKey,byte[] srcBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        if(publicKey!=null){
            //Cipher负责完成加密或解密工作，基于RSA
            Cipher cipher = Cipher.getInstance("RSA");
            //根据公钥，对Cipher对象进行初始化
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(srcBytes);
        }
        return null;
    }
    protected static byte[] decrypt(RSAPrivateKey privateKey,byte[] srcBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        if(privateKey!=null){
            //Cipher负责完成加密或解密工作，基于RSA
            Cipher cipher = Cipher.getInstance("RSA");
            //根据公钥，对Cipher对象进行初始化
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(srcBytes);
        }
        return null;
    }

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        //初始化密钥对生成器，密钥大小为1024位
        keyPairGen.initialize(2024);
        //生成一个密钥对，保存在keyPair中
        keyPair = keyPairGen.generateKeyPair();
        return keyPair;
    }

    public static RSAPrivateKey getRsaPrivateKey(){
        return (RSAPrivateKey)keyPair.getPrivate();
    }

    public static RSAPublicKey getRsaPublicKey(){
        return (RSAPublicKey)keyPair.getPublic();
    }

//    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
//        String msg = "liujun";
//        generateKeyPair();
//        //得到私钥
//        RSAPrivateKey privateKey = getRsaPrivateKey();
//        //得到公钥
//        RSAPublicKey publicKey = getRsaPublicKey();
//
//        //用公钥加密
//        byte[] srcBytes = msg.getBytes();
//        byte[] resultBytes = encrypt(publicKey, srcBytes);
//
//        //用私钥解密
//        byte[] decBytes = decrypt(privateKey, resultBytes);
//
//        System.out.println("明文是:" + msg);
//        System.out.println("加密后是:" + new String(resultBytes));
//        System.out.println("解密后是:" + new String(decBytes));
//    }

}
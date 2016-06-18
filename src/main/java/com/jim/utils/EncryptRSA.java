package com.jim.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 *  String msg = "liujun";
    generateKeyPair();
    RSAPrivateKey privateKey = getRsaPrivateKey();
    RSAPublicKey publicKey = getRsaPublicKey();
    byte[] srcBytes = msg.getBytes();
    byte[] resultBytes = encrypt(publicKey, srcBytes);

    byte[] decBytes = decrypt(privateKey, resultBytes);

    System.out.println("plain text:" + msg);
    System.out.println("encrypt text:" + new String(resultBytes));
    System.out.println("decrypt text:" + new String(decBytes));
 *
 */
public class EncryptRSA  {
    private static KeyPair keyPair;
    protected static byte[] encrypt(RSAPublicKey publicKey,byte[] srcBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        if(publicKey!=null){
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(srcBytes);
        }
        return null;
    }
    protected static byte[] decrypt(RSAPrivateKey privateKey,byte[] srcBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        if(privateKey!=null){
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(srcBytes);
        }
        return null;
    }

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        keyPair = keyPairGen.generateKeyPair();
        return keyPair;
    }

    public static RSAPrivateKey getRsaPrivateKey(){
        return (RSAPrivateKey)keyPair.getPrivate();
    }

    public static RSAPublicKey getRsaPublicKey(){
        return (RSAPublicKey)keyPair.getPublic();
    }

}
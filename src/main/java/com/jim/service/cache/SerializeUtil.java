package com.jim.service.cache;

import java.io.*;
import java.util.Objects;

/**
 * Created by liqing on 2016/6/6.
 */
public class SerializeUtil {
    public static byte[] serialize(Object object){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);

            byte [] bytes = byteArrayOutputStream.toByteArray();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static Object unSerialize(byte [] bytes){
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

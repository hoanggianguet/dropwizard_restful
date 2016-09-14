package com.gianghoang.db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

/**
 * Created by Longlaptop on 8/17/2016.
 */
public class RSAKeyPair {
    private int keyLength;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    //Khởi tạo cặp key Pri-Pub

    public RSAKeyPair(int keyLength) throws GeneralSecurityException {
        //độ dài có thể dùng: 512 1024 2048 3076 4096
        this.keyLength = keyLength;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(this.keyLength);
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();

    }
    public final void toFileSystem(String privateKeyPathName, String publicKeyPathName) throws IOException {
        //Create two file using write key
        FileOutputStream privateKeyOutputStream = null;
        FileOutputStream publicKeyOutputStream = null;

        File privateKeyFile = new File(privateKeyPathName);
        File publicKeyFile = new File(publicKeyPathName);

        //Write key to file form Encoded
        try {
            //private key
            privateKeyOutputStream = new FileOutputStream(privateKeyFile);
            privateKeyOutputStream.write(privateKey.getEncoded());

            //public key
            publicKeyOutputStream = new FileOutputStream(publicKeyFile);
            publicKeyOutputStream.write(publicKey.getEncoded());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (privateKeyOutputStream != null) {
                privateKeyOutputStream.close();
            }

            if (publicKeyOutputStream != null) {
                publicKeyOutputStream.close();
            }
        }

    }
    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }
}

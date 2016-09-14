package com.gianghoang.db;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by Longlaptop on 8/17/2016.
 */
public class RSACipher {
    // Using Encrypt and Decrypt key rsa with KeyPair files
    public String encrypt(String rawText, String pubicKeyPath, String tranformation, String encoding) throws IOException, GeneralSecurityException {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(IOUtils.toByteArray(new FileInputStream(pubicKeyPath)));

        Cipher cipher = Cipher.getInstance(tranformation);
        cipher.init(Cipher.ENCRYPT_MODE, KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec));
        return Base64.encodeBase64String(cipher.doFinal(rawText.getBytes(encoding)));

    }

    public String decrypt(String cipherText, String privateKeyPath, String tranformation, String encoding) throws IOException, GeneralSecurityException {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(IOUtils.toByteArray(new FileInputStream(privateKeyPath)));
        Cipher cipher = Cipher.getInstance(tranformation);
        cipher.init(Cipher.DECRYPT_MODE, KeyFactory.getInstance("RSA").generatePrivate(pkcs8EncodedKeySpec));

        return new String(cipher.doFinal(Base64.decodeBase64(cipherText)),encoding);
    }

    // Using Encrypt and Decrypt key rsa with KeyPair
    public String encrypt(String rawText, PublicKey pubicKey, String tranformation, String encoding) throws IOException, GeneralSecurityException {

        Cipher cipher = Cipher.getInstance(tranformation);
        cipher.init(Cipher.ENCRYPT_MODE,pubicKey);
        return Base64.encodeBase64String(cipher.doFinal(rawText.getBytes(encoding)));

    }

    public String decrypt(String cipherText, PrivateKey privateKey, String tranformation, String encoding) throws IOException, GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(tranformation);
        cipher.init(Cipher.DECRYPT_MODE,privateKey);

        return new String(cipher.doFinal(Base64.decodeBase64(cipherText)),encoding);
    }
}

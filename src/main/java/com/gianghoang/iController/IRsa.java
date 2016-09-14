package com.gianghoang.iController;

import java.security.GeneralSecurityException;

/**
 * Created by Administrator on 8/19/2016.
 */
public interface IRsa {
    void RSA1024() throws GeneralSecurityException;
    void RSA512() throws GeneralSecurityException;
    void RSA2048() throws GeneralSecurityException;
}

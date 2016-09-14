package com.gianghoang.iController;

import org.springframework.web.context.request.async.DeferredResult;

import java.io.Serializable;

/**
 * Created by Administrator on 8/19/2016.
 */
public interface ITime extends Serializable {
    public String timeSleep(final Long time)throws InterruptedException;
    public DeferredResult<String> timeSleepAsync(Long time) throws InterruptedException;
}

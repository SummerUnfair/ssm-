package com.ferao.utils;/*
 * @author Ferao
 * @date
 * @discription
 */

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")
public class IDutils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDutils.getId());
    }

}

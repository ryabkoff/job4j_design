package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte b = 12;
        short s = 99;
        int i = -22;
        long l = 2323238923L;
        float f = 99.99f;
        double d = 87111.998;
        boolean bl = true;
        char c = 's';
        LOG.debug("byte : {}, "
                + "short : {}, "
                + "int : {}, "
                + "long : {}, "
                + "float : {}, "
                + "double : {}, "
                + "boolean : {}, "
                + "char : {}", b, s, i, l, f, d, bl, c);
    }
}
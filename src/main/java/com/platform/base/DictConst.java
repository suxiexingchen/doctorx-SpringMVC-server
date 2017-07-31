package com.platform.base;

import java.util.HashMap;

public interface DictConst {

    public final static String RESBEAN_SUCCESS = "1";
    public final static String RESBEAN_ERROR = "0";

    public final static HashMap<String, String> LOGTYPE = new HashMap<String, String>() {

        private static final long serialVersionUID = 4091643361151770275L;

        {
            put("1", "test");
        }

    };
}

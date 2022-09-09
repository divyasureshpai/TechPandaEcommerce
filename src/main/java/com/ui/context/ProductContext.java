package com.ui.context;

import java.util.HashMap;
import java.util.Map;

public class ProductContext {
    private Map<String,String> productContext=new HashMap();

    public void setProductContext(String key, String value) {
        productContext.put(key, value);
    }

    public String getProductContext(String key) {
        return productContext.get(key);
    }
}

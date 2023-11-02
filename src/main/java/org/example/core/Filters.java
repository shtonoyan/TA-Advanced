package org.example.core;

public enum Filters {
    TOTAL,
    PASSED,
    FAILED,
    SKIPPED,
    PRODUCT_BUG,
    AUTO_BUG,
    SYSTEM_ISSUE;

    public static String getStringValue(Filters filters){
        return String.valueOf(filters).toLowerCase().replace("_", " ");
    }
}

package com.gosling.core.ibatis;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 模块数据状态
 */
public enum DataStatus {
    /**
     * 禁用
     */
    Disabled(0), /**
                  * 启用
                  */
    Enabled(1), /**
                 * 逻辑删除
                 */
    Deleted(-1);

    private int value;

    DataStatus(int value) {
        this.value = value;
    }

    private static final Map<Integer, DataStatus> lookup = new HashMap<Integer, DataStatus>();

    static {
        for (DataStatus s : EnumSet.allOf(DataStatus.class))
            lookup.put(s.toValue(), s);
    }

    /**
     * 获取枚举的值（整数值、字符串值等）
     * @return
     */
    public int toValue() {
        return this.value;
    }

    /**
     * 根据值（整数值、字符串值等）获取相应的枚举类型
     * @param value
     * @return
     */
    public static DataStatus fromValue(int value) {
        return lookup.get(value);
    }

    //    @Override
    //    public String toString() {
    //        return this.value + "";
    //    }
}

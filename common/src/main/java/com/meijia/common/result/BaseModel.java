package com.meijia.common.result;

import java.io.Serializable;

/**
 * @author kaiser
 *
 * 返回公用参数
 */
public class BaseModel implements Serializable {

    private Long systemTime;

    public Long getSystemTime() {
        if(systemTime == null || systemTime == 0L){
            systemTime = System.currentTimeMillis();
        }
        return systemTime;
    }

    public void setSystemTime(Long systemTime) {
        this.systemTime = systemTime;
    }
}

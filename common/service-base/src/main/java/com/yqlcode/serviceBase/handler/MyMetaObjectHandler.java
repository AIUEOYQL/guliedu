package com.yqlcode.serviceBase.handler;/**
 * 描述:
 * 包名:com.yqlcode.serviceBase.handler
 * 版本信息: 版本1.0
 * 日期:2021/5/3
 * Copyright 三合力通科技有限公司
 */


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @describe：
 * @author: yql/三合力通科技有限公司 
 * @version:v1.0
 * 2021/5/3 22:31  
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 设置insert时自动填充的值
     * @param metaObject :
     * @throws
     * @return void
     * @Author yangqingliang
     * @Date 2021/5/1 22:50
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    /**
     * 设置update时自动填充的值
     * @param metaObject :
     * @throws
     * @return void
     * @Author yangqingliang
     * @Date 2021/5/1 22:51
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}

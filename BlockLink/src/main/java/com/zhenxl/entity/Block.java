package com.zhenxl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 区块的定义
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Block {
    //自己的数字签名
    private String sign;
    //存储的数据
    private String data;
    //上一个区块的数字签名
    private String previous_sign;
    //时间戳
    private long timestamps=System.currentTimeMillis();
}

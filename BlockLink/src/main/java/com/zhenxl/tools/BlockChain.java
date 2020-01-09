package com.zhenxl.tools;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 链类
 * @param <T>
 */
@Data
public class BlockChain<T> {
    private List<T> chain=new ArrayList<T>();
    public boolean addBlock(T block){
        return chain.add(block);
    }
}

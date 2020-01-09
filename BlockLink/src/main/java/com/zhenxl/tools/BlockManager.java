package com.zhenxl.tools;

import com.zhenxl.entity.Block;

public class BlockManager {
    public static String getHashString(Block block){
        return block.getPrevious_sign()+block.getData()+block.getTimestamps();
    }
}

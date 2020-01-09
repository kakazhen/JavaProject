package com.zhenxl;

import com.zhenxl.entity.Block;
import com.zhenxl.tools.BlockChain;
import com.zhenxl.tools.BlockManager;
import com.zhenxl.tools.DigestTools;

public class Test {
    public static void main(String[] args) {
        //1、创建第一个块
        //第一个块，previous_hash为空
        Block block = new Block();
        String data = "这是第一个块";
        block.setData(data);
        String strHash= BlockManager.getHashString(block);
        String currentHash = DigestTools.getSha256Hash(strHash);
        block.setSign(currentHash);

        //添加到链中
        BlockChain<Block> chain=new BlockChain<Block>();
        chain.addBlock(block);

        //添加下一个Block
        Block netxBlock = new Block();
        String nextData = "转账10块钱";
        netxBlock.setData(nextData);
        String strNextHash= BlockManager.getHashString(netxBlock);
        String currentNextHash = DigestTools.getSha256Hash(strNextHash);
        netxBlock.setSign(currentNextHash);
        netxBlock.setPrevious_sign(block.getSign());

        //将nextBlock添加到chain中
        chain.addBlock(netxBlock);
        System.out.println(chain);

    }
}

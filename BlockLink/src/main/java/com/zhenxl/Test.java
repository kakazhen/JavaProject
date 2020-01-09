package com.zhenxl;

import com.zhenxl.entity.Block;
import com.zhenxl.tools.BlockChain;
import com.zhenxl.tools.BlockManager;

public class Test {
    public static void main(String[] args) {
        //1、创建第一个块
        //第一个块，previous_hash为空
        Block block = new Block();
        String data = "这是第一个块";
        block.setData(data);
        String currentHash = BlockManager.mine(block);
        block.setSign(currentHash);

        //添加到链中
        BlockChain<Block> chain=new BlockChain<Block>();
        chain.addBlock(block);

        //添加下一个Block
        Block netxBlock = new Block();
        String nextData = "转账10块钱";
        netxBlock.setData(nextData);
        String currentNextHash = BlockManager.mine(netxBlock);
        netxBlock.setSign(currentNextHash);
        netxBlock.setPrevious_sign(block.getSign());

        //将nextBlock添加到chain中
        chain.addBlock(netxBlock);

        Block secBlock = new Block();
        String secData = "转账10块钱";
        secBlock.setData(secData);
        String currentSecHash = BlockManager.mine(secBlock);
        secBlock.setSign(currentSecHash);
        secBlock.setPrevious_sign(netxBlock.getSign());
        //将secBlock添加到chain中
        chain.addBlock(secBlock);
        System.out.println(chain);

        //窜改区块链内容
        chain.getChain().get(1).setData("转账10个100块钱");
        chain.getChain().get(1).setSign(BlockManager.mine(chain.getChain().get(1)));
        System.out.println("窜改后的");
        System.out.println(BlockManager.validateBlock(chain));
    }
}

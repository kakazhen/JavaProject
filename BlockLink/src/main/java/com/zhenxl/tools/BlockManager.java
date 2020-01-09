package com.zhenxl.tools;

import com.zhenxl.entity.Block;

import java.util.List;

public class BlockManager {
    //获取block签名的字符串

    //获取工作难度对应的正确字符串
    public static String getDifficutAnswer(Integer diff){
        String strAnswer="0";
        for (Integer i = 1; i < diff; i++) {
            strAnswer+="0";
        }
        return strAnswer;
    }
    //pow
    //工作量证明
    public static String mine(Block block){
        //根据难度系数返回合法的区块
        for (int i=0;;i++){
            String hxString = DigestTools.getSha256Hash(block.getHashString());
            if(!hxString.substring(0,block.getDifficut()).equals(getDifficutAnswer(block.getDifficut()))){
                block.setNonce(block.getNonce()+1);
                continue;
            }else{
                return hxString;
            }
        }
    }

    //校验区块链是否被窜改
    public static boolean validateBlock(BlockChain<Block> blockChain){
        List<Block> list = blockChain.getChain();
        boolean state = false;//没有被窜改
        Block currentBlock=null;
        Block prevBlock = null;
        for (int i = 1; i < list.size(); i++) {
            currentBlock=list.get(i);
            prevBlock = list.get(i-1);
            //判断当前块签名是否正确
            if(!currentBlock.getSign().equals(mine(currentBlock))){
                state = true;
                System.out.println("被串改了");
                break;
            }else if(!currentBlock.getSign().equals(prevBlock.getPrevious_sign())){//判断记录区块的签名是否上一区块的签名一致
                state=true;
                System.out.println("被串改了");
                break;
            }
        }
        return state;
    }

}

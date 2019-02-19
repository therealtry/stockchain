package com.stockchain.beans;

import org.ethereum.core.Block;
import org.ethereum.facade.Ethereum;
import org.ethereum.facade.EthereumFactory;

import com.stockchain.listeners.EthListener;

import java.math.BigInteger;

public class EthBean {
    private Ethereum ethereum;

    public void start() {
        this.ethereum = EthereumFactory.createEthereum();
        this.ethereum.addListener(new EthListener(ethereum));
    }

    public Block getBestBlock() {
        return this.ethereum.getBlockchain().getBestBlock();
    }

    public BigInteger getTotalDifficulty() {
        return this.ethereum.getBlockchain().getTotalDifficulty();
    }
}
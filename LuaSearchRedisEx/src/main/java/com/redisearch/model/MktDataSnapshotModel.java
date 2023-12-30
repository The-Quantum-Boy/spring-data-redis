package com.redisearch.model;


import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MktDataSnapshotModel {

    private String tokenId;
    private String auctionNo;
    private String contractCode;
    private String marketType;
    private int counter;
    private BigDecimal bestBidPrice;
    private String bestBidSide;
    private List<Object> depthList;
    private String type;
    private String wtAvgPrice;
}
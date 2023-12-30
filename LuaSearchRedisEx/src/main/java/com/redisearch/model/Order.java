package com.redisearch.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private String marketCode;
    private String showPrice;
    private String commodityCode;
    private String commNm;
    private String contractCode;
    private String auctionType;
    private String qtyUnit;
    private String priceUnit;
    private String auctionShortCode;
    private String ordSide;
    private String remarks;
    private BigDecimal ordPrice;
    private BigDecimal ordQty;
    private String uniqueNo;
    private Timestamp pricingDate;
    private String deliveryMode;
    private String location;
    private String paymentMode;
    private String tmId;
    private String tradingAccNo;
    private String isSelected;
    private String ordStatus;
    private String globalClient;
    private String tokenId;
    private String internalOrdNo;
    private String exchOrdNo;
    private Timestamp biddingStartTime;
    private Timestamp biddingEndTime;
    private String ordType;
    private int totalSize;
    private boolean isAccessAllow;
    private String sessionId;
    private int extensionNo;
    private String sessionState;
    private long timeLeft;
    private MktDataSnapshotModel mktDataSnapshotModel;
    private String isInitiator;

    private String paramValue5;
    private String paramValue6;
    private String paramValue7;
    private String paramValue8;
    private String paramValue9;
    private String paramValue10;
    private String paramValue11;
    private String paramValue12;
    private String paramValue13;
    private String publicImageUrl;
    private String superH1matchqty;
    private String superH1Price;


}
package com.sumit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private String schemeCode;
    private String stateName;
    private String internalOrdNo;
    private String dealerId;
    private String marketCode;
    private String ordSide;
    private String commodityCode;
    private String contractCode;
    private String auctionType;
    private String auctionShortCode;
    private String remarks;
    private double ordPrice;
    private double ordQty;
    private String exchOrdNo;
    private Date biddingStartTime;
    private Date biddingEndTime;
    private Date pricingDate;
    private String deliveryMode;
    private String location;
    private String auctionOrdNo;
    private String commodityName;
    private Double matchQty;
    private Double minBidQty;
    private Date ordIntrnlDate;
    private Double ordValue;
    private String priceUnit;
    private String qtyUnit;
    private String showPrice;
    private String status;
    private String tmId;
    private String tokenId;
    private Double tradePrice;
    private Double tradeQty;
    private String tradingAccNo;
    private String globalClient;
    private Date fromDate;
    private Date toDate;
    private String paymentMode;
    private String paramValue5;
    private Integer totalNoOfItems;
    private String publicImageUrl;
    private String paramValue6;
    private String paramValue7;
    private String paramValue8;
    private String paramValue9;
    private String paramValue10;
    private String paramValue11;
    private String paramValue12;
    private String paramValue13;
    private Integer offset;
    private Integer limit;
    private List<String> commodityList;
    private List<String> seasonList;
    private List<String> stateList;
    private List<String> schemeList;
    private List<String> locationList;
    private List<String> globalClientList;

}
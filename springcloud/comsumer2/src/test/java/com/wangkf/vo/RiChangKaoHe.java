package com.wangkf.vo;


import lombok.Value;

@Value
public class RiChangKaoHe implements java.io.Serializable{
	
	private static final long serialVersionUID = -1L;

	private String riChangGuid;
	
	private Long pingBiaoTime;
	
	private String xiangMuNo;
	
	private String xiangMuName;
	
	private Double chuQinQingKuangScore;
	
	private Double pingShenJiLvScore;
	
	private Double zhiYeDaoDeScore;
	
	private Double yeWuShuiPingScore;
	
	private Double qiTaPingFenScore;
	
	private String zongHePingJia;
	
	private String pingJiaJiGou;
	
	private Long createTime;
	
	private String creatorGuid;
	
	private String zhuanJiaCode;
	
	private String zhuanJiaGuid;
	
}


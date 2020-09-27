
package cs523.finalproject.kafka.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang.builder.ToStringBuilder;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"symbol",
"companyName",
"primaryExchange",
"calculationPrice",
"open",
"openTime",
"openSource",
"close",
"closeTime",
"closeSource",
"high",
"highTime",
"highSource",
"low",
"lowTime",
"lowSource",
"latestPrice",
"latestSource",
"latestTime",
"latestUpdate",
"latestVolume",
"iexRealtimePrice",
"iexRealtimeSize",
"iexLastUpdated",
"delayedPrice",
"delayedPriceTime",
"oddLotDelayedPrice",
"oddLotDelayedPriceTime",
"extendedPrice",
"extendedChange",
"extendedChangePercent",
"extendedPriceTime",
"previousClose",
"previousVolume",
"change",
"changePercent",
"volume",
"iexMarketPercent",
"iexVolume",
"avgTotalVolume",
"iexBidPrice",
"iexBidSize",
"iexAskPrice",
"iexAskSize",
"iexOpen",
"iexOpenTime",
"iexClose",
"iexCloseTime",
"marketCap",
"peRatio",
"week52High",
"week52Low",
"ytdChange",
"lastTradeTime",
"isUSMarketOpen"
})
public class StockInfo implements Serializable
{

@JsonProperty("symbol")
private String symbol;
@JsonProperty("companyName")
private String companyName;
@JsonProperty("primaryExchange")
private String primaryExchange;
@JsonProperty("calculationPrice")
private String calculationPrice;
@JsonProperty("open")
private Double open;
@JsonProperty("openTime")
private long openTime;
@JsonProperty("openSource")
private String openSource;
@JsonProperty("close")
private Double close;
@JsonProperty("closeTime")
private long closeTime;
@JsonProperty("closeSource")
private String closeSource;
@JsonProperty("high")
private Double high;
@JsonProperty("highTime")
private long highTime;
@JsonProperty("highSource")
private String highSource;
@JsonProperty("low")
private Double low;
@JsonProperty("lowTime")
private long lowTime;
@JsonProperty("lowSource")
private String lowSource;
@JsonProperty("latestPrice")
private Double latestPrice;
@JsonProperty("latestSource")
private String latestSource;
@JsonProperty("latestTime")
private String latestTime;
@JsonProperty("latestUpdate")
private long latestUpdate;
@JsonProperty("latestVolume")
private long latestVolume;
@JsonProperty("iexRealtimePrice")
private Double iexRealtimePrice;
@JsonProperty("iexRealtimeSize")
private long iexRealtimeSize;
@JsonProperty("iexLastUpdated")
private long iexLastUpdated;
@JsonProperty("delayedPrice")
private Double delayedPrice;
@JsonProperty("delayedPriceTime")
private long delayedPriceTime;
@JsonProperty("oddLotDelayedPrice")
private Double oddLotDelayedPrice;
@JsonProperty("oddLotDelayedPriceTime")
private long oddLotDelayedPriceTime;
@JsonProperty("extendedPrice")
private Double extendedPrice;
@JsonProperty("extendedChange")
private Double extendedChange;
@JsonProperty("extendedChangePercent")
private Double extendedChangePercent;
@JsonProperty("extendedPriceTime")
private long extendedPriceTime;
@JsonProperty("previousClose")
private Double previousClose;
@JsonProperty("previousVolume")
private long previousVolume;
@JsonProperty("change")
private Double change;
@JsonProperty("changePercent")
private Double changePercent;
@JsonProperty("volume")
private long volume;
@JsonProperty("iexMarketPercent")
private Double iexMarketPercent;
@JsonProperty("iexVolume")
private long iexVolume;
@JsonProperty("avgTotalVolume")
private long avgTotalVolume;
@JsonProperty("iexBidPrice")
private long iexBidPrice;
@JsonProperty("iexBidSize")
private long iexBidSize;
@JsonProperty("iexAskPrice")
private long iexAskPrice;
@JsonProperty("iexAskSize")
private long iexAskSize;
@JsonProperty("iexOpen")
private Object iexOpen;
@JsonProperty("iexOpenTime")
private Object iexOpenTime;
@JsonProperty("iexClose")
private Double iexClose;
@JsonProperty("iexCloseTime")
private long iexCloseTime;
@JsonProperty("marketCap")
private long marketCap;
@JsonProperty("peRatio")
private Double peRatio;
@JsonProperty("week52High")
private Double week52High;
@JsonProperty("week52Low")
private Double week52Low;
@JsonProperty("ytdChange")
private Double ytdChange;
@JsonProperty("lastTradeTime")
private long lastTradeTime;
@JsonProperty("isUSMarketOpen")
private Boolean isUSMarketOpen;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -2403440578458579973L;

public StockInfo()
{
	symbol="APPL";
	companyName = "Apple";	
}

@JsonProperty("symbol")
public String getSymbol() {
return symbol;
}

@JsonProperty("symbol")
public void setSymbol(String symbol) {
this.symbol = symbol;
}

@JsonProperty("companyName")
public String getCompanyName() {
return companyName;
}

@JsonProperty("companyName")
public void setCompanyName(String companyName) {
this.companyName = companyName;
}

@JsonProperty("primaryExchange")
public String getPrimaryExchange() {
return primaryExchange;
}

@JsonProperty("primaryExchange")
public void setPrimaryExchange(String primaryExchange) {
this.primaryExchange = primaryExchange;
}

@JsonProperty("calculationPrice")
public String getCalculationPrice() {
return calculationPrice;
}

@JsonProperty("calculationPrice")
public void setCalculationPrice(String calculationPrice) {
this.calculationPrice = calculationPrice;
}

@JsonProperty("open")
public Double getOpen() {
return open;
}

@JsonProperty("open")
public void setOpen(Double open) {
this.open = open;
}

@JsonProperty("openTime")
public long getOpenTime() {
return openTime;
}

@JsonProperty("openTime")
public void setOpenTime(long openTime) {
this.openTime = openTime;
}

@JsonProperty("openSource")
public String getOpenSource() {
return openSource;
}

@JsonProperty("openSource")
public void setOpenSource(String openSource) {
this.openSource = openSource;
}

@JsonProperty("close")
public Double getClose() {
return close;
}

@JsonProperty("close")
public void setClose(Double close) {
this.close = close;
}

@JsonProperty("closeTime")
public long getCloseTime() {
return closeTime;
}

@JsonProperty("closeTime")
public void setCloseTime(long closeTime) {
this.closeTime = closeTime;
}

@JsonProperty("closeSource")
public String getCloseSource() {
return closeSource;
}

@JsonProperty("closeSource")
public void setCloseSource(String closeSource) {
this.closeSource = closeSource;
}

@JsonProperty("high")
public Double getHigh() {
return high;
}

@JsonProperty("high")
public void setHigh(Double high) {
this.high = high;
}

@JsonProperty("highTime")
public long getHighTime() {
return highTime;
}

@JsonProperty("highTime")
public void setHighTime(long highTime) {
this.highTime = highTime;
}

@JsonProperty("highSource")
public String getHighSource() {
return highSource;
}

@JsonProperty("highSource")
public void setHighSource(String highSource) {
this.highSource = highSource;
}

@JsonProperty("low")
public Double getLow() {
return low;
}

@JsonProperty("low")
public void setLow(Double low) {
this.low = low;
}

@JsonProperty("lowTime")
public long getLowTime() {
return lowTime;
}

@JsonProperty("lowTime")
public void setLowTime(long lowTime) {
this.lowTime = lowTime;
}

@JsonProperty("lowSource")
public String getLowSource() {
return lowSource;
}

@JsonProperty("lowSource")
public void setLowSource(String lowSource) {
this.lowSource = lowSource;
}

@JsonProperty("latestPrice")
public Double getLatestPrice() {
return latestPrice;
}

@JsonProperty("latestPrice")
public void setLatestPrice(Double latestPrice) {
this.latestPrice = latestPrice;
}

@JsonProperty("latestSource")
public String getLatestSource() {
return latestSource;
}

@JsonProperty("latestSource")
public void setLatestSource(String latestSource) {
this.latestSource = latestSource;
}

@JsonProperty("latestTime")
public String getLatestTime() {
return latestTime;
}

@JsonProperty("latestTime")
public void setLatestTime(String latestTime) {
this.latestTime = latestTime;
}

@JsonProperty("latestUpdate")
public long getLatestUpdate() {
return latestUpdate;
}

@JsonProperty("latestUpdate")
public void setLatestUpdate(long latestUpdate) {
this.latestUpdate = latestUpdate;
}

@JsonProperty("latestVolume")
public long getLatestVolume() {
return latestVolume;
}

@JsonProperty("latestVolume")
public void setLatestVolume(long latestVolume) {
this.latestVolume = latestVolume;
}

@JsonProperty("iexRealtimePrice")
public Double getIexRealtimePrice() {
return iexRealtimePrice;
}

@JsonProperty("iexRealtimePrice")
public void setIexRealtimePrice(Double iexRealtimePrice) {
this.iexRealtimePrice = iexRealtimePrice;
}

@JsonProperty("iexRealtimeSize")
public long getIexRealtimeSize() {
return iexRealtimeSize;
}

@JsonProperty("iexRealtimeSize")
public void setIexRealtimeSize(long iexRealtimeSize) {
this.iexRealtimeSize = iexRealtimeSize;
}

@JsonProperty("iexLastUpdated")
public long getIexLastUpdated() {
return iexLastUpdated;
}

@JsonProperty("iexLastUpdated")
public void setIexLastUpdated(long iexLastUpdated) {
this.iexLastUpdated = iexLastUpdated;
}

@JsonProperty("delayedPrice")
public Double getDelayedPrice() {
return delayedPrice;
}

@JsonProperty("delayedPrice")
public void setDelayedPrice(Double delayedPrice) {
this.delayedPrice = delayedPrice;
}

@JsonProperty("delayedPriceTime")
public long getDelayedPriceTime() {
return delayedPriceTime;
}

@JsonProperty("delayedPriceTime")
public void setDelayedPriceTime(long delayedPriceTime) {
this.delayedPriceTime = delayedPriceTime;
}

@JsonProperty("oddLotDelayedPrice")
public Double getOddLotDelayedPrice() {
return oddLotDelayedPrice;
}

@JsonProperty("oddLotDelayedPrice")
public void setOddLotDelayedPrice(Double oddLotDelayedPrice) {
this.oddLotDelayedPrice = oddLotDelayedPrice;
}

@JsonProperty("oddLotDelayedPriceTime")
public long getOddLotDelayedPriceTime() {
return oddLotDelayedPriceTime;
}

@JsonProperty("oddLotDelayedPriceTime")
public void setOddLotDelayedPriceTime(long oddLotDelayedPriceTime) {
this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
}

@JsonProperty("extendedPrice")
public Double getExtendedPrice() {
return extendedPrice;
}

@JsonProperty("extendedPrice")
public void setExtendedPrice(Double extendedPrice) {
this.extendedPrice = extendedPrice;
}

@JsonProperty("extendedChange")
public Double getExtendedChange() {
return extendedChange;
}

@JsonProperty("extendedChange")
public void setExtendedChange(Double extendedChange) {
this.extendedChange = extendedChange;
}

@JsonProperty("extendedChangePercent")
public Double getExtendedChangePercent() {
return extendedChangePercent;
}

@JsonProperty("extendedChangePercent")
public void setExtendedChangePercent(Double extendedChangePercent) {
this.extendedChangePercent = extendedChangePercent;
}

@JsonProperty("extendedPriceTime")
public long getExtendedPriceTime() {
return extendedPriceTime;
}

@JsonProperty("extendedPriceTime")
public void setExtendedPriceTime(long extendedPriceTime) {
this.extendedPriceTime = extendedPriceTime;
}

@JsonProperty("previousClose")
public Double getPreviousClose() {
return previousClose;
}

@JsonProperty("previousClose")
public void setPreviousClose(Double previousClose) {
this.previousClose = previousClose;
}

@JsonProperty("previousVolume")
public long getPreviousVolume() {
return previousVolume;
}

@JsonProperty("previousVolume")
public void setPreviousVolume(long previousVolume) {
this.previousVolume = previousVolume;
}

@JsonProperty("change")
public Double getChange() {
return change;
}

@JsonProperty("change")
public void setChange(Double change) {
this.change = change;
}

@JsonProperty("changePercent")
public Double getChangePercent() {
return changePercent;
}

@JsonProperty("changePercent")
public void setChangePercent(Double changePercent) {
this.changePercent = changePercent;
}

@JsonProperty("volume")
public long getVolume() {
return volume;
}

@JsonProperty("volume")
public void setVolume(long volume) {
this.volume = volume;
}

@JsonProperty("iexMarketPercent")
public Double getIexMarketPercent() {
return iexMarketPercent;
}

@JsonProperty("iexMarketPercent")
public void setIexMarketPercent(Double iexMarketPercent) {
this.iexMarketPercent = iexMarketPercent;
}

@JsonProperty("iexVolume")
public long getIexVolume() {
return iexVolume;
}

@JsonProperty("iexVolume")
public void setIexVolume(long iexVolume) {
this.iexVolume = iexVolume;
}

@JsonProperty("avgTotalVolume")
public long getAvgTotalVolume() {
return avgTotalVolume;
}

@JsonProperty("avgTotalVolume")
public void setAvgTotalVolume(long avgTotalVolume) {
this.avgTotalVolume = avgTotalVolume;
}

@JsonProperty("iexBidPrice")
public long getIexBidPrice() {
return iexBidPrice;
}

@JsonProperty("iexBidPrice")
public void setIexBidPrice(long iexBidPrice) {
this.iexBidPrice = iexBidPrice;
}

@JsonProperty("iexBidSize")
public long getIexBidSize() {
return iexBidSize;
}

@JsonProperty("iexBidSize")
public void setIexBidSize(long iexBidSize) {
this.iexBidSize = iexBidSize;
}

@JsonProperty("iexAskPrice")
public long getIexAskPrice() {
return iexAskPrice;
}

@JsonProperty("iexAskPrice")
public void setIexAskPrice(long iexAskPrice) {
this.iexAskPrice = iexAskPrice;
}

@JsonProperty("iexAskSize")
public long getIexAskSize() {
return iexAskSize;
}

@JsonProperty("iexAskSize")
public void setIexAskSize(long iexAskSize) {
this.iexAskSize = iexAskSize;
}

@JsonProperty("iexOpen")
public Object getIexOpen() {
return iexOpen;
}

@JsonProperty("iexOpen")
public void setIexOpen(Object iexOpen) {
this.iexOpen = iexOpen;
}

@JsonProperty("iexOpenTime")
public Object getIexOpenTime() {
return iexOpenTime;
}

@JsonProperty("iexOpenTime")
public void setIexOpenTime(Object iexOpenTime) {
this.iexOpenTime = iexOpenTime;
}

@JsonProperty("iexClose")
public Double getIexClose() {
return iexClose;
}

@JsonProperty("iexClose")
public void setIexClose(Double iexClose) {
this.iexClose = iexClose;
}

@JsonProperty("iexCloseTime")
public long getIexCloseTime() {
return iexCloseTime;
}

@JsonProperty("iexCloseTime")
public void setIexCloseTime(long iexCloseTime) {
this.iexCloseTime = iexCloseTime;
}

@JsonProperty("marketCap")
public long getMarketCap() {
return marketCap;
}

@JsonProperty("marketCap")
public void setMarketCap(long marketCap) {
this.marketCap = marketCap;
}

@JsonProperty("peRatio")
public Double getPeRatio() {
return peRatio;
}

@JsonProperty("peRatio")
public void setPeRatio(Double peRatio) {
this.peRatio = peRatio;
}

@JsonProperty("week52High")
public Double getWeek52High() {
return week52High;
}

@JsonProperty("week52High")
public void setWeek52High(Double week52High) {
this.week52High = week52High;
}

@JsonProperty("week52Low")
public Double getWeek52Low() {
return week52Low;
}

@JsonProperty("week52Low")
public void setWeek52Low(Double week52Low) {
this.week52Low = week52Low;
}

@JsonProperty("ytdChange")
public Double getYtdChange() {
return ytdChange;
}

@JsonProperty("ytdChange")
public void setYtdChange(Double ytdChange) {
this.ytdChange = ytdChange;
}

@JsonProperty("lastTradeTime")
public long getLastTradeTime() {
return lastTradeTime;
}

@JsonProperty("lastTradeTime")
public void setLastTradeTime(long lastTradeTime) {
this.lastTradeTime = lastTradeTime;
}

@JsonProperty("isUSMarketOpen")
public Boolean getIsUSMarketOpen() {
return isUSMarketOpen;
}

@JsonProperty("isUSMarketOpen")
public void setIsUSMarketOpen(Boolean isUSMarketOpen) {
this.isUSMarketOpen = isUSMarketOpen;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public StockInfoDTO TranformDTO()
{
	StockInfoDTO dto = new StockInfoDTO();
	dto.setCompanyName(companyName);
	dto.setPrimaryExchange(primaryExchange);
	dto.setOpenPrice(open);
	dto.setOpenTime(openTime);
	dto.setClosePrice(close);
	dto.setCloseTime(closeTime);
	dto.setHighPrice(high);
	dto.setHighTime(highTime);
	dto.setLowPrice(low);
	dto.setLowTime(lowTime);
	dto.setLatestPrice(latestPrice);
	dto.setLatestUpdate(latestUpdate);
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();  
	
	dto.setReceiveDate(now);
	dto.setLatestVolume(latestVolume);
	dto.setPreviousClosePrice(previousClose);
	dto.setPreviousVolume(previousVolume);
	dto.setChange(change);
	dto.setChangePercent(changePercent);
	dto.setVolume(volume);
	dto.setAvgTotalVolume(avgTotalVolume);
	dto.setMarketCap(marketCap);
	dto.setPeRatio(peRatio);
	dto.setWeek52High(week52High);
	dto.setWeek52Low(week52Low);
	dto.setYtdChange(ytdChange);
	dto.setLastTradeTime(lastTradeTime);
	dto.setSymbol(symbol);

	return dto;
}

@Override
public String toString() {
	
	return this.TranformDTO().toString();
	
	/*
	return "StockInfo [symbol=" + symbol + ", companyName=" + companyName
			+ ", primaryExchange=" + primaryExchange + ", calculationPrice="
			+ calculationPrice + ", open=" + open + ", openTime=" + openTime
			+ ", openSource=" + openSource + ", close=" + close
			+ ", closeTime=" + closeTime + ", closeSource=" + closeSource
			+ ", high=" + high + ", highTime=" + highTime + ", highSource="
			+ highSource + ", low=" + low + ", lowTime=" + lowTime
			+ ", lowSource=" + lowSource + ", latestPrice=" + latestPrice
			+ ", latestSource=" + latestSource + ", latestTime=" + latestTime
			+ ", latestUpdate=" + latestUpdate + ", latestVolume="
			+ latestVolume + ", iexRealtimePrice=" + iexRealtimePrice
			+ ", iexRealtimeSize=" + iexRealtimeSize + ", iexLastUpdated="
			+ iexLastUpdated + ", delayedPrice=" + delayedPrice
			+ ", delayedPriceTime=" + delayedPriceTime
			+ ", oddLotDelayedPrice=" + oddLotDelayedPrice
			+ ", oddLotDelayedPriceTime=" + oddLotDelayedPriceTime
			+ ", extendedPrice=" + extendedPrice + ", extendedChange="
			+ extendedChange + ", extendedChangePercent="
			+ extendedChangePercent + ", extendedPriceTime="
			+ extendedPriceTime + ", previousClose=" + previousClose
			+ ", previousVolume=" + previousVolume + ", change=" + change
			+ ", changePercent=" + changePercent + ", volume=" + volume
			+ ", iexMarketPercent=" + iexMarketPercent + ", iexVolume="
			+ iexVolume + ", avgTotalVolume=" + avgTotalVolume
			+ ", iexBidPrice=" + iexBidPrice + ", iexBidSize=" + iexBidSize
			+ ", iexAskPrice=" + iexAskPrice + ", iexAskSize=" + iexAskSize
			+ ", iexOpen=" + iexOpen + ", iexOpenTime=" + iexOpenTime
			+ ", iexClose=" + iexClose + ", iexCloseTime=" + iexCloseTime
			+ ", marketCap=" + marketCap + ", peRatio=" + peRatio
			+ ", week52High=" + week52High + ", week52Low=" + week52Low
			+ ", ytdChange=" + ytdChange + ", lastTradeTime=" + lastTradeTime
			+ ", isUSMarketOpen=" + isUSMarketOpen + ", additionalProperties="
			+ additionalProperties + "]";
			*/
}



/*
@Override
public String toString() {
return new ToStringBuilder(this).append("symbol", symbol).append("companyName", companyName).append("primaryExchange", primaryExchange).append("calculationPrice", calculationPrice).append("open", open).append("openTime", openTime).append("openSource", openSource).append("close", close).append("closeTime", closeTime).append("closeSource", closeSource).append("high", high).append("highTime", highTime).append("highSource", highSource).append("low", low).append("lowTime", lowTime).append("lowSource", lowSource).append("latestPrice", latestPrice).append("latestSource", latestSource).append("latestTime", latestTime).append("latestUpdate", latestUpdate).append("latestVolume", latestVolume).append("iexRealtimePrice", iexRealtimePrice).append("iexRealtimeSize", iexRealtimeSize).append("iexLastUpdated", iexLastUpdated).append("delayedPrice", delayedPrice).append("delayedPriceTime", delayedPriceTime).append("oddLotDelayedPrice", oddLotDelayedPrice).append("oddLotDelayedPriceTime", oddLotDelayedPriceTime).append("extendedPrice", extendedPrice).append("extendedChange", extendedChange).append("extendedChangePercent", extendedChangePercent).append("extendedPriceTime", extendedPriceTime).append("previousClose", previousClose).append("previousVolume", previousVolume).append("change", change).append("changePercent", changePercent).append("volume", volume).append("iexMarketPercent", iexMarketPercent).append("iexVolume", iexVolume).append("avgTotalVolume", avgTotalVolume).append("iexBidPrice", iexBidPrice).append("iexBidSize", iexBidSize).append("iexAskPrice", iexAskPrice).append("iexAskSize", iexAskSize).append("iexOpen", iexOpen).append("iexOpenTime", iexOpenTime).append("iexClose", iexClose).append("iexCloseTime", iexCloseTime).append("marketCap", marketCap).append("peRatio", peRatio).append("week52High", week52High).append("week52Low", week52Low).append("ytdChange", ytdChange).append("lastTradeTime", lastTradeTime).append("isUSMarketOpen", isUSMarketOpen).append("additionalProperties", additionalProperties).toString();

}
*/


}
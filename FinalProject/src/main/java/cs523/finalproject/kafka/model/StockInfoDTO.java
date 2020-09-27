package cs523.finalproject.kafka.model;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.lang.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StockInfoDTO implements Serializer
{
	 public String companyName;
	 public String primaryExchange;
	 public double openPrice;
	 public long  openTime;
	 public double  closePrice;
	 public long closeTime;
	 public double  highPrice;
	 public long highTime;
	 public double   lowPrice;
	 public long lowTime ;
	 public double latestPrice;
	 public long latestUpdate;
	 public LocalDateTime receiveDate;
	 public double latestVolume;
	 public double previousClosePrice;
	 public double previousVolume;
	 public double change;
	 public double changePercent;
	 public double volume;
	 public double avgTotalVolume;
	 public double   marketCap;
	 public double   peRatio;
	 public double week52High;
	 public double   week52Low;
	 public double   ytdChange;
	 public long   lastTradeTime;
	 public String symbol;
	 public long time;
	@Override
	public String toString() {
		return "," +companyName.replace(',', '.')
				+ "," + primaryExchange.replace(',', '.') 
				+ ","+ openPrice 
				+ "," + openTime 
				+ ", " + closePrice 
				+ "," + closeTime 
				+ "," + highPrice 
				+ ", " + highTime 
				+ "," + lowPrice
				+ "," + lowTime
				+ ", " + latestPrice 
				+ ", " + latestUpdate
				+ "," + receiveDate 
				+ "," + String.format("%.0f", latestVolume) 
				+ ", " + previousClosePrice
				+ ", " + String.format("%.0f",previousVolume) 
				+ ", " + change
				+ ", " + changePercent 
				+ "," + String.format("%.0f",volume)
				+ "," + String.format("%.0f",avgTotalVolume) 
				+ "," + String.format("%.0f",marketCap) 
				+ "," + peRatio
				+ ", " + week52High
				+ ", " + week52Low 
				+ "," + ytdChange 
				+ ", " + lastTradeTime
				+ "," + symbol 
				+ ", " + latestUpdate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPrimaryExchange() {
		return primaryExchange;
	}
	public void setPrimaryExchange(String primaryExchange) {
		this.primaryExchange = primaryExchange;
	}
	public double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	public long getOpenTime() {
		return openTime;
	}
	public void setOpenTime(long openTime) {
		this.openTime = openTime;
	}
	public double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	public long getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(long closeTime) {
		this.closeTime = closeTime;
	}
	public double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	public long getHighTime() {
		return highTime;
	}
	public void setHighTime(long highTime) {
		this.highTime = highTime;
	}
	public double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public long getLowTime() {
		return lowTime;
	}
	public void setLowTime(long lowTime) {
		this.lowTime = lowTime;
	}
	public double getLatestPrice() {
		return latestPrice;
	}
	public void setLatestPrice(double latestPrice) {
		this.latestPrice = latestPrice;
	}
	public long getLatestUpdate() {
		return latestUpdate;
	}
	public void setLatestUpdate(long latestUpdate) {
		this.latestUpdate = latestUpdate;
	}
	public LocalDateTime getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(LocalDateTime receiveDate) {
		this.receiveDate = receiveDate;
	}
	public double getLatestVolume() {
		return latestVolume;
	}
	public void setLatestVolume(double latestVolume) {
		this.latestVolume = latestVolume;
	}
	public double getPreviousClosePrice() {
		return previousClosePrice;
	}
	public void setPreviousClosePrice(double previousClosePrice) {
		this.previousClosePrice = previousClosePrice;
	}
	public double getPreviousVolume() {
		return previousVolume;
	}
	public void setPreviousVolume(double previousVolume) {
		this.previousVolume = previousVolume;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
	public double getChangePercent() {
		return changePercent;
	}
	public void setChangePercent(double changePercent) {
		this.changePercent = changePercent;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getAvgTotalVolume() {
		return avgTotalVolume;
	}
	public void setAvgTotalVolume(double avgTotalVolume) {
		this.avgTotalVolume = avgTotalVolume;
	}
	public double getMarketCap() {
		return marketCap;
	}
	public void setMarketCap(double marketCap) {
		this.marketCap = marketCap;
	}
	public double getPeRatio() {
		return peRatio;
	}
	public void setPeRatio(double peRatio) {
		this.peRatio = peRatio;
	}
	public double getWeek52High() {
		return week52High;
	}
	public void setWeek52High(double week52High) {
		this.week52High = week52High;
	}
	public double getWeek52Low() {
		return week52Low;
	}
	public void setWeek52Low(double week52Low) {
		this.week52Low = week52Low;
	}
	public double getYtdChange() {
		return ytdChange;
	}
	public void setYtdChange(double ytdChange) {
		this.ytdChange = ytdChange;
	}
	public long getLastTradeTime() {
		return lastTradeTime;
	}
	public void setLastTradeTime(long lastTradeTime) {
		this.lastTradeTime = lastTradeTime;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	@Override
	public void close()  {
		// TODO Auto-generated method stub
		
	}
	@Override
	public byte[] serialize(String arg0, Object arg1) {
		 if (arg1 == null) {
	            return null;
	        }

	        try {


	        	byte[] retVal = null;
	            ObjectMapper objectMapper = new ObjectMapper();
	            try {
	              retVal = objectMapper.writeValueAsString(arg1).getBytes();
	            } catch (Exception e) {
	              e.printStackTrace();
	            }
	            return retVal;

	            //return bytes;

	        } catch (RuntimeException e) {
	            throw new SerializationException("Error serializing value", e);
	        }
	} 
	 
	 
	 
	 
}
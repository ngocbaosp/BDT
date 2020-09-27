package cs523.finalproject.kafka.model;


public class StockRecord
{
	private Long key;
	private StockInfo value;
	
	public StockRecord(Long k, StockInfo v)
	{
		key = k;
		value = v;
	}
	
	public StockRecord()
	{
		
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "StockRecord [key=" + key + ", value=" + value + "]";
	}

	public StockInfo getValue() {
		return value;
	}

	public void setValue(StockInfo value) {
		this.value = value;
	}
	
}
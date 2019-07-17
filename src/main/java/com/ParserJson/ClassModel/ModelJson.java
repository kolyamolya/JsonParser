package com.ParserJson.ClassModel;

public class ModelJson {

	private long recipient_id;
	private String email;
	private long at;

	private Data data;

	public ModelJson() {
	};

	public ModelJson(long recipient_id, String email, long at, Data data) {
		this.recipient_id = recipient_id;
		this.email = email;
		this.at = at;

		this.data = data;
	}
		
	public long getRecipient_id() {
		return recipient_id;
	}

	public String getEmail() {
		return email;
	}

	public long getAt() {
		return at;
	}

	public Data getData() {
		return data;
	}

	public class Data {
		
		private String s60;
		private String s90;
		private String traffic_past_week;
		private String v40cc;
		private String v60cc;
		private String v90cc;
		private String xc40;
		private String xc60;
		private String xc90;
		private String x;
		private String y;
		
		public String getS60() {
			return s60;
		}
		public String getV60cc() {
			return v60cc;
		}
		
		public String getS90() {
			return s90;
		}
		public String getV40CC() {
			return v40cc;
		}
		public String getV90CC() {
			return v90cc;
		}
		public String getXC40() {
			return xc40;
		}
		public String getXC60() {
			return xc60;
		}
		public String getXC90() {
			return xc90;
		}
		public String getTraffic_past_week() {
			return traffic_past_week;
		}
		public String getX() {
			return x;
		}
		public String getY() {
			return y;
		}
		
		

	}

}

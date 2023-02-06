package com.tsmc.common.constant;


public class MsgConstant {
	
	public enum OnlineMessage implements MsgKey{
		
		demo_message_args("demo.message.args"),
		demo_message("demo.message");

		private final String key;
		
		@Override
		public String getKey() {
			return this.key;
		}

		private OnlineMessage(String key) {
			this.key = key;
		}
		
	}
	
   public enum OnlineError implements MsgKey{
		
	    demo_error_args("demo.error.args");

		private final String key;
		
		@Override
		public String getKey() {
			return this.key;
		}

		private OnlineError(String key) {
			this.key = key;
		}
		
	}

}

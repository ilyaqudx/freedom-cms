package com.iquizoo.core.api;

import java.util.List;

import com.google.common.collect.Lists;

public class Channel {

	public static final List<Integer> channels = 
			Lists.newArrayList(1001,1002,1003,1004,1005,1006,1007,1008,1009);
	
	public static final boolean hasChannel(int channel)
	{
		return channels.contains(channel);
	}
	
	public static void main(String[] args) {
		System.out.println(channels.contains(1003));
	}
}

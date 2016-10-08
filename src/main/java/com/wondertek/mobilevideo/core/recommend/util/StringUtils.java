package com.wondertek.mobilevideo.core.recommend.util;

public class StringUtils
{
	public static boolean isBlank(String s)
	{
		return s == null || s.trim().length() <= 0 ;
	}
	
	public static boolean equals(String s,String...arr)
	{
		if (isBlank(s) || arr == null || arr.length <=0)
			return false;
		for (String p: arr)
			if (s.equalsIgnoreCase(p))
				return true ;
		return false ;
	}
	
	public static boolean isTrue(String s)
	{
		return equals(s,"true","yes","open","1","on");
	}
}

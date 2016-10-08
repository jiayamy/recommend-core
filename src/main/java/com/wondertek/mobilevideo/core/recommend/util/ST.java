package com.wondertek.mobilevideo.core.recommend.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import com.wondertek.mobilevideo.core.util.StringUtil;

public class ST {
	private final static String NULL_STRING = "\\s+";
    private final static Pattern pn = Pattern.compile(NULL_STRING);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat();
    
    private ST(){}
    
    public static void main(String[] args) {
	}
    
    /**
	 * 格式化年月日
	 * @param pattern,日期格式化模版,例yyyyMMdd,方法返回20090712
	 */
    public final static String getFormatDate(String pattern) {
    	dateFormat.applyPattern(pattern);
    	return dateFormat.format(new Date());
    }
    
    /**
	 * 格式化年月日,默认日期模版-yyyy-MM-dd HH:mm:ss
	 */
    public final static String getFormatDate() {
    	return getFormatDate("yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 检查对象是否为空
     * @param txt
     * @return boolean
     */
    public final static boolean isNull(String txt)
    {
    	return (txt == null || txt.length() == 0) || pn.matcher(txt).matches();
    }
    
    /**
     * 检查对象是否为空
     * @param obj
     * @return boolean
     */
    public final static boolean isNull(Object obj)
    {
    	if (obj == null) {
    		return true;
    	} else if (String.class.isInstance(obj)) {
    		return isNull((String)obj);
    	} else {
    		return false;
    	}
    }
    
    /**
     * 安全方法,如果对象为空或空字符串，将其转化为指定的值
     * @param str：要转换的对象
     * @param value：转换的值
     * @return String
     */
    public final static String getDefault(String str,String value)
    {
    	return isNull(str) ? value : str;
    }
    
    /**
     * 安全方法,将一个字符串转换为一个数字
     * converStringToInt  
     * @param str,要转换的字符串
     * @param defNum,默认返回值
     * @return    
     * int   
     * @exception    
     * @since  1.0.0
     */
    public final static int getDefaultToInt(String str,int defNum) {
    	if (isNull(str))
    		return defNum;
    	int result = defNum;
    	try {
    		result = Integer.valueOf(str).intValue();
    	} catch (NumberFormatException e) {
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * 比较两个对象是否相等,首先判断是否为同一类型；其次判断是否为字符串型，如果为字符串型则判断两个字符串的值是否相等(大小写敏感),
     * 不为字符串型则调用Object.equals()方法比较两个对象
     * @param obj1
     * @param obj2
     * @return
     */
    public final static boolean equals(Object obj1,Object obj2) {
    	if (obj1.getClass() != obj2.getClass())
    		return false;
    	else if (String.class.isInstance(obj1)) {
    		return equals((String)obj1,(String)obj2);
    	} else
    		return obj1.equals(obj2);
    }
    
    /**
     * 检查两个字符串是否相等
     * @param txt1
     * @param txt2
     * @param flag: 1.true(忽略大小写) 2.false(大小写敏感)
     * @return boolean
     */
    public final static boolean equals(String txt1,String txt2,boolean isIgnoreCase)
    {
    	if (txt1 == txt2)
    		return true;
        if (isIgnoreCase)
        {
            txt1 = txt1.toLowerCase(Locale.getDefault());
            txt2 = txt2.toLowerCase(Locale.getDefault());
        }
        return txt1.intern() == txt2.intern();
    }
    
    /**
     * 检查两个字符串是否相等
     * @param txt1
     * @param txt2
     * @return boolean
     */
    public final static boolean equals(String txt1,String txt2)
    {
    	return equals(txt1,txt2,false);
    }
    
    /**
     * 去除字符串前后的逗号
     * @param str
     * @return
     */
    public static String cutStringComma(String str)
    {
    	if (str == null)
    		return str ;
    	
    	boolean hasCut = false ;
    	if (str.startsWith(","))
    	{
    		str = str.substring(1);
    		hasCut = true ;
    	}
    	
    	if (str.endsWith(","))
    	{
    		str = str.substring(0,str.length() - 1);
    		hasCut = true ;
    	}
    	
		return hasCut ? cutStringComma(str) : str;
    }
    /**
     * 获取文件扩展名
     * getExtension  
     * @param fileName
     * @return    
     * String   
     * @exception    
     * @since  1.0.0
     */
    public static String getExtension(String fileName) {
    	if (fileName.indexOf(".") != -1) {
    		int beginIndex = fileName.lastIndexOf(".");
    		return fileName.substring(beginIndex == fileName.length() ? 0 : beginIndex + 1,fileName.length());
    	} else {
    		return fileName;
    	}
    }
    /**
	 * 传入字符串反回当前数组信息 将字符串打断并放入String[]中
	 * 
	 * @param mass
	 * @return
	 */
	public static String[] splitStr(String mass, String split)
	{
		StringTokenizer st = new StringTokenizer(mass, split);
		String[] reuls = new String[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens())
		{
			reuls[i] = st.nextToken();
			i++;
		}
		return reuls;
	}

	/**
     * 将一个字符串数组转换为一个字符串
     * getRangeStr  
     * @param arr
     * @return    
     * String   
     * @exception    
     * @since  1.0.0
     */
    public static String getRangeStr(String[] arr) {
    	return getRangeStr(arr,"(",")");
	}
    
    /**
     * 将一个字符串数组转换为一个字符串
     * getRangeStr  
     * @param idList
     * @param str1
     * @param str2
     * @return    
     * String   
     * @exception    
     * @since  1.0.0
     */
    public static String getRangeStr(String[] arr,String str1,String str2) {
		return Arrays.toString(arr)
		  		     .replaceAll("\\[", getDefault(str1,""))
		  			 .replaceAll("\\]", getDefault(str2,""))
		  			 .replaceAll("\\s", "");
	}
    /**
     * 将一个字符串数组转换为一个字符串
     * getRangeStr  
     * @param idList
     * @param str1
     * @param str2
     * @return    
     * String   
     * @exception    
     * @since  1.0.0
     */
    public static String getRange(String[] arr,String str1,String str2) {
		return Arrays.toString(arr)
		  		     .replaceAll("\\[", getDefault(str1,""))
		  			 .replaceAll("\\]", getDefault(str2,""))
		  			 .trim();
	}
    /**
     * 由于自动带[]，所以需要去掉头和尾
     * @param arr
     * @return
     */
    public static String getRange(String[] arr) {
    	String temp = Arrays.toString(arr).trim().substring(1);
    	return temp.substring(0, temp.length() - 1);
	}
    
    //数组转化成list类型
    public static List<Long> stringToLongArray(String [] value){
		List<Long> ls = new ArrayList<Long> ();
		if(value == null){
			return ls;
		}
		for(int i = 0; i < value.length; i ++ ){
			try{
				if(StringUtil.isNumber(value[i])){
					ls.add(Long.parseLong(value[i]));
				}
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
		return ls;
	} 
}

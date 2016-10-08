package com.wondertek.mobilevideo.core.recommend.bean;


/**   
 *    
 * SortBean  
 *   
 * Creator: sunyue  
 * 2012-5-3 上午10:16:25  
 *   
 * @version 1.0.0  
 *    
 */
public class SortBean {
	private String property;
	private String direction;
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getDirection() {
		return direction == null || direction.equals("") ? "desc" : direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
}

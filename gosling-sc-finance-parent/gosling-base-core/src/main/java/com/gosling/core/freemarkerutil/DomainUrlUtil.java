package com.gosling.core.freemarkerutil;

/**
 * 
 * @类描述：系统资源
 * @项目名称：gosling-base-core
 * @包名： com.gosling.core.freemarkerutil
 * @类名称：DomainUrlUtil
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午3:02:04
 */
public class DomainUrlUtil {
    protected static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(DomainUrlUtil.class);

    public static String                     GOSLING_URL_RESOURCES;                
    public static String                     GOSLING_STATIC_RESOURCES;                    
    public static String                     GOSLING_IMAGE_RESOURCES;                      
    public static String                     GOSLING_ADMIN_URL;            
    public static String                     GOSLING_FRONT_URL;            
    public static String                     GOSLING_SHOP_URL;
    
    
	public static String getGOSLING_URL_RESOURCES() {
		return GOSLING_URL_RESOURCES;
	}
	public static void setGOSLING_URL_RESOURCES(String gOSLING_URL_RESOURCES) {
		GOSLING_URL_RESOURCES = gOSLING_URL_RESOURCES;
	}
	public static String getGOSLING_STATIC_RESOURCES() {
		return GOSLING_STATIC_RESOURCES;
	}
	public static void setGOSLING_STATIC_RESOURCES(String gOSLING_STATIC_RESOURCES) {
		GOSLING_STATIC_RESOURCES = gOSLING_STATIC_RESOURCES;
	}
	public static String getGOSLING_IMAGE_RESOURCES() {
		return GOSLING_IMAGE_RESOURCES;
	}
	public static void setGOSLING_IMAGE_RESOURCES(String gOSLING_IMAGE_RESOURCES) {
		GOSLING_IMAGE_RESOURCES = gOSLING_IMAGE_RESOURCES;
	}
	public static String getGOSLING_ADMIN_URL() {
		return GOSLING_ADMIN_URL;
	}
	public static void setGOSLING_ADMIN_URL(String gOSLING_ADMIN_URL) {
		GOSLING_ADMIN_URL = gOSLING_ADMIN_URL;
	}
	public static String getGOSLING_FRONT_URL() {
		return GOSLING_FRONT_URL;
	}
	public static void setGOSLING_FRONT_URL(String gOSLING_FRONT_URL) {
		GOSLING_FRONT_URL = gOSLING_FRONT_URL;
	}
	public static String getGOSLING_SHOP_URL() {
		return GOSLING_SHOP_URL;
	}
	public static void setGOSLING_SHOP_URL(String gOSLING_SHOP_URL) {
		GOSLING_SHOP_URL = gOSLING_SHOP_URL;
	}              

    

}

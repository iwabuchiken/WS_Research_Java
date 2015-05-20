
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;








// Apache
import org.apache.commons.lang.StringUtils;

// REF=> http://commons.apache.org/net/download_net.cgi
//REF=> http://www.searchman.info/tips/2640.html

//import org.apache.commons.net.ftp.FTPReply;

public class Methods {
	
	

//	/****************************************
//	 *	getMillSeconds_now()
//	 * 
//	 * <Caller> 
//	 * 1. ButtonOnClickListener # case main_bt_start
//	 * 
//	 * <Desc> 1. <Params> 1.
//	 * 
//	 * <Return> 1.
//	 * 
//	 * <Steps> 1.
//	 ****************************************/
	public static long getMillSeconds_now() {
		
		Calendar cal = Calendar.getInstance();
		
		return cal.getTime().getTime();
		
	}//private long getMillSeconds_now(int year, int month, int date)

	/******************************
		@return format => "yyyyMMdd_HHmmss"
	 ******************************/
	public static String get_TimeLabel(long millSec) {
		
		 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.JAPAN);
		 
		return sdf1.format(new Date(millSec));
		
	}//public static String get_TimeLabel(long millSec)

	public static String 
	perm(String target, String before, String after) {
//		public static String perm(String s1, String s2) {

		///////////////////////////////////
		//
		// validate
		//
		///////////////////////////////////
		if (before.length() != after.length()) {
			
			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] before/after => length not equal: %d/%d", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), 
					before.length(), after.length());

			System.out.println(msg);
			
			return null;
			
		}

		///////////////////////////////////
		//
		// report
		//
		///////////////////////////////////
		String msg;
		
//		String msg;
		msg = String.format(Locale.JAPAN, 
				"[%s : %d] ----------------- Starting perm... -------------", 
				Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber());

		System.out.println(msg);
		
		
		msg = String.format(Locale.JAPAN, "[%s : %d] target = %s / before = %s / after = %s", Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber(), target, before, after);

		System.out.println(msg);
		
		
		///////////////////////////////////
		//
		// map: 1
		//
		///////////////////////////////////
		String[] chars_Before = before.split("");
		chars_Before = Arrays.copyOfRange(chars_Before, 1, chars_Before.length);
		
		String[] chars_After = after.split("");
		chars_After = Arrays.copyOfRange(chars_After, 1, chars_After.length);
		
		Map<String , String> map_1 = new TreeMap<String, String>();
//		Map<String , String> map_1 = new HashMap<String, String>();
		
		for (int i = 0; i < chars_After.length; i++) {
			
			map_1.put(chars_Before[i], chars_After[i]);
			
		}
		
		//report
//		String msg;
		msg = String.format(Locale.JAPAN, 
				"[%s : %d] **************** map_1 ****************", 
				Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber());

		System.out.println(msg);
		
		Methods.report_Map(map_1);
		
		///////////////////////////////////
		//
		// map: 2
		//
		///////////////////////////////////
		String[] chars_Before_2 = target.split("");
		chars_Before_2 = Arrays.copyOfRange(chars_Before_2, 1, chars_Before_2.length);
		
//		String[] chars_After_2 = after.split("");
//		chars_After_2 = Arrays.copyOfRange(chars_After_2, 1, chars_After_2.length);
		
		Map<String , String> map_2 = new HashMap<String, String>();
		
		for (int i = 0; i < chars_Before_2.length; i++) {
			
			map_2.put(chars_Before_2[i], null);
			
		}
		
		//report
//		String msg;
		msg = String.format(Locale.JAPAN, "[%s : %d] *************** map_2 ***************", 
				Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber());

		System.out.println(msg);
		
		Methods.report_Map(map_2);
		
		///////////////////////////////////
		//
		// map: 2 => set value
		//
		///////////////////////////////////
		for (int i = 0; i < chars_Before_2.length; i++) {
			
			map_2.put(chars_Before_2[i], map_1.get(chars_Before_2[i]));
			
		}

		//report
//		String msg;
		msg = String.format(Locale.JAPAN, 
				"[%s : %d] *************** map_2 => values added ***************", 
				Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber());

		System.out.println(msg);
		
		Methods.report_Map(map_2);

		// sort
//		Collections.sort(list);
		Map<String, String> map_2_new = map_2;
//		Map<String, String> map_2_new = new TreeMap<String, String>(map_2);
		
//		msg = String.format(Locale.JAPAN, 
//				"[%s : %d] *************** map_2 => sorted ***************", 
//				Thread
//				.currentThread().getStackTrace()[1].getFileName(), Thread
//				.currentThread().getStackTrace()[1].getLineNumber());
//		
//		System.out.println(msg);
		
		
//		Methods.report_Map(map_2_new);
		
		///////////////////////////////////
		//
		// return
		//
		///////////////////////////////////
		StringBuilder sb = new StringBuilder();

		//REF http://beginnersbook.com/2013/12/how-to-sort-hashmap-in-java-by-keys-and-values/
		Set set = map_2_new.entrySet();
		
        Iterator it = set.iterator();
        
        Map.Entry me2 = null;
        
        while(it.hasNext()) {
        	
             me2 = (Map.Entry)it.next();
             
             sb.append(me2.getValue());
             
//             System.out.print(me2.getKey() + ": ");
//             
//             System.out.println(me2.getValue());
             
        }
		
        return sb.toString();
        
//		///////////////////////////////////
//		//
//		// s2: hash map
//		//
//		///////////////////////////////////
//		String[] chars = s2.split("");
//		chars = Arrays.copyOfRange(chars, 1, chars.length);
//
//	Map<String , Integer> map = new HashMap<String, Integer>();
//		
//		String s = null;
//		
//		for (int i = 0; i < chars.length; i++) {
//			
//			s = chars[i];
//			
//			map.put(s, i);
//			
//		}
//		
//		int index;
//
//		Set<String> set = map.keySet();
//		
//		Iterator<String> it = set.iterator();
		
//		//report
//		
//		while (it.hasNext()) {
//			
//			s = it.next();
//			
//			index = map.get(s);
//			
//			String msg;
//			msg = String.format(Locale.JAPAN, "[%s : %d] map: s = %s / index = %d", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), s, index);
//
//			System.out.println(msg);
//			
//			
//		}
		
//		return null;
		
	}

	/*******************************
	 * perm_V2<br>
	 * Example<br>
	 * before = "abc"<br>
	 * after = "acb"<br>
	 * target = "bac"<br>
	 * result = "cab"
	 *******************************/
	public static String 
	perm_V2(String target, String before, String after) {
//		public static String perm(String s1, String s2) {
		
		///////////////////////////////////
		//
		// validate
		//
		///////////////////////////////////
		if (before.length() != after.length()) {
			
			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] before/after => length not equal: %d/%d", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), 
					before.length(), after.length());
			
			System.out.println(msg);
			
			return null;
			
		}
		
		///////////////////////////////////
		//
		// report
		//
		///////////////////////////////////
		String msg;
		
//		String msg;
		msg = String.format(Locale.JAPAN, 
				"[%s : %d] ----------------- Starting perm... -------------", 
				Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber());
		
		System.out.println(msg);
		
		
		msg = String.format(Locale.JAPAN, "[%s : %d] target = %s / before = %s / after = %s", Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber(), target, before, after);
		
		System.out.println(msg);
		
		
		///////////////////////////////////
		//
		// map: 1
		//
		///////////////////////////////////
		String[] chars_Before = before.split("");
		chars_Before = Arrays.copyOfRange(chars_Before, 1, chars_Before.length);
		
		String[] chars_After = after.split("");
		chars_After = Arrays.copyOfRange(chars_After, 1, chars_After.length);
		
		Map<String , String> map_1 = new TreeMap<String, String>();
//		Map<String , String> map_1 = new HashMap<String, String>();
		
		for (int i = 0; i < chars_After.length; i++) {
			
			map_1.put(chars_Before[i], chars_After[i]);
			
		}
		
		//report
//		String msg;
		msg = String.format(Locale.JAPAN, 
				"[%s : %d] **************** map_1 ****************", 
				Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber());
		
		System.out.println(msg);
		
		Methods.report_Map(map_1);
		
		///////////////////////////////////
		//
		// map: 2
		//
		///////////////////////////////////
		String[] chars_Before_2 = target.split("");
		chars_Before_2 = Arrays.copyOfRange(chars_Before_2, 1, chars_Before_2.length);
		
		String[] chars_After_2 = new String[chars_Before_2.length];
		
		String s1 = null, s2 = null;
		
		for (int i = 0; i < chars_Before_2.length; i++) {
			
			s1 = chars_Before_2[i];
			
			s2 = map_1.get(s1);
			
			chars_After_2[i] = s2;
			
		}
		
		String target_new = StringUtils.join(chars_After_2, "");
		
//		String msg;
		msg = String.format(Locale.JAPAN, "[%s : %d] target_new => %s", Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber(), target_new);

		System.out.println(msg);
		
		
		///////////////////////////////////
		//
		// return
		//
		///////////////////////////////////
		return target_new;
		
//		StringBuilder sb = new StringBuilder();
//		
//		//REF http://beginnersbook.com/2013/12/how-to-sort-hashmap-in-java-by-keys-and-values/
//		Set set = map_2_new.entrySet();
//		
//		Iterator it = set.iterator();
//		
//		Map.Entry me2 = null;
//		
//		while(it.hasNext()) {
//			
//			me2 = (Map.Entry)it.next();
//			
//			sb.append(me2.getValue());
//			
////             System.out.print(me2.getKey() + ": ");
////             
////             System.out.println(me2.getValue());
//			
//		}
//		
//		return sb.toString();
		
	}
	
	public static void 
	report_Map(Map<String, String> map) {
		
		Set<String> set = map.keySet();
		
		Iterator<String> it = set.iterator();

		String val = null;
		
		String key = null;
		
		//report
		
		while (it.hasNext()) {
			
			key = it.next();
			
			val = map.get(key);
			
			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] map: key = %s / val = %s", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), key, val);

			System.out.println(msg);
			
			
		}

		
	}//report_Map(Map<String, String> map)
	
}//public class Methods

/*
 * [2014/09/02 10:12:47.283] [MainActv.java : 84] Starting MainActv...
 * 
 * 
 */

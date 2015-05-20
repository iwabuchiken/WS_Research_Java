
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
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
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

	
	

//	/******************************
//		@return
//			false => 1. No db file<br>
//	 ******************************/
//	public static boolean 
//	import_DB
//	(Activity actv, Dialog dlg1) {
//		
//		
//		////////////////////////////////
//
//		// setup: src, dst
//
//		////////////////////////////////
//		// IFM10
//		String src_dir = CONS.DB.dPath_dbFile_backup_IFM10;
////		String src_dir = CONS.DB.dPath_dbFile_backup;
//		
//		File f_dir = new File(src_dir);
//		
//		File[] src_dir_files = f_dir.listFiles();
//		
//		// If no files in the src dir, quit the method
//		if (src_dir_files.length < 1) {
//			
//			// Log
//			Log.d("Methods.java" + "["
//					+ Thread.currentThread()
//						.getStackTrace()[2].getLineNumber()
//					+ "]", "No files in the dir: " + src_dir);
//			
//			return false;
//			
//		}//if (src_dir_files.length == condition)
//		
//		// Latest file
//		File f_src_latest = src_dir_files[0];
//		
//		
//		for (File file : src_dir_files) {
//			
//			if (f_src_latest.lastModified() < file.lastModified()) {
//						
//				f_src_latest = file;
//				
//			}//if (variable == condition)
//			
//		}//for (File file : src_dir_files)
//		
//		// Show the path of the latest file
//		// Log
//		Log.d("Methods.java" + "["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//				+ "]", "f_src_latest=" + f_src_latest.getAbsolutePath());
//		
//		////////////////////////////////
//
//		// Restore file
//
//		////////////////////////////////
//		String src = f_src_latest.getAbsolutePath();
//		
//		String dst = StringUtils.join(
//				new String[]{
//						//REF http://stackoverflow.com/questions/9810430/get-database-path answered Jan 23 at 11:24
//						actv.getDatabasePath(CONS.DB.dbName).getPath()
//				},
////						actv.getFilesDir().getPath() , 
////						CONS.DB.dbName},
//				File.separator);
//		
//		// Log
//		String msg_Log = "db path => " 
//					+ actv.getDatabasePath(CONS.DB.dbName).getPath();
//		Log.d("Methods.java" + "["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//				+ "]", msg_Log);
//		
//		////////////////////////////////
//
//		// build: db file path (dst)
//
//		////////////////////////////////
//		String tmp_str = Methods.get_Dirname(actv, dst);
//		
//		String dst_New = StringUtils.join(
//					new String[]{
//							
//							tmp_str,
//							CONS.DB.dbName_IFM10
//							
//					}, 
//					File.separator);
//		
//		// Log
//		msg_Log = String.format(Locale.JAPAN,
//							"src = %s // dst = %s", 
//							src, dst_New);
//		
//		Log.d("Methods.java" + "["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//				+ "]", msg_Log);
//		
//		////////////////////////////////
//
//		// import (using restoration-related method)
//
//		////////////////////////////////
//		boolean res = Methods.restore_DB(
//							actv, 
//							CONS.DB.dbName, 
//							src, dst_New);
//		
//		// Log
//		Log.d("MainActv.java" + "["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//				+ "]", "res=" + res);
//		
//		////////////////////////////////
//
//		// dismiss: dlg
//
//		////////////////////////////////
//		dlg1.dismiss();
//		
//		////////////////////////////////
//
//		// return
//
//		////////////////////////////////
//		return res;
//
////		return false;
//		
//	}//import_DB
//
//	/******************************
//		@return
//			false => 1. No db file<br>
//	 ******************************/
//	public static boolean 
//	import_DB
//	(Activity actv, String fpath_DB) {
//		
//		////////////////////////////////
//		
//		// Restore file
//		
//		////////////////////////////////
//		String src = fpath_DB;
//		
//		String dst = actv.getDatabasePath(CONS.DB.dbName).getPath();
//		
//		// Log
//		String msg_Log = "db path => " 
//				+ actv.getDatabasePath(CONS.DB.dbName).getPath();
//		Log.d("Methods.java" + "["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//				+ "]", msg_Log);
//		
//		////////////////////////////////
//		
//		// build: db file path (dst)
//		
//		////////////////////////////////
//		String tmp_str = Methods.get_Dirname(actv, dst);
//		
//		String dst_New = StringUtils.join(
//				new String[]{
//						
//						tmp_str,
//						CONS.DB.dbName_Previous
//						
//				}, 
//				File.separator);
//		
//		// Log
//		msg_Log = String.format(Locale.JAPAN,
//				"src = %s // dst = %s", 
//				src, dst_New);
//		
//		Log.d("Methods.java" + "["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//				+ "]", msg_Log);
//		
//		////////////////////////////////
//		
//		// import (using restoration-related method)
//		
//		////////////////////////////////
////		boolean res = true;
//		boolean res = Methods.restore_DB(
//				actv, 
//				CONS.DB.dbName, 
//				src, dst_New);
//		
//		// Log
//		Log.d("MainActv.java" + "["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//				+ "]", "res=" + res);
//		
//		////////////////////////////////
//		
//		// return
//		
//		////////////////////////////////
//		return res;
//		
////		return false;
//		
//	}//import_DB


}//public class Methods

/*
 * [2014/09/02 10:12:47.283] [MainActv.java : 84] Starting MainActv...
 * 
 * 
 */

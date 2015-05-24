
package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;












import com.opencsv.CSVReader;











import com.opencsv.CSVWriter;



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
		
		//REF http://tutorialswithexamples.com/java-map-and-hashmap-tutorial-with-examples/
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

	/*******************************
	 * R.55<br>
	 * @return
	 * String[][]
	 *******************************/
	public static String[][]
	swap_RowCol(String fpath) {
		
		try {
			
			//REF http://howtodoinjava.com/2014/08/12/parse-read-write-csv-files-opencsv-tutorial/#read
			//REF referer http://stackoverflow.com/questions/101100/csv-api-for-java answered Sep 19 '08 at 21:10
			CSVReader r = new CSVReader(new FileReader(fpath));
			
			String[] nextLine;
			
			List<String[]> list_Orig = new ArrayList<String[]>();
			
			int count = 0;
			
			while ((nextLine = r.readNext()) != null) {
				
				if (nextLine != null) {
					//Verifying the read data here
//						System.out.println(Arrays.toString(nextLine));

					list_Orig.add(nextLine);
					
					count ++;
					
					String msg;
					msg = String.format(Locale.JAPAN, "[%s : %d] line %d: %d columns", Thread
							.currentThread().getStackTrace()[1].getFileName(),
							Thread.currentThread().getStackTrace()[1]
									.getLineNumber(), count, nextLine.length);
	
					System.out.println(msg);
				
					
				}
			}
		
			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] csv list => %d", Thread
//					msg = String.format(Locale.JAPAN, "[%s : %d] csv lines => %d", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), list_Orig.size());
//			.currentThread().getStackTrace()[1].getLineNumber(), count);

			System.out.println(msg);
			
			///////////////////////////////////
			//
			// swap
			//
			///////////////////////////////////
			int numOf_Cols = list_Orig.get(0).length;
			
//			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] numOf_Cols = %d", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), numOf_Cols);

			System.out.println(msg);
			
			String[][] ary_new = new String[numOf_Cols][list_Orig.size()];

			String[] tmp;
			
			for (int i = 0; i < list_Orig.size(); i++) {
				
				tmp = list_Orig.get(i);
				
				for (int j = 0; j < numOf_Cols; j++) {
					
					ary_new[j][i] = tmp[j];
//					ary_new[j][i] = tmp[i];
					
				}
				
			}

			//report
			Methods.report_Array_MultiDim(ary_new);
			
			///////////////////////////////////
			//
			// msg
			//
			///////////////////////////////////
			r.close();
			
			return ary_new;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
			
		}
		
	}//swap_RowCol(String fpath)

	private static void 
	report_Array_MultiDim(String[][] ary_new) {
		// TODO Auto-generated method stub

		int numOf_Rows = ary_new.length;
		int numOf_Cols = ary_new[0].length;
		
		String msg;
		msg = String.format(Locale.JAPAN, "[%s : %d] ary_new: rows %d / cols %d", Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber(), 
				numOf_Rows, numOf_Cols);
		
				//=> year/211863427/378699/337898/66280/166643
		
	//	0, StringUtils.join(list_Orig.get(0), "/"));
	
		System.out.println(msg);

		///////////////////////////////////
		//
		// contents
		//
		///////////////////////////////////
		for (int i = 0; i < numOf_Rows; i++) {
			
//			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] row[%d] = %s", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), 
					i, StringUtils.join(ary_new[i], ","));

			System.out.println(msg);
			
			
		}
		
		
	}

	
	public static int 
	create_CSV(String[][] ary_new, String fpath_Dst) {
		// TODO Auto-generated method stub
		
		try {
			
			CSVWriter w = new CSVWriter(new FileWriter(fpath_Dst));
			
			///////////////////////////////////
			//
			// prep: list
			//
			///////////////////////////////////
			List<String[]> list = new ArrayList<String[]>();
			
			int numOf_Rows = ary_new.length;
			
			String[] line;
			
			for (int i = 0; i < numOf_Rows; i++) {
				
				line = ary_new[i];
				
				list.add(line);
				
			}
			
//			String msg;
//			msg = String.format(Locale.JAPAN, "[%s : %d] list built => %d lines", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), list.size());
//
//			System.out.println(msg);
			
			///////////////////////////////////
			//
			// write
			//
			///////////////////////////////////
			w.writeAll(list);

			boolean res = w.checkError();
			
			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] write all => %s", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), res);

			System.out.println(msg);
			
			w.close();
			
			return 0;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return -1;
			
		}
		
	}//create_CSV(String[][] ary_new, String fpath_Dst)

	/*******************************
	 * prettify: http://www.customs.go.jp/toukei/suii/html/data/d61fa.csv
	 *******************************/
	public static void ops_V_1_2__Imports() {
		// TODO Auto-generated method stub
		///////////////////////////////////
		//
		// vars
		//
		///////////////////////////////////
		String dpath = "data";
		
		String fname_Src_trunk = "R.55.#6.imports";
//		String fname_Src_trunk = "R.78.v_1_1.LNG-price";
		
		String ext = ".csv";
//		String ext = ".txt";
		
		String fname_Dst_trunk = fname_Src_trunk + ".PROCESSED";
//		String fname_Dst_trunk = fname_Src_trunk + "PROCESSED";
		
		String fpath_Src = dpath + "/" + fname_Src_trunk + ext;
		
		String fpath_Dst = dpath + "/" + fname_Dst_trunk + ext;
		
		String fpath_Dst_csv = dpath + "/" + fname_Dst_trunk + ".CSV" + ext;
		
		///////////////////////////////////
		//
		// read csv
		//
		///////////////////////////////////
		try {
			
			CSVReader r = new CSVReader(new FileReader(fpath_Src), '\t');
//			CSVReader r = new CSVReader(new FileReader(fpath_Src));

			///////////////////////////////////
			//
			// names
			//
			///////////////////////////////////
			int skipp = 4;
//			int skipp = 2;
//			int skipp = 3;
			
			for (int i = 0; i < skipp; i++) r.readNext();

			String[] cols = r.readNext();	// 報道発表品目名

//			cols[0] = "Years";
			
			String[] cols_Target = Arrays.copyOfRange(cols, 0, cols.length - 1);
//			String[] cols_Target = Arrays.copyOfRange(cols, 1, cols.length - 1);
//			String[] cols_Target = Arrays.copyOfRange(cols, 1, cols.length);
			
//			for (int i = 0; i < cols_Target.length; i++) {
//				
//				String msg;
//				msg = String.format(Locale.JAPAN, "[%s : %d] cols_Target[%d] = %s", Thread
//						.currentThread().getStackTrace()[1].getFileName(),
//						Thread.currentThread().getStackTrace()[1]
//								.getLineNumber(), i, cols_Target[i]);
//
//				System.out.println(msg);
//				
//				
//			}
			
//			String msg;
//			msg = String.format(Locale.JAPAN, "[%s : %d] cols_Target => %d", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), cols_Target.length);
//
//			System.out.println(msg);
			
			
			///////////////////////////////////
			//
			// build: data
			//
			///////////////////////////////////
			List<String[]> list = new ArrayList<String[]>();
			
			list.add(cols_Target);

//			//
//			cols = r.readNext();	// 概況品名
//
//			cols_Target = Arrays.copyOfRange(cols, 0, cols.length - 1);
//			
//			list.add(cols_Target);
			
			// data
			skipp = 3;
			
			for (int i = 0; i < skipp; i++) r.readNext();
			
			cols = r.readNext();
			
			String[] cols_new = null;
			
			int numOf_cols;
			
			int j = 1;	// index for cols_new
			
			//debug
			if (cols != null) {
				
				for (int i = 0; i < cols.length; i++) {
					
					String msg;
					msg = String.format(Locale.JAPAN, "[%s : %d] cols[%d] = %s", Thread
							.currentThread().getStackTrace()[1].getFileName(),
							Thread.currentThread().getStackTrace()[1]
									.getLineNumber(), i, cols[i]);

					System.out.println(msg);
					
				}
				
			} else {
				
				String msg;
				msg = String.format(Locale.JAPAN, "[%s : %d] cols => null", Thread
						.currentThread().getStackTrace()[1].getFileName(),
						Thread.currentThread().getStackTrace()[1]
								.getLineNumber());

				System.out.println(msg);
				
			}
			
			///////////////////////////////////
			//
			// data: 1st line
			//
			///////////////////////////////////
			while(cols != null) {
				j = 1;
				
				numOf_cols = cols.length;
				
				cols_new = new String[numOf_cols/2 + 2];
				
				cols_new[0] = cols[0];
				
				for (int i = 1; i < numOf_cols; i++) {
			//		for (int i = 1; i < numOf_cols - 1; i++) {
			//		for (int i = 1; i < numOf_cols; i++) {
					
					if (i % 2 == 1) {
	//					if (i % 2 == 0) {
						
						cols_new[j] = cols[i];
	
						String msg;
						msg = String.format(Locale.JAPAN, "[%s : %d] add: cols_new[%d] = %s", Thread
								.currentThread().getStackTrace()[1].getFileName(),
								Thread.currentThread().getStackTrace()[1]
										.getLineNumber(), j, cols_new[j]);
	
						System.out.println(msg);
						
						
						j ++;
						
						
					}
					
				}//for (int i = 1; i < numOf_cols; i++)
				
				list.add(cols_new);
			
				// next line
				cols = r.readNext();
				
			}//while(cols != null)
			
//			while(cols != null) {
//				
//				// init j
//				j = 1;
//				
//				numOf_cols = cols.length;
//				
//				String msg;
//				msg = String.format(Locale.JAPAN, "[%s : %d] numOf_cols = %d", Thread
//						.currentThread().getStackTrace()[1].getFileName(),
//						Thread.currentThread().getStackTrace()[1]
//								.getLineNumber(), numOf_cols);
//
//				System.out.println(msg);
//				
//				
//				cols_new = new String[numOf_cols/2 + 2];	// half of the cols + "year" col
////				cols_new = new String[numOf_cols/2 + 1];	// half of the cols + "year" col
//				
////				String msg;
//				msg = String.format(Locale.JAPAN, 
//						"[%s : %d] length: cols = %d, cols_new = %d, numOf_cols = %d", 
//						Thread.currentThread().getStackTrace()[1].getFileName(),
//						Thread.currentThread().getStackTrace()[1]
//								.getLineNumber(), 
//						cols.length, cols_new.length, numOf_cols);
//
//				System.out.println(msg);
//				
//				
//				cols_new[0] = cols[0];
//				
//				for (int i = 1; i < numOf_cols; i++) {
////					for (int i = 1; i < numOf_cols - 1; i++) {
////					for (int i = 1; i < numOf_cols; i++) {
//					
//					if (i % 2 == 0) {
//						
//						cols_new[j] = cols[i];
//							
//						j ++;
//						
////						String msg;
//						msg = String.format(Locale.JAPAN, "[%s : %d] i = %d, j = %d",
//								Thread.currentThread().getStackTrace()[1]
//										.getFileName(), Thread.currentThread()
//										.getStackTrace()[1].getLineNumber(),
//								i, j);
//
//						System.out.println(msg);
//						
//						
//					}
//					
//				}
//				
//				// add cols
//				list.add(cols_new);
//				
//				// next line
//				cols = r.readNext();
//				
//			}//while(cols != null)
			
//			String msg;
//			msg = String.format(Locale.JAPAN, "[%s : %d] cols_new(1) => %d", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), list.get(1).length);
//
//			System.out.println(msg);
//			
//			msg = String.format(Locale.JAPAN, "[%s : %d] cols_new(10) => %d", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), list.get(10).length);
//			
//			System.out.println(msg);
//			
//			msg = String.format(Locale.JAPAN, "[%s : %d] list => %d", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), list.size());
//			
//			System.out.println(msg);
//			
//			int tmp = list.get(10).length;
//			
//			String[] tmp_ary = list.get(10);
//			
//			for (int i = 0; i < tmp; i++) {
//				
////				String msg;
//				msg = String.format(Locale.JAPAN, "[%s : %d] list.get(10) col[%d] = %s", Thread
//						.currentThread().getStackTrace()[1].getFileName(),
//						Thread.currentThread().getStackTrace()[1]
//								.getLineNumber(), i, tmp_ary[i]);
//
//				System.out.println(msg);
//				
//				
//			}
			
			
			///////////////////////////////////
			//
			// close
			//
			///////////////////////////////////
			r.close();

			
			
			///////////////////////////////////
			//
			// save: data
			//
			///////////////////////////////////
			CSVWriter w = new CSVWriter(new FileWriter(fpath_Dst_csv), '\t');
//			CSVWriter w = new CSVWriter(new FileWriter(fpath_Dst_csv), '\t');
//			CSVWriter w = new CSVWriter(new FileWriter(fpath_Dst_csv));
			
			w.writeAll(list);
			
			w.close();
			
			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] csv => written: %s", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), fpath_Dst_csv);

			System.out.println(msg);
			
			
//			int skipp = 7;		// first X lines to omit
//			
//			for (int i = 0; i < skipp; i++) {
//				
//				r.readNext();
//				
//			}
//			
//			String[] cols = r.readNext();
//			
//			String msg;
//			msg = String.format(Locale.JAPAN, "[%s : %d] cols => %d", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), cols.length);
//
//			System.out.println(msg);
			
//			for (int i = 0; i < 10; i++) {
//				
////				String msg;
//				msg = String.format(Locale.JAPAN, "[%s : %d] col[%d] = %s", Thread
//						.currentThread().getStackTrace()[1].getFileName(),
//						Thread.currentThread().getStackTrace()[1]
//								.getLineNumber(), i, cols[i]);
//
//				System.out.println(msg);
//				
//				
//			}
			
////			String msg;
//			msg = String.format(Locale.JAPAN, "[%s : %d] csv => closed", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber());
//
//			System.out.println(msg);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		///////////////////////////////////
//		//
//		// swap
//		//
//		///////////////////////////////////
//		String[][] ary_new = Methods.swap_RowCol(fpath_Dst);
//		
		///////////////////////////////////
		//
		// validate
		//
		///////////////////////////////////
		
//		if (ary_new == null) {
//			
//			String msg;
//			msg = String.format(Locale.JAPAN, "[%s : %d] ary_new => null", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber());
//			
//			System.out.println(msg);
//			
//			return;
//			
//		}
		
		///////////////////////////////////
		//
		// new csv
		//
		///////////////////////////////////
//		String keyword = "SWPPED";
		
//		String fpath_Dst_csv = dpath + "/" + fname + "." + keyword + ext;
		//String fpath_Dst = "data/R.55.oil.SWPPED.csv";
		
//		Methods.create_CSV(ary_new, fpath_Dst_csv);
		
	}//ops_V_1_2__Imports

}//public class Methods

/*
 * [2014/09/02 10:12:47.283] [MainActv.java : 84] Starting MainActv...
 * 
 * 
 */

package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import utils.Methods;

public class R_78 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Methods.ops_V_1_2__Imports();
		ops_V_1_2__Imports();
//		ops_V_1_2();
		
//		ops_V_1_1();
		
//		ops();

//		ops_residue();
		
	}

	/*******************************
	 * swap rows/cols
	 *******************************/
	private static void ops_V_1_2() {
		// TODO Auto-generated method stub
		///////////////////////////////////
		//
		// vars
		//
		///////////////////////////////////
		String dpath = "data";
		
		String fname_Src_trunk = "R.55.oil.chart";
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
		// swap
		//
		///////////////////////////////////
		String[][] ary_new = Methods.swap_RowCol(fpath_Dst);
		
		///////////////////////////////////
		//
		// validate
		//
		///////////////////////////////////
		
		if (ary_new == null) {
		
			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] ary_new => null", Thread
			.currentThread().getStackTrace()[1].getFileName(), Thread
			.currentThread().getStackTrace()[1].getLineNumber());
			
			System.out.println(msg);
			
			return;
		
		}
		
		///////////////////////////////////
		//
		// new csv
		//
		///////////////////////////////////
//		String keyword = "SWPPED";
		
//		String fpath_Dst_csv = dpath + "/" + fname + "." + keyword + ext;
		//String fpath_Dst = "data/R.55.oil.SWPPED.csv";
		
		Methods.create_CSV(ary_new, fpath_Dst_csv);

	}
	
	/*******************************
	 * prettify: http://www.customs.go.jp/toukei/suii/html/data/d61fa.csv
	 *******************************/
	private static void ops_V_1_2__Imports() {
		// TODO Auto-generated method stub
		
//		Methods.ops_V_1_2__Imports();

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
		// swap
		//
		///////////////////////////////////
		
		String[][] ary_new = Methods.swap_RowCol(fpath_Dst_csv);

		///////////////////////////////////
		//
		// validate
		//
		///////////////////////////////////
		
		if (ary_new == null) {
			
			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] ary_new => null", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber());

			System.out.println(msg);
			
			return;
			
		}
		
		///////////////////////////////////
		//
		// new csv
		//
		///////////////////////////////////
		String keyword = "SWPPED";
		
//		String fpath_Dst_swapped = dpath + "/" + fname_Dst_trunk + ".CSV" + "." + keyword + ext;
		String fpath_Dst_swapped = dpath + "/" + fname_Dst_trunk + "." + keyword + ext;
//		String fpath_Dst = "data/R.55.oil.SWPPED.csv";
		
		Methods.create_CSV(ary_new, fpath_Dst_swapped);

		
//		Methods.swap_RowCol(fpath)
		
	}//ops_V_1_2__Imports
	

	/*******************************
	 * for: data in http://ecodb.net/pcp/imf_group_ngas.html
	 *******************************/
	private static void ops_V_1_1() {
		// TODO Auto-generated method stub

		///////////////////////////////////
		//
		// vars
		//
		///////////////////////////////////
		String dpath = "data";
		
		String fname_Src_trunk = "R.55.oil.chart";
//		String fname_Src_trunk = "R.78.v_1_1.LNG-price";
		
		String ext = ".csv";
//		String ext = ".txt";
		
		String fname_Dst_trunk = fname_Src_trunk + ".PROCESSED";
//		String fname_Dst_trunk = fname_Src_trunk + "PROCESSED";
		
		String fpath_Src = dpath + "/" + fname_Src_trunk + ext;

		String fpath_Dst = dpath + "/" + fname_Dst_trunk + ext;

		///////////////////////////////////
		//
		// processes
		//
		///////////////////////////////////
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(fpath_Src));
			
//			String line = br.readLine();		// 1st line (header)

			String line = null;
			
			int counter = 0, tmp_i, res;
			
			String[] list = new String[4];
			
			// init
			for(int i = 0; i < 4; i ++) list[i] = "";
			
			///////////////////////////////////
			//
			// first 4 lines
			//
			///////////////////////////////////
			for (int i = 0; i < 4; i++) {
				
				list[i] += br.readLine();
				
			}
			
			///////////////////////////////////
			//
			// lines: 2nd ~
			//
			///////////////////////////////////
			line = br.readLine();
			
			String[] splits = null;
			
			while (line != null) {
				
				splits = line.split("\t");
				
//				list[counter] += "\t" + StringUtils.join(
//						Arrays.copyOfRange(splits, 1, splits.length), "\t");
//				list[counter] += "\t" + line;
				
				if (counter % 4 == 3) {
//					if (counter >= 3) {
//					if ((counter % 3) == 0) {
//					if (tmp_i == 0) {
					
//					splits = line.split("\t");
					
					list[counter] += "\t" + StringUtils.join(
										Arrays.copyOfRange(splits, 1, splits.length), "\t");
//					list[counter] += "\t" + StringUtils.join(splits, "\t");
//					list[counter] += "\t" + line;
					
					counter = 0;
					
					String msg;
					msg = String.format(Locale.JAPAN, "[%s : %d] line => %s", Thread
							.currentThread().getStackTrace()[1].getFileName(),
							Thread.currentThread().getStackTrace()[1]
									.getLineNumber(), 
							StringUtils.join(
									Arrays.copyOfRange(splits, 1, splits.length), "\t"));

					System.out.println(msg);
					
					
//					tokens = new String[4];
					
				} else {
					
					list[counter] += "\t" + StringUtils.join(
							Arrays.copyOfRange(splits, 1, splits.length), "\t");
					
					counter ++;
					
				}
				
				// new line
				line = br.readLine();
				
			}
			
			br.close();
			
			///////////////////////////////////
			//
			// data => save
			//
			///////////////////////////////////
//			String[] tmp_ary = null;
//			
//			String tmp_s = null;
//			
			BufferedWriter bw = new BufferedWriter(new FileWriter(fpath_Dst));
			
			for (int i = 0; i < list.length; i++) {
				
//				tmp_ary = list.get(i);
				
//				tmp_s = StringUtils.join(tmp_ary, "\t");
				
				bw.write(list[i]);
				
				bw.write("\n");
				
			}
			
			bw.close();
			
			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] bw => closed", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber());

			System.out.println(msg);
			
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}//try

	}//private static void ops_V_1_1()

	private static void ops_residue() {
		// TODO Auto-generated method stub

		int a = 0, b = 4;
		
		String msg;
		
		for (int i = 0; i < 10; i++) {
			
			msg = String.format(Locale.JAPAN, "[%s : %d] i = %d, b = %d => i %% b = %d", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), i, b, i % b);
			
			System.out.println(msg);
			
		}
		
		
		
	}

	/*******************************
	 * R.78.new_energy.txt => R.78.new_energy.PROCESSED.txt
	 *******************************/
	private static void ops() {
		// TODO Auto-generated method stub
		
		String dpath = "data";
		
		String fname_Src = "R.78.new_energy.txt";
		
		String fname_Dst = "R.78.new_energy.PROCESSED.txt";
		
		String fpath_Src = dpath + "/" + fname_Src;

		String fpath_Dst = dpath + "/" + fname_Dst;
		
		try {
			
			List<String[]> list = new ArrayList<String[]>();
			
			BufferedReader br = new BufferedReader(new FileReader(fpath_Src));
			
			String line = br.readLine();		// 1st line (header)

			list.add(new String[]{line});
			
			line = br.readLine();		// 1st data line
			
			int counter = 0, tmp_i, res;
			
			String[] tokens = new String[4];
			
			while (line != null) {
				
//				counter ++;
//				
//				tmp_i = counter % 4;
				
				tokens[counter] = line;
				
//				res = counter % 3;
				
//				String msg;
//				msg = String.format(Locale.JAPAN, "[%s : %d] res => %d (counter = %d)", Thread
//						.currentThread().getStackTrace()[1].getFileName(),
//						Thread.currentThread().getStackTrace()[1]
//								.getLineNumber(), res, counter);
//
//				System.out.println(msg);
				
				
				if (counter >= 3) {
//					if ((counter % 3) == 0) {
//					if (tmp_i == 0) {
					
					list.add(tokens);
					
					counter = 0;
					
					String msg;
					msg = String.format(Locale.JAPAN, "[%s : %d] tokens added => %s", Thread
							.currentThread().getStackTrace()[1].getFileName(),
							Thread.currentThread().getStackTrace()[1]
									.getLineNumber(), line);

					System.out.println(msg);
					
					
					tokens = new String[4];
					
				} else {
					
					counter ++;
					
				}
				
				// new line
				line = br.readLine();
				
			}
			
			br.close();
			
			///////////////////////////////////
			//
			// data => save
			//
			///////////////////////////////////
			String[] tmp_ary = null;
			
			String tmp_s = null;
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(fpath_Dst));
			
			for (int i = 0; i < list.size(); i++) {
				
				tmp_ary = list.get(i);
				
				tmp_s = StringUtils.join(tmp_ary, "\t");
				
				bw.write(tmp_s);
				
				bw.write("\n");
				
			}
			
			bw.close();
			
			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] bw => closed", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber());

			System.out.println(msg);
			
			
			///////////////////////////////////
			//
			// message
			//
			///////////////////////////////////
//			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] closed", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber());

			System.out.println(msg);
			
			msg = String.format(Locale.JAPAN, "[%s : %d] list => %d", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber()
					, list.size()
					);
			
			System.out.println(msg);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package main;

import java.util.Locale;

import utils.Methods;

public class R_55 {

	private static String fname = "R.78.facil.Nihon-tennen";
//	private static String fname = "R.78.facil.Kanto";
//	private static String fname = "R.78.facilities";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ops_1();
		
//		String fpath = "data/R.55.oil.csv";
////		String fpath = "/data/R.55.oil.csv";
//		
//		///////////////////////////////////
//		//
//		// swap
//		//
//		///////////////////////////////////
//		String[][] ary_new = Methods.swap_RowCol(fpath);
//
//		///////////////////////////////////
//		//
//		// validate
//		//
//		///////////////////////////////////
//		
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
		
		
	}

	private static void ops_1() {
		// TODO Auto-generated method stub

//		String fname = "R.78.facilities";
		
		String ext = ".csv";
		
		String dpath = "data";
		
		String fpath = dpath + "/" + fname + ext;
		
//		String fpath = "data/R.55.oil.csv";
//		String fpath = "/data/R.55.oil.csv";
		
		///////////////////////////////////
		//
		// swap
		//
		///////////////////////////////////
		String[][] ary_new = Methods.swap_RowCol(fpath);

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
		
		String fpath_Dst = dpath + "/" + fname + "." + keyword + ext;
//		String fpath_Dst = "data/R.55.oil.SWPPED.csv";
		
		Methods.create_CSV(ary_new, fpath_Dst);

	}//private static void ops_1()

}

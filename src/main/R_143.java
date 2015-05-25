package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import utils.Methods;

public class R_143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ops_V_1_0();
		
	}

	private static void 
	ops_V_1_0() {
		// TODO Auto-generated method stub
	
		int[] a1 = {1,2,3,4,5,6};
		int[] a2 = {1,2,3,4,5,6};
		
		int[] res = new int[36];
		
		int count = 0;
		
		for (int i = 0; i < 6; i++) {

			for (int j = 0; j < 6; j++) {
				
				res[count] = a1[i]*a2[j];
				
				count ++;
				
			}
			
		}
		
		//report
		int len = res.length;
		
		for (int i = 0; i < len; i++) {
			
			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] res[%d] = %d", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), i, res[i]);

			System.out.println(msg);
			
			
		}
		
		///////////////////////////////////
		//
		// sort
		//
		///////////////////////////////////
		Arrays.sort(res);

		//report
		String msg;
		msg = String.format(Locale.JAPAN, "[%s : %d] ----------- sorted -----------\n", Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber());

		System.out.println(msg);
		
		for (int i = 0; i < len; i++) {
			
//			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] res[%d] = %d", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), i, res[i]);

			System.out.println(msg);
			
			
		}

		///////////////////////////////////
		//
		// unique
		//
		///////////////////////////////////
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < len; i++) {
			
			set.add(res[i]);
			
		}

//		// sort
//		Object[] tmp_i = set.toArray();
		
		
		
		//report
		int len_set = set.size();
		
		Iterator it = set.iterator();

		int num;
		
		while (it.hasNext()) {
			
			num = (int) it.next();
			
//			String msg;
			msg = String.format(Locale.JAPAN, "[%s : %d] set = %d", Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), num);

			System.out.println(msg);
			
			
		}
		
		
	}

	

}

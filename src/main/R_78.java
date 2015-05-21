package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

public class R_78 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ops();
		
	}

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

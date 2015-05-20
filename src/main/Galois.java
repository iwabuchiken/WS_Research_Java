package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import utils.Methods;

public class Galois {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		///////////////////////////////////
		//
		// ops
		//
		///////////////////////////////////
		ops_1();
		
//		String target = "ブレオ";
//		String s1 = "オブレ";
//		String s2 = "レオブ";
//		String target = "bac";
//		String s1 = "abc";
//		String s2 = "bca";
//
//		Methods.perm(target, s1, s2);
		
//		String str = "abc";
//		
//		permu(str);
////		permu("abcde");
//		
//		///////////////////////////////////
//		//
//		// ops: 2
//		//
//		///////////////////////////////////
//		Set<String> perm = permutationFinder(str);
//		
//		List<String> list = new ArrayList<String>();
//		
//		Iterator<String> it = perm.iterator();
//		
//		String s = null;
//		
//		while (it.hasNext()) {
//
//			s = it.next();
//			
////			String msg;
////			msg = String.format(Locale.JAPAN, "[%s : %d] s = %s", Thread
////					.currentThread().getStackTrace()[1].getFileName(), Thread
////					.currentThread().getStackTrace()[1].getLineNumber(), s);
////
////			System.out.println(msg);
//			
//			list.add(s);
//			
////			String s = (String) it
//			
//		}
//
//		// sort
//		Collections.sort(list);
//		
//		for (int i = 0; i < list.size(); i++) {
//			
//			s = list.get(i);
//			
//			String msg;
//			msg = String.format(Locale.JAPAN, "[%s : %d] s = %s", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), s);
//
//			System.out.println(msg);
//			
//			
//		}
		
		
		///////////////////////////////////
		//
		// ending
		//
		///////////////////////////////////
		String msg;
		msg = String.format(Locale.JAPAN, "[%s : %d] yes", Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber());

		System.out.println(msg);
		
		
		
	}

	public static void ops_1() {

		///////////////////////////////////
		//
		// abc/acb
		//
		///////////////////////////////////
		String target = "bac";
		
		String s1 = "abc";
		String s2 = "acb";

		String msg;
//		msg = String.format(Locale.JAPAN, "[%s : %d] target => %s / result => %s", Thread
//				.currentThread().getStackTrace()[1].getFileName(), Thread
//				.currentThread().getStackTrace()[1].getLineNumber(), 
//				target, res);
//		String msg;
		msg = String.format(Locale.JAPAN, "[%s : %d] ############### abc/acb ###############", 
				Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber());

		System.out.println(msg);
		
		String res = Methods.perm(target, s1, s2);
		
		
		msg = String.format(Locale.JAPAN, 
				"[%s : %d] (s1=%s, s2=%s)target => %s / result => %s", 
					Thread
					.currentThread().getStackTrace()[1].getFileName(), Thread
					.currentThread().getStackTrace()[1].getLineNumber(), 
					s1, s2, target, res);

		System.out.println(msg);

		///////////////////////////////////
		//
		// abc/bca * abc/bac
		//
		///////////////////////////////////
		msg = String.format(Locale.JAPAN, 
				"[%s : %d] ############### abc/bca * abc/bac ###############", 
				Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber());

		System.out.println(msg);

		s1 = "abc";
		s2 = "bca";

		res = Methods.perm(target, s1, s2);
		
//		String msg;
		msg = String.format(Locale.JAPAN, "[%s : %d] (s1=%s, s2=%s)target => %s / result => %s", Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber(), 
				s1, s2, target, res);

		System.out.println(msg);

		// abc/bac
		s1 = "abc";
		s2 = "bac";

		res = Methods.perm(res, s1, s2);
		
//		String msg;
		msg = String.format(Locale.JAPAN, "[%s : %d] (s1=%s, s2=%s)target => %s / result => %s", Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber(), 
				s1, s2, target, res);

		System.out.println(msg);
		
		

	}
	
	public static void 
	permu(String str) {
		
		String[] chars = str.split("");
		chars = Arrays.copyOfRange(chars, 1, chars.length);
		
		String target = "bac";
		String s1 = "abc";
		String s2 = "bca";
		
		Methods.perm(target, s1, s2);
		
//		String str_new = StringUtils.join(chars, "-");
////		String str_new_2 = StringUtils.join(chars, "-");
//
//		String tmp = null;
//		
//		for (int i = 1; i < chars.length; i++) {
////			for (int i = 0; i < chars.length; i++) {
//	
//			tmp = chars[i];
//			
//			String msg;
//			msg = String.format(Locale.JAPAN, "[%s : %d] chars[%d] = %s", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), i, tmp);
//
//			System.out.println(msg);
//			
//			
//		}
//		
//		
//		String msg;
//		msg = String.format(Locale.JAPAN, "[%s : %d] str = %s / new = %s / len = %d", Thread
//				.currentThread().getStackTrace()[1].getFileName(), Thread
//				.currentThread().getStackTrace()[1].getLineNumber(), str, str_new, str.length());
//
//		System.out.println(msg);
		
		
	}//permu(String str)

	//REF http://www.journaldev.com/526/java-program-to-find-all-permutations-of-a-string
	public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }
	
	//REF http://www.journaldev.com/526/java-program-to-find-all-permutations-of-a-string
	public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
	
}


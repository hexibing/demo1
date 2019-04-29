/**   
 * @Prject: parking
 * @author: ZHUZIQIU676   
 * @date: 2017年12月27日 上午10:15:33 
 * @version: V1.0   
 */
package com.example.demo1.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * 空字符串和null字符串返回true
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNil(String string) {
		return string == null || string.length() == 0;
	}

	public static boolean isNotNil(String string) {
		return !isNil(string);
	}

	/**
	 * 空字符串集合和没有元素的字符串集合返回true
	 * 
	 * @param strings
	 * @return
	 */
	public static boolean isNil(Collection<String> strings) {
		return strings == null || strings.size() == 0;
	}

	public static boolean isNil(String[] strings) {
		return strings == null || strings.length == 0;
	}

	public static boolean isNotNil(String[] strings) {
		return !isNil(strings);
	}

	public static boolean isNotNil(Collection<String> strings) {
		return !isNil(strings);
	}

	public static List<String> createList(String... strings) {
		ArrayList<String> list = new ArrayList<String>();
		for (String string : strings) {
			list.add(string);
		}
		return list;
	}

	public static String[] createArray(List<String> strings) {
		String[] array = new String[strings.size()];
		for (int i = 0; i < strings.size(); i++) {
			array[i] = strings.get(i);
		}
		return array;
	}

	public static String trim(String string) {
		if (string == null) {
			return string;
		}
		return string.trim();
	}

	public static boolean isInStrings(String target, String... conditions) {
		for (String condition : conditions) {
			if (target.equals(condition)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNumber(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher match = pattern.matcher(str);
		if (match.matches() == false) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 判断一个字符串是不是数字，包括小数和负数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDigit(String str) {
		Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?)$");
		Matcher match = pattern.matcher(str);
		if (match.matches() == false) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isNumberOrLetters(String str) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher match = pattern.matcher(str);
		if (match.matches() == false) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 在字符串str中每隔lineSize个字符插入一个回车
	 * 
	 * @param str
	 * @param lineSize
	 */
	public static String insertEnterToString(String str, int lineSize) {
		return insertStrtoString(str, lineSize, "\n\r");
	}

	/**
	 * 在字符串string中每隔lineSize个字符插入一个str
	 * 
	 * @param string
	 * @param lineSize
	 * @param str
	 */
	public static String insertStrtoString(String string, int lineSize, String str) {
		if (string == null || "".equals(string)) {
			return null;
		}
		if (lineSize >= string.length() || lineSize <= 0) {
			return string;
		}
		String resultStr = "";
		while (string.length() > lineSize) {
			resultStr += string.substring(0, lineSize) + str;
			string = string.substring(lineSize);
		}
		resultStr += string;
		return resultStr;
	}

	/**
	 * 取字符串的 前length个字符
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	public static String subString(String str, int length) {
		if (isNil(str) || length <= 0) {
			return str;
		}
		return str.length() < length ? str : str.substring(0, length);
	}

	public static String subString(String str) {
		if (isNil(str)) {
			return str;
		}
		return str.substring(0, str.length() - 1);
	}

	/**
	 * 截取字符串str中指定字符 strStart、strEnd之间的字符串
	 *
	 * @param str
	 * @param strStart
	 * @param strEnd
	 * @return
	 */
	public static String subString(String str, String strStart, String strEnd){

		/* 找出指定的2个字符在 该字符串里面的 位置 */
		int strStartIndex = str.indexOf(strStart);
		int strEndIndex = str.indexOf(strEnd);

		/* index 为负数 即表示该字符串中 没有该字符 */
		if(strStartIndex < 0){
			return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
		}
		if(strEndIndex < 0){
			return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
		}
		/* 开始截取 */
		String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
		return result;

	}
		public static String limitStringByBytes(String value, int len) {
		if (isNil(value) || len <= 0) {
			return value;
		}
		if (value.getBytes().length <= len) {
			return value;
		}
		return new String(value.getBytes(), 0, len);
	}

	public static boolean validStringByBytes(String value, int len) {
		if (isNil(value) || len <= 0) {
			return true;
		}
		if (value.getBytes().length <= len) {
			return true;
		}
		return false;
	}

	/**
	 * null转换为""
	 * 
	 * @param str
	 * @return
	 */
	public static String blankWhenNull(String str) {
		return str == null ? "" : str;
	}

	public static String getStringAfter(String s, String after) {
		int beginIndex = s.indexOf(after);
		if (s.length() == beginIndex + 1 || beginIndex == -1) {
			return "";
		}
		return s.substring(beginIndex + 1);
	}

	public static String right(String s, int length) {
		if (s == null) {
			return null;
		}
		assert length > 0 : "length must greater than zerio";
		if (s.length() <= length) {
			return s;
		}
		return s.substring(s.length() - length, s.length());
	}

	public static String listToString(List<String> productTagList, String split) {
		String r = "";
		for (String item : productTagList) {
			if (r.length() == 0) {
				r += item;
			} else {
				r += split + item;
			}
		}
		return r;
	}

	public static boolean isNullOrEmpty(String str) {
		if (null == str || 0 == str.trim().length()) {
			return true;
		}
		return false;
	}

	public static final int PAD_STYLE_LEFT = 1;
	public static final int PAD_STYLE_RIGTH = 2;
	public static final int PAD_STYLE_BOTH = 3;

	public static String pad(String str, String padStr, int padTimes, int padStyle) {
		assert str != null : "填充目标为空";
		assert isNotNil(padStr) : "填充字符串为空";
		assert padTimes >= 0 : "填充次数小于0";
		String actualPadStr = "";
		for (int i = 0; i < padTimes; i++) {
			actualPadStr += padStr;
		}
		if (PAD_STYLE_LEFT == padStyle) {
			return actualPadStr + str;
		} else if (PAD_STYLE_RIGTH == padStyle) {
			return str + actualPadStr;
		} else if (PAD_STYLE_BOTH == padStyle) {
			return actualPadStr + str + actualPadStr;
		} else {
			assert false : "不能识别填充模式";
		}
		return str;
	}

	public static String pad(String str, int padTimes) {
		return pad(str, " ", padTimes, PAD_STYLE_BOTH);
	}

	public static String objToStr(Object obj) {
		return obj == null ? "" : String.valueOf(obj);
	}

	public static String convertNullToString(String str) {
		return str == null ? "" : str;
	}

	public static String addZeroBeforeNumber(String numberString, int fixedLength) {
		String zeroString = "";
		for (int i = 0; i < fixedLength - numberString.length(); i++) {
			zeroString += "0";
		}
		return zeroString + numberString;
	}

	public static String dealNullOrBlankString(String str) {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return str.trim();
		}
	}

	/**
	 * 为list里的字符串添加单引号
	 * 
	 * @param list
	 * @return
	 */
	public static String toCommaString(List list) {
		String r = "";
		if (list == null) {
			return r;
		}
		if (list.size() > 0) {
			r += "'" + list.get(0).toString().trim() + "'";
		}
		for (int i = 1; i < list.size(); i++) {
			r += ", '" + list.get(i).toString().trim() + "'";
		}
		return r;
	}

	public static String getSubString(String value, int subLength) {
		if (isNil(value)) {
			return value;
		}
		if (value.getBytes().length == subLength) {
			return value;
		}
		byte[] copy = new byte[subLength];
		System.arraycopy(value.getBytes(), 0, copy, 0, Math.min(value.getBytes().length, subLength));
		return new String(copy).trim();
	}

	public static String convertArrayToStr(String[] values) {
		if (values.length == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (String value : values) {
			sb.append(value + ",");
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}

	/**
	 * 首字母大写
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

	public static String[] splitComma(String str) {
		str = replaceComma(str);
		String[] results = str.split("，");
		return results;
	}
	
	public static String[] splitCustom(String str, String regex) {
		String[] results = str != null ? str.split(regex) : null;
		return results;
	}

	/**
	 * 把半角,替换成，
	 * 
	 * @param str
	 * @return 替换后的String
	 */
	public static String replaceComma(String str) {
		if (isNil(str)) {
			return str;
		}
		return str.replace(',', '，');
	}

	/**
	 * @Description: ibatis in 特殊处理
	 * @param str
	 * @return
	 * @return: String
	 */
	public static String replaceSeparator(String str) {
		return isNotNil(str) ? str.trim().replaceAll(",", "','").replaceAll(" ", "") : str;
	}

	/**
	 * 字符串+1方法，该方法将其结尾的整数+1,适用于任何以整数结尾的字符串,不限格式，不限分隔符。
	 * 
	 * @author zxcvbnmzb
	 * @param testStr
	 *            要+1的字符串
	 * @return +1后的字符串
	 * @exception NumberFormatException
	 */
	public static String addOne(String testStr) {
		String[] strs = testStr.split("[^0-9]");// 根据不是数字的字符拆分字符串
		String numStr = strs[strs.length - 1];// 取出最后一组数字
		if (numStr != null && numStr.length() > 0) {// 如果最后一组没有数字(也就是不以数字结尾)，抛NumberFormatException异常
			int n = numStr.length();// 取出字符串的长度
			int num = Integer.parseInt(numStr) + 1;// 将该数字加一
			String added = String.valueOf(num);
			n = Math.min(n, added.length());
			// 拼接字符串
			return testStr.subSequence(0, testStr.length() - n) + added;
		} else {
			throw new NumberFormatException();
		}
	}

	private static char[] letters = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	/**
	 * @Description: 生成随机字母
	 * @param length
	 * @return
	 * @return: String
	 */
	public static String generateLetters(int length) {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int index = r.nextInt(letters.length - 1);
			sb.append(letters[index]);
		}
		return sb.toString();
	}
	
	/**
	 * 取文件后缀名
	 * @param name
	 * @return
	 */
	public static String getSuffixName(String name) {
		return name.substring(name.lastIndexOf("."));
	}
	
}

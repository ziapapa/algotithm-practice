package algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class PairRemove {

	static int result = 0;

	public static void main(String[] args) {

		String str = "cdcd";
		System.out.println(solution(str));
	}

	private static int solution(String s) {
		int pos = 0;
		Stack<String> strStack = new Stack<>();

		while (pos < s.length()) {

			if (strStack.isEmpty() || !strStack.peek().equals(s.substring(pos, pos + 1))) {
				strStack.push(s.substring(pos, pos + 1));
			} else if (strStack.peek().equals(s.substring(pos, pos + 1))) {
				strStack.pop();
			}

			pos++;
		}
		if (strStack.size() != 0) {
			return 0;
		}

		return 1;
	}

	public static int solution1(String s) {
		byte[] bytes = s.getBytes();
		int length = bytes.length;

		Stack<Integer> stack = new Stack<>();

		int iLeft = 0, iRight = iLeft + 1;
		for (; iLeft < length && iRight < length;) {
			if (bytes[iLeft] == bytes[iRight]) {
				// bytes[iLeft] = 0;
				// bytes[iRight] = 0;

				if (stack.empty()) {
					/*
					 * while (iLeft >= 0 && bytes[iLeft] == 0) iLeft--; while
					 * (iRight < length && bytes[iRight] == 0) iRight++;
					 *
					 * if (iLeft < 0) iLeft = iRight; if (iRight <= iLeft)
					 * iRight = iLeft + 1;
					 */

					iLeft = iRight + 1;
					iRight = iLeft + 1;
				} else {
					iLeft = stack.pop();
					iRight++;
				}
			} else {
				stack.push(iLeft);

				iLeft = iRight;
				iRight = iLeft + 1;
			}
		}

		return iLeft >= length && iRight >= length ? 1 : 0;
	}

	public void removeStr(String s) {

		String returnStr = "";
		ArrayList<String> tempList = new ArrayList<>();

		if ("".equals(s) || s.length() < 1) {
			result = 1;
		} else {
			for (int i = 0; i < s.length(); i++) {
				tempList.add(s.substring(i, i + 1));
			}

			for (int j = 0; j < tempList.size() - 1; j++) {
				if (tempList.get(j).equals(tempList.get(j + 1))) {
					tempList.remove(j + 1);
					tempList.remove(j);

					for (String str : tempList) {
						returnStr = returnStr + str;
					}
					removeStr(returnStr);
					return;
				}
			}
		}
	}

	public static void removeStr1(String s) {

		String returnStr = "";

		int len = s.length();
		if ("".equals(s) || len < 1) {
			result = 1;
		} else {
			for (int i = 0; i < len; i++) {
				if (i != 0 && s.substring(i - 1, i).equals(s.substring(i, i + 1))) {
					returnStr = returnStr.substring(0, returnStr.length() - 1) + s.substring(i + 1);
					removeStr1(returnStr);
					break;
				} else {
					returnStr = returnStr + s.substring(i, i + 1);
				}
			}
		}
	}

}

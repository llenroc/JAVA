package string.replaceSymbols.regExpression;
/*
2021-May-18. Oleksii Saiun.
Remove punctuation symbols <=> replace punctuation symbols by ""

input: A man, a plan, a canal: Panama.!?
output: AmanaplanacanalPanama

*/
public class StringReplaceSymbolsRegExpression {

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama.!?";
		System.out.println("input: " + str);
		String strOut = str.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println("output: " + strOut);

	}

}

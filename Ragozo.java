import java.util.*;
import java.io.*;

public class Ragozo {
	
	public enum VowelType {
		VowelTypeHigh,
		VowelTypeLow
	}
	
	private static BufferedReader reader;
	
	public static void main(String[] args) {
		try {
			reader = new BufferedReader(new FileReader("nevek.txt"));
			String line = null;
			while((line = reader.readLine()) != null) {
				Ragozo.VowelType type = getVowelType(line);
				if(type == VowelType.VowelTypeLow) {
					System.out.println(changeLastVowel(line) + "nak");
				} else {
					System.out.println(changeLastVowel(line) + "nek");
				}
			}
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
	
	public static VowelType getVowelType(String str) {
		String[] parts = str.split(" ");
		String word = parts[parts.length - 1];
		String highVowels = word.replaceAll("[^eéiíöőüű]", "");
		String lowVowels = word.replaceAll("[^aáoóuú]", "");
		if(highVowels.length() == 0 && lowVowels.length() == 0) {
			return VowelType.VowelTypeLow;
		} else if (highVowels.length() != 0 && lowVowels.length() == 0) {
			return VowelType.VowelTypeHigh;
		} else if(highVowels.length() == 0 && lowVowels.length() != 0) {
			return VowelType.VowelTypeLow;
		} else {
			return VowelType.VowelTypeLow;
		}
	}
	
	public static String changeLastVowel(String name) {
		String lastChar = name.substring(name.length() - 1);
		if(lastChar.equals("e")) {
			return name.substring(0, name.length() - 1) + "é";
		} else if (lastChar.equals("a")) {
			return name.substring(0, name.length() - 1) + "á";
		} else if(lastChar.equals("i")) {
			return name.substring(0, name.length() - 1) + "í";
		} else if(lastChar.equals("u")) {
			return name.substring(0, name.length() - 1) + "ú";
		}
		return name;
	}
}

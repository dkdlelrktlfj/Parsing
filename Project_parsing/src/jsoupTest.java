//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.Reader;
//import java.util.ArrayList;
//
//import org.jsoup.*;
//import org.jsoup.nodes.*;
//
//import org.jsoup.select.*;
//
//public class jsoupTest {
//	
//	private final static String address = "https://ja.dict.naver.com/jlpt/level-5/parts-1/p1.nhn";
//	public static void main(String[] args) throws IOException {
//
//		Document doc = Jsoup.connect(address).header("User-Agent", "Mozilla/5.0").get();		
//		ArrayList<Elements> text = new ArrayList<Elements>();
//		
//		Elements texts = doc.select("span.jp");
//		String texts2 = texts.select("a").html();	//È÷¶ó°¡³ª ÆÄ½Ì
//		
//		Elements kanji = doc.select("span.jp span");
//		String kanji2 = kanji.select("span").html();	//ÇÑÀÚ ÆÄ½Ì
//		
//		
//		if(kanji2.indexOf("<span class=\"mid_ico\">¡¤</span>") != -1) {
//			kanji2 = kanji2.replace("<span class=\"mid_ico\">¡¤</span>", "¡¤");
//		}
//		else {
//			System.out.println("not found");
//		}
//		
//		String data[] = kanji2.split("\n");
//		for(int i=0; i < data.length; i++) {
//			if(!data[i].equals("¡¤")) {
//				System.out.println(data[i]);
//			}
//		}
//		
//		
////		Elements[] text;
////		text = new Elements[5];
//		
//	}
//
//}

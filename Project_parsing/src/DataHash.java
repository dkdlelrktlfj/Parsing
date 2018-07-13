import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

class DataHash {
	private final static String address = "https://ja.dict.naver.com/jlpt/level-5/parts-1/p1.nhn";
	HashMap<Integer, WordEntity> word = new HashMap<Integer,WordEntity>();
	
	public void DataSet() {
		try {
			Document doc = Jsoup.connect(address).header("User-Agent", "Mozilla/5.0").get();		
			
			Elements japan = doc.select("span.jp span");
			String japan2 = japan.select("span").html();	//한자 파싱
			
			if(japan2.indexOf("<span class=\"mid_ico\">·</span>") != -1) {
				japan2 = japan2.replace("<span class=\"mid_ico\">·</span>", "·");
			}
			else {
				System.out.println("not found");
			}
			
			String japan_c_data[] = japan2.split("\n");
			
			
//=================================================================================================			
			
			japan = doc.select("span.jp");
			japan2 = japan.select("a").html();	//히라가나 파싱
			
			String japan_data[] = japan2.split("\n");
			
//=================================================================================================
			
			String koreas = doc.select("span.bot_txt").html();
			
			if(koreas.indexOf("<span class=\"pin\">") != -1 || koreas.indexOf("</span>") != -1) {
				koreas = koreas.replace("<span class=\"pin\">","");
				koreas = koreas.replace("</span>","");
			}
			else {
				System.out.println("not found");
			}
			
			String korean_data[] = koreas.split("\n");
			
			for(int i=0; i < japan_data.length; i++) {
				if(!japan_data[i].equals("·") && !japan_c_data[i].equals("·") && !korean_data[i].equals("·")) {
					word.put(i, new WordEntity(japan_data[i],japan_c_data[i],korean_data[i]));
				}
			}
			
			System.out.println("저장 완료");
			
		}catch(IOException e) {
			System.out.println("error - DataSet");
		}
	}

	public HashMap<Integer,WordEntity> wordEntityget() {
		return word;
	}
	
	
}

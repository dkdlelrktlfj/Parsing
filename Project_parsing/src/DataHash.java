import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

class DataHash {
	private static String address;
	HashMap<Integer, WordEntity> word = new HashMap<Integer, WordEntity>();
	ArrayList<String> japan_list = new ArrayList<String>();
	ArrayList<String> japan2_list = new ArrayList<String>();
	ArrayList<String> korean_list = new ArrayList<String>();
	
	public DataHash() {
		System.out.println("Load DataHash");
	}

	public void DataSet() {
		for (int j = 1; j < 3; j++) {
			try {
				address = "https://ja.dict.naver.com/jlpt/level-5/parts-1/p" + j + ".nhn";
				Document doc = Jsoup.connect(address).header("User-Agent", "Mozilla/5.0").get();
				Elements japan = doc.select("span.jp");
				String japan5 = japan.select("span").html();

				String japan_c_test[] = japan5.split("\n");
				
				int temp = 0;
				for (int i = 0; i < japan_c_test.length; i++) {
					temp = japan_list.size();
					japan_list.add(temp, japan_c_test[i]);
				}
				
				String RegExp;
				int loopCheck = 0;

				for (int i = 0; i < japan_list.size(); i += 1) {
					if (loopCheck == 0) {
						RegExp = "^[·]+$";
						if (japan_list.get(i).matches(RegExp)) {
							System.out.println("점 캐치" + japan_list.get(i));
							japan_list.remove(i);
							i = -1;
						}
						if (i == japan_list.size() - 1) {
							i = -1;
							loopCheck = 1;
						}
					} else if (loopCheck == 1) {
						RegExp = "^[あ-んカ-ン\\u4E00-\\u9FD5]+$";
						if (japan_list.get(i).matches(RegExp)) {
							System.out.println("히라가나 캐치" + japan_list.get(i));
							japan_list.remove(i);
							i = -1;
						}
						
						if (i == japan_list.size() - 1) {
							i = -1;
							loopCheck = 2;
						}
					} else if (loopCheck == 2) {
						RegExp = "^\\[+\\D*\\]+$";
						if (i < japan_list.size() == true) {
							if (japan_list.get(i).matches(RegExp) == false) {
								if (japan_list.get(i + 1).matches(RegExp) == false) {
									if ((japan_list.get(i).equals("-") == false
											&& japan_list.get(i + 1).equals("-") == false) == true) {
										japan_list.add((i + 1), "-");
										i = -1;
									}
								}
							}
							if (i >= japan_list.size() - 1) {
								i = 0;
								loopCheck = 3;
							}
						}
					} else if (loopCheck == 3) {
						RegExp = "^\\<+[\\s\\S]*\\>+$";
						if (japan_list.get(i).matches(RegExp) == true) {
							japan_list.remove(i);
							i = -1;
						}
						if (i >= japan_list.size() - 1) {
							i = -1;
							loopCheck = 4;
						}
					} else if (loopCheck == 4) {
						japan_list.set(i, japan_list.get(i).replaceFirst("<span class=\"mid_ico\">��</span>", "-"));
					}
				}

				
//=================================================================================================			
				
				japan = doc.select("span.jp");
				String japan2 = japan.select("a").html(); // ���󰡳� �Ľ�
				String japan_data[] = japan2.split("\n");
				
				for (int i=0; i < japan_data.length; i++) {
					temp = japan2_list.size();
					japan2_list.add(temp, japan_data[i]);
				}
				
//=================================================================================================

				String koreas = doc.select("span.bot_txt").html();

				koreas = koreas.replace("<span class=\"pin\">", "");
				koreas = koreas.replace("</span>", "");
				koreas = koreas.replace("<span class=\"jp\" lang=\"ja\">", "");

				String korean_data[] = koreas.split("\n");
				
				
				for (int i = 0; i < korean_data.length; i++) {
					temp = korean_list.size();
					korean_list.add(temp, korean_data[i]);
				}
				System.out.println(japan2_list.size() + "\t" + japan_list.size() + "\t" + korean_list.size());
				
				for (int i = 0; i < japan2_list.size(); i++) {
					if (!japan2_list.get(i).equals("·") && !japan_list.get(i).equals("·") && !korean_list.get(i).equals("·")) {
						word.put(i, new WordEntity(japan2_list.get(i), japan_list.get(i), korean_list.get(i)));
					}
				}
				
				System.out.println("저장완료");


			} catch (IOException e) {
				System.out.println("error - DataSet");
			}
			finally {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public HashMap<Integer, WordEntity> wordEntityget() {
		return word;
	}

}

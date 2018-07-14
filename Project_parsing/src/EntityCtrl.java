import java.util.Random;

class EntityCtrl {
	DataHash dh = new DataHash();
	private int Level;
	private String answer = "";
	
	public EntityCtrl() {
		dh.DataSet();
	}
	
	public void test() {
		WordEntity dhs = dh.word.get(1);
		System.out.println(dhs.japan);
		System.out.println(dhs.japan_c);
		System.out.println(dhs.korean);
	}
	
	public String[] setTest(int level) {
		if(level == 3) {
			int random = (int)(Math.random() * dh.word.size());
			WordEntity japan = dh.word.get(random);
			String[] s = new String[3];
			s[0] = japan.japan;
			s[1] = japan.japan_c;
			s[2] = japan.korean;
			answer = japan.korean;
			
			return s;
		}
		return null;
	}
	
	
}

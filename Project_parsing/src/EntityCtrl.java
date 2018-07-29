import java.util.Random;

class EntityCtrl {
	public static DataHash dh = new DataHash();
	private AnswerEntity answerentity = AnswerEntity.getInstance();
	private static int Level;
	
	
	public void EntitySet() {
		System.out.println("Load EntityCtrl");
		dh.DataSet();
	}
	
	public String[] setTest(int level) {
		if(level == 3) {
			int random = (int)(Math.random() * (dh.word.size() - 1));
			int temp = random;
			WordEntity japan = dh.word.get(random);
			String[] s = new String[6];
			s[0] = japan.japan;
			s[1] = japan.japan_c;
			s[2] = japan.korean;
			
			answerentity.answerSet(japan.korean);
			
			for(int i=3; i < 6; i++) {
				random = (int)(Math.random() * (dh.word.size() - 1));
				if(random != temp) {
					japan = dh.word.get(random);
					s[i] = japan.korean;
				}
				else {
					i-=1;
				}
			}
			
			return s;
		}
		return null;
	}
}


class EntityCtrl {
	DataHash dh = new DataHash();
	
	public void EntityCtrl() {
		dh.DataSet();
	}
	
	public void test() {
		WordEntity dhs = dh.word.get(1);
		System.out.println(dhs.japan);
		System.out.println(dhs.japan_c);
		System.out.println(dhs.korean);
	}
	
	public void setTest() {
		
	}
}


class AnswerEntity {
	private static String answer;
	private static int clickButton;
	private static AnswerEntity answerentity = new AnswerEntity();

	private AnswerEntity() {}
	
	static AnswerEntity getInstance() {
		return answerentity;
	}
	
	public void answerSet(String answer) {
		AnswerEntity.answer = answer;
	}
	
	public String answerGet() {
		return answer;
	}
	
	public void clickButtonSet(int clickButton) {
		AnswerEntity.clickButton = clickButton;
	}
	
	public int clickButtonGet() {
		return clickButton;
	}
	
	
}

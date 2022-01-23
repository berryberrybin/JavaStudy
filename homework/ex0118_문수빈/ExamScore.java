class ExamScore {
	public static void main(String []args){
	String name = "문수빈" ;
	int koreanScore, englishScore, mathScore;
	int sumScore;
	double avgScore;
	char gradeScore;

	koreanScore = 90;
	englishScore = 90;
	mathScore = 91;
	
	sumScore = (koreanScore+englishScore+mathScore);
	avgScore = sumScore / 3.0;
	
	gradeScore = avgScore >= 90 ? 'A' : 'F';
	
	System.out.println("이름 : " + name);
	System.out.println("----------------------------------------");
	System.out.print("국어점수 : " + koreanScore);
	System.out.print("\t영어점수 : " + englishScore);
	System.out.print("\t수학점수 : " + mathScore + "\n");
	System.out.println("----------------------------------------");
	System.out.println();
	System.out.println("총점 : " + sumScore);
	System.out.println("평균 : " + ((int)(avgScore*100))/100.00);
	System.out.println("학점 : " + gradeScore);

	}
}

/**
본인이름 : 문수빈
날짜 : 22.01.18
주제 : 성적구하기
*/
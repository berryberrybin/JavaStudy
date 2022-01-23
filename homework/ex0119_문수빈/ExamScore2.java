class ExamScore2 {
	public static void main(String []args){
	String name = "문수빈" ;
	int koreanScore, englishScore, mathScore;
	int sumScore;
	double avgScore;
	char gradeScore;

	koreanScore = (int)(Math.random()*56)+45;
	englishScore = (int)(Math.random()*56)+45;
	mathScore = (int)(Math.random()*56)+45;
	
	sumScore = (koreanScore+englishScore+mathScore);
	avgScore = sumScore / 3.0;


	if(avgScore>=90){
		gradeScore='A';
	} else if(avgScore>=80){ //  else if(avgScore<=89&&avgScore>=80) : avgScore 이미 윗단계에서 90이하를 걸러져 내려옴
		gradeScore='B';
	} else if(avgScore>=70){
		gradeScore='C';
	} else if(avgScore>=60){
		gradeScore='D';
	} else{
		gradeScore='F';
	}


	/*
	switch ((int)avgScore/10){
		case 10:
		case 9 :
			gradeScore='A';
			break;
		case 8:
			gradeScore='B';
			break;
		case 7:
			gradeScore='C';
			break;
		case 6:
			gradeScore='D';
			break;
		default:
			gradeScore='F';
			break;
	}
	*/

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
날짜 : 22.01.19
주제 : 성적구하기
*/
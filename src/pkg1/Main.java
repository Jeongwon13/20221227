package pkg1;
/*
 * 
 */

class Person {
	//3) 멤버 변수들을 선언
	String m_name;
	int m_age;
	String m_bt;

	//4) 다른 클래스로부터 값을 입력받는 생성자를 정의
	// - 입력 순서: 이름, 나이, 혈액형 -> 매개변수 선언할 때 참고
	public Person(String name, int age, String bt) {
		//5) 각각의 매개변수로 입력된 값들을 각각의 멤버변수에 대입
		 m_name = name;
		m_age = age;
		 m_bt = bt;
		
	}
	//6) getter 메소드들을 정의하기
	// - 기능: 각각의 멤버 변수의 현재 값을 반환
	// - 순서: 이름, 나이, 혈액형
	public String getName() {
		return m_name;
	}
	public int getAge() {
		return m_age;
	}
	public String getBt() {
		return m_bt;
	}
	
	/*
	 * toString() 메소드를 재정의(다시 작성)
	 * 1) 형식
	 * @Override 
	 * public String toString(){
	 *  return "문자열";
	 *   //"문자열": 멤버 변수의 값을 읽는 명령어(멤버 변수 이름을 사용 또는 getter())
	 *  }
	 */
	@Override
	public String toString() {
		String result = "";
		String name = getName();
		int age = getAge();
		String bt = getBt();
		//반환 값의 기본 형식: 값1 + 구분자 + 값2 + 구분자 + 값3
		// - 구분자가 없으면 하나로 붙어버려서 알아볼 수가 없게 됨
		// - 구분자: 일반적으로 공백을 많이 사용 (" ")
		//  - 하지만, 엑셀 문서의 내용처럼 쉼표(,) 사용도 가능
		// - 반환 값의 순서: 이름값 + ","	+ 나이값 + "," + 혈액형값
		result = name + "," + age + "," + bt;
		return result;
	}
	
}//end of Person class

public class Main {

	public static void main(String[] args) {
		
		Person a = new Person("홍길동",20,"O형");
		//getName() 메소드 호출해서 이름만 가져오기
		String name = a.getName();
		//-String name은 지역 변수로 main() 메소드 내부에서만 사용 가능
		//모니터 화면에(사용자에게) 이름을 보여주기
		System.out.println("사람의 이름은 " + name);
		
		int age = a.getAge();
		//getAge() 메소드 호출해서 나이만 읽어오기
		System.out.println("사람의 나이는 " + age);
		
		String bt = a.getBt();
		System.out.println("사람의 혈액형은 " + bt);
		
		/*
		 * Person 클래스에서 재정의한 toString() 메소드를 호출하는 방법 2가지
		 * 1. System.out.println(객체참조변수명);
		 */
		System.out.println(a);
		// 2. toString() 메소드를 바로 사용하기
		String value = a.toString();
		System.out.println(value);
		
		//toString() 메소드의 반환값: 모든 멤버변수의 값
		// - 가져온 전체 값에서 다시 개별적으로 나누고 싶은 경우
		// - String 클래스가 갖고 있는 split() 메소드를 호출
		//  - split() 메소드의 형식
		//public String[] split(문자열형식의구분자) { }
		// 문자열형식의구분자: toString() 메소드에서 return 이름 + "," + ...;
		// - 쉼표(,) 기호를 사용(일치시켜야 합니다.)
		String[] arr = value.split(",");
		/*
		 * value.split("구분자기호") 메소드의 기능
		 *  - 변수 value가 갖고 있는 전체 문자열의 값인 "홍길동,20,O형"에서
		 *    쉼표(,) 기호를 구분으로 하여 왼쪽과 오른쪽에 있는 이름, 나이, 혈액형
		 *    값을 추출(뽑아오기)해서 뽑은 값들을 String[] 배열에 차례대로 저장
		 */
		//String[] 배열인 arr의 각각 방에 들어있는 값을 읽어와서 화면에 표시하기
		//향상된 for문을 작성하기
		for(String value2 : arr) {
			System.out.println(value2);
		}
		
		
	}

}
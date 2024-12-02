@FunctionalInterface
public interface MathInterface {
    double get();
}
/** @FunctionalInterface 애노테이션을 통해 해당
 * 인터페이스가 하나의 메소드만 가질 것이라 선언
 * 실제 사용할 때 해당 인터페이스에 하나의 함수를 ::로 할당하여 사용
 * 메소드의 빈 껍데기처럼 사용가능
 * 참고 이런 함수형 인터페이스는 완전히 함수 취급하듯 호출가능
 */

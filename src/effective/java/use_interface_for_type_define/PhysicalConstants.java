package effective.java.use_interface_for_type_define;

// IntelliJ는 static final 빼도 좋다는 경고가 뜨고 있다. (이미 인터페이스 안에 있는 변수니깐)
interface PhysicalConstants {
    // 아보가르드 수
    static final double AVOGADROS_NUMBER = 6.022_140_857e23;

    // 볼츠만 상수
    static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;

    // 전자 질량
    static final double ELECTRON_MASS = 9.109_383_56e-31;
}

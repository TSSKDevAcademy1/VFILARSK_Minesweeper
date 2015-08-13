package interfaces.defaultMethod;

public interface Defaultable2 {
	default String notRequired() {
		return "Default implementation 2";
	}
}

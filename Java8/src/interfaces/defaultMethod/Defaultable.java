package interfaces.defaultMethod;

public interface Defaultable {
	default String notRequired() {
		return "Default implementation";
	}
}

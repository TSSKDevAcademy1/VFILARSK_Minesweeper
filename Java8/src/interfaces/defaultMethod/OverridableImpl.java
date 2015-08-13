package interfaces.defaultMethod;

public class OverridableImpl implements Defaultable {
	@Override
	public String notRequired() {
		return "Overriden implementation";
	}
}

package interfaces;

import interfaces.defaultMethod.Defaultable;
import interfaces.defaultMethod.DefaultableImpl;
import interfaces.defaultMethod.OverridableImpl;
import interfaces.staticMethod.DefaultableFactory;

public class DefaultableTest {

	public static void main(String[] args) {
		//default
		Defaultable defaultable = DefaultableFactory.create(DefaultableImpl::new);
		System.out.println(defaultable.notRequired());
		
		//overriden
		defaultable = DefaultableFactory.create(OverridableImpl::new);
		System.out.println(defaultable.notRequired());
	}

}

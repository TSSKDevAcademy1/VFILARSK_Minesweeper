package interfaces.staticMethod;

import interfaces.defaultMethod.Defaultable;

import java.util.function.Supplier;

//static method in interface
public interface DefaultableFactory {
	static Defaultable create(Supplier<Defaultable> supplier) {
		return supplier.get();
	}	
}

package lambda.functionalInterfaces;

public class UnitOfWorkTestRepeat {
	@FunctionalInterface
    public interface UnitOfWork {
        void doIt();
    }
    
    private static void repeat(int times, UnitOfWork work) { 
        for (int i = 0; i < times; i++) {
            work.doIt();
        }
    }
    
    private static void helloWorld() {
        System.out.println("hello world");
    }
    
    public static void main(String[] args) {
        repeat(10, UnitOfWorkTestRepeat::helloWorld);
        repeat(10, new MaDajakeMeno());
    }
    
    static class MaDajakeMeno implements UnitOfWork {

        @Override
        public void doIt() {
            helloWorld();
        }        
    }
}

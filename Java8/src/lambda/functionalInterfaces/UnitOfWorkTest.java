package lambda.functionalInterfaces;

public class UnitOfWorkTest {

    @FunctionalInterface
    public interface UnitOfWork {
        public void doIt();
    }

    public static void repeat(int times, UnitOfWork fi) {
        for (int i = 0; i < times; i++) {
            fi.doIt();
        }
    }

    public static void helloWorld() {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) {
        repeat(10, new UnitOfWork() {

            @Override
            public void doIt() {
                System.out.println("Hello world!");
            }
        });

        repeat(10, () -> System.out.println("Hello world!"));

        repeat(10, () -> {
            System.out.println("Hello world!");
        });

        repeat(10, UnitOfWorkTest::helloWorld);
    }
}

package jhvgvvh;

public class Khvjh {
    public static void main(String[] args) {
        check(() -> {
            throw new RuntimeException();
        });
    }

    private static void doTenTimes(Callback callback) {
        for (int i = 0; i < 10; i++) {
            callback.call();
        }
    }

    private static void check(Callback callback) {
        try {
            callback.call();
            System.out.println("Brak wyjątku");
        } catch (Exception e) {
            System.out.println("Wyjątek");
        }
    }

    interface Callback{
        void call();
    }

    static class PrintMartyna implements Callback{
        @Override
        public void call() {
            System.out.println("Martyna");
        }
    }
    static class PrintMaciek implements Callback{
        @Override
        public void call() {
            System.out.println("Maciek");
        }
    }
}

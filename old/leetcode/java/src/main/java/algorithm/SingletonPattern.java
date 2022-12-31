package algorithm;

public class SingletonPattern {

    public static class Singleton {
        private Singleton() {}

        public static Singleton Instance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

        private static Singleton instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.Instance();
        Singleton x = singleton;
        Singleton y = Singleton.Instance();
        if (x != y) {
            System.out.println("Error");
        } else {
            System.out.println("Good for me!");
        }
    }
}

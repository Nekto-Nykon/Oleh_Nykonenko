package nykon.factory;


public class AbstractFactory {
    private static volatile Factory factory;

    public static Factory getImplInstance() {
        if (factory == null) {
            synchronized (Factory.class) {
                if (factory == null) {
                    Factory newFactory = new FactoryImpl();
                    factory = newFactory;
                }
            }
        }
        return factory;
    }
}

package patterns.creational.abstract_factory;

abstract class CPU {}

class EmberCPU extends CPU {
    public EmberCPU() {
        System.out.println("EmberCPU created.");
    }
}

class EnginolaCPU extends CPU {
    public EnginolaCPU() {
        System.out.println("EnginolaCPU created.");
    }
}

abstract class MMU {}

class EmberMMU extends MMU {
    public EmberMMU() {
        System.out.println("EmberMMU created.");
    }
}

class EnginolaMMU extends MMU {
    public EnginolaMMU() {
        System.out.println("EnginolaMMU created.");
    }
}

class EmberToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EmberCPU();
    }

    @Override
    public MMU createMMU() {
        return new EmberMMU();
    }
}

class EnginolaToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EnginolaCPU();
    }

    @Override
    public MMU createMMU() {
        return new EnginolaMMU();
    }
}

enum Architecture {
    ENGINOLA, EMBER
}

abstract class AbstractFactory {
    private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
    private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

    static AbstractFactory getFactory(Architecture architecture) {
        AbstractFactory factory = null;
        switch (architecture) {
            case ENGINOLA:
                factory = ENGINOLA_TOOLKIT;
                break;
            case EMBER:
                factory = EMBER_TOOLKIT;
                break;
        }
        return factory;
    }

    public abstract CPU createCPU();

    public abstract MMU createMMU();
}

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = AbstractFactory.getFactory(Architecture.ENGINOLA);
        factory.createCPU();
        factory.createMMU();
    }
}
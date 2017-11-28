package patterns.creational.abstract_factory;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class AbstractFactoryShould {

    @Test
    public void
    create_Ember_parts_when_Ember_architecture_is_chosen() {
        AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);
        assertThat(factory.createCPU(), instanceOf(EmberCPU.class));
        assertThat(factory.createMMU(), instanceOf(EmberMMU.class));
    }

    @Test
    public void
    create_Enginola_parts_when_Enginola_architecture_is_chosen() {
        AbstractFactory factory = AbstractFactory.getFactory(Architecture.ENGINOLA);
        assertThat(factory.createCPU(), instanceOf(EnginolaCPU.class));
        assertThat(factory.createMMU(), instanceOf(EnginolaMMU.class));
    }
}

package patterns.behavioral.chain_of_responsibility;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChainShould {

    @Test
    public void
    print_correct_output_to_output_stream() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        new Chain().run();

        assertThat(outputStream.toString(), is(
                "Operation #1:\n" +
                "Processor 1 - IR\n" +
                "\n" +
                "Operation #2:\n" +
                "   Processor 1 is busy\n" +
                "Processor 2 - IR\n" +
                "\n" +
                "Operation #3:\n" +
                "   Processor 1 is busy\n" +
                "   Processor 2 is busy\n" +
                "Processor 3 - LS\n" +
                "\n" +
                "Operation #4:\n" +
                "Processor 1 - IR\n" +
                "\n" +
                "Operation #5:\n" +
                "Processor 1 - LS\n" +
                "\n" +
                "Operation #6:\n" +
                "   Processor 1 is busy\n" +
                "Processor 2 - LS\n\n"
        ));
    }
}
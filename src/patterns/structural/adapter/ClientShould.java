package patterns.structural.adapter;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClientShould {

    @Test
    public void
    print_correct_output_to_output_stream() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        new Client().run();

        assertThat(outputStream.toString(),
                is("Line from point A(" + 10 + ";" + 20 + "), to point B(" + 30 + ";" + 60 + ")\n" +
                        "Rectangle with coordinate left-down point (" + 30 + ";" + 60 + "), width: 40, height: 40\n"));
    }
}

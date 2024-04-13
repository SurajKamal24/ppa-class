package exceptionhandling;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;

public class MyResource implements Closeable {
    @Override
    public void close() throws IOException {
        throw new EOFException("error during closure");
    }
}

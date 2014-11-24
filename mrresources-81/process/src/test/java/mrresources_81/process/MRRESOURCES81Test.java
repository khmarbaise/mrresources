package mrresources_81.process;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class MRRESOURCES81Test {

    private static final String PATH = "/META-INF/beans.xml";

    @Test
    public void test() throws IOException {
        assertEquals("<!-- from bundle -->", getFileContent(PATH));
    }

    private static String getFileContent(final String path) throws IOException {
        Closeable closeable = null;
        try {
            final InputStream inStream = MRRESOURCES81Test.class.getResourceAsStream(path);
            closeable = inStream;
            final BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
            closeable = reader;
            return reader.readLine();
        } finally {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (final IOException ioe) {
                    System.err.println("error closing stream/reader: " + ioe);
                }
            }
        }
    }
}

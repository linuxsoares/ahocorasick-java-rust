import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Hello world!
 *
 */
public class App {
    private static java.lang.reflect.Field LIBRARIES;

    public static native void hello();
    public static native List<List<String>> match(List<String> keywords, String text);

    static {
        try {
            LIBRARIES = ClassLoader.class.getDeclaredField("loadedLibraryNames");
            LIBRARIES.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean getLoadedLibraries(final ClassLoader loader, String absolutePath) throws Exception {
        final Vector<String> libraries = (Vector<String>) LIBRARIES.get(loader);
        return libraries.contains(absolutePath);
    }

    public static void main(String[] args) {
        try {
            File f = new File("optimize/target/debug/liboptimize.so");
            System.load(f.getAbsolutePath());

            List<String> keywords = new ArrayList<>();
            keywords.add("gilmar");
            keywords.add("soares");
            String text = "fwionfweonfowenfoingilmargowengwenowensoaresonfwoeinfownefownef";

            hello();
            List<List<String>> match = match(keywords, text);
            System.out.println(match);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

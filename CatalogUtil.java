//@author Moisanu Stefan, having laboratory slides as starting point

package compulsory;

import java.awt.*;
import java.io.*;

/**
 * handles operations on Catalog objects
 */
public class CatalogUtil {
    /**
     * saves a Catalog object with decorator streams
     *
     * @param catalog a catalog to be saved
     * @throws IOException in case something goes wrong with accessing external files or connections
     */
    public static void save(Catalog catalog)
            throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            objectOutputStream.writeObject(catalog);
        }
    }

    /**
     * loads a Catalog previously saved in path
     *
     * @param path location for .ser file
     * @return the read Catalog
     * @throws IOException in case something goes wrong with accessing external files or connections
     */
    public static Catalog load(String path)
            throws IOException {
        Catalog readCatalog = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            readCatalog = (Catalog) objectInputStream.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return readCatalog;
    }

    /**
     * opens webpages associated with the Document doc
     *
     * @param doc object with the URL
     * @throws IOException in case something goes wrong with accessing external files or connections
     */
    public static void view(Document doc) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(doc.getLocationAsURI());
    }
}
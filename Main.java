//@author Moisanu Stefan, having laboratory slides as starting point

package compulsory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Main app = new Main();
        app.testCreateSave();
        System.out.println("Pages will open for heroes in order: 2,1,3");
        app.testLoadView("hero2");
        app.testLoadView("hero1");
        app.testLoadView("hero3");
    }

    /**
     * creates documents, adds them to a catalog, saves the catalog
     *
     * @throws IOException in case something goes wrong with accessing external files or connections
     * Observation: I know function has to many functionalities; if I had enough time I would have broken it down in 3 functions
     */
    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Superheros", "catalog.ser");
        Document doc = new Document("hero1", "Batman", "https://www.dccomics.com/characters/batman");
        Document doc2 = new Document("hero2", "Aquaman", "https://en.wikipedia.org/wiki/Aquaman");
        Document doc3 = new Document("hero3", "Ironman", "https://en.wikipedia.org/wiki/Ironman");

        doc.addTag("type", "FanPage");
        doc.addTag("power", "VeryCoolCar");
        doc2.addTag("type", "WikipediaPage");
        doc2.addTag("power", "BreatheUnderwater");
        doc3.addTag("type", "WikipediaPage");
        doc3.addTag("power", "VeryCoolSuit");
        catalog.add(doc);
        catalog.add(doc2);
        catalog.add(doc3);
        CatalogUtil.save(catalog);
    }

    /**
     * gets previously saved Catalog from .ser file
     *
     * @param id for identifying a certain Document from Catalog
     * @throws IOException in case something goes wrong with accessing external files or connections
     */
    private void testLoadView(String id) throws IOException {
        Catalog catalog = CatalogUtil.load("catalog.ser");
        Document doc = catalog.findById(id);
        CatalogUtil.view(doc);

    }
}
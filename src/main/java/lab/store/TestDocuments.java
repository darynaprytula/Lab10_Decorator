package lab.store;

import lab.store.decorators.CachedDocument;
import lab.store.decorators.Document;
import lab.store.decorators.MockedDocument;
import lab.store.decorators.TimedDocument;

public class TestDocuments {
    public static void main(String[] args) {
        System.out.println("===== TIMED DOCUMENT =====");
        Document timed = new TimedDocument(new MockedDocument("path1"));
        System.out.println(timed.parse());

        System.out.println("===== CACHED DOCUMENT =====");
        Document cached = new CachedDocument(new MockedDocument("path2"));
        System.out.println(cached.parse());
        System.out.println(cached.parse());
    }
}

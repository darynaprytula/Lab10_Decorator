
package lab.store.decorators;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MockedDocument implements Document {

    private final String gcsPath;

    @Override
    public String parse() {
        return "MOCKED RESULT for " + gcsPath;
    }

    @Override
    public String getGcsPath() {
        return gcsPath;
    }
}

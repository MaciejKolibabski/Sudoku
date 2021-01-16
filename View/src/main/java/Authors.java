import java.util.ListResourceBundle;

public class Authors extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"Author1", "Maciej Kolibabski",},
                {"Author2", "Kacper Świąder"}
        };
    }
}

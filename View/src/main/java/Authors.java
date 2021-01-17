import java.util.ListResourceBundle;

public class Authors extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"a", "1. Maciej Kolibabski",},
                {"b", "2. Kacper Świąder"}
        };
    }
}

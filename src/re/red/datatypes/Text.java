package re.red.datatypes;

public class Text extends DataType {

    private final java.lang.String text;

    public Text(java.lang.String text) {

        super("TEXT", text);

        this.text = text;

    }

    @Override
    protected Object getValue() {

        return text;

    }

    @Override
    protected String getRawValue() {

        return text;

    }

}

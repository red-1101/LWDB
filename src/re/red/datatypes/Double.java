package re.red.datatypes;

public class Double extends DataType {

    private final double aDouble;

    public Double(java.lang.Double aDouble) {

        super("DECIMAL", aDouble);

        this.aDouble = aDouble;

    }

    @Override
    protected Object getValue() {

        return aDouble;

    }

    @Override
    protected String getRawValue() {

        return String.valueOf(aDouble);

    }
}

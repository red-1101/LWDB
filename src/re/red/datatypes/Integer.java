package re.red.datatypes;

public class Integer extends DataType {

    private final int anInt;

    public Integer(int anInt) {

        super("INTEGER", anInt);

        this.anInt = anInt;

    }

    @Override
    protected Object getValue() {

        return anInt;

    }

    @Override
    protected String getRawValue() {

        return String.valueOf(anInt);

    }
}

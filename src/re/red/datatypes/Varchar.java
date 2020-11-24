package re.red.datatypes;

public class Varchar extends DataType {

    private final String varchar;

    public Varchar(String varchar) {

        super("VARCHAR", varchar);

        this.varchar = varchar;

    }

    @Override
    protected Object getValue() {

        return varchar;

    }

    @Override
    protected String getRawValue(){

        return varchar;

    }

}

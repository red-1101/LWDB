package re.red.datatypes;

public abstract class DataType {

    private final Object object;
    private final String sqlType;

    public DataType(String sqlType, Object object){

        this.object = object;
        this.sqlType = sqlType;

    }

    protected abstract Object getValue();

    protected abstract String getRawValue();

    public String getSqlType(){

        return sqlType;

    }

}

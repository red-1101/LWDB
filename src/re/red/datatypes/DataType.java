package re.red.datatypes;

public abstract class DataType {

    private final String sqlType;

    public DataType(String sqlType){

        this.sqlType = sqlType;

    }

    public String getSqlType(){

        return sqlType;

    }

}

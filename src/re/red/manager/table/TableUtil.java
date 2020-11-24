package re.red.manager.table;

import re.red.datatypes.DataType;

import java.util.List;

public interface TableUtil {

    void insertInto(List<String> rowNames, List<Object> values);

    void createTable(List<String> rowNames, List<DataType> types);

}

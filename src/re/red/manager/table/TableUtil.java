package re.red.manager.table;

import java.util.List;

public interface TableUtil {

    /***
     *
     * @param rowNames The rows the value will be inserted into.
     * @param values The values that will be inserted into the rows accordingly. values Index 0 will be inserted into rows Index 0 and so on.
     */

    void insertInto(List<String> rowNames, List<Object> values);

}

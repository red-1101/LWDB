package re.red.manager.table;

import re.red.exceptions.NotConnectedException;
import re.red.exceptions.TableNotFoundException;

import java.util.List;

public interface TableUtil {

    /***
     *
     * @param rowNames The rows the value will be inserted into.
     * @param values The values that will be inserted into the rows accordingly. values Index 0 will be inserted into rows Index 0 and so on.
     */

    void insertInto(List<String> rowNames, List<Object> values) throws TableNotFoundException, NotConnectedException;

    /***
     *
     * @param column The column that will be updated.
     * @param values The value that is going to be updated to.
     */

    void update(List<String> column, List<Object> values, String whereCheck, String whereTo) throws TableNotFoundException;

    /***
     * Deletes a row from the table.
     */
    void delete(String whereCheck, String whereTo);

    /***
     *
     * Drops the table.
     */
    void drop();

    /***
     *
     * Truncates the table.
     */
    void truncate();

    /***
     *
     * @return Returns whether the table exists in the database.
     */
    boolean exists();

}

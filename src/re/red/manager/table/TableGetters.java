package re.red.manager.table;

public interface TableGetters {

    /**
     *
     * @param selection What to select from the table.
     * @param whereCheck When a condition is met.
     * @param whereTo The condition.
     * @return The specific return type. Might be null.
     */
    String getStringValue(final String selection, final String whereCheck, final String whereTo);

    /**
     *
     * @param selection What to select from the table.
     * @param whereCheck When a condition is met.
     * @param whereTo The condition.
     * @return The specific return type. Might be null.
     */
    int getIntValue(final String selection, final String whereCheck, final String whereTo);

    /**
     *
     * @param selection What to select from the table.
     * @param whereCheck When a condition is met.
     * @param whereTo The condition.
     * @return The specific return type. Might be null.
     */
    double getDoubleValue(final String selection, final String whereCheck, final String whereTo);

    /**
     *
     * @param selection What to select from the table.
     * @param whereCheck When a condition is met.
     * @param whereTo The condition.
     * @return The specific return type. Might be null.
     */
    float getFloatValue(final String selection, final String whereCheck, final String whereTo);

    /**
     *
     * @param selection What to select from the table.
     * @param whereCheck When a condition is met.
     * @param whereTo The condition.
     * @return The specific return type. Might be null.
     */
    byte getByteValue(final String selection, final String whereCheck, final String whereTo);

    /**
     *
     * @param selection What to select from the table.
     * @param whereCheck When a condition is met.
     * @param whereTo The condition.
     * @return The specific return type. Might be null.
     */
    short getShortValue(final String selection, final String whereCheck, final String whereTo);

    /**
     *
     * @param selection What to select from the table.
     * @param whereCheck When a condition is met.
     * @param whereTo The condition.
     * @return The specific return type. Might be null.
     */
    long getLongValue(final String selection, final String whereCheck, final String whereTo);

    Object get(final String selection, final String whereCheck, final String whereTo);

}

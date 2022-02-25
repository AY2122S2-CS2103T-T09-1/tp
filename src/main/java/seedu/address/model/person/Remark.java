package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's Remark in the Remark book.
 * Guarantees: immutable; is always valid
 */
public class Remark {

    public final String value;

    /**
     * Constructs an {@code Remark}.
     *
     * @param Remark A Remark.
     */
    public Remark(String Remark) {
        requireNonNull(Remark);
        value = Remark;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

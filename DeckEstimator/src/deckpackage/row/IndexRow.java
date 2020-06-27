package deckpackage.row;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Ethan Johnson
 */
public class IndexRow {
    private final SimpleStringProperty quoteName   = new SimpleStringProperty("");
    private final SimpleStringProperty quoteDate   = new SimpleStringProperty("");
    private final SimpleStringProperty quoteStatus = new SimpleStringProperty("");

    public IndexRow(String name, String date, String status) {
        setQuoteName(name);
        setQuoteDate(date);
        setQuoteStatus(status);
    }

    public void setQuoteName(String name) {
        this.quoteName.set(name);
    }

    public void setQuoteDate(String date) {
        this.quoteDate.set(date);
    }

    public void setQuoteStatus(String status) {
        this.quoteStatus.set(status);
    }

    public String getQuoteName() {
        return this.quoteName.get();
    }

    public String getQuoteDate() {
        return this.quoteDate.get();
    }

    public String getQuoteStatus() {
        return this.quoteStatus.get();
    }
}

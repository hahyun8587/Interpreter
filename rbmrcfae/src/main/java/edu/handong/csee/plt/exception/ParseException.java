package edu.handong.csee.plt.exception;

/**
 * Class that represents exceptions caused by parsing.
 */
public abstract class ParseException extends Exception {
    protected String location;

    public ParseException(String location) {
        this.location = location;
    }

    @Override
    public abstract String getMessage();
}

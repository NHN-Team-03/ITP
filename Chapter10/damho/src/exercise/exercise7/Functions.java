package exercise.exercise7;

public enum Functions {
    SIN, COS, TAN, ABS, SQRT, LOG
}

/**
 * An object of this class represents one of the standard functions.
 */
class StandardFunction {

    /**
     * Tells which function this is.
     */
    Functions functionCode;

    /**
     * Constructor creates an object to represent one of
     * the standard functions
     *
     * @param code which function is represented.
     */
    StandardFunction(Functions code) {
        functionCode = code;
    }

    /**
     * Finds the value of this function for the specified
     * parameter value, x.
     */
    double evaluate(double x) {
        // (This uses the "switch expression" syntax)
        switch (functionCode) {
            case SIN:
                return Math.sin(x);
            case COS:
                return Math.cos(x);
            case TAN:
                return Math.tan(x);
            case ABS:
                return Math.abs(x);
            case SQRT:
                return Math.sqrt(x);
            case LOG:
                return Math.log(x);
            default:
                return Math.log(x);
        }
    }

} // end class StandardFunction

public enum MathOperation {
    // each value in an enum is an instance of the enum class
    ADD ('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'); //semi-colon

    private char symbol;
    // constructor- set private because it's only used for the values stated above
    private MathOperation(char symbol){
        this.symbol = symbol;
    }

    //function to return the symbol
    public char getSymbol() {
        return symbol;
    }

    
}

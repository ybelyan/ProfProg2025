public enum Operations {
    SUMMA("+") {
        @Override
        double action(double operand1, double operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        double action(double operand1, double operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLY("*") {
        @Override
        double action(double operand1, double operand2) {
            return operand1 * operand2;
        }
    },
    DIVISION("/") {
        @Override
        double action(double operand1, double operand2) {
            return operand1 / operand2;
        }
    },
    UNKNOWN(""){
        @Override
        double action(double operand1, double operand2) {
            return 0.0;
        }
    };
    private final String operation;


    Operations(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
    abstract double action(double operand1, double operand2);

    public static Operations valueBy(String digit) {
        for (Operations value : values()) {
            if (value.getOperation().equals(digit)) {
                return value;
            }
        }
        return UNKNOWN;
    }
}

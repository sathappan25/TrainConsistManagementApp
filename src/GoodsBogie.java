public class GoodsBogie {
    private String type;
    private String cargo;
    private String lastErrorMessage;
    private String lastCompletionMessage;
    private boolean lastAssignmentSuccessful;
    private boolean lastExceptionHandled;
    private boolean lastFinallyExecuted;

    public GoodsBogie(String type) {
        this(type, null);
    }

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public void assignCargo(String cargo) {
        lastErrorMessage = null;
        lastCompletionMessage = null;
        lastAssignmentSuccessful = false;
        lastExceptionHandled = false;
        lastFinallyExecuted = false;

        try {
            if (isUnsafeCombination(type, cargo)) {
                throw new CargoSafetyException("Unsafe cargo assignment!");
            }

            this.cargo = cargo;
            lastAssignmentSuccessful = true;
            System.out.println("Cargo assigned successfully -> " + cargo);
        } catch (CargoSafetyException ex) {
            lastExceptionHandled = true;
            lastErrorMessage = ex.getMessage();
            System.out.println("Error: " + ex.getMessage());
        } finally {
            lastFinallyExecuted = true;
            lastCompletionMessage = "Cargo validation completed for " + type + " bogie";
            System.out.println(lastCompletionMessage);
        }
    }

    private boolean isUnsafeCombination(String shape, String cargo) {
        return shape != null
                && cargo != null
                && shape.equalsIgnoreCase("Rectangular")
                && cargo.equalsIgnoreCase("Petroleum");
    }

    public String getType() {
        return type;
    }

    public String getShape() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public String getLastCompletionMessage() {
        return lastCompletionMessage;
    }

    public boolean isLastAssignmentSuccessful() {
        return lastAssignmentSuccessful;
    }

    public boolean wasLastExceptionHandled() {
        return lastExceptionHandled;
    }

    public boolean wasLastFinallyExecuted() {
        return lastFinallyExecuted;
    }

    @Override
    public String toString() {
        return type + " -> " + cargo;
    }
}
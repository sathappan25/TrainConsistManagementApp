import org.junit.Test;
import static org.junit.Assert.*;

public class GoodsBogieTest {

    @Test
    public void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.getCargo());
        assertTrue(bogie.isLastAssignmentSuccessful());
        assertFalse(bogie.wasLastExceptionHandled());
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertTrue(bogie.wasLastExceptionHandled());
        assertEquals("Unsafe cargo assignment!", bogie.getLastErrorMessage());
        assertFalse(bogie.isLastAssignmentSuccessful());
    }

    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo());
    }

    @Test
    public void testCargo_ProgramContinuesAfterException() {
        GoodsBogie unsafeBogie = new GoodsBogie("Rectangular");
        GoodsBogie safeBogie = new GoodsBogie("Cylindrical");

        unsafeBogie.assignCargo("Petroleum");
        safeBogie.assignCargo("Petroleum");

        assertTrue(unsafeBogie.wasLastExceptionHandled());
        assertEquals("Petroleum", safeBogie.getCargo());
        assertTrue(safeBogie.isLastAssignmentSuccessful());
    }

    @Test
    public void testCargo_FinallyBlockExecution() {
        GoodsBogie safeBogie = new GoodsBogie("Cylindrical");
        GoodsBogie unsafeBogie = new GoodsBogie("Rectangular");

        safeBogie.assignCargo("Coal");
        unsafeBogie.assignCargo("Petroleum");

        assertTrue(safeBogie.wasLastFinallyExecuted());
        assertTrue(unsafeBogie.wasLastFinallyExecuted());
        assertEquals("Cargo validation completed for Cylindrical bogie", safeBogie.getLastCompletionMessage());
        assertEquals("Cargo validation completed for Rectangular bogie", unsafeBogie.getLastCompletionMessage());
    }
}
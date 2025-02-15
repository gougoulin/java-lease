package com.github.gougoulin.lease.common.result;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test class for the Result class.
 * Covers the main functionalities of the Result class, including success, failure, and custom result creation.
 */
public class ResultTest {
    @Test
    void testOk() {
        // Test the creation of a successful result with data
        Result<String> got = Result.ok("Data loaded successfully");

        // Verify the status code, message, and data
        assertEquals(ResultOption.SUCCESS.getCode(), got.getCode());
        assertEquals(ResultOption.SUCCESS.getDesc(), got.getMsg());
        assertEquals("Data loaded successfully", got.getData());
    }

    @Test
    void testFail() {
        // Test the creation of a failed result with a custom error message
        Result<Integer> result = Result.fail("Invalid input");

        // Verify the status code, message, and data
        assertEquals(ResultOption.FAIL.getCode(), result.getCode());
        assertEquals("Invalid input", result.getMsg()); // Custom error message should be set
        assertNull(result.getData()); // Data should be null for a failed result
    }

    @Test
    void testCreateResultWithOption() {
        // Test the creation of a result using only a ResultOption (no data)
        Result<Double> result = Result.createResult(ResultOption.SUCCESS);

        // Verify the status code, message, and data
        assertEquals(ResultOption.SUCCESS.getCode(), result.getCode());
        assertEquals(ResultOption.SUCCESS.getDesc(), result.getMsg());
        assertNull(result.getData()); // Data should be null when not provided
    }

    @Test
    void testCreateResultWithDataAndOption() {
        // Test the creation of a result with both data and a ResultOption
        Result<Integer> result = Result.createResult(42, ResultOption.SUCCESS);

        // Verify the status code, message, and data
        assertEquals(ResultOption.SUCCESS.getCode(), result.getCode());
        assertEquals(ResultOption.SUCCESS.getDesc(), result.getMsg());
        assertEquals(42, result.getData()); // Data should match the provided value
    }

    @Test
    void testCreateResultWithData() {
        // Test the creation of a result with only data (no ResultOption)
        Result<String> result = Result.createResult("Test data");

        // Verify the status code and message are not set, but data is set
        assertEquals(0, result.getCode()); // Default code (not set)
        assertNull(result.getMsg()); // Default message (not set)
        assertEquals("Test data", result.getData()); // Data should match the provided value
    }
}

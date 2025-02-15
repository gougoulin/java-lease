package com.github.gougoulin.lease.common.result;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the ResultOption enum.
 * Covers the validation of status codes and descriptions for each enum value.
 */
class ResultOptionTest {

    @Test
    void testFailEnum() {
        // Test the FAIL enum value
        assertEquals(0, ResultOption.FAIL.getCode()); // Verify the status code
        assertEquals("fail", ResultOption.FAIL.getDesc()); // Verify the description
    }

    @Test
    void testSuccessEnum() {
        // Test the SUCCESS enum value
        assertEquals(1, ResultOption.SUCCESS.getCode()); // Verify the status code
        assertEquals("success", ResultOption.SUCCESS.getDesc()); // Verify the description
    }
}

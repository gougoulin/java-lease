package com.github.gougoulin.lease.common.result;

import lombok.Getter;

/**
 * An enumeration representing the possible outcomes of an operation.
 * Each enum value contains a status code and a description.
 * <p>
 * This is typically used to standardize the result status in response objects.
 */
@Getter
public enum ResultOption {
    /**
     * Represents a failed operation.
     * - Code: 0
     * - Description: "fail"
     */
    FAIL(0, "fail"),

    /**
     * Represents a successful operation.
     * - Code: 1
     * - Description: "success"
     */
    SUCCESS(1, "success");

    // TODO: add more ResultOption
    // TODO: error associated with User domain: 1000 - 1999
    // TODO: error associated with Apartment domain: 2000 - 2999
    // TODO: error associated with Lease domain: 3000 - 3999

    // The status code associated with the enum value.
    private final int code;
    // The description or message associated with the enum value.
    private final String desc;

    /**
     * Constructor for the enum values.
     *
     * @param code The status code to associate with the enum value.
     * @param desc The description to associate with the enum value.
     */
    ResultOption(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

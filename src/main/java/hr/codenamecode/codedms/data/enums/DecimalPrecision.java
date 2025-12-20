package hr.codenamecode.codedms.data.enums;

import java.math.BigInteger;

public enum DecimalPrecision {
    BITS32(BigInteger.valueOf(32)),
    BITS64(BigInteger.valueOf(64));
    private final BigInteger value;

    DecimalPrecision(BigInteger v) {
        value = v;
    }

    public static DecimalPrecision fromValue(BigInteger v) {
        for (DecimalPrecision c : DecimalPrecision.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

    public BigInteger value() {
        return value;
    }
}

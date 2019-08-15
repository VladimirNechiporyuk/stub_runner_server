package com.flexihouse.stub_runner_server.tools;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

public enum FlatPermission {

    MANAGE_ANTI_WATER_FLOOD(1 << 2),
    MANAGE_FIRE_ALARM(1 << 3),
    MANAGE_SECURITY_ALARM(1 << 4),
    MANAGE_UTILITIES(1 << 5),
    MANAGE_INTERCOM(1L << 62),
    MANAGE_HEATING(1L << 62),
    MANAGE_PAYMENT(1L << 62);

    private final long flagValue;

    FlatPermission(long flagValue) {
        this.flagValue = flagValue;
    }

    public static EnumSet<FlatPermission> getFlags(long statusValue) {
        EnumSet<FlatPermission> flags = EnumSet.noneOf(FlatPermission.class);
        Arrays.stream(FlatPermission.values()).forEach(flag ->
        {
            long flagValue = flag.getFlagValue();
            if ((flagValue & statusValue) == flagValue) {
                flags.add(flag);
            }
        });
        return flags;
    }

    public static long getBits(Set<FlatPermission> flags) {
        long value = 0;
        for (FlatPermission flag : flags) {
            value |= flag.getFlagValue();
        }
        return value;
    }

    public long getFlagValue() {
        return flagValue;
    }

}

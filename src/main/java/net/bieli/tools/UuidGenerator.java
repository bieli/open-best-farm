package net.bieli.tools;

import com.fasterxml.uuid.Generators;

import java.util.UUID;

public class UuidGenerator {
    public static UUID get() {
        return Generators.randomBasedGenerator().generate();
    }
}

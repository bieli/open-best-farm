package net.bieli.machine;

import net.bieli.product.ProductImpl;

public interface MachineActions {
    public void run(ProductImpl productToPreccessed);
    public boolean isProccessed();
    public void stop();
}

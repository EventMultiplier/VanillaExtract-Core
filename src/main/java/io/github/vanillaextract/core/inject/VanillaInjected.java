package io.github.vanillaextract.core.inject;

import io.github.vanillaextract.core.VanillaCore;

// Make the instance without ever using static, or raw instances.
public abstract class VanillaInjected
{

    private VanillaCore vanillaCore;

    public VanillaInjected(VanillaCore vanillaCore)
    {
        this.vanillaCore = vanillaCore;
    }

    protected VanillaCore getCore()
    {
        return vanillaCore;
    }
}


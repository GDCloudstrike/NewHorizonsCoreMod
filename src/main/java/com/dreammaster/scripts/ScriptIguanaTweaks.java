package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import com.dreammaster.item.ItemList;
import gregtech.api.util.GT_OreDictUnificator;
import java.util.Arrays;

public class ScriptIguanaTweaks implements IScriptLoader {
    @Override
    public void initScriptData() {

        scriptName.setLength(0);
        scriptName.append("Iguana Tweaks Tinker Construct");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("IguanaTweaksTConstruct", "Natura"));
    }

    @Override
    public void loadRecipes() {
        // --- Unfired Clay Bucket
        // If you change this recipe, be sure to update gregtech.api.enums.OrePrefixes!
        // bucketClay.mSecondaryMaterial controls what the clay bucket pulverizes into.
        addShapedRecipe(
                getModItem("IguanaTweaksTConstruct", "clayBucketUnfired", 1),
                new Object[] {null, null, null, "dustClay", null, "dustClay", "dustClay", "dustClay", "dustClay"});

        addShapedRecipe(getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1), new Object[] {
            getModItem("Natura", "waterdrop", 1), getModItem("Natura", "waterdrop", 1),
                    getModItem("Natura", "waterdrop", 1),
            getModItem("Natura", "waterdrop", 1), getModItem("IguanaTweaksTConstruct", "clayBucketFired", 1),
                    getModItem("Natura", "waterdrop", 1),
            getModItem("Natura", "waterdrop", 1), getModItem("Natura", "waterdrop", 1),
                    getModItem("Natura", "waterdrop", 1)
        });

        /* oredict so the recipes modified in iguanatweaks will work
        those are exceptionnally in iguanatweaks because the items in the recipes are registered at PostInit=
         */ GT_OreDictUnificator.registerOre("toolHeadSawArdite", ItemList.SawBladeArdite.getIS());
        GT_OreDictUnificator.registerOre("toolHeadSawManyullyn", ItemList.SawBladeManyullyn.getIS());
    }
}

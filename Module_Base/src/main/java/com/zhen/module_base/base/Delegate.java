package com.zhen.module_base.base;

public abstract class Delegate extends PermissionDelegate {

    @SuppressWarnings("unchecked")
    public <T extends Delegate> T getParentDelegate(){
        return (T) getParentFragment();
    }

}

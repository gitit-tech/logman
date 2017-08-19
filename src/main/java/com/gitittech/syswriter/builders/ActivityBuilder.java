/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gitittech.syswriter.builders;

import com.gitittech.syswriter.models.Activity;

/**
 *
 * @author Ambrose Ariagiegbe
 */
public class ActivityBuilder {

    private String objectId;
    private String property;
    private String className;
    private String val;
    private String actor;

    public ActivityBuilder setObjectId(String objectId) {
        this.objectId = objectId;
        return this;
    }

    public ActivityBuilder setProperty(String property) {
        this.property = property;
        return this;
    }

    public ActivityBuilder setClassName(String className) {
        this.className = className;
        return this;
    }

    public ActivityBuilder setVal(String val) {
        this.val = val;
        return this;
    }

    public ActivityBuilder setActor(String actor) {
        this.actor = actor;
        return this;
    }
    
    public Activity build(){
        return new Activity(objectId,className,property,val,actor);
    }
    
}

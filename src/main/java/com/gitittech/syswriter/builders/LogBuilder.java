/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gitittech.syswriter.builders;

import com.gitittech.syswriter.Level;
import com.gitittech.syswriter.models.Log;

/**
 *
 * @author Ambrose Ariagiegbe
 */
public class LogBuilder {

    protected String controller, description, level;

    public LogBuilder setController(String controller) {
        this.controller = controller;
        return this;
    }

    public LogBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public LogBuilder setLevel(Level level) {
        this.level = level.name();
        return this;
    }

    public Log build() {   
        if(controller == null)
            throw new IllegalArgumentException("Controller is null");
        return new Log(controller, description, level);
    }
}

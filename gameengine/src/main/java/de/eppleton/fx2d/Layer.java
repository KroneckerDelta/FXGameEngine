/**
 * This file is part of FXGameEngine 
 * A Game Engine written in JavaFX
 * Copyright (C) 2012 Anton Epple <info@eppleton.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://opensource.org/licenses/GPL-2.0.
 * 
 * For alternative licensing or use in closed source projects contact Anton Epple 
 * <info@eppleton.de>
 */
package de.eppleton.fx2d;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author antonepple
 */
public class Layer {

    private String name = "";
    private double opacity;
    private boolean visible = true;
    private float parallaxFactor = 1;

    public void draw(GraphicsContext graphicsContext, double x, double y, double width, double height) {
    }

    public String getName() {
        return name;
    }

    public double getOpacity() {
        return opacity;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public float getParallaxFactor() {
        return parallaxFactor;
    }

    public void setParallaxFactor(float parallaxFactor) {
        this.parallaxFactor = parallaxFactor;
    }
    
}

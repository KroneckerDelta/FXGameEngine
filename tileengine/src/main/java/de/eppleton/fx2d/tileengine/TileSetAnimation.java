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
package de.eppleton.fx2d.tileengine;

import de.eppleton.fx2d.Sprite;
import de.eppleton.fx2d.action.Renderer;
import java.util.Arrays;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author antonepple
 */
public class TileSetAnimation implements Renderer {

    protected int[] indices;
    final TileSet tileSet;
    private int index;
    private int tile;
    private float frameDelta;
    private long lastFrameSwitch;

    public TileSetAnimation(TileSet set, final int[] indices, float speed) {
        for (int i : indices) {
            if (i >= set.getNumTiles()) {
                throw new IllegalArgumentException("No tile with index " + i + " in this TileSet");
            }
        }
        this.indices = Arrays.copyOf(indices, indices.length);
        this.tileSet = set;
        frameDelta = 1_000_000_000 / speed;
        
    }

    int[] getIndices() {
        return Arrays.copyOf(indices, indices.length);
    }

    @Override
    public void render(Sprite sprite, GraphicsContext context, float alpha, long delta) {
        if ((delta - lastFrameSwitch) > frameDelta) {
            lastFrameSwitch = delta;
            index++;
            if (index >= indices.length) {
                index = 0;
            }
        }
        tile = indices[index];
        tileSet.drawTile(context, tile);
    }
}

package com.mygdx.cardpickupch09;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class LevelScreen extends BaseScreen {
    @Override
    public void initialize() {
        camera.setToOrtho(false, 800, 600);
    }

    @Override
    public void update(float dt) {
//        Vector3 touchPos = new Vector3();
//        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//        camera.unproject(touchPos);
    }
}

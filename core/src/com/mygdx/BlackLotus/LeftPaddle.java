package com.mygdx.BlackLotus;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by kingskull on 18/11/2014.
 */
public class LeftPaddle extends Paddle {

    public LeftPaddle(float x, float y) {
        super(x, y);
    }

    @Override
    public void update() {
        float delta = Gdx.graphics.getDeltaTime();

        //if (Gdx.app.getType() == Application.ApplicationType.Desktop){
        //  inputDesktop(delta);
        //}

        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            inputAndroid(delta);
        }

    }

    public void inputDesktop(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (!colisionUp())
                bordes.y += SPEED * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (!colisionDown())
                bordes.y -= SPEED * delta;
        }
    }

    public void inputAndroid(float delta) {
        float coordPaddle = bordes.y + (bordes.height / 2);
        if (Gdx.input.isTouched()) {
            float coordY = Gdx.graphics.getHeight() - Gdx.input.getY();

            if (coordPaddle >= coordY - 5 && coordPaddle <= coordY + 5) {
                coordY = coordPaddle;
            }

            if (coordY < coordPaddle) {
                if (colisionDown()) bordes.y = 0;
                else bordes.y = bordes.y - SPEED * delta;
            }

            if (coordY > coordPaddle) {
                if (colisionUp()) bordes.y = Gdx.graphics.getHeight() - texture.getHeight();
                else bordes.y = bordes.y + SPEED * delta;
            }
        }
    }
}

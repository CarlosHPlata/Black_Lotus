package com.mygdx.BlackLotus;

import com.badlogic.gdx.Gdx;

/**
 * Created by kingskull on 19/11/2014.
 */
public class RightPaddle extends Paddle {
    private Ball ball;

    public RightPaddle(float x, float y, Ball ball) {
        super(x, y);
        this.ball = ball;
    }

    @Override
    public void update() {
        float delta = Gdx.graphics.getDeltaTime();
        float coordPadle = bordes.y + texture.getHeight()/2;
        float coordBall = ball.getBordes().y + ball.getBordes().getHeight()/2;

        if (coordPadle >= coordBall - 10 && coordPadle <= coordBall + 10) coordBall = coordPadle;

        if (coordBall < coordPadle){
            if (colisionDown()) bordes.y=0;
            else bordes.y-= SPEED*delta;
        }

        if (coordBall > coordPadle) {
            if (colisionUp()) bordes.y=Gdx.graphics.getHeight() - texture.getHeight();
            else bordes.y += SPEED*delta;
        }
    }
}

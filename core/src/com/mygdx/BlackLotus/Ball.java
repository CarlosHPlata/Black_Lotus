package com.mygdx.BlackLotus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Kingskull on 23/11/2014.
 */
public class Ball {
    static final float SPEED = 200;
    private int xdirection, ydirection;
    private float xposition, yposition;

    private Texture texture;
    private Rectangle bordes;

    public Ball(float x, float y){
        xposition = x;
        yposition = y;
        texture = new Texture(Gdx.files.internal("bola.png"));
        bordes = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
        xdirection = ydirection = 1;
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture, bordes.x,bordes.y,texture.getWidth(),texture.getHeight());
    }

    public void update(Paddle paddleLeft, Paddle paddleRight){
        float delta = Gdx.graphics.getDeltaTime();

        if (colisionWall()){
            ydirection = ydirection * -1;
        }

        if (colisionPadle(paddleLeft.getBorders(), paddleRight.getBorders())){
            xdirection = xdirection * -1;
        }

        bordes.x = bordes.x + SPEED*delta * xdirection;
        bordes.y = bordes.y + SPEED*delta * ydirection;

        ballPositionOver();
    }

    public Rectangle getBordes(){
        return bordes;
    }

    private boolean colisionWall(){
        if (bordes.y + texture.getHeight() > Gdx.graphics.getHeight()) {
            bordes.y = Gdx.graphics.getHeight() - texture.getHeight();
            return true;
        } else if (bordes.y <= 0){
            bordes.y=0;
            return true;
        } else return false;
    }

    private void ballPositionOver() {
        if ( bordes.x < 0 || bordes.x > Gdx.graphics.getWidth()){
            bordes.x = xposition;
            bordes.y = yposition;
        }
    }
    
    private boolean colisionPadle(Rectangle paddleLeft, Rectangle paddleRight){
        if (bordes.overlaps(paddleLeft)){
            bordes.x = paddleLeft.x + paddleLeft.getWidth();
            return true;
        } else if (bordes.overlaps(paddleRight)) {
            bordes.x = paddleRight.x - paddleRight.getWidth();
            return true;
        } else return false;
    }
}
